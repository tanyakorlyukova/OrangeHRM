package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class UsersPage {

    private WebDriver driver;

    private By adminModule = By.id("menu_admin_viewAdminModule");
    private By addButton = By.id("btnAdd");
    private By userRoleSelect = By.id("systemUser_userType");
    private By employeeNameInput = By.id("systemUser_employeeName_empName");
    private By usernameInput = By.id("systemUser_userName");
    private By statusSelect = By.id("systemUser_status");
    private By passwordInput = By.id("systemUser_password");
    private By confirmPasswordInput = By.id("systemUser_confirmPassword");
    private By saveButton = By.id("btnSave");

    public UsersPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openAddUserForm() {
        driver.findElement(adminModule).click();
        driver.findElement(addButton).click();
    }

    public void addValidUser(String empName, String username, String password, String confPassword) {
        driver.findElement(userRoleSelect).click();
        driver.findElement(By.xpath("//option[contains(text(),'Admin')]")).click();
        driver.findElement(statusSelect).click();
        driver.findElement(By.xpath("//option[contains(text(),'Disabled')]")).click();
        addUserForm(empName, username, password, confPassword);
        driver.findElement(By.xpath("//h1[contains(text(),'System Users')]"));
        driver.findElement(By.xpath("//a[contains(text(),'" + username + "')]"));
    }

    public void addInvalidUser(String empName, String username, String password, String confPassword) {
        addUserForm(empName, username, password, confPassword);
        driver.findElement(By.xpath("//h1[contains(text(),'Add User')]"));
    }

    public void addUserForm(String empName, String username, String password, String confPassword) {
        driver.findElement(employeeNameInput).sendKeys(empName);
        driver.findElement(usernameInput).sendKeys(username);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(confirmPasswordInput).sendKeys(confPassword);
        driver.findElement(saveButton).click();
    }
}
