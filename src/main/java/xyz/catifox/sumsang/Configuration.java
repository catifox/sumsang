package xyz.catifox.sumsang;

import eu.midnightdust.lib.config.MidnightConfig;

public class Configuration extends MidnightConfig {
    @Entry
    public static int explosivePower = 20;
    @Entry
    public static boolean poisonOnDetonate = true;
    @Entry
    public static int poisonTime = 5;
    @Entry
    public static boolean rightClickDetonator = true;

}

//    public ForgeConfigSpec.ConfigValue<Integer> getExplosivePower() {
//        return explosivePower;
//    }
//默认为20
//    public ForgeConfigSpec.ConfigValue<Boolean> getPoisonOnDetonate() {
//        return poisonOnDetonate;
//    }
//默认为true
//    public ForgeConfigSpec.ConfigValue<Integer> getPoisonTime() {
//        return poisonTime;
//    }
//默认为5
//    public ForgeConfigSpec.ConfigValue<Boolean> getRightClickDetonator() {
//        return rightClickDetonator;
//    }
//默认为true
