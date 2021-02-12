package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTests extends BaseTest {
    @Test
    public void successLoginTest() throws IOException {
        mainPage.openPage();
        mainPage.openLoginPage();
        loginPage.enterEmail();
        loginPage.enterPassword();
        loginPage.clickSubmitButton();
        Assert.assertTrue(loginPage.isUserLoggedSuccessfully(), "Incorrect credentials!");
    }
}
