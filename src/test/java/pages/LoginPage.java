package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    private WebDriver driver;

    private By usernameTextbox = By.id("txtUsername");
    private By passwordTextbox = By.id("txtPassword");
    private By loginButton = By.id("btnLogin");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void wait(By element) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.presenceOfElementLocated(element));
    }

    public void loginForm(String username, String password) {
        driver.findElement(usernameTextbox).sendKeys(username);
        driver.findElement(passwordTextbox).sendKeys(password);
        driver.findElement(loginButton).click();
    }
}
