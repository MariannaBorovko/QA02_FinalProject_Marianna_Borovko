package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;


@Log4j2
public class UserProfilePage extends MainPage {
    @FindBy(xpath = "//a[contains(text(),'Выйти')]")
    WebElement logoutButton;
    @FindBy(xpath = "//input[@name='firstName']")
    WebElement firstNameField;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement submitButton;
    @FindBy(xpath = "//span[@class ='label__text']")
    List<WebElement> fieldTitles;

    public UserProfilePage(WebDriver driver) {
        super(driver);
    }

    public void logOut() {
        log.info("Logout button click");
        logoutButton.click();
    }

    public boolean isFieldPresent(String fieldName) {
        ArrayList<WebElement> titles = new ArrayList<>();
        for (int i = 0; i < fieldTitles.size(); i++) {
            if (fieldTitles.get(i).getText().contains(fieldName)) {
                titles.add(fieldTitles.get(i));
            }
        }
        return titles.size() > 0;
    }

    public boolean isFirstNameFieldEmpty() {
        return getFirstName().isEmpty();
    }

    public String getFirstName() {
        return firstNameField.getAttribute("value");
    }

    public String setFirstName(String firstName) {
        if (!isFirstNameFieldEmpty()) {
            firstNameField.clear();
        }
        firstNameField.sendKeys(firstName);
        return firstName;
    }

    public void saveChanges() {
        submitButton.click();
        waitRefreshPage();
    }

    public void waitRefreshPage() {
        getWebDriverWait().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='container']")));
    }
}
