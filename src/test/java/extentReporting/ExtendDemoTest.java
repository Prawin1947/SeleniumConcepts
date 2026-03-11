package extentReporting;

import BasicTests.basic.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

import java.util.List;

public class ExtendDemoTest extends BaseTest {

    @BeforeClass
    public void preRequisit(){
        //start the extent report
        ExtentManager.getReporter();

    }

    @AfterClass
    public void exit(){
        //start the extent report
        ExtentManager.afterTest();

    }

//    @BeforeMethod
//    public void openUrl()throws Exception{
//        driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
//        Thread.sleep(3000);
//    }



    @Test
    public void getOptions() throws Exception {

        ExtentManager.startTest("getOptions");

        driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
        Thread.sleep(3000);

        ExtentManager.logStep("The URL is launched "+"https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");

        ExtentManager.logStepWithScreenshot(driver,"The URL is launched","getOptions");

        WebElement stateSelector = driver.findElement(By.cssSelector("#state"));

        Select select = new Select(stateSelector);
        List<WebElement> elements = select.getOptions();
        for (WebElement element : elements) {
            System.out.println(element.getText());
        }

        ExtentManager.logStepWithScreenshot(driver,"getOptions method","getOptions");

        System.out.println("There are " + elements.size() + " elements in a dropDown");


    }

    @Test
    public void selectOption() throws Exception {

        ExtentManager.startTest("selectOption");

        driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
        Thread.sleep(3000);

        ExtentManager.logStep("The URL is launched "+"https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");

        WebElement stateSelector = driver.findElement(By.cssSelector("#state"));
        Select select = new Select(stateSelector);
        select.selectByValue("Haryana1");
        Thread.sleep(2000);

        ExtentManager.logStepWithScreenshot(driver,"selectOption method","selectOption");

        ExtentManager.logFailure(driver,"selectOption test failed","selectOption");
    }

}
