package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends CommonPageMethods {

    private By usernameTextbox = By.id("txtUsername");
    private By passwordTextbox = By.id("txtPassword");
    private By loginButton = By.id("btnLogin");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void loginForm(String username, String password) {
        driver.findElement(usernameTextbox).sendKeys(username);
        driver.findElement(passwordTextbox).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    public String getErrorText() {
        return driver.findElement(By.id("spanMessage")).getText();
    }

    public String getSuccessText() {
        return driver.findElement(By.className("panelTrigger")).getText();
    }
}
