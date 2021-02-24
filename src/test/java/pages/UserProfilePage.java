package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;


@Log4j2
public class UserProfilePage extends MainPage {
    @FindBy(xpath = "//a[contains(text(),'Выйти')]")
    WebElement logoutButton;
    @FindBy(xpath = "//input[@name='firstName']")
    WebElement firstNameField;
    @FindBy(xpath = "//input[@name='lastName']")
    WebElement lastNameField;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement submitButton;
    @FindBy(xpath = "//div[@class='spinner']")
    WebElement spinner;
    @FindBy(xpath = "//span[@class ='label__text']")
    List<WebElement> fieldTitles;

    public UserProfilePage(WebDriver driver) {
        super(driver);
    }

    public void logOut() {
        log.info("Logout button click");
        logoutButton.click();
    }


    //    public boolean isFieldPresent(String fieldName) {
//        for (WebElement fieldTitle : fieldTitles) {
//            return fieldTitle.getText().contains(fieldName);
//            break;
//        }
//}
    public boolean isFirstNameFieldEmpty() {
        return getFirstName().isEmpty();
    }

    public boolean isLastNameFieldEmpty() {
        return getLastName().isEmpty();
    }

    public String getFirstName() {
        return firstNameField.getAttribute("value");
    }

    public String getLastName() {
        return lastNameField.getText();
    }

    public String setFirstName(String firstName) {
        if (!isFirstNameFieldEmpty()) {
            firstNameField.clear();
        }
        firstNameField.sendKeys(firstName);
        return firstName;
    }

    public void setLastName() {
        if (isLastNameFieldEmpty() == false) {
            lastNameField.clear();
        }
        lastNameField.sendKeys("NewLastName");
    }


    public void saveChanges() {
        submitButton.click();
        waitRefreshPage();
    }

    //    public void refreshPage() {
//        driver.navigate().refresh();
//    }
//
    public void waitRefreshPage() {
        if (spinner.isDisplayed()) {
            getWebDriverWait().until(ExpectedConditions.invisibilityOf(spinner));
        }
    }
}
