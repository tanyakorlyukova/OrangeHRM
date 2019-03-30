package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage {

    private WebDriver driver;

    private By usernameTextbox = By.id("txtUsername");
    private By passwordTextbox = By.id("txtPassword");
    private By loginButton = By.id("btnLogin");
    private By successMessage = By.className("panelTrigger");
    private By errorMessage = By.id("spanMessage");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void validLogin(String username, String password, String message) {
        loginForm(username,password);
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.presenceOfElementLocated(successMessage));
        Assert.assertEquals(message, driver.findElement(successMessage).getText());
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
