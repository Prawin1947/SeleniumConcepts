package listenerDemo;

import BasicTests.basic.BaseTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

public class ExtentManager extends BaseTest {
    public static ExtentTest extentTest;
    public static ExtentReports extentReports;
    public static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
    String timeStampForReport = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());

    public static ExtentReports getReporter() {
        String path = System.getProperty("user.dir") + "/src/main/resources/report/ExtentReportResults_1.html";
        ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(path);
        extentSparkReporter.config().setReportName("Automation_Report");
        extentSparkReporter.config().setDocumentTitle("Selenium_Automation");
        extentSparkReporter.config().setTheme(Theme.DARK);

        //Create object for 'ExtentReports'
        extentReports = new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);
        //Adding System information using 'ExtentReports'
        extentReports.setSystemInfo("OS : ", System.getProperty("os.name"));
        extentReports.setSystemInfo("Java Version : ", System.getProperty("java.version"));
        extentReports.setSystemInfo("User Name : ", System.getProperty("user.name"));
        return extentReports;
    }


    //Start the Test
    public static ExtentTest startTest(String testName) {
        extentTest = getReporter().createTest(testName);
        test.set(extentTest);
        return extentTest;
    }

    //End the Test
    public static void endTest() {
        getReporter().flush();
    }

    //Get the current Thread's test
    public static ExtentTest getTest() {
        return test.get();
    }

    public static String getTestName() {
        ExtentTest currentTest = getTest();
        if (currentTest != null) {
            return currentTest.getModel().getName();
        } else {
            return "No Test is currently active for this Thread";
        }
    }

    //Log a step
    public static void logStep(String logMessage) {
        getTest().pass(logMessage);
    }

    //Log a step validation with screenshot
    public static void logStepWithScreenshot(WebDriver driver, String logMessage, String screenshotMessage) {
        getTest().pass(logMessage);
        //Screenshot Method
        attachScreenshot(driver,screenshotMessage);
    }


    //Log a step validation with screenshot
    public static void logFailure(WebDriver driver, String logMessage, String screenshotMessage) {
        getTest().fail(logMessage);
        //Screenshot Method
        attachScreenshot(driver,screenshotMessage);
    }

    //Log skip
    public static void logSkip(String logMessage) {
        getTest().skip(logMessage);
    }

    public static String takeScreenshot(WebDriver driver, String screenshotName) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File srcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        //get the date and time
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());

        String destinationPath = System.getProperty("user.dir") + "/src/main/resources/screenshots/" + screenshotName + "_" + timeStamp+".png";

        File destFile = new File(destinationPath);

        try {
            FileUtils.copyFile(srcFile, destFile);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        //Convert screenshot to base64 for embidding in report
        String base64Format = convertToBase64(srcFile);

        return base64Format;
    }

    //convert screenshot to Base64 format
    public static String convertToBase64(File screenShotFile) {
        String base64Format = "";
        //Read the file content into a byte array
        try {
            byte[] fileContent = FileUtils.readFileToByteArray(screenShotFile);
            base64Format = Base64.getEncoder().encodeToString(fileContent);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return base64Format;

    }

    public static void attachScreenshot(WebDriver driver, String message) {
        String screenShotBase64 = takeScreenshot(driver, getTestName());
        try {
            getTest().info(message, com.aventstack.extentreports.MediaEntityBuilder.createScreenCaptureFromBase64String(screenShotBase64).build());
        } catch (Exception e) {
            getTest().fail("Failed to attach the screenshot");
            e.printStackTrace();
        }

    }


    public static void afterTest() {
        extentReports.flush();
    }
}
