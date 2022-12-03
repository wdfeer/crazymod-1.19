const fs = require('fs');

function replaceAll(text, search, replace) {
    let oldText = text;
    text = oldText.replace(search, replace);
    while (text != oldText) {
        oldText = text;
        text = oldText.replace(search, replace);
    }
    return text;
}

function writeByTemplate(templatePath, dirPath, arg0, arg1) {
    let text = fs.readFileSync(templatePath).toString();
    text = replaceAll(text, "<0>", arg0);
    text = replaceAll(text, "<1>", arg1);
    if (!fs.existsSync(dirPath)) {
        fs.mkdirSync(dirPath, { recursive: true });
    }
    fs.writeFileSync(dirPath + arg0 + '.json', text);
}

function writeSideTopBlock(generatedPath, name, topOverride) {
    if (topOverride) {
        writeByTemplate('./templates/models/sideTopBlockModelTopOverride.json', generatedPath + 'assets/crazymod/models/block/', name, topOverride);
    } else
        writeByTemplate('./templates/models/sideTopBlockModel.json', generatedPath + 'assets/crazymod/models/block/', name);
    writeByTemplate('./templates/models/blockItemModel.json', generatedPath + 'assets/crazymod/models/item/', name);
    writeByTemplate('./templates/loot_tables/dropSelfBlockLootTable.json', generatedPath + 'data/crazymod/loot_tables/blocks/', name);
    writeByTemplate('./templates/blockstates/genericBlockState.json', generatedPath + 'assets/crazymod/blockstates/', name);
}

function datagen(workspacePath) {
    let data = fs.readFileSync('./sideTopBlocks.json');
    let sideTopBlocks = JSON.parse(data).values;
    let generatedPath = workspacePath + '/generated/';
    sideTopBlocks.forEach(object => {
        let name = object.name;
        if (name == undefined) {
            name = object;
        }
        console.log("Generating Data for " + name);
        writeSideTopBlock(generatedPath, name, object.top);
    });
}

function tryDatagen(workspacePath) {
    let files = fs.readdirSync(workspacePath);

    if (['generated', 'resources'].some(x => files.includes(x))) {
        datagen(workspacePath);
    } else {
        tryDatagen(workspacePath + '/..');
    }
}

tryDatagen('..');