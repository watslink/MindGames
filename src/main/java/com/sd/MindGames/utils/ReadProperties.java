package com.sd.MindGames.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public  class ReadProperties {





    public  static String readStringFromProperties(String propKey) {

        Properties prop=new Properties();
        FileInputStream ip;
        try {
            ip = new FileInputStream("src/main/resources/config.properties");
            prop.load(ip);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return prop.getProperty(propKey);

    }



    public  static int readIntFromProperties(String propString) {


        return Integer.parseInt(readStringFromProperties(propString));

    }

    public  static boolean readBooleanFromProperties(String propString) {


        return Boolean.parseBoolean(readStringFromProperties(propString));

    }

}


