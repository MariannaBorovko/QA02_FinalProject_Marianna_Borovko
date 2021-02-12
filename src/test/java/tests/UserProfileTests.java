package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class UserProfileTests extends BaseTest{
    @Test
    public void logoutTest(){
        loginPage.login();
        mainPage.openUserProfile();
        userProfilePage.lougout();
        Assert.assertEquals(userProfilePage.getCurrentUrl(), "https://id.dev.by/@/hello");
    }
}
