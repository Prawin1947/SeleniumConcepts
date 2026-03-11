package BasicTests.basic;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class DialogBox extends BaseTest {


    /**
     *
     */
    @Test
    public void dialogBoxDemo() throws Exception {
        String url = " https://www.tutorialspoint.com/selenium/practice/modal-dialogs.php";
        driver.get(url);
        Thread.sleep(2000);

        driver.findElement(By.xpath("//button[@data-bs-target='#exampleModalSm']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@id='exampleModalSm']//button[@class='btn-close']")).click();

    }
}
