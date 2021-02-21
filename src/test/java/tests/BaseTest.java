package tests;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.*;
import utils.DriverManager;
import utils.DriverManagerFactory;
import utils.DriverTypes;
import utils.Listener;

@Log4j2
@Listeners(Listener.class)
public class BaseTest {
    DriverManager driverManager;
    WebDriver driver;
    MainPage mainPage;
    BasePage basePage;
    LoginPage loginPage;
    NewsPage newsPage;
    UserProfilePage userProfilePage;
    JobsPage jobsPage;

    @BeforeMethod
    public void setUp() {
        basePage = new BasePage(driver);
//        driverManager = basePage.getDriverManagerFactory();
        driverManager = DriverManagerFactory.getManager(DriverTypes.CHROME);
        if (driverManager.getOS().contains("Win")) {
            driver = driverManager.getDriverWindows();
        } else {
            driver = driverManager.getDriverLinux();
        }
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        newsPage = new NewsPage(driver);
        userProfilePage = new UserProfilePage(driver);
        jobsPage = new JobsPage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
        driverManager.quitDriver();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
