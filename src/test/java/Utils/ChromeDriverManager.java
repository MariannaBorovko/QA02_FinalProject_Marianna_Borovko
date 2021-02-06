package Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ChromeDriverManager extends DriverManager {

    protected void createDriverWindows() {
        WebDriverManager.chromedriver().win().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    protected void createDriverLinux() {
        WebDriverManager.chromedriver().linux().setup();
        driver = new ChromeDriver();
    }
}
