package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UsersPage extends CommonPageMethods {

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
    private By searchTextbox = By.id("searchSystemUser_userName");
    private By searchButton = By.id("searchBtn");
    private By selectAllUsers = By.id("ohrmList_chkSelectAll");
    private By deleteButton = By.id("btnDelete");
    private By dialogDeleteButton = By.id("dialogDeleteBtn");

    public UsersPage(WebDriver driver) {
        super(driver);
    }

    public void openAddUserForm() {
        waitForElement(adminModule);
        driver.findElement(adminModule).click();
        waitForElement(addButton);
        driver.findElement(addButton).click();
    }

    public void addValidUser(String empName, String username, String password, String confPassword) {
        driver.findElement(userRoleSelect).click();
        driver.findElement(selectAdmin).click();
        driver.findElement(statusSelect).click();
        driver.findElement(selectDisabled).click();
        addUserForm(empName, username, password, confPassword);
        waitForElement(By.xpath("//h1[contains(text(),'System Users')]"));
    }

    public void addUserForm(String empName, String username, String password, String confPassword) {
        driver.findElement(employeeNameInput).sendKeys(empName);
        driver.findElement(usernameInput).sendKeys(username);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(confirmPasswordInput).sendKeys(confPassword);
        driver.findElement(saveButton).click();
    }

    public String getAddUserPageText() {
        return driver.findElement(By.id("UserHeading")).getText();
    }

    public String getUsernameText(String username) {
        return driver.findElement(By.xpath("//a[contains(text(),'" + username + "')]")).getText();
    }

    public void deleteUser(String username) {
        driver.findElement(searchTextbox).sendKeys(username);
        driver.findElement(searchButton).click();
        waitForElement(By.xpath("//a[contains(text(),'" + username + "')]"));
        driver.findElement(selectAllUsers).click();
        driver.findElement(deleteButton).click();
        waitForElement(dialogDeleteButton);
        driver.findElement(dialogDeleteButton).click();
    }
}
