package tests;

import dataprovider.TestDataProvider;
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

    @Test(dataProvider = "addValidJobTitle", dataProviderClass = TestDataProvider.class, groups = "JobTitles")
    public void addValidJobTitleTest(String title, String description, String path, String note) {
        JobTitlesPage jobTitlesPage = new JobTitlesPage(driver);
        jobTitlesPage.openJobTitlesPage();
        jobTitlesPage.addJobTitle(title, description, path, note);
        Assert.assertTrue(jobTitlesPage.isFound(title));
    }

    @Test(dataProvider = "addInvalidJobTitle", dataProviderClass = TestDataProvider.class, groups = "JobTitles")
    public void addInvalidJobTitleTest(String title, String description, String path, String note) {
        JobTitlesPage jobTitlesPage = new JobTitlesPage(driver);
        jobTitlesPage.openJobTitlesPage();
        jobTitlesPage.addJobTitle(title, description, path, note);
        Assert.assertEquals(jobTitlesPage.jobTitleText(), "Add Job Title");
    }

    @Test(dataProvider = "editOnValidJobTitle", dataProviderClass = TestDataProvider.class, groups = "JobTitles")
    public void editOnValidJobTitleTest(String title, String description, String path, String note) {
        JobTitlesPage jobTitlesPage = new JobTitlesPage(driver);
        jobTitlesPage.openJobTitlesPage();
        jobTitlesPage.editJobTitle("for editing", title, description, path, note);
        Assert.assertTrue(jobTitlesPage.isFound(title));
    }

    @Test(dataProvider = "editOnInvalidJobTitle", dataProviderClass = TestDataProvider.class, groups = "JobTitles")
    public void editOnInvalidJobTitleTest(String previous, String title, String description, String path, String note) {
        JobTitlesPage jobTitlesPage = new JobTitlesPage(driver);
        jobTitlesPage.openJobTitlesPage();
        jobTitlesPage.editJobTitle(previous, title, description, path, note);
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
