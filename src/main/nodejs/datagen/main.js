const fs = require('fs');

function readJsonObject(path) {
    return JSON.parse(fs.readFileSync(path));
}

function writeByTemplate(templatePath, dirPath, arg0, arg1) {
    let text = fs.readFileSync(templatePath).toString();
    text = text.replaceAll("<0>", arg0);
    text = text.replaceAll("<1>", arg1);
    if (!fs.existsSync(dirPath)) {
        fs.mkdirSync(dirPath, { recursive: true });
    }
    fs.writeFileSync(dirPath + arg0 + '.json', text);
}

const { argv } = require('process');

function writeGenericBlockLootTable(name) {
    writeByTemplate('./templates/loot_tables/dropSelfBlockLootTable.json', generatedPath + '/data/crazymod/loot_tables/blocks/', name);
}

function writeGenericBlockState(name) {
    writeByTemplate('./templates/blockstates/genericBlockState.json', generatedPath + '/assets/crazymod/blockstates/', name);
}

function writeBlockItem(name) {
    writeByTemplate('./templates/models/items/blockItemModel.json', generatedPath + '/assets/crazymod/models/item/', name);
}

function writeSideTopBlock(name, topOverride) {
    if (topOverride) {
        writeByTemplate('./templates/models/blocks/sideTopBlockModelTopOverride.json', generatedPath + '/assets/crazymod/models/block/', name, topOverride);
    } else {
        writeByTemplate('./templates/models/blocks/sideTopBlockModel.json', generatedPath + '/assets/crazymod/models/block/', name);
    }
    writeGenericBlockLootTable(name);
    writeGenericBlockState(name);
    writeBlockItem(name);
}

function sideTopBlocks() {
    let sideTopBlocks = readJsonObject(valueDir + '/sideTopBlocks.json').values;
    sideTopBlocks.forEach(object => {
        let name = object.name;
        if (name == undefined) {
            name = object;
        }

        try {
            writeSideTopBlock(generatedPath, name, object.top);
        } catch (error) {
            console.error("Failed to generate data for " + name);
        }
    });
}

function datagen() {
    sideTopBlocks();
}

const generatedPath = argv[2];
const valueDir = argv[3];
if (generatedPath && valueDir) {
    datagen()
}
else
    throw "Generated path and Value Directory path arguments not provided!";