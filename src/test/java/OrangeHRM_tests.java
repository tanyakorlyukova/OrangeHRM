import org.testng.annotations.*;

public class OrangeHRM_tests extends BaseTest {

    @Test(groups = "login")
    public void LoginTest_Valid() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.validLogin("Admin", "admin123");
    }

    @Test(groups = "login")
    public void LoginTest_Empty() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.invalidLogin("", "", "Username cannot be empty");
    }

    @Test(groups = "login")
    public void LoginTest_InvalidUsername() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.invalidLogin("invalid", "admin123", "Invalid credentials");
    }

    @Test(groups = "login")
    public void LoginTest_InvalidPassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.invalidLogin("Admin", "invalid", "Invalid credentials");
    }

    @Test(groups = "login")
    public void LoginTest_Invalid() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.invalidLogin("invalid", "invalid", "Invalid credentials");
    }

    @Test(groups = "login")
    public void LoginTest_SpecialSymbols() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.invalidLogin("@#$%&^~", "@#$%&^~", "Invalid credentials");
    }
}
