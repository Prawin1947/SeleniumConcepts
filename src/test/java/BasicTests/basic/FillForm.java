package BasicTests.basic;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FillForm extends BaseTest{

    @BeforeMethod
    public void openUrl()throws Exception{
        driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
        Thread.sleep(2000);
    }


    @Test
    public void fillTheForm() throws Exception {
        driver.findElement(By.cssSelector("#name")).sendKeys("Praveen");
        Thread.sleep(2000);

        driver.findElement(By.cssSelector("#email")).sendKeys("pimayakar@gmail.com");

        //select radio button
        driver.findElement(By.cssSelector("#gender")).click();


        driver.findElement(By.cssSelector("#mobile")).sendKeys("1234567890");




        //data filed
        driver.findElement(By.cssSelector("#dob")).sendKeys(getDate("dd-mm-yyyy"));

        driver.findElement(By.cssSelector("#subjects")).sendKeys(getDate("new Subject"));


    }

    public String getDate(String dateFormat)throws Exception{

        String dateInString =new SimpleDateFormat(dateFormat).format(new Date());
        System.out.println("Date :"+ dateInString);
        return dateInString;

    }
}
