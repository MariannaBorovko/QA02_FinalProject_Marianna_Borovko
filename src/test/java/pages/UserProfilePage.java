package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


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

    public UserProfilePage(WebDriver driver) {
        super(driver);
    }

    public void lougout() {
        log.info("Logout button click");
        logoutButton.click();
    }

    public boolean isFirstNameFieldEmpty() {
        if (getFirstName().isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
    public boolean isLastNameFieldEmpty() {
        if (getLastName().isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public String  getFirstName(){
        String a = firstNameField.getAttribute("value");
        return a;
    }

    public String getLastName(){
        return lastNameField.getText();
    }

    public String setFirstName(String firstName){
        if (isFirstNameFieldEmpty()==false){
            firstNameField.clear();
        }
       firstNameField.sendKeys(firstName);
        return firstName;
    }



    public void setLastName(){
        if (isLastNameFieldEmpty()==false){
            lastNameField.clear();
        }
        lastNameField.sendKeys("NewLastName");
    }

    public void saveChanges(){
        submitButton.click();
        waitRefreshPage();
    }

    public void refreshPage(){
        driver.navigate().refresh();
    }

    public void waitRefreshPage() {
        getWebDriverWait().until(ExpectedConditions.invisibilityOf(spinner));
    }
}
