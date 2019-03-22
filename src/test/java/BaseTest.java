import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import static java.util.concurrent.TimeUnit.SECONDS;

public class BaseTest {

    WebDriver driver;
    private String baseURL = "https://opensource-demo.orangehrmlive.com/";

    @BeforeClass
    public void initializeBrowser() {
        System.setProperty("webdriver.chrome.driver", "E:\\drivers\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, SECONDS);
        driver.get(baseURL);
    }

    @AfterClass
    public void closeBrowser() {
        driver.quit();
    }

}
