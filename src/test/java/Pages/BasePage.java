package Pages;

import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BasePage {
    WebDriver driver;
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
}
