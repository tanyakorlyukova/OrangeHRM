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
        Assert.assertEquals(usersPage.getUsernameText(username), username);
    }

    @Test(dataProvider = "addInvalidUserData", dataProviderClass = TestDataProvider.class, groups = "addUser")
    public void addInvalidUserTest(String empName, String username, String password, String confPassword) {
        UsersPage usersPage = new UsersPage(driver);
        usersPage.openAddUserForm();
        usersPage.addUserForm(empName, username, password, confPassword);
        Assert.assertEquals(usersPage.getAddUserPageText(), "Add User");
    }
}
