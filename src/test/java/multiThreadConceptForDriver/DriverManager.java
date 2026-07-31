package multiThreadConceptForDriver;

import org.openqa.selenium.WebDriver;

public class DriverManager {

   static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getWebDriver(){
        if (driver.get() == null) {
            throw new IllegalStateException("Driver is not initialized for this thread");
        }
        return driver.get();
    }

    public static void setWebDriver(WebDriver driverInstance){
        driver.set(driverInstance);
    }

    public static void unload(){
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
