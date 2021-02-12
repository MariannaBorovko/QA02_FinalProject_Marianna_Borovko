package Pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
public class UserProfilePage extends MainPage{
    @FindBy(xpath = "//a[contains(text(),'Выйти')]")
    WebElement logoutButton;

    public UserProfilePage(WebDriver driver){
        super(driver);
    }

    public void lougout(){
        log.info("Logout button click");
        logoutButton.click();
    }
}
