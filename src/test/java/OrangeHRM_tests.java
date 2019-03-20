import org.testng.annotations.*;

public class OrangeHRM_tests {

    private BaseTest baseTest;
    private LoginPage loginPage;

    @BeforeClass
    public void setUp() {
        baseTest = new BaseTest();
        baseTest.initializeBrowser();
    }

    @BeforeGroups(groups = "login")
    public void getLoginPage() {
        baseTest.initializePage(loginPage);
    }

    @Test(groups = "login")
    public void LoginTest_Valid() {
        loginPage.validLogin("Admin", "admin123");
    }

    @Test(groups = "login")
    public void LoginTest_Empty() {
        loginPage.invalidLogin("", "", "Username cannot be empty");
    }

    @Test(groups = "login")
    public void LoginTest_InvalidUsername() {
        loginPage.invalidLogin("invalid", "admin123", "Invalid credentials");
    }

    @Test(groups = "login")
    public void LoginTest_InvalidPassword() {
        loginPage.invalidLogin("Admin", "invalid", "Invalid credentials");
    }

    @Test(groups = "login")
    public void LoginTest_Invalid() {
        loginPage.invalidLogin("invalid", "invalid", "Invalid credentials");
    }

    @Test(groups = "login")
    public void LoginTest_SpecialSymbols() {
        loginPage.invalidLogin("@#$%&^~", "@#$%&^~", "Invalid credentials");
    }

    @AfterClass
    public void close() {
        baseTest.closeBrowser();
    }

}
