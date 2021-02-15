package pages;

import utils.DriverManager;
import utils.DriverManagerFactory;
import utils.DriverTypes;
import utils.PropertyManager;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

@Log4j2

public class BasePage {
    WebDriver driver;
    DriverManager driverManager;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void openPage() {
        log.error("+++++++OpenPage+++++++++");
        String webSiteUrl = PropertyManager.getInstance().getURL();
       log.error("driver.getURL");
       log.error("driver" + driver + "URL" + webSiteUrl);
        driver.get(webSiteUrl);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public DriverManager getDriverManagerFactory() {
        driverManager = DriverManagerFactory.getManager(DriverTypes.getTypeByStringValue(DriverManager.getBrowserName()));
        return driverManager;
    }

    public WebDriverWait getWebDriverWait() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        return wait;
    }
}
