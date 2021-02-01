package Tests;

import Pages.BasePage;
import Pages.MainPage;
import Utils.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.IOException;

public class BaseTest {
    DriverManager driverManager;
    WebDriver driver;
    MainPage mainPage;
    BasePage basePage;

    @BeforeTest
    public void getManagerTest() throws IOException {
        basePage = new BasePage(driver);
        driverManager = basePage.getDriverManagerFactory();
    }

    @BeforeMethod
    public void setUp() throws IOException {
        if (driverManager.getOS().contains("Win")) {
            driver = driverManager.getDriverWindows();
        } else {
            driver = driverManager.getDriverLinux();
        }
        mainPage = new MainPage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
        driverManager.quitDriver();
    }
}
