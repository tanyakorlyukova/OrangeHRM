import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage extends BaseTest {

    private By usernameTextbox = By.id("txtUsername");
    private By passwordTextbox = By.id("txtPassword");
    private By loginButton = By.id("btnLogin");
    private By successMessage = By.className("panelTrigger");
    private By errorMessage = By.id("spanMessage");

    public void validLogin(String username, String password) {
        loginForm(username,password);
        Assert.assertEquals("Welcome Admin", driver.findElement(successMessage).getText());
    }

    public void invalidLogin(String username, String password, String errMessage) {
        loginForm(username,password);
        Assert.assertEquals(errMessage, driver.findElement(errorMessage).getText());
    }

    private void loginForm(String username, String password) {
        driver.findElement(usernameTextbox).sendKeys(username);
        driver.findElement(passwordTextbox).sendKeys(password);
        driver.findElement(loginButton).click();
    }
}