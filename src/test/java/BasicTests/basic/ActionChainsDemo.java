package BasicTests.basic;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionChainsDemo extends BaseTest{

    @BeforeMethod
    public void openUrl()throws Exception{
        driver.get("https://www.tutorialspoint.com/selenium/practice/buttons.php");
        Thread.sleep(2000);
    }

    @Test
    public void doubleClick() throws Exception {
        driver.findElement(By.xpath("//a[@href='buttons.php']")).click();
        Thread.sleep(2000);

        WebElement element = driver.findElement(By.xpath("//button[@class='btn btn-success']"));
        Actions actions = new Actions(driver);
        actions.doubleClick(element).perform();
        Thread.sleep(2000);

        String actualText = driver.findElement(By.cssSelector("#doublec")).getText();
        Assert.assertEquals(actualText,"You have Double clicked");
    }

   //In Selenium, contextClick() is a method used to perform a right-click action on a web element.
   // After right click will get a context menu
    @Test
    public void rightClick() throws Exception {
        driver.findElement(By.xpath("//a[@href='links.php']")).click();
        Thread.sleep(2000);


        WebElement element = driver.findElement(By.xpath("//a[@href='https://www.tutorialspoint.com/index.htm']"));
        Actions actions = new Actions(driver);
        //Right click/ Context click
        actions.contextClick(element).perform();
        Thread.sleep(2000);
        //Handle context menu [Click on 'Open link in new tab']
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
               .sendKeys(Keys.ENTER).build().perform();
        Thread.sleep(3000);
    }

}
