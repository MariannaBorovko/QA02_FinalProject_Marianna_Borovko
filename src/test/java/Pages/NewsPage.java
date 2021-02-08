package Pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.support.FindBy;

import java.io.FileNotFoundException;
import java.util.List;

@Log4j2
public class NewsPage extends MainPage{
    @FindBy(xpath = "//div[@class='article__container']//h1")
    WebElement articleTitle;
    @FindBy(xpath = "//div[@class='card card_media']")
    List<WebElement> news;

    public NewsPage(WebDriver driver) throws FileNotFoundException {
        super(driver);
    }
    public String getArticleTitle(){
        return articleTitle.getText();
    }

    public boolean isNewsPresent(){
        if (news.size()>0){
            return true;
        }
        else{
            log.error("List of news is empty");
            return false;
        }
    }

    public void openFirstNews(){
        log.info("openFirstNews method started");
        news.get(0).click();
    }

    public String getLinkFirstNews(){
        openPage();
        openNewsPage();
        return news.get(0).getAttribute("data-vr-contentbox-url");
    }

    public void scrollToNews(){
        Locatable firstNews = (Locatable) driver.findElement(By.xpath("//div[@class='card card_media']"));
        int y = firstNews.getCoordinates().onPage().getY();
        ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,"+y+");");
    }
}
