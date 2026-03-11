package BasicTests.basic;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

/**
 *
 * The StaleElementReferenceException in Selenium Java occurs when the referenced web element is no longer attached to the page's Document Object Model (DOM).
 * This typically happens after a page refresh, dynamic DOM updates via JavaScript/AJAX, or navigation.
 *
 * ways to handle StaleElementReferenceException exception:
 *
 * 1.  Re-Locate the Element ::-
 * 2.  Use Explicit Waits (WebDriverWait)
 * 3.  Implement Retry Logic (Try-Catch Block)
 * 4.  Refresh the Page and Re-Locate
 */

public class StaleElementReferenceExceptionTest extends BaseTest{

    //Re-Locate the Element ::-
    @Test
    public void relocateTheElement(){
         // Instead of storing a global or long-lived WebElement
        // WebElement myElement = driver.findElement(By.id("someId"));

        driver.findElement(By.id("submitBtn")).click();

    }

    //Use Explicit Waits (WebDriverWait)
    @Test
    public void useExplicitWait(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//tagName[@attribute='value']")));
    }

    @Test
    public void refreshThePage(){

        driver.navigate().refresh();
        driver.findElement(By.cssSelector("web element locator")).click();
    }

    @Test
    public void usingTryCatch() {
        try {
            driver.findElement(By.cssSelector("webelement locator")).click();
        } catch(StaleElementReferenceException e) {
            driver.navigate().refresh();
            driver.findElement(By.xpath("//tagName[@attribute='value']")).click();
        }
    }

        @Test
    public void waitUntilTheElementIsRefreshed(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//tagName[@attribute='value']"))));
    }

}
