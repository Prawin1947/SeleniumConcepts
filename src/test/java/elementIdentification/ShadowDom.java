package elementIdentification;

import BasicTests.basic.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ShadowDom extends BaseTest {

    @BeforeMethod
    public void openUrl()throws Exception{
        driver.get("chrome://downloads/");
        Thread.sleep(5000);
    }

    @Test
    public void identifySearchBar()throws Exception{

        JavascriptExecutor javascriptExecutor = (JavascriptExecutor)driver;

        WebElement searchElement = (WebElement)javascriptExecutor.executeScript("return document.querySelector('downloads-manager').shadowRoot.querySelector('downloads-toolbar').shadowRoot.querySelector('cr-toolbar').shadowRoot.querySelector('cr-toolbar-search-field').shadowRoot.querySelector('div>input#searchInput')");

        ((JavascriptExecutor)driver).executeScript("arguments[0].setAttribute('value','candidate (1).pdf')",searchElement);

        Thread.sleep(2000);

        //#gbwa
    }


    /**
     * svg :
     *
     *  //*[name()='svg']//*[name-local()='circle']
     *
     *  //*[name()='svg'][@class='gb_E']
     *
     *
     * @throws Exception
     */
    @Test
    public void clickOnSvg()throws Exception{
        driver.get("https://www.google.com/");
        Thread.sleep(4000);
        driver.findElement(By.xpath("//*[name()='svg'][@class='gb_E']")).click();
        Thread.sleep(4000);
        driver.findElement(By.cssSelector("#sdgBod")).getText();
    }


}
