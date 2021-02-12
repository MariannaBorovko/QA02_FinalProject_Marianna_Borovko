package Pages;

import Utils.PropertyManager;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.FileNotFoundException;
import java.util.List;

@Log4j2
public class LoginPage extends MainPage {
    @FindBy(xpath = "//input[@name='email']")
    WebElement emailField;
    @FindBy(xpath = "//input[@name='password']")
    WebElement passwordField;
    @FindBy(xpath = "//span[text()='Войти']")
    WebElement submitButton;

    public LoginPage(WebDriver driver) throws FileNotFoundException {
        super(driver);
    }

    public void enterEmail() {
        log.info("Fill email field with valid data");
        String email = PropertyManager.getInstance().getEmail();
        emailField.sendKeys(email);
    }

    public void enterPassword() {
        log.info("Fill password field with valid data");
        String password = PropertyManager.getInstance().getPassword();
        passwordField.sendKeys(password);
    }

    public void clickSubmitButton() {
        waitForLogin();
        log.info("Click submit button");
        submitButton.click();
    }

    public boolean isUserLoggedSuccessfully() {
        log.info("Login with valid data");
        List<WebElement> navbarUser = driver.findElements(By.xpath("//div[@class='navbar__user']"));
        if (navbarUser.size() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public void waitForLogin() {
        log.info("waitForLogin method is started");
        getWebDriverWait().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class = 'navbar__user']")));
    }

    public void login() {
        log.info("login method is started");
        openPage();
        openLoginPage();
        enterEmail();
        enterPassword();
        clickSubmitButton();
    }
}
