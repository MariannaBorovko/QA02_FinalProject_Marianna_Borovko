package Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ChromeDriverManager extends DriverManager {

    protected void createDriverWindows() {
        WebDriverManager.chromedriver().win().setup();
        DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("test-type");
        desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, options);
        driver = new ChromeDriver(options);
    }

    protected void createDriverLinux() {
        WebDriverManager.chromedriver().linux().setup();
        DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("test-type");
        desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, options);
        driver = new ChromeDriver(options);
    }
}
