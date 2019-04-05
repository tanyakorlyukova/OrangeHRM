package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonPageMethods {

    WebDriver driver;

    public CommonPageMethods(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForElement(By element) {
        WebDriverWait wait = new WebDriverWait(driver, 12);
        wait.until(ExpectedConditions.presenceOfElementLocated(element));
    }

}
