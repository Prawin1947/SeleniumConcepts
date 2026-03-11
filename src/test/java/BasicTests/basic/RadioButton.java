package BasicTests.basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class RadioButton  extends BaseTest{

    @Test
    public void selectRadioButton()throws Exception {
        String url = "https://www.tutorialspoint.com/selenium/practice/radio-button.php";
        driver.get(url);
        Thread.sleep(2000);



        List<WebElement> labels = driver.findElements(By.xpath("//div[@class='form-check form-check-inline']//label"));

        List<WebElement> inputs = driver.findElements(By.xpath("//div[@class='form-check form-check-inline']//input"));

        for(int i=0; i<inputs.size();i++){

            if(inputs.get(i).isEnabled()){
              String name =  labels.get(i).getText();
                System.out.println(name);
                inputs.get(i).click();
               String textForSelected = driver.findElement(By.xpath("//div[@style='display: block;']")).getText();
                System.out.println(textForSelected);
            }
        }

        }



    }
