package com.sd.MindGames.utils;

import java.io.*;

import java.util.Properties;

public class PropertiesUtils {

    static private Properties prop = getProperties();

    protected static Properties getProperties() {
        Properties prop = new Properties();
        InputStream ip;
        try {
            ip = ClassLoader.getSystemResourceAsStream("config.properties");
            prop.load(ip);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }

    public static String readStringFromProperties(String propKey) {

        return prop.getProperty(propKey);
    }

    public static int readIntFromProperties(String propString) {
        return Integer.parseInt(readStringFromProperties(propString));
    }

    public static boolean readBooleanFromProperties(String propString) {
        return Boolean.parseBoolean(readStringFromProperties(propString));
    }


}


