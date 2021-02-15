package tests;

import lombok.extern.log4j.Log4j2;
import org.testng.Assert;
import org.testng.annotations.Test;

@Log4j2
public class NewsTests extends BaseTest {
    @Test
    public void mainNewsTitle() {
        mainPage.openPage();
        mainPage.openMainNews();
        Assert.assertEquals(newsPage.getArticleTitle(), mainPage.getTitleMainNews());
    }

    @Test
    public void newsAbilityInList() {
        mainPage.openPage();
        mainPage.openNewsPage();
        Assert.assertTrue(newsPage.isNewsPresent());
    }

    @Test
    public void openFirstNews() {
        mainPage.openPage();
        mainPage.openNewsPage();
        newsPage.scrollToNews();
        newsPage.openFirstNews();
        Assert.assertEquals(newsPage.getCurrentUrl(), newsPage.getLinkFirstNews());
    }
}
