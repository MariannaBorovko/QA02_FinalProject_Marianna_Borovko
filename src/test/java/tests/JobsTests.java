package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class JobsTests extends BaseTest{

    @Test
    public void isFilterAppearedAfterChoiceOfPosition(){
        mainPage.openPage();
        mainPage.openJobsPage();
        jobsPage.closeWishPopup();
        jobsPage.chooseQAManualPosition();
        Assert.assertFalse(jobsPage.isListOfChosenPositionsEmpty());
    }

    @Test
    public void isPremiumVacancyOpened(){
        mainPage.openPage();
        mainPage.openJobsPage();
        jobsPage.closeWishPopup();
        jobsPage.openPremiumVacancy();
        Assert.assertTrue(jobsPage.isOpenedVacancyTitleIsCorrect());

    }

}