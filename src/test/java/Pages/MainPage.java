package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.FileNotFoundException;

public class MainPage extends BasePage {
    @FindBy(xpath = "//a[contains(text(),\'Вход\')]")
    WebElement loginPageButton;

    public MainPage(WebDriver driver) throws FileNotFoundException {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void openLoginPage() {
        loginPageButton.click();
    }
}
