package tests;

import dataprovider.TestDataProvider;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;
import pages.JobTitlesPage;
import pages.LoginPage;

public class JobTitlesTest extends BaseTest {

    @BeforeGroups(groups = "JobTitles")
    public void login() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginForm("Admin", "admin123");
        JobTitlesPage jobTitlesPage = new JobTitlesPage(driver);
        jobTitlesPage.openJobTitlesPage();
    }

    @Test(dataProvider = "addValidJobTitle", dataProviderClass = TestDataProvider.class,
            groups = "JobTitles")
    public void addValidJobTitleTest(String title, String description, String path, String note) {
        JobTitlesPage jobTitlesPage = new JobTitlesPage(driver);
        int countOfJobTitles = jobTitlesPage.getCountOfJobTitles();
        jobTitlesPage.addJobTitle(title, description, path, note);
        Assert.assertTrue(jobTitlesPage.isFound(title));
        Assert.assertEquals(jobTitlesPage.getCountOfJobTitles(), countOfJobTitles + 1);
    }

    @Test(dataProvider = "addInvalidJobTitle", dataProviderClass = TestDataProvider.class,
            groups = {"JobTitles", "invalid"})
    public void addInvalidJobTitleTest(String title, String description, String path, String note) {
        JobTitlesPage jobTitlesPage = new JobTitlesPage(driver);
        jobTitlesPage.addJobTitle(title, description, path, note);
        Assert.assertEquals(jobTitlesPage.getHeadingText(), "Add Job Title");
    }

    @Test(dataProvider = "editOnValidJobTitle", dataProviderClass = TestDataProvider.class,
               groups = "JobTitles")
    public void editOnValidJobTitleTest(String title, String description, String path, String note) {
           JobTitlesPage jobTitlesPage = new JobTitlesPage(driver);
           jobTitlesPage.editJobTitle(title, description, path, note);
           Assert.assertTrue(jobTitlesPage.isFound(title));
    }

    @Test(dataProvider = "editOnInvalidJobTitle", dataProviderClass = TestDataProvider.class,
               groups = {"JobTitles", "invalid"})
    public void editOnInvalidJobTitleTest(String title, String description, String path, String note) {
           JobTitlesPage jobTitlesPage = new JobTitlesPage(driver);
           jobTitlesPage.editJobTitle(title, description, path, note);
           Assert.assertEquals(jobTitlesPage.getHeadingText(), "Edit Job Title");
    }

    @Test(dataProvider = "deleteJobTitle", dataProviderClass = TestDataProvider.class,
            groups = "JobTitles")
    public void deleteJobTitleTest(String n) {
        int number = Integer.parseInt(n);
        JobTitlesPage jobTitlesPage = new JobTitlesPage(driver);
        int countOfJobTitles = jobTitlesPage.getCountOfJobTitles();
        jobTitlesPage.deleteJobTitle(number);
        Assert.assertEquals(jobTitlesPage.getCountOfJobTitles(), countOfJobTitles - number);
    }

    @Test(groups = "JobTitles")
    public void invalidDeletion() {
        JobTitlesPage jobTitlesPage = new JobTitlesPage(driver);
        int countOfJobTitles = jobTitlesPage.getCountOfJobTitles();
        jobTitlesPage.deleteJobTitle(0);
        Assert.assertEquals(jobTitlesPage.getCountOfJobTitles(), countOfJobTitles);
    }

    @AfterMethod
    public void openJobTitles() {
        JobTitlesPage jobTitlesPage = new JobTitlesPage(driver);
        if(jobTitlesPage.getHeadingText().equals("Add Job Title") || jobTitlesPage.getHeadingText().equals("Edit Job Title")) {
            jobTitlesPage.openJobTitles();
        }
    }
}
