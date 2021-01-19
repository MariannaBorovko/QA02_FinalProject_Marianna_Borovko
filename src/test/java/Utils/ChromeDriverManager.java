package Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverManager extends DriverManager {

    protected void createDriverWindows() {
        WebDriverManager.chromedriver().win().setup();
        driver = new ChromeDriver();
    }

    protected void createDriverLinux() {
        WebDriverManager.chromedriver().linux().setup();
        driver = new ChromeDriver();
    }

}
