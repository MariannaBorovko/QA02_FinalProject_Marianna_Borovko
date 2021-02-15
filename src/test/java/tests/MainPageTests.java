package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MainPageTests extends BaseTest {
    @Test
    public void openWebSite() {
        mainPage.openPage();
        Assert.assertEquals(mainPage.getCurrentUrl(), "https://dev.by/");
    }
}
