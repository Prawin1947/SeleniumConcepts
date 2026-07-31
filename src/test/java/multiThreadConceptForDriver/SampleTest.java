package multiThreadConceptForDriver;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class SampleTest extends BaseTest{


    @Test
    public void launchBrowser()throws Exception{
      WebDriver driver = DriverManager.getWebDriver();
        driver.get("https://www.youtube.com/");

        driver.manage().window().maximize();
        Thread.sleep(15);
    }
}
