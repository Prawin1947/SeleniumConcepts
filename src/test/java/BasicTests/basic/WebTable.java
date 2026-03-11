package BasicTests.basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class WebTable  extends BaseTest {

    @Test
    public void readWebTable()throws Exception {
        String url = "https://www.tutorialspoint.com/selenium/practice/webtables.php";
        driver.get(url);
        Thread.sleep(2000);
        int headerColumnNum = 0;


        //Match the name and get the row index
        int row = 0;
        //get the name of the person
        List<WebElement> nameElements = driver.findElements(By.xpath("//table[@class='table table-striped mt-3']//tbody//tr//td[1]"));
        for(int h=0;h<nameElements.size();h++){
            if(nameElements.get(h).getText().equals("Alden")){
                row = h;
            }
        }

        //Get the header index which you want to read
        List<WebElement> colomnElemets = driver.findElements(By.xpath("//table[@class='table table-striped mt-3']//thead//tr//th"));
        for(int h=0;h<colomnElemets.size();h++){
            if(colomnElemets.get(h).getText().equals("Department")){
                headerColumnNum = h;


                List<WebElement> columnElementList = driver.findElements(By.xpath("//table[@class='table table-striped mt-3']//tbody//tr//td["+headerColumnNum+"]"));
                 String value =   columnElementList.get(row).getText();
                System.out.println("Department name is "+value);
                    Assert.assertEquals(value,"Compliance","Department name is verified");
                }
            }
        }

}
