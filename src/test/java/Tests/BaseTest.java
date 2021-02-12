package Tests;

import Pages.*;
import Pages.BasePage;
import Pages.LoginPage;
import Pages.MainPage;
import Utils.DriverManager;
import Utils.Listener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import java.io.IOException;
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

    @BeforeTest
    public void getManagerTest(){
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
        loginPage = new LoginPage(driver);
        newsPage = new NewsPage(driver);
        userProfilePage = new UserProfilePage(driver);
        jobsPage = new JobsPage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
        driverManager.quitDriver();
    }

    public WebDriver getDriver(){
        return driver;
    }
}
