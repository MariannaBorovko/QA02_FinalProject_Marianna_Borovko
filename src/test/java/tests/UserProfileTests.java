package tests;

import lombok.extern.log4j.Log4j2;
import org.testng.Assert;
import org.testng.annotations.Test;

@Log4j2
public class UserProfileTests extends BaseTest {
    @Test
    public void logOut() {
        loginPage.login();
        mainPage.openUserProfile();
        userProfilePage.lougout();
        Assert.assertEquals(userProfilePage.getCurrentUrl(), "https://id.dev.by/@/hello");
    }
}
