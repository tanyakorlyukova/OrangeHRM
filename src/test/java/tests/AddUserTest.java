package tests;

import org.openqa.selenium.By;
import org.testng.annotations.*;
import pages.UsersPage;

public class AddUserTest extends BaseTest {

    @BeforeGroups(groups = "addUser")
    public void login() {
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("admin123");
        driver.findElement(By.id("btnLogin")).click();
    }

    @DataProvider(name = "addValidUserData")
    public Object[][] addValidUserdata() {
        return new String[][] {
                {"Larry Page", "userlarry", "password", "password"},  //all fields - valid
                {"Larry Page", "itislarry", "", ""},   //password is not required
                {"Larry Page", "hhhhl", "password", "password"}  //5 characters in Username (at least 5)
        };
    }

    @DataProvider(name = "addInvalidUserData")
    public Object[][] addInvalidUserdata() {
        return new String[][] {
                {"", "", "", ""},   //empty
                {"d", "d", "d", "d"},   //invalid
                {"Larry Page", "hanna", "password", "otherpassword"},   //different password
                {"Larry Page", "Admin", "password", "password"},   //user Admin exist
                {"Larry Page", "page", "password", "password"},  //4 characters in Username (at least 5)
                {"notexistemployee", "exist", "password", "password"},  //employee does not exist
                {"Larry Page", "laaaaaary", "sssssss", "sssssss"}   //7 characters in Password (at least 8)
        };
    }

    @Test(dataProvider = "addValidUserData", groups = "addUser")
    public void addValidUserTest(String empName, String username, String password, String confPassword) {
        UsersPage usersPage = new UsersPage(driver);
        usersPage.openAddUserForm();
        usersPage.addValidUser(empName, username, password, confPassword);
        usersPage.deleteUser(username);
    }

    @Test(dataProvider = "addInvalidUserData", groups = "addUser")
    public void addInvalidUserTest(String empName, String username, String password, String confPassword) {
        UsersPage usersPage = new UsersPage(driver);
        usersPage.openAddUserForm();
        usersPage.addInvalidUser(empName, username, password, confPassword);
    }
}
