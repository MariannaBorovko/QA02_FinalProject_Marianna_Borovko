package tests;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pages.*;
import utils.DriverManager;
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
        log.debug("1) BasePage driver");
        basePage = new BasePage(driver);
        log.debug("2) DriverManagerFactory get");
        driverManager = basePage.getDriverManagerFactory();
        log.debug("3) Start if");
        if (driverManager.getOS().contains("Win")) {
            log.debug("4) GetWindowsChromeDriver");
            driver = driverManager.getDriverWindows();
        } else {
            log.debug("5) GetLinuxChromeDriver");
            driver = driverManager.getDriverLinux();
        }
        log.debug("6) MainPage");
        mainPage = new MainPage(driver);
        log.debug("7) LoginPage");
        loginPage = new LoginPage(driver);
        log.debug("8) NewsPage");
        newsPage = new NewsPage(driver);
        log.debug("9) MainPage");
        userProfilePage = new UserProfilePage(driver);
        log.debug("10) JobsPage");
        jobsPage = new JobsPage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
        log.debug("11) QuitDriver");
        driverManager.quitDriver();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
