package BasicTests.basic;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ExceptionInAutomationWithExample extends BaseTest{

    //
    // InvalidSelectorException :
    // org.openqa.selenium.InvalidSelectorException: invalid selector: An invalid or illegal selector was specified
    // This exception will occur when we use a Xpath with cssSelector method from By class
    @Test
    public void invalidSelectorException() throws Exception {
        String url = "https://www.tutorialspoint.com/selenium/practice/browser-windows.php";
        driver.get(url);
        Thread.sleep(2000);
        int headerColumnNum = 0;

        WebElement newTabElement = driver.findElement(By.cssSelector("//button[@title='New Tab']/following-sibling::button[1]"));
        newTabElement.click();
        Thread.sleep(2000);
    }


    //NoSuchWindowException :
    //org.openqa.selenium.NoSuchWindowException: no such window: target window already closed
    //Without using the last line of code, it will throw the 'NoSuchWindowException',
    // Because the current window is closed and in the AfterMethod we are trying to close the same window(driver control in the new window its already closed),
    // to avoid 'NoSuchWindowException' after closing the new window, come back to parent window.
    @Test
    public void newTab() throws Exception {
        String url = "https://www.tutorialspoint.com/selenium/practice/browser-windows.php";
        driver.get(url);
        Thread.sleep(2000);
        int headerColumnNum = 0;

        WebElement newTabElement = driver.findElement(By.xpath("//button[@title='New Tab']"));
        newTabElement.click();
        Thread.sleep(2000);

        //parent id
        String parentWindowId = driver.getWindowHandle();
        String newId = null;

        Set<String> windows = driver.getWindowHandles();
        List<String> winArr = new ArrayList<>(windows);
        for(int i=1;i<winArr.size();i++){
            newId = winArr.get(i);
            //Switch to new Window
            driver.switchTo().window(newId);
            driver.close();
        }
        //driver.switchTo().window(parentWindowId);
    }

    //TimeoutException:
    //org.openqa.selenium.TimeoutException: Expected condition failed: waiting for alert to be present (tried for 6 second(s) with 500 milliseconds interval)
    // In the below code line 84 will give 'TimeoutException', Because within specified time the Alert didn't come.
    // To avoid this un comment line 82.
    @Test
    public void alertAccept() throws Exception {
        String url = "https://www.tutorialspoint.com/selenium/practice/alerts.php";
        driver.get(url);
        Thread.sleep(2000);
        String expectedText = "On button click, alert will appear after 5 seconds";
        List<WebElement> elements=  driver.findElements(By.xpath("//div[@class='d-flex justify-content-between mt-4']"));

        for(WebElement element :elements){
            String text = element.findElement(By.xpath("//div[@class='d-flex justify-content-between mt-4']//label")).getText();

            switch (text){
                case "On button click, alert will appear after 5 seconds":
                    //element.findElement(By.xpath("//div[@class='d-flex justify-content-between mt-4']//button")).click();
                    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
                    wait.until(ExpectedConditions.alertIsPresent());
                    Alert alert = driver.switchTo().alert();
                    String alertMessage = alert.getText();
                    System.out.println(alertMessage);
                    Assert.assertEquals(alertMessage,"Hello just appeared");
                    alert.accept();
            }
        }
    }

    /**
     * NoAlertPresentException:
     * org.openqa.selenium.NoAlertPresentException: no such alert
     * In this case the before occureing the alert The we are tying to switch to the alert.
     * In line 107 we are trying to switch to the aleret before it occuring. After executing 113 only the alert will be available.
     */
    @Test
    public void waitForAlertToBePresent() throws Exception {
        String url = "https://www.tutorialspoint.com/selenium/practice/alerts.php";
        driver.get(url);
        Thread.sleep(2000);
        String expectedText = "On button click, alert will appear after 5 seconds";
        List<WebElement> elements=  driver.findElements(By.xpath("//div[@class='d-flex justify-content-between mt-4']"));
        Alert alert = driver.switchTo().alert();
        for(WebElement element :elements){
            String text = element.findElement(By.xpath("//div[@class='d-flex justify-content-between mt-4']//label")).getText();

            switch (text){
                case "On button click, alert will appear after 5 seconds":
                    element.findElement(By.xpath("//div[@class='d-flex justify-content-between mt-4']//button")).click();
                    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
                    wait.until(ExpectedConditions.alertIsPresent());

                    String alertMessage = alert.getText();
                    System.out.println(alertMessage);
                    Assert.assertEquals(alertMessage,"Hello just appeared");
                    alert.accept();
            }
        }
    }

    /**
     * ElementClickInterceptedException:
     * org.openqa.selenium.ElementClickInterceptedException: element click intercepted: Element is not clickable at point (113, 164)
     * In the following code "//a[@href='/selenium/index.htm']" xpath identifies a text and if we try to click on text we will get ElementClickInterceptedException.
     */

    @Test
    public void frames() throws Exception {
        String url = "https://www.tutorialspoint.com/selenium/practice/frames.php";
        driver.get(url);
        Thread.sleep(2000);

        List<WebElement> frames = driver.findElements(By.tagName("iframe"));
        //Switch to frame by WebElement
        driver.switchTo().frame(frames.get(1));
        driver.findElement(By.xpath("//a[@href='/selenium/index.htm']")).click();
        String parent = driver.getWindowHandle();
        ArrayList<String> allWin = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(allWin.get(1));
        String nwurl = driver.getCurrentUrl();
        System.out.println(nwurl);
        Assert.assertEquals(nwurl,"https://www.tutorialspoint.com/selenium/index.htm");

    }

}
