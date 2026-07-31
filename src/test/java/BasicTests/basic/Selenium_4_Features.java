package BasicTests.basic;

public class Selenium_4_Features {

//    Key Features in Selenium 4:
//
//     1. Selenium 4 comes with native support for Chrome DevTools Protocol.
//    enabling QA engineers to utilize Chrome development properties and leverage APIs provided by Chrome DevTools for improved testing and bug resolution.
//
//2. newWindow():
//    The most significant addition is the newWindow() method, which allows you to create a new window or tab and automatically switches the driver's focus to it
//
//            //Opens a new tab and switches to new tab
//            driver.switchTo().newWindow(WindowType.TAB);
//    assertEquals("",driver.getTitle());
//
//    //Opens a new window and switches to new window
//        driver.switchTo().newWindow(WindowType.WINDOW);
//    assertEquals("",driver.getTitle());
//
//3. Relative locators:
//
//    above(): Utilized for identifying web elements positioned immediately above a specified element
//
//    WebElement password = driver.findElement(By.id("password"));
//    WebElement email = driver.findElement(with(By.tagName("input")).above(password));
//    OR
//    driver.findElement(RelativeLocator.with(By.tagName("input")).above(By.id("password")));
//
//
//    below() : Utilized for identifying web elements positioned immediately below a specified element
//
//    WebElement emailAddressField = driver.findElement(By.id("email"));
//    WebElement passwordField = driver.findElement(with(By.tagName("input")).below(emailAddressField));
//
//    toLeftOf(): Utilized for identifying web elements positioned specified element left of the designated element.
//
//            WebElement submitButton = driver.findElement(By.id("submit"));
//    WebElement cancelButton = driver.findElement(with(By.tagName("button")).toLeftOf(submitButton));
//
//    toRightOf():  Utilized for identifying web elements positioned specified element right of the designated element.
//
//            WebElement cancelButton = driver.findElement(By.id("cancel"));
//    WebElement submitButton = driver.findElement(with(By.tagName("button")).toRightOf(cancelButton));
//
//    near():
//    near is helpful when we need to find an element that is at most 50px away from the specified element.
//    In this case, we would like to find the email address field by first finding the label of that field.
//
//            WebElement emailAddressLabel = driver.findElement(By.id("lbl-email"));
//    WebElement emailAddressField = driver.findElement(with(By.tagName("input")).near(emailAddressLabel));
//
//    near(By locator)
//
//    near(WebElement element)
//
//    near(By locator, int atMostDistanceInPixels)
//
//    near(WebElement element, int atMostDistanceInPixels)
//
//
//................................................................................................................................................
//    W3C WebDriver Protocol:
//
//    In selenium 3 the tests communicates with the browser through JSON wire protocol. It requires API encoding and decoding.
//    In selenium 4 the tests communicates through the W3C protocol without encoding and decoding.
//
//
//    Improved Selenium Grid:
//    Selenium Grid is now enhanced with Docker support, simplifying the setup and scaling of Selenium Grid using containers.
//    Note: Selenium Grid is used to run automated tests in parallel across multiple machines, browsers and OS.
//
//    Upgraded Selenium IDE:
//    In selenium 3 the Selenium IDE was primarily a Firefox add-on.
//    In selenium 4 the Selenium IDE is available for Chrome, Firefox and Edge.
      //Note:
//
//
//    Changes in Action Class:
//    In Selenium 4, the Actions class was significantly updated to align with the W3C WebDriver protocol.
//
//    The most significant change is the simplification  of method to remove the mandatory requirement of "moveToElement"
//
//1. click() -->
//    selenium-3 : movetoElement(elemeint).click();
//    selenium-4 : click(WebElement)
//
//2.Double Click -->
//    selenium-3 : moveToElement(el).doubleClick();
//    selenium-4 : doubleClick();
//
//3.Context Click (Right Click) -->
//    selenium-3 : moveToElement(el).contextClick()
//    selenium-4 : contextClick(WebElement)
//
//4.Click and Hold -->
//    selenium-3 : moveToElement(el).clickAndHold()
//    selenium-4 : clickAndHold(WebElement)
//
//5.Release Method() -->
//    selenium-3 : in selenium 3 it was a part of ButtonReleaseAction class
//    selenium-4 : in selenium 4 its a part of Actions class
//
//6. pause() --> In selenium 4 the pause(Duration) method is introduced to insert intentional delays between chained actions without using "Thread.sleep()"
//            ---------------------------------------------------------------------------------------------------------------------------------------------------------------
//
//    What is deprecated in Selenium 4?
//
//    Fluent Wait: --------------
//
//
//    selenium-3 :
//    Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
//            .withTimeout(30, TimeUnit.SECONDS) // Old: two parameters
//            .pollingEvery(5, TimeUnit.SECONDS)  // Old: two parameters
//            .ignoring(NoSuchElementException.class);
//
//    selenium-4
//
//    Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
//            .withTimeout(Duration.ofSeconds(30)) // New: single Duration parameter
//            .pollingEvery(Duration.ofSeconds(5))  // New: single Duration parameter
//            .ignoring(NoSuchElementException.class);
//
//
//    Driver Constructors:-----------
//
//    Several driver constructors have been deprecated. Capabilities objects are now substituted with Options. To work with the Driver class, you must create an Options object.
//
//    FirefoxDriver Capabilities are now replaced by FirefoxDriver FirefoxOptions.
//
//    ChromeDriver Capabilities are now replaced by ChromeDriver ChromeOptions.
//
//    InternetExplorerDriver Capabilities are now replaced by InternetExplorerDriver InternetExplorerOptions.
//
//    SafariDriver Capabilities are now replaced by SafariDriver SafariOptions.
//
//    EdgeDriver Capabilities are now replaced by EdgeDriver EdgeOptions.


}
