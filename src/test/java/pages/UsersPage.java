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

    public void addUser(String testTitle, String empName, String username, String password, String confPassword) {
        addUserForm(empName, username, password, confPassword);

        switch (testTitle) {
            case "valid": validTest(username, empName);
            case "empty": emptyTest();
            case "invalid": invalidTest();
            case "invalid password confirmation": invPasswConfTest();
        }
    }

    public void addUserForm(String empName, String username, String password, String confPassword) {
        //driver.findElement(userRoleSelect);
        driver.findElement(employeeNameInput).sendKeys(empName);
        driver.findElement(usernameInput).sendKeys(username);
        //driver.findElement(statusSelect);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(confirmPasswordInput).sendKeys(confPassword);
        driver.findElement(saveButton).click();
    }

    private void validTest(String username, String empName) {
        driver.findElement(By.xpath("//a[contains(text(),'" + username + "')]")).click();
        Assert.assertEquals(driver.findElement(By.id("systemUser_employeeName_empName")).getText(), empName);
    }

    private void emptyTest() {
        driver.findElement(By.xpath("//span[contains(text(),'Employee does not exist')]"));
        driver.findElement(By.xpath("//span[contains(text(),'Required')]"));
    }

    private void invalidTest() {
        driver.findElement(By.xpath("//span[contains(text(),'Employee does not exist')]"));
        driver.findElement(By.xpath("//span[contains(text(),'Should have at least 5 characters')]"));
        driver.findElement(By.xpath("//span[contains(text(),'Should have at least 8 characters')]"));
        driver.findElement(By.xpath("//span[contains(text(),'Please enter at least 8 characters.')]"));
    }

    private void invPasswConfTest() {
        driver.findElement(By.xpath("//span[contains(text(),'Passwords do not match')]"));
    }
}
