const fs = require('fs');

function writeByTemplate(templatePath, dirPath, name) {
    let template = fs.readFileSync(templatePath).toString();
    let oldText = template;
    let text = oldText.replace("<0>", name);
    while (text != oldText) {
        oldText = text;
        text = oldText.replace("<0>", name);
    }
    if (!fs.existsSync(dirPath)) {
        fs.mkdirSync(dirPath, { recursive: true });
    }
    fs.writeFileSync(dirPath + name + '.json', text);
}

function writeSideTopBlock(generatedPath, name) {
    writeByTemplate('./templates/models/sideTopBlockModel.json', generatedPath + 'assets/crazymod/models/block/', name);
    writeByTemplate('./templates/models/blockItemModel.json', generatedPath + 'assets/crazymod/models/item/', name);
    writeByTemplate('./templates/loot_tables/dropSelfBlockLootTable.json', generatedPath + 'data/crazymod/loot_tables/blocks/', name);
    writeByTemplate('./templates/blockstates/genericBlockState.json', generatedPath + 'assets/crazymod/blockstates/', name);
}

function datagen(workspacePath) {
    let data = fs.readFileSync('./sideTopBlocks.json');
    let sideTopBlocks = JSON.parse(data).values;
    sideTopBlocks.forEach(name => {
        console.log("Generating Data for " + name);
        writeSideTopBlock(workspacePath + '/generated/', name);
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