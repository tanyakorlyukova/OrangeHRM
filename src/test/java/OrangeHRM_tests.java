import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;

public class OrangeHRM_tests {

    private WebDriver driver;
    private String baseURL = "https://opensource-demo.orangehrmlive.com/";
    private LoginPage loginPage;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "E:\\drivers\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(baseURL);
        driver.manage().window().maximize();
    }

    @BeforeGroups(groups = "login")
    public void getLoginPage() {
        loginPage = PageFactory.initElements(driver, LoginPage.class);
    }

    @Test(groups = "login")
    public void LoginTest_Valid() {
        loginPage.validLogin(driver, "Admin", "admin123");
    }

    @Test(groups = "login")
    public void LoginTest_Empty() {
        loginPage.invalidLogin(driver, "", "", "Username cannot be empty");
    }

    @Test(groups = "login")
    public void LoginTest_InvalidUsername() {
        loginPage.invalidLogin(driver, "invalid", "admin123", "Invalid credentials");
    }

    @Test(groups = "login")
    public void LoginTest_InvalidPassword() {
        loginPage.invalidLogin(driver, "Admin", "invalid", "Invalid credentials");
    }

    @Test(groups = "login")
    public void LoginTest_Invalid() {
        loginPage.invalidLogin(driver, "invalid", "invalid", "Invalid credentials");
    }

    @Test(groups = "login")
    public void LoginTest_SpecialSymbols() {
        loginPage.invalidLogin(driver, "@#$%&^~", "@#$%&^~", "Invalid credentials");
    }

    @AfterClass
    public void close() {
        driver.quit();
    }

}
