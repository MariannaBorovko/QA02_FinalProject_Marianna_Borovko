package Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxDriverManager extends DriverManager {

    protected void createDriverWindows() {
        WebDriverManager.firefoxdriver().win().setup();
        driver = new FirefoxDriver();
    }

    protected void createDriverLinux() {
        WebDriverManager.firefoxdriver().linux().setup();
        driver = new FirefoxDriver();
    }
}
