package utils;

import java.io.*;
import java.util.Properties;

public class PropertyManager {

    private static PropertyManager instance;
    private static final Object lock = new Object();
    private String propertyFilePath = "./src/test/resources/data.properties";
    private static String url;
    private static String browser;
    private String email;
    private String password;

    public static PropertyManager getInstance() {
        synchronized (lock) {
            if (instance == null) {
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
        email = prop.getProperty("email");
        password = prop.getProperty("password");
    }

    public String getURL() {
        return url;
    }

    public String getBrowser() {
        return browser;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
