package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test(dataProvider = "loginData")
    public void LoginTest_Invalid(String username, String password, String message) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.invalidLogin(username, password, message);
    }

    @Test
    public void LoginTest_Valid() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.validLogin("Admin", "admin123", "Welcome Admin");
    }
}
