package BasicTests.basic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    public static WebDriver driver;

    @BeforeMethod
    public void launchBrowser()throws Exception{
        System.setProperty("webdriver.chrome.driver","src/main/resources/driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        Thread.sleep(2000);
    }

    public static WebDriver getDriver(){
        driver = new ChromeDriver();
        return driver;
    }

    public void launchBrowserWithHeadless()throws Exception{
        System.setProperty("webdriver.chrome.driver","src/main/resources/driver/chromedriverold.exe");

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless=new");

        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        Thread.sleep(2000);
    }

    @AfterMethod
    public void closeBrowser()throws Exception{
        driver.close();
        driver.quit();
    }

}
