package BasicTests.basic;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class SlidTheBar extends BaseTest {


    /**
     * Perform the slide operation. first we need to click on the bar and starting pont scroll.
     * But if we click on the bar through script it will click at 50% hence we ned to hover first and do context click.
     * over the iteration press RIGHT ARROW
     * @throws Exception
     */
    @Test
    public void slideTheBar() throws Exception {

        String url = "https://www.tutorialspoint.com/selenium/practice/slider.php";
        driver.get(url);
        Thread.sleep(2000);

       WebElement element = driver.findElement(By.xpath("//input[@id='ageInputId']"));
        Actions actions = new Actions(driver);

       // actions.moveToElement(element).contextClick(element).build().perform();

        // In selenium 4 moveToElement is not required
        actions.contextClick(element).build().perform();
        for(int i=0;i<24;i++){
            actions.sendKeys(Keys.ARROW_RIGHT).build().perform();
        }
    }
}
