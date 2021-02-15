package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class JobsTests extends BaseTest {

    @Test
    public void filterAbilityAfterPositionChoice() {
        mainPage.openPage();
        mainPage.openJobsPage();
        jobsPage.closeWishPopup();
        jobsPage.chooseQAManualPosition();
        Assert.assertFalse(jobsPage.isListOfChosenPositionsEmpty());
    }

    @Test
    public void openPremiumVacancy() {
        mainPage.openPage();
        mainPage.openJobsPage();
        jobsPage.closeWishPopup();
        jobsPage.openPremiumVacancy();
        Assert.assertTrue(jobsPage.isOpenedVacancyTitleIsCorrect());

    }
}
