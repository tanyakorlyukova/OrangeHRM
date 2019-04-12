package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasePage {

    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected void waitForElement(By element) {
        WebDriverWait wait = new WebDriverWait(driver, 12);
        wait.until(ExpectedConditions.presenceOfElementLocated(element));
    }

    protected WebElement find(By locator){
        return driver.findElement(locator);
    }

    protected List<WebElement> findElements(By locator) {
        return driver.findElements(locator);
    }

    protected void clickOn(By locator) {
        find(locator).click();
    }

    protected String getTextFrom(By locator) {
        return find(locator).getText();
    }

    protected void typeIn(By locator, String text) {
        find(locator).sendKeys(text);
    }

    protected void clear(By locator) {
        find(locator).clear();
    }

}
