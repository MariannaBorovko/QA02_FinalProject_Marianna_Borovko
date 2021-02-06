package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.FileNotFoundException;
import java.io.IOException;

public class MainPage extends BasePage {
    @FindBy(xpath = "//a[contains(text(),\'Вход\')]")
    WebElement loginPageButton;

    @FindBy(xpath = "//a[@class='navbar__user-name']")
    WebElement userProfileButton;

    @FindBy(xpath = "//nav[@class='navbar__nav navbar__nav_desktop']//a[text()='Новости']")
    WebElement newsButton;
    @FindBy(xpath = "//nav[@class='navbar__nav navbar__nav_desktop']//a[text()='Вакансии']")
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

    public MainPage(WebDriver driver) throws FileNotFoundException {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void openLoginPage() {
        loginPageButton.click();
    }

    public void openUserProfile() {
        userProfileButton.click();
    }

    public void openNewsPage() {
        newsButton.click();
    }

    public void openJobsPage() {
        jobsButton.click();
    }

    public void openEventsPage() {
        eventsButton.click();
    }

    public void openSalariesPage() {
        salariesButton.click();
    }

    public void openCompaniesPage() {
        companiesButton.click();
    }

    public void openBlogsPage() {
        blogsButton.click();
    }

    public void openMainNews() {
        mainNewsButton.click();
    }

    public String getTitleMainNews() throws IOException {
        openPage();
        return mainNewsTitle.getText();
    }
}
