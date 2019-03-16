import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage {

    private By usernameTextbox = By.id("txtUsername");
    private By passwordTextbox = By.id("txtPassword");
    private By loginButton = By.id("btnLogin");
    private By successMessage = By.className("panelTrigger");
    private By errorMessage = By.id("spanMessage");

    public void validLogin(WebDriver driver, String username, String password) {
        driver.findElement(usernameTextbox).sendKeys(username);
        driver.findElement(passwordTextbox).sendKeys(password);
        driver.findElement(loginButton).click();
        Assert.assertEquals("Welcome Admin", driver.findElement(successMessage).getText());
    }

    public void invalidLogin(WebDriver driver, String username, String password, String errMessage) {
        driver.findElement(usernameTextbox).sendKeys(username);
        driver.findElement(passwordTextbox).sendKeys(password);
        driver.findElement(loginButton).click();
        Assert.assertEquals(errMessage, driver.findElement(errorMessage).getText());
    }
}
