package xyz.catifox.sumsang;

import eu.midnightdust.lib.config.MidnightConfig;

public class Configuration extends MidnightConfig {
    @Entry
    public static int explosivePower = 20;
    @Entry
    public static boolean poisonOnDetonate = true;
    @Entry
    public static int poisonTime = 5;
}
