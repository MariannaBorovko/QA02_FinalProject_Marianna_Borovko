package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.FileNotFoundException;
import java.util.List;

public class JobsPage extends MainPage {
    @FindBy(xpath = "//span[@class='radio']")
    List<WebElement> positions;
    @FindBy(xpath = "//label[@for='filter_specialization_title_qa_manual']")
    WebElement qaManualPositionButton;
    @FindBy(xpath = "//div[@class='wishes-popup__content']")
    WebElement wishPopup;
    @FindBy(xpath = "//button[@class='wishes-popup__button-close wishes-popup__button-close_icon']")
    WebElement closeWishPopupButton;
    @FindBy(xpath = "//span[@class='vacancies-list__filter-tag__text']")
    List<WebElement> filterPositions;
    @FindBy(xpath = "//div[@class ='vacancies-list-item premium-vacancy']")
    WebElement premiumVacancy;
    @FindBy(xpath = "//div[@class ='premium-vacancy__title']")
    WebElement premiumVacancyTitle;
    @FindBy(xpath = "//div[@class ='vacancy__container']")
    WebElement vacancyContainer;
    @FindBy(xpath = "//div[@class ='vacancy__header__name']")
    WebElement vacancyContainerTitle;
    @FindBy(xpath = "//div[@class ='vacancies-list-item premium-vacancy vacancies-list-item--active']")
    WebElement activeVacancy;
    @FindBy(xpath = "//div[@class ='vacancies-list-item premium-vacancy vacancies-list-item--active']//div[@class='premium-vacancy__title']")
    WebElement activeVacancyTitle;

    public JobsPage(WebDriver driver) throws FileNotFoundException {
        super(driver);
    }

    public void chooseQAManualPosition() {
        qaManualPositionButton.click();
    }

    public boolean isWishPopupAppeared() {
        return wishPopup.isDisplayed();
    }

    public void closeWishPopup() {
        if (isWishPopupAppeared() == true) {
            closeWishPopupButton.click();
        }
    }

    public boolean isListOfChosenPositionsEmpty() {
        if (filterPositions.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public void openPremiumVacancy() {
        premiumVacancy.click();
    }

    public boolean isVacancyContainerPresent() {
        if (vacancyContainer.isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isOpenedVacancyTitleIsCorrect() {
        if (isVacancyContainerPresent() == true) {
            String a = vacancyContainerTitle.getText() + " ";
            String b = "Вакансия " + activeVacancyTitle.getText();
            String c = driver
                    .findElement(By.xpath("//div[@class ='vacancies-list-item premium-vacancy vacancies-list-item--active']//div[@class='premium-vacancy__title']//span[@class='premium-vacancy__label']"))
                    .getText();
            b = b.replace(c, "");
            if (a.equals(b)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
