package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MainTests extends BaseTest {
    @Test
    public void isWebSiteOpened() {
        mainPage.openWebSite();
        Assert.assertEquals(mainPage.getCurrentUrl(), "https://www.tut.by/");
    }
}
