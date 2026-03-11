package BasicTests.basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class CheckBox extends BaseTest{



    @Test
    public void checkBoxSelectAndDeselect()throws Exception {
        String url = " https://www.tutorialspoint.com/selenium/practice/check-box.php";
        driver.get(url);
        Thread.sleep(2000);

        WebElement element = driver.findElement(By.xpath("//ul[@id='bs_main']/li[@id='bs_1']/span"));
        element.click();
        Thread.sleep(2000);


        element = driver.findElement(By.xpath("//li[@id='bf_2']/span"));
        element.click();
        Thread.sleep(2000);


        //isEnabled
        Assert.assertEquals(element.isEnabled(),true,"Element is Enabled");
        //isDisplayed
        Assert.assertEquals(element.isDisplayed(),true,"Element is Displayed");

        element = driver.findElement(By.xpath("//ul[@id='bf_l_2']/li[@id='io_6']/input"));
        element.click();
        Thread.sleep(2000);

        //isSelected
        Assert.assertEquals(element.isSelected(),true,"Element is selected");


        //Deselect
        element = driver.findElement(By.xpath("//ul[@id='bf_l_2']/li[@id='io_6']/input"));
        element.click();
        Thread.sleep(2000);

        //isSelected
        Assert.assertEquals(element.isSelected(),false,"Element is deSelected");

    }

    @Test
    public void checkBoxSelectAndDeselectBasedOnTextVerification()throws Exception {
        String url = " https://www.tutorialspoint.com/selenium/practice/check-box.php";
        driver.get(url);
        Thread.sleep(2000);

        WebElement element = driver.findElement(By.xpath("//ul[@id='bs_main']/li[@id='bs_1']/span"));
        element.click();
        Thread.sleep(2000);

        element = driver.findElement(By.xpath("//li[@id='bf_2']/span"));
        element.click();
        Thread.sleep(2000);

       List<WebElement> elements = driver.findElements(By.xpath("//ul[@id='bf_l_2']//li"));
       String text = null;
       int index =0;
       WebElement checkBox = null;
        for(WebElement ele: elements){
            text = ele.getText();
            if(text.equals("Last Level 7")){
                checkBox =  ele.findElements(By.xpath("//ul[@id='bf_l_2']//li//input")).get(index);
                checkBox.click();
                break;
            }
            index++;
        }
        Thread.sleep(2000);
        //isSelected
        Assert.assertEquals(checkBox.isSelected(),true,"checkBox is Selected");

    }


}
