package BasicTests.basic;

import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SeleniumBasicConcepts extends BaseTest{


    //Open the URL using get method
    @Test
    public void openUrl()throws Exception{
        driver.get("https://www.tutorialspoint.com/selenium/practice/text-box.php");
        Thread.sleep(2000);
    }


    //Open the URL using get method
    @Test
    public void getCurrentUrl()throws Exception{
        String url = "https://www.tutorialspoint.com/selenium/practice/text-box.php";
        driver.get(url);
        Thread.sleep(2000);

       String currentUrl =   driver.getCurrentUrl();
        Assert.assertEquals(currentUrl,url,"URL is : "+currentUrl);
        System.out.println("URL is : "+currentUrl);

    }


    //get Title
    @Test
    public void getTitle()throws Exception{
        String url = "https://www.tutorialspoint.com/selenium/practice/text-box.php";
        driver.get(url);
        Thread.sleep(2000);

      String title =  driver.getTitle();
        System.out.println("Session Id : "+title);
    }


    //get ssionId
    @Test
    public void getSessionId()throws Exception{
        String url = "https://www.tutorialspoint.com/selenium/practice/text-box.php";
        driver.get(url);
        Thread.sleep(2000);

        SessionId sessionId = ((RemoteWebDriver)driver).getSessionId();
        System.out.println("Session Id : "+sessionId);


    }

    //sendKeys
    @Test
    public void sendKeysDemo()throws Exception {
        String url = "https://www.tutorialspoint.com/selenium/practice/text-box.php";
        driver.get(url);
        Thread.sleep(2000);

        driver.findElement(By.cssSelector("#fullname")).sendKeys("Praveen M");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("#email")).sendKeys("pimayakar@gmail.com");
        driver.findElement(By.cssSelector("#address")).sendKeys("Complete Address");
        driver.findElement(By.cssSelector("#password")).sendKeys("@1234");
        Thread.sleep(1000);
        //Clear the field
        driver.findElement(By.cssSelector("#fullname")).clear();
        Thread.sleep(500);
        driver.findElement(By.cssSelector("#fullname")).sendKeys("Praveen Mayakar");
        Thread.sleep(500);
        driver.findElement(By.xpath("//input[@value='Submit']")).click();
    }

    //getText()
    @Test
    public void getText()throws Exception {
        String url = "https://www.tutorialspoint.com/selenium/practice/text-box.php";
        driver.get(url);
        Thread.sleep(2000);

        String text = driver.findElement(By.cssSelector("#TextForm .mb-4")).getText();
        Assert.assertEquals(text,"Text Box","Text is verified");

    }

    //getTagName() : When we want to verify the tag name
    // Whether the tag name is 'a' for link
    @Test
    public void getTagName()throws Exception {
        String url = "https://www.tutorialspoint.com/selenium/practice/links.php";
        driver.get(url);
        Thread.sleep(2000);

        WebElement element = driver.findElement(By.cssSelector("#created"));
        String tagName = element.getTagName();

        Assert.assertEquals(tagName,"a","Tag name is "+tagName +" So that we can click");

    }

    //getTagName() : When we want to verify css value
    @Test
    public void getCssValue()throws Exception {
        String url = "https://www.tutorialspoint.com/selenium/practice/links.php";
        driver.get(url);
        Thread.sleep(2000);

        WebElement element = driver.findElement(By.cssSelector("#created"));
        String cssValue = element.getCssValue("color");

        Assert.assertEquals(cssValue,"rgba(51, 51, 51, 1) ","Tag css value is "+cssValue);

    }

    //getAttribute() : When we want to verify the attribute value
    @Test
    public void getAttribute()throws Exception {
        String url = "https://www.tutorialspoint.com/selenium/practice/links.php";
        driver.get(url);
        Thread.sleep(2000);

        WebElement element = driver.findElement(By.cssSelector("#created"));
        String attributeValue = element.getAttribute("onclick");

        Assert.assertEquals(attributeValue,"shide('create')","attribute value is "+attributeValue);

    }

    //getSize() : it will return the Dimention.
    // With the help of dimention object we can get the height and width
    @Test
    public void getSize()throws Exception {
        String url = "https://www.tutorialspoint.com/selenium/practice/links.php";
        driver.get(url);
        Thread.sleep(2000);

        WebElement element = driver.findElement(By.cssSelector("#created"));
        Dimension dimension = element.getSize();
        int height = dimension.getHeight();
        int width = dimension.getWidth();

        System.out.println("Height is "+height +" and Width is "+width);

    }

    @Test
    public void getLocation()throws Exception {
        String url = "https://www.tutorialspoint.com/selenium/practice/links.php";
        driver.get(url);
        Thread.sleep(2000);

        WebElement element = driver.findElement(By.cssSelector("#created"));
        Point point = element.getLocation();
        int x = point.getX();
        int y = point.getY();

        System.out.println("X co-ordination is  "+x +" and Y  co-ordination is "+y);
    }


    /**
     * findElement() will return "WebElement" when it's able to successfully locates an element.
     * if its cannot find any element matching the specified locator strategy, it throws a NoSuchElementException
     * @throws NoSuchElementException
     */
    @Test
    public void findElement()throws Exception {
        String url = "https://www.tutorialspoint.com/selenium/practice/links.php";
        driver.get(url);
        Thread.sleep(2000);

        WebElement element = driver.findElement(By.cssSelector("#created"));

    }

    /**
     * findElements() will return List of WebElement when it's able to successfully locates an element.
     * If it's cannot find any element matching the specified locator strategy, it will return an "empty list".
     */
    @Test
    public void findElements()throws Exception {
        String url = "https://www.tutorialspoint.com/selenium/practice/links.php";
        driver.get(url);
        Thread.sleep(2000);

        List<WebElement> element = driver.findElements(By.cssSelector("#created"));
    }


}
