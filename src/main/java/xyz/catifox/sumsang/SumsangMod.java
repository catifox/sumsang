package xyz.catifox.sumsang;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class SumsangMod implements ModInitializer {
    public static final NalaxyGote7Item FABRIC_ITEM = new NalaxyGote7Item(new FabricItemSettings().group(ItemGroup.MISC).maxCount(16));//创建物品，最大堆叠 16

    @Override
    public void onInitialize() {
        Configuration.init("sumsang", Configuration.class);
        Registry.register(Registry.ITEM, new Identifier("sumsang", "nalaxygote7"), FABRIC_ITEM);//注册物品

    }

}
