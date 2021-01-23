package Tests;

import Pages.MainPage;
import Utils.DriverManager;
import Utils.DriverManagerFactory;
import Utils.DriverTypes;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.io.FileNotFoundException;

public class BaseTest {
    DriverManager driverManager;
    WebDriver driver;
    MainPage mainPage;

    @BeforeTest
    public void getManagerTest() {
        driverManager = DriverManagerFactory.getManager(DriverTypes.CHROME);
    }

    @BeforeMethod
    @Parameters("os")
    public void setUp(String os) throws FileNotFoundException {
        if (os.equalsIgnoreCase("windows")) {
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
