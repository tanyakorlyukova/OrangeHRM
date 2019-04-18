package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import static java.util.concurrent.TimeUnit.SECONDS;

public class BaseTest {

    WebDriver driver;
    private String baseURL = "https://opensource-demo.orangehrmlive.com/";

    @Parameters("browserName")
    @BeforeClass
    public void initializeBrowser(String browserName) {
        if (browserName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "E:\\drivers\\chromedriver\\chromedriver.exe");
            driver = new ChromeDriver();
        }
        if (browserName.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", "E:\\drivers\\firefoxdriver\\geckodriver.exe");
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, SECONDS);
        driver.get(baseURL);
    }

    @AfterClass
    public void closeBrowser() {
        driver.quit();
    }

}
