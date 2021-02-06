package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class MainPageTests extends BaseTest {
    @Test
    public void isWebSiteOpened() throws IOException {
        mainPage.openPage();
        Assert.assertEquals(mainPage.getCurrentUrl(), "https://dev.by/");
    }
}
