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
    public void openVacancyContainer() {
        mainPage.openPage();
        mainPage.openJobsPage();
        jobsPage.closeWishPopup();
        jobsPage.openPremiumVacancy(1);
        Assert.assertTrue(jobsPage.isVacancyContainerPresent());
    }

   // @Test
    public void premiumVacancyTitle() {
        mainPage.openPage();
        mainPage.openJobsPage();
        jobsPage.closeWishPopup();
        jobsPage.openPremiumVacancy(1);
        Assert.assertTrue(jobsPage.isOpenedVacancyTitleIsCorrect());
    }
}
