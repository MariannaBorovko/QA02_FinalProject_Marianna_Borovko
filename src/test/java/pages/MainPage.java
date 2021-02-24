package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Log4j2
public class MainPage extends BasePage {
    @FindBy(xpath = "//a[contains(text(),'Вход')]")
    WebElement loginPageButton;
    @FindBy(xpath = "//a[@class='navbar__user-name']")
    WebElement userProfileButton;

    @FindBy(xpath = "//nav[@class = 'navbar__nav navbar__nav_desktop']//a[contains(text(),'Новости')]")
    WebElement newsButton;
    @FindBy(xpath = "//nav[@class='navbar__nav navbar__nav_desktop']//a[contains(text(),'Вакансии')]")
    WebElement jobsButton;
    @FindBy(xpath = "//nav[@class='navbar__nav navbar__nav_desktop']//a[text()='События']")
    WebElement eventsButton;
    @FindBy(xpath = "//nav[@class='navbar__nav navbar__nav_desktop']//a[text()='Зарплаты']")
    WebElement salariesButton;
    @FindBy(xpath = "//nav[@class='navbar__nav navbar__nav_desktop']//a[text()='Компании']")
    WebElement companiesButton;
    @FindBy(xpath = "//nav[@class='navbar__nav navbar__nav_desktop']//a[text()='Корпблоги']")
    WebElement blogsButton;

    @FindBy(xpath = "//div[@class='cards-grid__item cards-grid__item_1']")
    WebElement mainNewsButton;
    @FindBy(xpath = "//div[@class='cards-grid__item cards-grid__item_1']//div[@class='card__title card__title_text-crop']")
    WebElement mainNewsTitle;

    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Step("Open LoginPage")
    public void openLoginPage() {
        log.info("Click login button");
        loginPageButton.click();
    }

    public void openUserProfile() {
        log.info("Click user profile button");
        userProfileButton.click();
    }

    public void openNewsPage() {
        log.info("Open news menu item");
        newsButton.click();
    }

    public void openJobsPage() {
        log.info("Open jobs menu item");
        jobsButton.click();
    }

    public void openEventsPage() {
        log.info("Open events menu item");
        eventsButton.click();
    }

    public void openSalariesPage() {
        log.info("Open salaries menu item");
        salariesButton.click();
    }

    public void openCompaniesPage() {
        log.info("Open companies menu item");
        companiesButton.click();
    }

    public void openBlogsPage() {
        log.info("Open blog menu item");
        blogsButton.click();
    }

    public void openMainNews() {
        log.info("Open main news");
        mainNewsButton.click();
    }

    public String getTitleMainNews() {
        log.info("Get main news title");
        openPage();
        return mainNewsTitle.getText();
    }
}
