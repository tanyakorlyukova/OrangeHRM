package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UsersPage extends BasePage {

    private By adminModule = By.id("menu_admin_viewAdminModule");
    private By addButton = By.id("btnAdd");
    private By userRoleSelect = By.id("systemUser_userType");
    private By employeeNameInput = By.id("systemUser_employeeName_empName");
    private By usernameInput = By.id("systemUser_userName");
    private By statusSelect = By.id("systemUser_status");
    private By passwordInput = By.id("systemUser_password");
    private By confirmPasswordInput = By.id("systemUser_confirmPassword");
    private By saveButton = By.id("btnSave");
    private By selectAdmin = By.xpath("//option[contains(text(),'Admin')]");
    private By selectDisabled = By.xpath("//option[contains(text(),'Disabled')]");

    public UsersPage(WebDriver driver) {
        super(driver);
    }

    public void openAddUserForm() {
        waitForElement(adminModule);
        clickOn(adminModule);
        waitForElement(addButton);
        clickOn(addButton);
    }

    public void addValidUser(String empName, String username, String password, String confPassword) {
        clickOn(userRoleSelect);
        clickOn(selectAdmin);
        clickOn(statusSelect);
        clickOn(selectDisabled);
        addUserForm(empName, username, password, confPassword);
        waitForElement(By.xpath("//h1[contains(text(),'System Users')]"));
    }

    public void addUserForm(String empName, String username, String password, String confPassword) {
        typeIn(employeeNameInput, empName);
        typeIn(usernameInput, username);
        typeIn(passwordInput, password);
        typeIn(confirmPasswordInput, confPassword);
        clickOn(saveButton);
    }

    public String getAddUserPageText() {
        return getTextFrom(By.id("UserHeading"));
    }

    public String getUsernameText(String username) {
        return getTextFrom(By.xpath("//a[contains(text(),'" + username + "')]"));
    }

}
