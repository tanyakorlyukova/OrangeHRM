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

    @Test
    public void LoginTest_Valid() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.validLogin("Admin", "admin123", "Welcome Admin");
    }

}
