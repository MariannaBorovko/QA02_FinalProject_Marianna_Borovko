package Pages;

import Utils.PropertyManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class LoginPage extends MainPage{
    @FindBy(xpath = "//input[@name='email']")
    WebElement emailField;

    @FindBy(xpath = "//input[@name='password']")
    WebElement passwordField;

    @FindBy(xpath = "//span[text()='Войти']")
    WebElement submitButton;
    public LoginPage(WebDriver driver) throws FileNotFoundException {
        super(driver);
    }

    public void enterEmail(){
        String email = PropertyManager.getInstance().getEmail();
        emailField.sendKeys(email);
    }

    public void enterPassword(){
        String password = PropertyManager.getInstance().getPassword();
        passwordField.sendKeys(password);
    }

    public void submitCreds() {
        submitButton.click();
    }
    public boolean isUserLoggedSuccessfully() {
        List<WebElement> navbarUser = driver.findElements(By.xpath("//div[@class='navbar__user']"));
        if (navbarUser.size() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public void waitForLogin(){
        getWebDriverWait().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class = 'navbar__user']")));
    }
    public void login() throws IOException {
        openPage();
        openLoginPage();
        enterEmail();
        enterPassword();
        submitCreds();
    }
}
