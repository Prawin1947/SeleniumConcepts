package BasicTests.basic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;

public class ChromeOptionsDemo {

    public WebDriver driver;

   @BeforeMethod
    public void launchBrowser()throws Exception{
        System.setProperty("webdriver.chrome.driver","src/main/resources/driver/chromedriverold.exe");
        driver = new ChromeDriver(geChromeOptions());
     //   driver.manage().window().maximize();
        Thread.sleep(2000);
    }


    //Open the URL using get method
    @Test
    public void openUrl()throws Exception{
        driver.get("https://www.tutorialspoint.com/selenium/practice/text-box.php");
        Thread.sleep(2000);
    }

    public ChromeOptions geChromeOptions(){
        ChromeOptions chromeOptions = new ChromeOptions();

        //Open the chrome Browser in headless mode
        //  chromeOptions.addArguments("--headless=new");

        //Open the  browser in maximized
        chromeOptions.addArguments("--start-maximized");

        // disable information bar
        chromeOptions.setExperimentalOption("excludeSwitches",Arrays.asList("enable-automation"));

        //SSL Certificate using chrome options
        chromeOptions.setAcceptInsecureCerts(true);

        //Handling SSL Certificate using DesiredCapabilities
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS,true);
        chromeOptions.merge(desiredCapabilities);






        return chromeOptions;
    }

    @AfterMethod
    public void closeBrowser()throws Exception{
        driver.close();
    }


}
