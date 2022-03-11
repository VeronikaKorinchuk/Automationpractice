package com.coherentsolutions.korinchuk.lab.java.web.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class PropertyReader {

    private static final String PROPERTIES_PATH = "src/test/resources/config.properties";
    private Properties property;
    private FileInputStream propertiesFolder;
    private static PropertyReader propertyReader;

    private PropertyReader() {
        loadProperties();
    }

    public static PropertyReader getInstance() {
        if (propertyReader == null) {
            propertyReader = new PropertyReader();
        }
        return propertyReader;
    }

    public void loadProperties() {
        try {
            property = new Properties();
            propertiesFolder = new FileInputStream(PROPERTIES_PATH);
            property.load(propertiesFolder);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getProperty(String propertyName) {
        return property.getProperty(propertyName);
    }
}