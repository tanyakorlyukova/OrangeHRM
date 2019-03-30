package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
    private By successfullySaved = By.xpath("//h1[contains(text(),'System Users')]");
    private By addUserText = By.xpath("//h1[contains(text(),'Add User')]");
    private By selectAdmin = By.xpath("//option[contains(text(),'Admin')]");
    private By selectDisabled = By.xpath("//option[contains(text(),'Disabled')]");
    private By searchTextbox = By.id("searchSystemUser_userName");
    private By searchButton = By.id("searchBtn");
    private By selectAllUsers = By.id("ohrmList_chkSelectAll");
    private By deleteButton = By.id("btnDelete");
    private By dialogDeleteButton = By.id("dialogDeleteBtn");

    public UsersPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openAddUserForm() {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.presenceOfElementLocated(adminModule));
        driver.findElement(adminModule).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(addButton));
        driver.findElement(addButton).click();
    }

    public void addValidUser(String empName, String username, String password, String confPassword) {
        driver.findElement(userRoleSelect).click();
        driver.findElement(selectAdmin).click();
        driver.findElement(statusSelect).click();
        driver.findElement(selectDisabled).click();
        addUserForm(empName, username, password, confPassword);
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.presenceOfElementLocated(successfullySaved));
        driver.findElement(successfullySaved);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'" + username + "')]")));
        driver.findElement(By.xpath("//a[contains(text(),'" + username + "')]"));
    }

    public void addInvalidUser(String empName, String username, String password, String confPassword) {
        addUserForm(empName, username, password, confPassword);
        driver.findElement(addUserText);
    }

    public void addUserForm(String empName, String username, String password, String confPassword) {
        driver.findElement(employeeNameInput).sendKeys(empName);
        driver.findElement(usernameInput).sendKeys(username);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(confirmPasswordInput).sendKeys(confPassword);
        driver.findElement(saveButton).click();
    }

    public void deleteUser(String username) {
        driver.findElement(searchTextbox).sendKeys(username);
        driver.findElement(searchButton).click();
        WebDriverWait wait = new WebDriverWait(driver, 8);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'" + username + "')]")));
        driver.findElement(selectAllUsers).click();
        driver.findElement(deleteButton).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(dialogDeleteButton));
        driver.findElement(dialogDeleteButton).click();
    }
}
