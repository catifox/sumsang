package xyz.catifox.sumsang;

import net.fabricmc.api.ModInitializer;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

public class SumsangMod implements ModInitializer {
    private static final String MODID = "sumsang";
    public static Item NalaxyGote7Item;

    @Override
    public void onInitialize() {
        Configuration.init("sumsang", Configuration.class);
        NalaxyGote7Item = Registry.register(Registry.ITEM, new ResourceLocation(SumsangMod.MODID, "nalaxygote7"), new NalaxyGote7Item());
    }

}
