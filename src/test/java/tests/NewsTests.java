package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

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
        newsPage.openNews(1);
        Assert.assertEquals(newsPage.getCurrentUrl(), newsPage.getNewsLink(1));
    }
}
