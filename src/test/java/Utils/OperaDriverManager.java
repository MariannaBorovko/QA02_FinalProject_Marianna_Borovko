package Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.opera.OperaDriver;

public class OperaDriverManager extends DriverManager {

    protected void createDriver() {
        WebDriverManager.operadriver().setup();
        driver = new OperaDriver();
    }
}
