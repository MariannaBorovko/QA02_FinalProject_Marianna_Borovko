package Utils;

import java.io.*;
import java.util.Properties;

public class PropertyManager {

    private static PropertyManager instance;
    private static final Object lock = new Object();
    private static String propertyFilePath = System.getProperty("user.dir") +
            "./src/test/resources/data.properties";
    private static String url;
    private static String browser;

    public static PropertyManager getInstance() {
        if (instance == null) {
            synchronized (lock) {
                instance = new PropertyManager();
                instance.loadData();
            }
        }
        return instance;
    }

    private void loadData() {
        Properties prop = new Properties();
        try {
            prop.load(new FileInputStream(propertyFilePath));
        } catch (IOException e) {
            System.out.println("Configuration properties file cannot be found");
        }

        url = prop.getProperty("url");
        browser = prop.getProperty("browser");
    }

    public String getURL() {
        return url;
    }

    public String getBrowser() {
        return browser;
    }
}
