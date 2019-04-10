package tests;

import dataprovider.TestDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test(dataProvider = "loginData", dataProviderClass = TestDataProvider.class)
    public void LoginTest_Invalid(String username, String password, String message) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginForm(username, password);
        Assert.assertEquals(loginPage.getErrorText(), message);
    }

    @Test
    public void LoginTest_Valid() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginForm("Admin", "admin123");
        Assert.assertEquals(loginPage.getSuccessText(), "Welcome Admin");
    }
}
