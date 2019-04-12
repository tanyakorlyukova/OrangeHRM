package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;
import pages.JobTitlesPage;
import pages.LoginPage;

public class JobTitlesTest extends BaseTest {

    @BeforeGroups(groups = "JobTitles")
    public void login() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginForm("Admin", "admin123");
    }

    @Test(groups = "JobTitles")
    public void addValidJobTitleTest() {
        JobTitlesPage jobTitlesPage = new JobTitlesPage(driver);
        jobTitlesPage.openJobTitlesPage();
        jobTitlesPage.addJobTitle("QA Engineer", "The best job", "I think so");
        Assert.assertTrue(jobTitlesPage.isFound("QA Engineer"));
    }

    @Test(groups = "JobTitles")
    public void addInvalidJobTitleTest() {
        JobTitlesPage jobTitlesPage = new JobTitlesPage(driver);
        jobTitlesPage.openJobTitlesPage();
        jobTitlesPage.addJobTitle("", "", "");
        Assert.assertEquals(jobTitlesPage.jobTitleText(), "Add Job Title");
    }

    @Test(groups = "JobTitles")
    public void editOnValidJobTitleTest() {
        JobTitlesPage jobTitlesPage = new JobTitlesPage(driver);
        jobTitlesPage.openJobTitlesPage();
        jobTitlesPage.editJobTitle("for editing", "Automation QA", "Perfect job", "I think so");
        Assert.assertTrue(jobTitlesPage.isFound("Automation QA"));
    }

    @Test(groups = "JobTitles")
    public void editOnInvalidJobTitleTest() {
        JobTitlesPage jobTitlesPage = new JobTitlesPage(driver);
        jobTitlesPage.openJobTitlesPage();
        jobTitlesPage.editJobTitle("for invalid editing", "", "", "");
        Assert.assertEquals(jobTitlesPage.jobTitleText(), "Edit Job Title");
    }

    @Test(groups = "JobTitles")
    public void deleteJobTitleTest() {
        JobTitlesPage jobTitlesPage = new JobTitlesPage(driver);
        jobTitlesPage.openJobTitlesPage();
        jobTitlesPage.deleteJobTitle("forDeletion");
        Assert.assertFalse(jobTitlesPage.isFound("forDeletion"));
    }

}
