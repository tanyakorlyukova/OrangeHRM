import org.testng.annotations.*;
import pages.LoginPage;
import pages.UsersPage;

public class OrangeHRM_tests extends BaseTest {

    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        return new String[][] {
                {"", "", "Username cannot be empty"},
                {"invalid", "admin123", "Invalid credentials"},
                {"Admin", "invalid", "Invalid credentials"},
                {"invalid", "invalid", "Invalid credentials"},
                {"@#$%&^~", "@#$%&^~", "Invalid credentials"}
        };
    }

 /*   @Test(dataProvider = "loginData")
    public void LoginTest_Invalid(String username, String password, String message) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.invalidLogin(username, password, message);
    } */

    @Test
    public void LoginTest_Valid() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.validLogin("Admin", "admin123", "Welcome Admin");
    }

    @DataProvider(name = "addUserData")
    public Object[][] addUserdata() {
        return new String[][] {
                {"valid", "Fiona Grace", "fiooonna", "password", "password"},
                {"empty", "", "", "", ""},
                {"invalid", "d", "d", "d", "d"},
                {"invalid password confirmation", "Hannah Flores", "hanna", "password", "otherpassword"}
        };
    }

    @Test(dataProvider = "addUserData")
    public void addUserTest(String testTitle, String empName, String username, String password, String confPassword) {
        UsersPage usersPage = new UsersPage(driver);
        usersPage.openAddUserForm();
        usersPage.addUser(testTitle, empName, username, password, confPassword);
    }
}
