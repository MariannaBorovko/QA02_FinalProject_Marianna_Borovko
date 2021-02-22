package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
    WebElement premiumVacancy;
    @FindBy(xpath = "//div[@class ='vacancy__container']")
    WebElement vacancyContainer;
    @FindBy(xpath = "//div[@class ='vacancy__header__name']")
    WebElement vacancyContainerTitle;
    @FindBy(xpath = "//div[@class ='vacancies-list-item premium-vacancy vacancies-list-item--active']"
            + "//div[@class='premium-vacancy__title']")
    WebElement activeVacancyTitle;
    @FindBy (xpath = "//div[@class = 'wishes-popup__content']")
    List<WebElement> wishPopup;

    public JobsPage(WebDriver driver) {
        super(driver);
    }

    public void chooseQAManualPosition() {
        log.info("Choose QA manual position and click");
        qaManualPositionButton.click();
    }

    public void closeWishPopup() {
        if (isWishPopupPresent()) {
            log.info("Close Wish Popup");
            closeWishPopupButton.click();
        }
    }

    public boolean isListOfChosenPositionsEmpty() {
        log.info("Check list items present");
        return filterPositions.isEmpty();
    }

    public void openPremiumVacancy() {
        log.info("Open details of premium vacancy");
        premiumVacancy.click();
    }

    public boolean isVacancyContainerPresent() {
        log.info("Vacancy container present check");
        return vacancyContainer.isDisplayed();
    }

    public boolean isOpenedVacancyTitleIsCorrect() {
        log.info("Check title of active vacancy method is started");
        String vacancyTitleText = "Вакансия " + activeVacancyTitle.getText();
        String priceFromTitle = activeVacancyTitle
                .findElement(By.xpath("//span[@class='premium-vacancy__label']"))
                .getText();
        vacancyTitleText = vacancyTitleText.replace(priceFromTitle, "");
        return vacancyContainerTitle.getText().equals(vacancyTitleText.trim());
    }

    public boolean isWishPopupPresent() {
        return wishPopup.size()>0;
    }
}
