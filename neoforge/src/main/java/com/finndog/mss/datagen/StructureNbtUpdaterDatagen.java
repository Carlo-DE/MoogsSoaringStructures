package com.finndog.mss.datagen;

import com.finndog.mss.MSSCommon;
import net.minecraft.data.DataGenerator;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

// Source: https://github.com/BluSunrize/ImmersiveEngineering/blob/1.20.1/src/datagen/java/blusunrize/immersiveengineering/data/IEDataGenerator.java
@Mod.EventBusSubscriber(modid = MSSCommon.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class StructureNbtUpdaterDatagen {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        ExistingFileHelper exHelper = event.getExistingFileHelper();
        DataGenerator gen = event.getGenerator();
        final var output = gen.getPackOutput();

        if (event.includeServer()) {
            gen.addProvider(true, new StructureNbtUpdater("structures", MSSCommon.MODID, exHelper, output));
        }
    }
}
