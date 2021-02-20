package utils;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager {

    protected WebDriver driver;

    protected abstract void createDriverWindows();

    protected abstract void createDriverLinux();

    public void quitDriver() {
        if (null != driver) {
            driver.quit();
            driver = null;
        }
    }

    public WebDriver getDriverWindows() {
        if (null == driver) {
            createDriverWindows();
        }
        return driver;
    }

    public WebDriver getDriverLinux() {
        if (null == driver) {
            createDriverLinux();
        }
        return driver;
    }

//    public String getOS() {
//        String os = System.getenv("OS");
//        return os;
//    }
        public String getOS() {
        String os = "Windows";
        return os;
    }

    public static String getBrowserName(){
        String browser = PropertyManager.getInstance().getBrowser();
        return browser;
    }
}
