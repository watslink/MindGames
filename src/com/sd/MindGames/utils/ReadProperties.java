package com.sd.MindGames.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public  class ReadProperties {

    public  static int ReadIntFromProperties(String propString) {

        Properties prop=new Properties();
        FileInputStream ip;
        try {
            ip = new FileInputStream("src/config.properties");
            prop.load(ip);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return Integer.parseInt(prop.getProperty(propString));

    }

}


