package pages;

import io.qameta.allure.Step;
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

    @Step ("Open WebSite")
    public void openPage() {
        String webSiteUrl = PropertyManager.getInstance().getURL();
        log.info("Open WebsiteURL: " + webSiteUrl);
        driver.get(webSiteUrl);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public DriverManager getDriverManagerFactory() {
        driverManager = DriverManagerFactory
                .getManager(DriverTypes.getTypeByStringValue(DriverManager.getBrowserName()));
        return driverManager;
    }

    public WebDriverWait getWebDriverWait() {
        return new WebDriverWait(driver, 10);
    }
}
