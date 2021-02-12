package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
    @Test
    public void successLoginTest(){
        mainPage.openPage();
        mainPage.openLoginPage();
        loginPage.enterEmail();
        loginPage.enterPassword();
        loginPage.clickSubmitButton();
        Assert.assertTrue(loginPage.isUserLoggedSuccessfully(), "Incorrect credentials!");
    }
}
