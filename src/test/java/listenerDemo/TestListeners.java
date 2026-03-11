package listenerDemo;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListeners implements ITestListener {

    public WebDriver driver;


    /**
     * Initilize the extent report
     * @param context
     */
    @Override
    public void onStart(ITestContext context) {
      ExtentManager.getReporter();
    }


    @Override
    public void onFinish(ITestContext context) {
        ExtentManager.endTest();
    }

    @Override
    public void onTestStart(ITestResult result) {
     String testName = result.getMethod().getMethodName();
        ExtentManager.startTest(testName);
        ExtentManager.logStep("Test Started : "+testName);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        String testName = result.getMethod().getMethodName();
        ExtentManager.logStepWithScreenshot(ListenersTests.getDriver(),"Test pass ","Test End : " + testName + " - TEST PASSED.");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String testName = result.getMethod().getMethodName();
        String failedMessage = result.getThrowable().getMessage();
        ExtentManager.logStep(failedMessage);
        ExtentManager.logFailure(ListenersTests.getDriver(),"Test Fail ", "Test End : " + testName + " - TEST FAILED. ");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        String testName = result.getMethod().getMethodName();
        ExtentManager.logSkip("Test Skipped "+testName);
    }

}
