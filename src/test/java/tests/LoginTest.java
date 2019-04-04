package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test(dataProvider = "loginData", dataProviderClass = TestDataProvider.class)
    public void LoginTest_Invalid(String username, String password, String message) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginForm(username, password);
        Assert.assertEquals(message, driver.findElement(By.id("spanMessage")).getText());
    }

    @Test
    public void LoginTest_Valid() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginForm("Admin", "admin123");
        loginPage.wait(By.className("panelTrigger"));
        Assert.assertEquals("Welcome Admin", driver.findElement(By.className("panelTrigger")).getText());
    }
}
