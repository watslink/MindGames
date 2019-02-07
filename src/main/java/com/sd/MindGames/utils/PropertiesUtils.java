package com.sd.MindGames.utils;

import java.io.*;

import java.util.Properties;

public class PropertiesUtils {

    static private Properties PROP = getProperties();
    static private String FILE_NAME="config.properties";

    /**
     * Recuperation d'un Properties à partir d'un fichier
     * @return
     */
    private static Properties getProperties() {
        Properties prop = new Properties();
        InputStream ip;
        try {
            ip = ClassLoader.getSystemResourceAsStream(FILE_NAME);
            prop.load(ip);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }

    /**
     * Recuperation d'un String dans fichier properties à partir de sa clé
     * @param propKey
     * @return
     */
    public static String readStringFromProperties(String propKey) {
        return PROP.getProperty(propKey);
    }

    /**
     * Recuperation d'un Int dans fichier properties à partir de sa clé
     * @param propString
     * @return
     */
    public static int readIntFromProperties(String propString) {
        return Integer.parseInt(readStringFromProperties(propString));
    }

    /**
     * Recuperation d'un Boolean dans fichier properties à partir de sa clé
     * @param propString
     * @return
     */
    public static boolean readBooleanFromProperties(String propString) {
        return Boolean.parseBoolean(readStringFromProperties(propString));
    }


}


