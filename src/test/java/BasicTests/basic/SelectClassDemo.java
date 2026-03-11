package BasicTests.basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

public class SelectClassDemo extends BaseTest{

    @BeforeMethod
    public void openUrl()throws Exception{
        driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
        Thread.sleep(3000);
    }


    //getOptions() : It will get all the options from the dropdown
    @Test
    public void getOptions() throws Exception {

        WebElement stateSelector = driver.findElement(By.cssSelector("#state"));

        Select select = new Select(stateSelector);
        List<WebElement> elements = select.getOptions();
        for(WebElement element: elements){
            System.out.println(element.getText());
        }
        System.out.println("There are "+ elements.size()+" elements in a dropDown");
    }


    //selectByValue("value") : it will select the item from the dropdown based on 'value' attribute
    @Test
    public void selectByValue() throws Exception {
        WebElement stateSelector = driver.findElement(By.cssSelector("#state"));
        Select select = new Select(stateSelector);
        select.selectByValue("Haryana");
        Thread.sleep(2000);
    }

    //selectByIndex(int index) : it will select the item from the dropdown based on index
    @Test
    public void selectByIndex() throws Exception {
        WebElement stateSelector = driver.findElement(By.cssSelector("#state"));
        Select select = new Select(stateSelector);
        select.selectByIndex(4);
        Thread.sleep(2000);
    }

    //selectByVisibleText(String text) : it will select the item from the dropdown based on visible Text
    @Test
    public void selectByVisibleText() throws Exception {
        WebElement stateSelector = driver.findElement(By.cssSelector("#state"));
        Select select = new Select(stateSelector);
        select.selectByVisibleText("NCR");
        Thread.sleep(2000);
    }

    /**
     * The isMultiple() method in Selenium's Select class in Java.
     * it's used to determine whether a <select> HTML element supports multiple selections.
     *
     * true : if the dropdown element allows selecting multiple options simultaneously.
     * false : if the dropdown element only allows selecting a single option at a time.
     */
    @Test
    public void isMultiple() throws Exception {
        WebElement stateSelector = driver.findElement(By.cssSelector("#state"));
        Select select = new Select(stateSelector);
        boolean itsMultiSelect =  select.isMultiple();
        System.out.println("Its a multi Select : "+ itsMultiSelect);
    }


    //getAllSelectedOptions() : it will return  List<WebElement> for the options selected
    @Test
    public void getAllSelectedOptions() throws Exception {
        WebElement stateSelector = driver.findElement(By.cssSelector("#state"));
        Select select = new Select(stateSelector);
        select.selectByVisibleText("NCR");
        Thread.sleep(2000);

        //getAllSelectedOptions
       List<WebElement> selectedOptions = select.getAllSelectedOptions();
        for(WebElement element:selectedOptions){
            System.out.println(element.getText());
        }

        System.out.println("Selected options number is : "+ selectedOptions.size());
    }

    /**
     * deselectAll() : it will remove all selected options from the dropDown
     * its will applicable for multiSelect dropdown
     *
     * if we use for single Select it will give below error
     * "java.lang.UnsupportedOperationException: You may only deselect options of a multi-select"
     */
    @Test
    public void deselectAll() throws Exception {
        WebElement stateSelector = driver.findElement(By.cssSelector("#state"));
        Select select = new Select(stateSelector);
        select.selectByVisibleText("NCR");
        Thread.sleep(2000);

        // deselectAll
        select.deselectAll();
        Thread.sleep(2000);
       List<WebElement> selectedOptions =  select.getAllSelectedOptions();
        System.out.println("There is no option selected : "+selectedOptions.size());
    }

    /**
     * deselectByIndex : it will deselect the option based on the specified index
     * its will applicable for multiSelect dropdown
     *
     * if we use for single Select it will give below error
     * "java.lang.UnsupportedOperationException: You may only deselect options of a multi-select"
     */
    @Test
    public void deselectByIndex() throws Exception {
        WebElement stateSelector = driver.findElement(By.cssSelector("#state"));
        Select select = new Select(stateSelector);
        select.selectByVisibleText("NCR");
        Thread.sleep(2000);

        // deselectByIndex
        select.deselectByIndex(1);
        Thread.sleep(2000);
        List<WebElement> selectedOptions =  select.getAllSelectedOptions();
        System.out.println("There is no option selected : "+selectedOptions.size());
    }

    /**
     * deselectByValue : it will deselect the option based on the "value" attribute value
     * its will applicable for multiSelect dropdown
     *
     * if we use for single Select it will give below error
     * "java.lang.UnsupportedOperationException: You may only deselect options of a multi-select"
     */
    @Test
    public void deselectByValue() throws Exception {
        WebElement stateSelector = driver.findElement(By.cssSelector("#state"));
        Select select = new Select(stateSelector);
        select.selectByVisibleText("NCR");
        Thread.sleep(2000);

        // deselectByValue
        select.deselectByValue("NCR");
        Thread.sleep(2000);
        List<WebElement> selectedOptions =  select.getAllSelectedOptions();
        System.out.println("There is no option selected : "+selectedOptions.size());
    }

    /**
     * deselectByVisibleText : it will deselect the option based on the specified text
     * its will applicable for multiSelect dropdown
     *
     * if we use for single Select it will give below error
     * "java.lang.UnsupportedOperationException: You may only deselect options of a multi-select"
     */
    @Test
    public void deselectByVisibleText() throws Exception {
        WebElement stateSelector = driver.findElement(By.cssSelector("#state"));
        Select select = new Select(stateSelector);
        select.selectByVisibleText("NCR");
        Thread.sleep(2000);

        // deselectByVisibleText
        select.deselectByVisibleText("NCR");
        Thread.sleep(2000);
        List<WebElement> selectedOptions =  select.getAllSelectedOptions();
        System.out.println("There is no option selected : "+selectedOptions.size());
    }

}
