package listenerDemo;

import extentReporting.ExtentManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ListenersTests {

    public static WebDriver driver;

    @BeforeMethod
    public void launchBrowser()throws Exception{
        System.setProperty("webdriver.chrome.driver","src/main/resources/driver/chromedriverold.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        Thread.sleep(2000);
    }

    public static WebDriver getDriver(){
        return driver;
    }


    @AfterMethod
    public void closeBrowser()throws Exception{
        driver.quit();
    }

    @Test
    public void getOptions() throws Exception {

        driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
        Thread.sleep(3000);
        WebElement stateSelector = driver.findElement(By.cssSelector("#state"));
        Select select = new Select(stateSelector);
        List<WebElement> elements = select.getOptions();
        for (WebElement element : elements) {
            System.out.println(element.getText());
        }
        System.out.println("There are " + elements.size() + " elements in a dropDown");
    }


    @Test
    public void selectOption() throws Exception {

        driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
        Thread.sleep(3000);
        WebElement stateSelector = driver.findElement(By.cssSelector("#state"));
        Select select = new Select(stateSelector);
        select.selectByValue("Haryana1");
        Thread.sleep(2000);
    }

    @Test
    public void setOption() throws Exception {

        driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
        Thread.sleep(3000);
        WebElement stateSelector = driver.findElement(By.cssSelector("#state"));
        Select select = new Select(stateSelector);
        select.selectByValue("Haryana");
        Thread.sleep(2000);
    }

    @Test
    public void setOptionForSkip() throws Exception {
        driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
        Thread.sleep(3000);
        WebElement stateSelector = driver.findElement(By.cssSelector("#state"));
        Select select = new Select(stateSelector);
        select.selectByValue("Haryana");
        Thread.sleep(2000);
    }


}
