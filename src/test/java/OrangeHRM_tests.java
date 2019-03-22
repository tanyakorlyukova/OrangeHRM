import org.testng.annotations.*;

public class OrangeHRM_tests extends BaseTest {

    @DataProvider(name = "logindata")
    public Object[][] data() {
        return new String[][] {
                {"", "", "Username cannot be empty"},
                {"invalid", "admin123", "Invalid credentials"},
                {"Admin", "invalid", "Invalid credentials"},
                {"invalid", "invalid", "Invalid credentials"},
                {"@#$%&^~", "@#$%&^~", "Invalid credentials"}
        };
    }

    @Test(dataProvider = "logindata")
    public void LoginTest_Invalid(String username, String password, String message) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.invalidLogin(username, password, message);
    }

    @Test(groups = "login")
    public void LoginTest_Valid() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.validLogin("Admin", "admin123", "Welcome Admin");
    }

    /*@Test(groups = "login")
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
    } */
}
