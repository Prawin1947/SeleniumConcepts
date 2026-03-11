package BasicTests.basic;

import org.testng.annotations.Test;

import java.net.URL;

public class NavigateMethods  extends BaseTest{


    //Navigate methods
    @Test
    public void navigateTo()throws Exception{

        // navigate().to("url") - it will navigate to the  url
        driver.navigate().to("https://www.tutorialspoint.com/selenium/practice/text-box.php");
        Thread.sleep(2000);
    }

    //Navigate methods
    @Test
    public void navigateToWithURLObject()throws Exception{

        // navigate().to(URL) - it will navigate to the  url
        URL url = new URL("https://www.tutorialspoint.com/selenium/practice/text-box.php");
        driver.navigate().to(url);
        Thread.sleep(2000);
    }

    //Navigate Back and forward
    @Test
    public void navigateBackAndForword()throws Exception{

        // navigate().to("url") - it will navigate to the  url
        driver.navigate().to("https://www.tutorialspoint.com/selenium/practice/text-box.php");
        Thread.sleep(2000);

        //   navigate back
        driver.navigate().back();
        Thread.sleep(2000);

        // navigate Forward
        driver.navigate().forward();
        Thread.sleep(2000);
    }

}
