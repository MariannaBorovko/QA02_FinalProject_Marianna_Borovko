package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

@Log4j2
public class JobsPage extends MainPage {
    @FindBy(xpath = "//label[@for='filter_specialization_title_qa_manual']")
    WebElement qaManualPositionButton;
    @FindBy(xpath = "//button[@class='wishes-popup__button-close wishes-popup__button-close_icon']")
    WebElement closeWishPopupButton;
    @FindBy(xpath = "//span[@class='vacancies-list__filter-tag__text']")
    List<WebElement> filterPositions;
    @FindBy(xpath = "//div[@class ='vacancies-list-item premium-vacancy']")
    List<WebElement> premiumVacancy;
    @FindBy(xpath = "//div[@class ='vacancy__container']")
    WebElement vacancyContainer;
    @FindBy(xpath = "//div[@class ='vacancy__header__name']")
    WebElement vacancyContainerTitle;
    @FindBy(xpath = "//div[@class ='vacancies-list-item premium-vacancy vacancies-list-item--active']//div[@class='premium-vacancy__title']")
    WebElement activeVacancyTitle;
    @FindBy(xpath = "//div[@class = 'wishes-popup__content']")
    WebElement wishPopup;
    @FindBy(xpath = "//span[@class='vacancies-list__filter-tag__text']")
    WebElement filterVacancyTitle;
    @FindBy(xpath = "//div[@class ='vacancies-list__body js-vacancies-list__body']")
    WebElement vacanciesList;

    public JobsPage(WebDriver driver) {
        super(driver);
    }

    public void chooseQAManualPosition() {
        log.info("Choose QA manual position and click");
        qaManualPositionButton.click();
        waitForFilterAppears();
    }

    public void closeWishPopup() {
        if (isWishPopupPresent()) {
            log.info("Close Wish Popup");
            closeWishPopupButton.click();
        }
        waitForVacanciesList();
    }

    public boolean isListOfChosenPositionsEmpty() {
        log.info("Check list items present");
        return filterPositions.isEmpty();
    }

    public void openPremiumVacancy(int premiumVacancyNumber) {
        log.info("Open details of premium vacancy");
        premiumVacancy.get(premiumVacancyNumber - 1).click();
        waitForVacancyContainer();
    }

    public String getActiveVacancyTitle() {
        log.error("getActiveVacancyTitle = " + activeVacancyTitle.getText());
        return activeVacancyTitle.getText();
    }

    public boolean isVacancyContainerPresent() {
        log.info("Vacancy container present check");
        return vacancyContainer.isDisplayed();
    }

    public boolean isOpenedVacancyTitleIsCorrect() {
        log.info("Check title of active vacancy method is started");
        String vacancyTitleText = "Вакансия " + getActiveVacancyTitle();
        String priceFromTitle = activeVacancyTitle
                .findElement(By.xpath("//span[@class='premium-vacancy__label']"))
                .getText();
        log.error("vacancyTitleText = [" + vacancyTitleText + "]");
        log.error("priceFromTitle = [" + priceFromTitle + "]");
        vacancyTitleText = vacancyTitleText.replace(priceFromTitle, "");
        log.error("newVacancyTitleText = [" + vacancyTitleText.trim() + "]");
        log.error("vacancyContainerTitle = [" + vacancyContainerTitle.getText() + "]");
        return vacancyContainerTitle.getText().equals(vacancyTitleText.trim());
    }

    public void waitForWishPopup() {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(wishPopup));
    }

    public boolean isWishPopupPresent() {
        waitForWishPopup();
        return wishPopup.isDisplayed();
    }

    public void waitForVacanciesList() {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(vacanciesList));
    }

    public void waitForFilterAppears() {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(filterVacancyTitle));
    }

    public void waitForVacancyContainer() {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(vacancyContainerTitle));
    }
}
