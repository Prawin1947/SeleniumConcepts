package BasicTests.basic;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DatePicker extends BaseTest {

    @Test
    public void dateSelector() throws Exception {


        String url = "https://www.tutorialspoint.com/selenium/practice/date-picker.php";
        driver.get(url);
        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@id='datetimepicker1']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='flatpickr-innerContainer']//span[@class='flatpickr-day'][@aria-label='December 1, 2025']")).click();
        driver.findElement(By.xpath("//span[@class='flatpickr-am-pm']")).click();

        driver.findElement(By.xpath("//h1[@class='mb-3 fw-normal border-bottom text-left pb-2 mb-4']")).click();
        Thread.sleep(2000);

        String selectedData = driver.findElement(By.xpath("//input[@id='datetimepicker1']")).getText();
        System.out.println(selectedData);
        Assert.assertEquals(selectedData.contains("2025-12-01"),true);
    }
}
