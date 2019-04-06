package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForElement(By element) {
        WebDriverWait wait = new WebDriverWait(driver, 12);
        wait.until(ExpectedConditions.presenceOfElementLocated(element));
    }

    public WebElement find(By locator){
        return driver.findElement(locator);
    }

    public void clickOn(By locator) {
        find(locator).click();
    }

    public String getTextFrom(By locator) {
        find(locator).getText();
    }

    public void typeIn(By locator, String text) {
        find(locator).sendKeys(text);
    }

}
