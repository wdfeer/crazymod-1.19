package net.wdfeer.crazymod;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.wdfeer.crazymod.datagen.ModModelGenerator;
import net.wdfeer.crazymod.datagen.ModBlockTagGenerator;
import net.wdfeer.crazymod.datagen.ModItemTagGenerator;

public class CrazyDatagen implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        fabricDataGenerator.addProvider(ModItemTagGenerator::new);
        fabricDataGenerator.addProvider(ModBlockTagGenerator::new);
        fabricDataGenerator.addProvider(ModModelGenerator::new);
    }
}
