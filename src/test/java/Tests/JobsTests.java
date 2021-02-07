package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class JobsTests extends BaseTest{

    @Test
    public void isFilterAppearedAfterChoiceOfPosition() throws IOException {
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
