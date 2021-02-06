package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.FileNotFoundException;

public class UserProfilePage extends MainPage{
    @FindBy(xpath = "//a[contains(text(),'Выйти')]")
    WebElement logoutButton;

    public UserProfilePage(WebDriver driver) throws FileNotFoundException {
        super(driver);
    }

    public void lougout(){
        logoutButton.click();
    }
}
