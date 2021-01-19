package Pages;

import org.openqa.selenium.WebDriver;

public class BasePage {
    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void openWebSite() {
        driver.get("https://www.tut.by/");
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}
