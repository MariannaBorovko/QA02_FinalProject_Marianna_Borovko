package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

@Log4j2
public class NewsPage extends MainPage {
    @FindBy(xpath = "//div[@class='article__container']//h1")
    WebElement articleTitle;
    @FindBy(xpath = "//div[@class='card card_media']")
    List<WebElement> news;
    @FindBy(xpath = "//div[@class='cards-group cards-group_list']")
    WebElement newsContainer;

    public NewsPage(WebDriver driver) {
        super(driver);
    }

    public String getArticleTitle() {
        waitForLoadingArticlePage();
        log.info("Get Article Title");
        return articleTitle.getText();
    }

    public boolean isNewsPresent() {
        log.info("Check if news present");
        return news.size() > 0;
    }

    public void openNews(int newsNumber) {
        log.info("openFirstNews method started");
        news.get(newsNumber - 1).click();
    }

    public String getNewsLink(int newsNumber) {
        log.info("Get news link");
        openPage();
        openNewsPage();
        return news.get(newsNumber - 1).getAttribute("data-vr-contentbox-url");
    }

    public void scrollToNews() {
        waitForLoadingNewsPage();
        log.info("Scroll to news");
        Locatable firstNews = (Locatable) driver.findElement(By.xpath("//div[@class='card card_media']"));
        int y = firstNews.getCoordinates().onPage().getY();
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0," + y + ");");
    }
    public void waitForLoadingNewsPage(){
        getWebDriverWait().until(ExpectedConditions.visibilityOf(newsContainer));
    }

    public void waitForLoadingArticlePage(){
        getWebDriverWait().until(ExpectedConditions.visibilityOf(articleTitle));
    }
}
