package Pages;

import Utils.DriverManager;
import Utils.DriverManagerFactory;
import Utils.DriverTypes;
import Utils.PropertyManager;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileNotFoundException;
import java.io.IOException;

@Log4j2

public class BasePage {
    WebDriver driver;
    DriverManager driverManager;



    public BasePage(WebDriver driver) throws FileNotFoundException {
        this.driver = driver;
    }

    public void openPage() {
        log.info("+++++++OpenPage+++++++++");
        String webSiteUrl = PropertyManager.getInstance().getURL();
        driver.get(webSiteUrl);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public DriverManager getDriverManagerFactory() throws IOException {
        driverManager = DriverManagerFactory.getManager(DriverTypes.getTypeByStringValue(DriverManager.getBrowserName()));
        return driverManager;
    }

    public WebDriverWait getWebDriverWait() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        return wait;
    }
}
