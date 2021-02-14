package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class NewsTests extends BaseTest {
    @Test
    public void isArticleTitleCorrectTest() {
        mainPage.openPage();
        mainPage.openMainNews();
        Assert.assertEquals(newsPage.getArticleTitle(), mainPage.getTitleMainNews());
    }

    @Test
    public void isNewsPresentTest() {
        mainPage.openPage();
        mainPage.openNewsPage();
        Assert.assertTrue(newsPage.isNewsPresent());
    }

    @Test
    public void isNewsOpened() {
        mainPage.openPage();
        mainPage.openNewsPage();
        newsPage.scrollToNews();
        newsPage.openFirstNews();
        Assert.assertEquals(newsPage.getCurrentUrl(), newsPage.getLinkFirstNews());
    }
}
