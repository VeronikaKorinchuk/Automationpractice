package web.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

    private static final String PROPERTIES_PATH = "src/test/resources/config.properties";
    private Properties property;
    private FileInputStream propertiesFolder;

    public Properties loadProperties() {
        try {
            property = new Properties();
            propertiesFolder = new FileInputStream(PROPERTIES_PATH);
            property.load(propertiesFolder);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return property;
    }

    public String getProperty(String propertyName) {
        return loadProperties().getProperty(propertyName);
    }
}
