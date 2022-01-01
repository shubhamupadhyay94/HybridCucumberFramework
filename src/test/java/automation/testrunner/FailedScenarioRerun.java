package automation.testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;


@CucumberOptions(
        glue ={"automation.stepdefinitions","automation.hooks"}
        ,plugin = {"pretty", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
        "rerun:target/failedRerun.txt",
        "timeline:test-output-thread/"
        },
        monochrome = true,
        features={"@target/failedRerun.txt"}
)

public class FailedScenarioRerun extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios(){
        return super.scenarios();
    }

}
