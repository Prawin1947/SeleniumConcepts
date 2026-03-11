package BasicTests.waits;

import BasicTests.basic.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.function.Function;

public class WaitsInSelenium extends BaseTest {

    /**
     *  Waits in selenium categorised in to two types
     *  a. Implecit Wait
     *  b. Explicit Wait
     *
     *  a.  Implcit Wait: The main function of the implicitwait is
     *      to wait for a certain amount of time before throwing an exception("NoSuchElementException").
     *      It is a kind of global wait applicable to the whole driver session.
     *      Eg: driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
     */


    @Test
    public void implicitWait()throws Exception {
        String url = " https://www.tutorialspoint.com/selenium/practice/check-box.php";
        driver.get(url);

        //implicitwait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        WebElement element = driver.findElement(By.xpath("//ul[@id='bs_main']/li[@id='bs_1']/span"));
        element.click();
        Thread.sleep(2000);

    }

    /**
     * b. Explicit Wait
     *   ExplicitWait is a type of wait in which selenium instructs the webdriver to wait un till certain condition is met or maximum time is elaplsed
     *
     *   There are two type in it:
     *    1. WebdriverWait
     *    2. FluentWait
     *
     */

    @Test
    public void webDriverWait()throws Exception {
        String url = " https://www.tutorialspoint.com/selenium/practice/check-box.php";
        driver.get(url);

        WebElement element = driver.findElement(By.xpath("//ul[@id='bs_main']/li[@id='bs_1']/span"));
        //WebdriverWait
       // Wait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        Thread.sleep(2000);
    }

    @Test
    public void fluentWait()throws Exception {
        String url = " https://www.tutorialspoint.com/selenium/practice/check-box.php";
        driver.get(url);

        FluentWait<WebDriver> fluentWait = new FluentWait(driver);
        fluentWait.withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);

//       WebElement element =  fluentWait.until(d -> driver.findElement(By.xpath("//ul[@id='bs_main']/li[@id='bs_1']/span")));
        WebElement element =  fluentWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[@id='bs_main']/li[@id='bs_1']/span")));
        element.click();
        Thread.sleep(2000);
    }


    @Test
    public void fluentWait2()throws Exception {
        String url = " https://www.tutorialspoint.com/selenium/practice/check-box.php";
        driver.get(url);

        FluentWait<WebDriver> fluentWait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);

        WebElement element = fluentWait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                return  driver.findElement(By.xpath("//ul[@id='bs_main']/li[@id='bs_1']/span"));
            }
        });
        element.click();
        Thread.sleep(2000);
    }
}
