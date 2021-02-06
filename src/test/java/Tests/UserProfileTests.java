package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class UserProfileTests extends BaseTest{
    @Test
    public void logoutTest() throws IOException {
        loginPage.login();
        mainPage.openUserProfile();
        userProfilePage.lougout();
        Assert.assertEquals(userProfilePage.getCurrentUrl(), "https://id.dev.by/@/hello");
    }
}
