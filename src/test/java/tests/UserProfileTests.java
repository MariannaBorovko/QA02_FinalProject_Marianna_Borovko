package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class UserProfileTests extends BaseTest {

    @Test
    public void logOut() {
        loginPage.login();
        mainPage.openUserProfile();
        userProfilePage.logOut();
        Assert.assertEquals(userProfilePage.getCurrentUrl(), "https://id.dev.by/@/hello");
    }

//    @Test
//    public void cityFieldPresentFailTest(){
//        loginPage.login();
//        mainPage.openUserProfile();
//        Assert.assertTrue(userProfilePage.isFieldPresent("Город"));

//    @Test
//    public void changeFistName(){
//        loginPage.login();
//        mainPage.openUserProfile();
//        userProfilePage.setFirstName("NameTest1");
//        userProfilePage.saveChanges();
//        Assert.assertEquals(userProfilePage.getFirstName(),"NameTest1");
//    }
}
