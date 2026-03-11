package BasicTests.basic;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Frames extends BaseTest {

    /**
     * We can switch to frame in three different ways
     *
     * // By passing the index of the frame and the index starts from '0'
     *  driver.switchTo().frame(0);
     *
     *  //by passing the WebElement
     *  driver.switchTo().frame(webElement);
     *
     *  //By passing String "nameOrId" of the frame
     *  driver.switchTo().frame("frameName");
     *
     *  //to come back to main window
     *   driver.switchTo().defaultContent();
     *
     *   //to come back to main frame
     *   // driver.switchTo().parentFrame();
     *
     * @throws Exception
     */
    @Test
    public void frames() throws Exception {
        String url = "https://www.tutorialspoint.com/selenium/practice/frames.php";
        driver.get(url);
        Thread.sleep(2000);

        List<WebElement> frames = driver.findElements(By.tagName("iframe"));

        //Switch to frame by index
       driver.switchTo().frame(0);
       String placeHolder = driver.findElement(By.xpath("//a[@href='/selenium/index.htm']")).getText();
       Assert.assertEquals(placeHolder,"Selenium Tutorial");
       driver.findElement(By.xpath("//a[@href='https://www.tutorialspoint.com']")).click();

       //Switch to parent frame
       // driver.switchTo().parentFrame();
        driver.switchTo().defaultContent();

        //Switch to frame by WebElement
        driver.switchTo().frame(frames.get(1));
        String t = driver.findElement(By.xpath("//a[@href='/selenium/index.htm']")).getText();
       WebElement element =  driver.findElement(By.xpath("//a[@href='/selenium/index.htm']"));

       //JavaScript to scroll
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView(true);",element);
        Thread.sleep(5000);
        //Wait for the element to be clickable
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();

        String parent = driver.getWindowHandle();
        ArrayList<String> allWin = new ArrayList<>(driver.getWindowHandles());
        //switch to child window
        driver.switchTo().window(allWin.get(1));
        String nwurl = driver.getCurrentUrl();
        System.out.println(nwurl);
        Assert.assertEquals(nwurl,"https://www.tutorialspoint.com/selenium/index.htm");

        //switch to main window
        driver.switchTo().window(parent);
        String parntUrl = driver.getCurrentUrl();
        System.out.println(parntUrl);
        Assert.assertEquals(parntUrl,"https://www.tutorialspoint.com/selenium/practice/frames.php");
    }



}
