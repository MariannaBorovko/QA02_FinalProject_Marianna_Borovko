package Pages;

import Utils.DriverManager;
import Utils.DriverManagerFactory;
import Utils.DriverTypes;
import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BasePage {
    WebDriver driver;
    DriverManager driverManager;
    Properties properties = new Properties();
    FileInputStream propertiesPath = new FileInputStream("./src/test/resources/data.properties");

    public BasePage(WebDriver driver) throws FileNotFoundException {
        this.driver = driver;
    }

    public void openPage() throws IOException {
        properties.load(propertiesPath);
        String webSiteUrl = properties.getProperty("data.url");
        driver.get(webSiteUrl);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public String getBrowserName() throws IOException {
        properties.load(propertiesPath);
        String browser = properties.getProperty("data.browser");
        return browser;
    }

    public String getOS() {
        String os = System.getenv("OS");
        return os;
    }

    public DriverManager getDriverManagerFactory() throws IOException {
        driverManager = DriverManagerFactory.getManager(DriverTypes.getTypeByStringValue(getBrowserName()));
        return driverManager;
    }
}
