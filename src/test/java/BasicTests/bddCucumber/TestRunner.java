package BasicTests.bddCucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;


@CucumberOptions(
        features = "src/test/features",
        glue = "StepDefinetion-Path",
        plugin = {
                "pretty",
                "html:target/cucumber-report.html",
                "json:target/cucumber.json",
                "rerun:target/failed-scenarios.txt"  // It will help to collect failed scenarios
        },
        dryRun = true, // This is the cleanest way to validate step definitions without executing tests.
        monochrome = true, //When you run Cucumber tests, the console output normally contains ANSI color codes (green for pass, red for fail, etc.).
        //Removes those color codes and Makes output plain text and also Improves readability in logs (especially in Jenkins / CI)
        tags = "@Regression"
)
public class TestRunner extends AbstractTestNGCucumberTests {



    @DataProvider(parallel = true)
    public Object[][] scnerios(){
        return super.scenarios();
    }
}
