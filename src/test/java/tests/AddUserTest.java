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
        //!!! it is necessary to change "Username" (field 2) so that there is no error "user already exists"
        return new String[][] {
                {"Fiona Grace", "sipaoh", "password", "password"},  //all fields - valid
                {"Fiona Grace", "srphcee", "", ""},   //password is not required
                {"Fiona Grace", "sfpfa", "password", "password"}  //5 characters in Username (at least 5)
        };
    }

    @DataProvider(name = "addInvalidUserData")
    public Object[][] addInvalidUserdata() {
        return new String[][] {
                {"", "", "", ""},   //empty
                {"d", "d", "d", "d"},   //invalid
                {"Hannah Flores", "hanna", "password", "otherpassword"},   //different password
                {"Fiona Grace", "Admin", "password", "password"},   //user Admin exist
                {"Hannah Flores", "hana", "password", "password"},  //4 characters in Username (at least 5)
                {"notexistemployee", "exist", "password", "password"},  //employee does not exist
                {"Fiona Grace", "graaaaaaace", "sssssss", "sssssss"}   //7 characters in Password (at least 8)
        };
    }

    @Test(dataProvider = "addValidUserData", groups = "addUser")
    public void addValidUserTest(String empName, String username, String password, String confPassword) {
        UsersPage usersPage = new UsersPage(driver);
        usersPage.openAddUserForm();
        usersPage.addValidUser(empName, username, password, confPassword);
    }

    @Test(dataProvider = "addInvalidUserData", groups = "addUser")
    public void addInvalidUserTest(String empName, String username, String password, String confPassword) {
        UsersPage usersPage = new UsersPage(driver);
        usersPage.openAddUserForm();
        usersPage.addInvalidUser(empName, username, password, confPassword);
    }
}
