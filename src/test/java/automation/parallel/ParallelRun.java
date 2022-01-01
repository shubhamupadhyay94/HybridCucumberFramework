//package automation.parallel;
//
//import io.cucumber.testng.AbstractTestNGCucumberTests;
//
//import io.cucumber.testng.CucumberOptions;
//
//import org.testng.annotations.DataProvider;
//
//
//@CucumberOptions(features = {"src\\test\\resources\\com\\feature\\"},
//        monochrome = true,
//        glue ={"automation.stepdefinitions","automation.hooks"}
//        , plugin = {"pretty", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
//        "timeline:test-output-thread/"
//})
//
//public class ParallelRun extends AbstractTestNGCucumberTests {
//    @Override
//    @DataProvider(parallel = false)
//    public Object[][] scenarios(){
//        return super.scenarios();
//    }
//
//}
