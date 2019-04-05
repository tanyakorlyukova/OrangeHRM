package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.LoginPage;
import pages.UsersPage;

public class AddUserTest extends BaseTest {

    @BeforeGroups(groups = "addUser")
    public void login() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginForm("Admin", "admin123");
    }

    @Test(dataProvider = "addValidUserData", dataProviderClass = TestDataProvider.class, groups = "addUser")
    public void addValidUserTest(String empName, String username, String password, String confPassword) {
        UsersPage usersPage = new UsersPage(driver);
        usersPage.openAddUserForm();
        usersPage.addValidUser(empName, username, password, confPassword);
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='head']/h1")).getText(), "System Users");
        Assert.assertEquals(driver.findElement(By.xpath("//a[contains(text(),'" + username + "')]")).getText(), username);
    }

    @Test(dataProvider = "addInvalidUserData", dataProviderClass = TestDataProvider.class, groups = "addUser")
    public void addInvalidUserTest(String empName, String username, String password, String confPassword) {
        UsersPage usersPage = new UsersPage(driver);
        usersPage.openAddUserForm();
        usersPage.addUserForm(empName, username, password, confPassword);
        Assert.assertEquals(driver.findElement(By.id("UserHeading")).getText(), "Add User");
    }
}
