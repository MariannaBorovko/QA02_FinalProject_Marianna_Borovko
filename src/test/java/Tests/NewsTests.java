package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class NewsTests extends BaseTest{
    @Test
    public void isArticleTitleCorrectTest() throws IOException {
        mainPage.openPage();
        mainPage.openMainNews();
        Assert.assertEquals(newsPage.getArticleTitle(), mainPage.getTitleMainNews());
    }

    @Test
    public void isNewsPresentTest() throws IOException {
        mainPage.openPage();
        mainPage.openNewsPage();
        Assert.assertTrue(newsPage.isNewsPresent());
    }

    @Test
    public void isNewsOpened() throws IOException {
        mainPage.openPage();
        mainPage.openNewsPage();
        newsPage.scrollToNews();
        newsPage.openFirstNews();
        Assert.assertEquals(newsPage.getCurrentUrl(), newsPage.getLinkFirstNews());
    }
}
