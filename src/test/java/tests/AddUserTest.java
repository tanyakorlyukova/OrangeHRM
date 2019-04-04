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

    @Test(dataProvider = "addValidUserData", groups = "addUser")
    public void addValidUserTest(String empName, String username, String password, String confPassword) {
        UsersPage usersPage = new UsersPage(driver);
        usersPage.openAddUserForm();
        usersPage.addValidUser(empName, username, password, confPassword);

        usersPage.wait(By.xpath("//h1[contains(text(),'System Users')]"));
        driver.findElement(By.xpath("//h1[contains(text(),'System Users')]"));
        usersPage.wait(By.xpath("//a[contains(text(),'" + username + "')]"));
        driver.findElement(By.xpath("//a[contains(text(),'" + username + "')]"));
        //usersPage.deleteUser(username);
    }

    @Test(dataProvider = "addInvalidUserData", groups = "addUser")
    public void addInvalidUserTest(String empName, String username, String password, String confPassword) {
        UsersPage usersPage = new UsersPage(driver);
        usersPage.openAddUserForm();
        usersPage.addUserForm(empName, username, password, confPassword);

        driver.findElement(By.xpath("//h1[contains(text(),'Add User')]"));
    }
}
