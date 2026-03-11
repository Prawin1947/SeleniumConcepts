package BasicTests.basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BrowserWindows extends BaseTest{


    @Test
    public void newTab() throws Exception {
        String url = "https://www.tutorialspoint.com/selenium/practice/browser-windows.php";
        driver.get(url);
        Thread.sleep(2000);
        int headerColumnNum = 0;

        WebElement newTabElement = driver.findElement(By.xpath("//button[@title='New Tab']"));
        newTabElement.click();
        Thread.sleep(2000);

        //parent id
        String parentWindowId = driver.getWindowHandle();
        String newId = null;

        Set<String> windows = driver.getWindowHandles();
        List<String> winArr = new ArrayList<>(windows);
       for(int i=1;i<winArr.size();i++){
           newId = winArr.get(i);
           driver.switchTo().window(newId);
           String newUrl = driver.getCurrentUrl();
           System.out.println("New URL is "+newUrl);
           String newTitle = driver.getTitle();
           System.out.println("New title is "+newTitle);

           String textInNewTab = driver.findElement(By.xpath("//div[@class='row d-flex justify-content-center logindiv bg-white rounded']")).getText();
           System.out.println(textInNewTab);
           Assert.assertEquals(textInNewTab,"New Tab\n" + "Sample New Tab","Message verified");
           driver.switchTo().window(parentWindowId);
           String oldURL = driver.getCurrentUrl();
           System.out.println(oldURL);
           Assert.assertEquals(oldURL,"https://www.tutorialspoint.com/selenium/practice/browser-windows.php");
       }

       //NoSuchWindowException: Without using the last line of code, it will throw the 'NoSuchWindowException',
        // Because the current window is closed. In AfterMethod we are trying to close the same window,
        // to avoid 'NoSuchWindowException' after closing the new window, come back to parent window.
        driver.switchTo().window(newId);
        driver.close();

        driver.switchTo().window(parentWindowId);
    }



    @Test
    public void newWindow() throws Exception {
        String url = "https://www.tutorialspoint.com/selenium/practice/browser-windows.php";
        driver.get(url);
        Thread.sleep(2000);
        int headerColumnNum = 0;

        WebElement newTabElement = driver.findElement(By.xpath("//button[@title='New Tab']/following-sibling::button[1]"));
        newTabElement.click();
        Thread.sleep(2000);

        driver.getWindowHandles();

        //parent id
        String parentWindowId = driver.getWindowHandle();
        String newId = null;

        Set<String> windows = driver.getWindowHandles();
        ArrayList<String> winArr = new ArrayList<>(windows);

        for(int i=1;i<winArr.size();i++) {
            newId = winArr.get(i);
            driver.switchTo().window(newId);
            String newUrl = driver.getCurrentUrl();
            System.out.println("New URL is " + newUrl);
            String newTitle = driver.getTitle();
            System.out.println("New title is " + newTitle);

            String text = driver.findElement(By.xpath("//div[@class='row d-flex justify-content-center logindiv bg-white rounded']")).getText();
            Assert.assertEquals(text,"New Window\n" + "Sample Text");
            System.out.println(text);

        }
        // Maximaize the new window
        driver.manage().window().maximize();

        // switch to old window
        driver.switchTo().window(parentWindowId);
        String priviouslyClickedButton = driver.findElement(By.xpath("//button[@title='New Tab']/following-sibling::button[1]")).getText();
        Assert.assertEquals(priviouslyClickedButton,"New Window");

        //close new window
        driver.switchTo().window(newId);
        driver.close();

        // switch back to main window to avoid
        driver.switchTo().window(parentWindowId);
        priviouslyClickedButton = driver.findElement(By.xpath("//button[@title='New Tab']/following-sibling::button[1]")).getText();
        Assert.assertEquals(priviouslyClickedButton,"New Window");
    }
}
