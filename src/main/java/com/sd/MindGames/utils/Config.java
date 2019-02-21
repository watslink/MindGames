package com.sd.MindGames.utils;

/**
 * Classe de Configuration
 */
public  class Config {

    private static boolean devMode=false;

    public static boolean isDevMode() {
        return devMode;
    }

    public static void setDevMode(boolean devMode) {
        Config.devMode = devMode;
    }
}
