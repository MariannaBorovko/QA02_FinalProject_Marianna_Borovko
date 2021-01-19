package Tests;

import Pages.MainPage;
import Utils.DriverManager;
import Utils.DriverManagerFactory;
import Utils.DriverTypes;
import Utils.OSTypes;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    DriverManager driverManager;
    WebDriver driver;
    MainPage mainPage;

    @BeforeTest
    public void getManagerTest() {
        driverManager = DriverManagerFactory.getManager(DriverTypes.CHROME);
    }

    @BeforeMethod
    public void setUp() {
        driver = driverManager.getDriver();
        mainPage = new MainPage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
        driverManager.quitDriver();
    }
}
