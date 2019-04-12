package tests;

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
    public void addJobTitleTest() {
        JobTitlesPage jobTitlesPage = new JobTitlesPage(driver);
        jobTitlesPage.openJobTitlesPage();
        jobTitlesPage.addJobTitle("QA Engineer", "The best job", "I think so");
    }

    @Test(groups = "JobTitles")
    public void editJobTitleTest() {
        JobTitlesPage jobTitlesPage = new JobTitlesPage(driver);
        jobTitlesPage.openJobTitlesPage();
        jobTitlesPage.editJobTitle("QA Engineer", "Automation QA", "Perfect job", "I think so");
    }

    @Test(groups = "JobTitles")
    public void deleteJobTitleTest() {
        JobTitlesPage jobTitlesPage = new JobTitlesPage(driver);
        jobTitlesPage.openJobTitlesPage();
        jobTitlesPage.deleteJobTitle("forDeletion");
    }

}
