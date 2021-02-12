package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.opera.OperaDriver;

public class OperaDriverManager extends DriverManager {

    protected void createDriverWindows() {
        WebDriverManager.operadriver().win().setup();
        driver = new OperaDriver();
    }

    protected void createDriverLinux() {
        WebDriverManager.operadriver().linux().setup();
        driver = new OperaDriver();
    }
}
