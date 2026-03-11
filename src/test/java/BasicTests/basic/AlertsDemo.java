package BasicTests.basic;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class AlertsDemo extends BaseTest{


    @Test
    public void alertAccept() throws Exception {
        String url = "https://www.tutorialspoint.com/selenium/practice/alerts.php";
        driver.get(url);
        Thread.sleep(2000);


        driver.findElement(By.xpath("//div[@class='d-flex justify-content-between']//button")).click();

        Alert alert = driver.switchTo().alert();
        String alertMessage = alert.getText();
        System.out.println(alertMessage);
        Assert.assertEquals(alertMessage,"Hello world!");
        alert.accept();
    }

    @Test
    public void waitForAlertToBePresent() throws Exception {
        String url = "https://www.tutorialspoint.com/selenium/practice/alerts.php";
        driver.get(url);
        Thread.sleep(2000);
 String expectedText = "On button click, alert will appear after 5 seconds";
// String expectedText = "On button click, alert will appear after 5 seconds";
// String expectedText = "On button click, alert will appear after 5 seconds";

       List<WebElement> elements=  driver.findElements(By.xpath("//div[@class='d-flex justify-content-between mt-4']"));
        int index = 1;
       for(WebElement element :elements){

           String text = element.findElement(By.xpath("//div[@class='d-flex justify-content-between mt-4']["+index+"]//label")).getText();
           WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
           String alertMessage = null;
           Alert alert =null;
           switch (text){

               case "On button click, confirm box will appear":

                   element.findElement(By.xpath("//div[@class='d-flex justify-content-between mt-4']["+index+"]//button")).click();
                   // Wait for alert to be present
                   wait.until(ExpectedConditions.alertIsPresent());
                   alert = driver.switchTo().alert();
                   alertMessage = alert.getText();
                   System.out.println(alertMessage);

                   alert.accept();
                   String message = element.findElement(By.xpath("//div[@id='desk']")).getText();
                   Assert.assertEquals(message,"You pressed OK!");

                   element.findElement(By.xpath("//div[@class='d-flex justify-content-between mt-4']["+index+"]//button")).click();
                   wait.until(ExpectedConditions.alertIsPresent());

                   alert.dismiss();
                   message = element.findElement(By.xpath("//div[@id='desk']")).getText();
                   Assert.assertEquals(message,"You pressed Cancel!");
                   break;


               case "On button click, alert will appear after 5 seconds":

                   element.findElement(By.xpath("//div[@class='d-flex justify-content-between mt-4']["+index+"]//button")).click();
                   wait.until(ExpectedConditions.alertIsPresent());
                   alert = driver.switchTo().alert();
                   alertMessage = alert.getText();
                   System.out.println(alertMessage);
                   Assert.assertEquals(alertMessage,"Hello just appeared");
                   alert.accept();
                   break;


               case "On button click, prompt box will appear":

                   element.findElement(By.xpath("//div[@class='d-flex justify-content-between mt-4']["+index+"]//button")).click();
                   wait.until(ExpectedConditions.alertIsPresent());
                   alert = driver.switchTo().alert();
                   alertMessage = alert.getText();
                   System.out.println(alertMessage);
                   Assert.assertEquals(alertMessage,"What is your name?");

                   alert.sendKeys("My Name is praveen");
                   alert.accept();
                   break;
           }
           index++;
       }
    }

 }
