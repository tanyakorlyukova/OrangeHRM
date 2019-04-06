package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private By usernameTextbox = By.id("txtUsername");
    private By passwordTextbox = By.id("txtPassword");
    private By loginButton = By.id("btnLogin");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void loginForm(String username, String password) {
        typeIn(usernameTextbox, username);
        typeIn(passwordTextbox, password);
        clickOn(loginButton);
    }

    public String getErrorText() {
        return getTextFrom(By.id("spanMessage"));
    }

    public String getSuccessText() {
        return getTextFrom(By.className("panelTrigger"));
    }
}
