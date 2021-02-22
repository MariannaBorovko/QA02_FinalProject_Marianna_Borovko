package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.PropertyManager;

@Log4j2
public class LoginPage extends MainPage {
    @FindBy(xpath = "//input[@name='email']")
    WebElement emailField;
    @FindBy(xpath = "//input[@name='password']")
    WebElement passwordField;
    @FindBy(xpath = "//span[text()='Войти']")
    WebElement submitButton;
    @FindBy(xpath = "//div[@class='auth-page']")
    WebElement authContainer;
    @FindBy(xpath = "//div[@class='navbar__user']")
    WebElement userProfileButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterEmail() {
        waitForAuthContainer();
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
        log.info("Click submit button");
        submitButton.click();
        waitForAuth();
    }

    public boolean isUserLoggedSuccessfully() {
        log.info("Login with valid data");
        return userProfileButton.isDisplayed();
    }

    public void login() {
        log.info("login method is started");
        openPage();
        openLoginPage();
        enterEmail();
        enterPassword();
        clickSubmitButton();
    }

    public void waitForAuthContainer() {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(authContainer));
    }

    public void waitForAuth() {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(userProfileButton));
    }
}
