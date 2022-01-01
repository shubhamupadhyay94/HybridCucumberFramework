package automation.hooks;

import framework.constant.FrameworkConstant;
import framework.driver.DriverUtilities;
import framework.exception.ConfigFileReaderException;
import framework.exception.DriverUtilitiesException;
import framework.exception.ReadExcelException;
import framework.utilities.ConfigFileReader;
import framework.utilities.ReadExcel;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import net.serenitybdd.core.annotations.events.AfterScenario;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assume;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

public class ApplicationHooks {

    private ConfigFileReader config;
    private DriverUtilities driverUtilities;
    private WebDriver driver;
    private Properties properties = new Properties();

    public static Map<String, String> map;

//    @Before(value = "@smoke", order = 0)
//    public void skip_scenario(Scenario scenario){
//
//        System.out.println(scenario.getName());
//        Assume.assumeTrue(false );
//
//    }

    @Before(order = 0)
    public void getProperty() throws ConfigFileReaderException {
        try {
            config = new ConfigFileReader();
            properties = config.configFile();
        } catch (ConfigFileReaderException e) {
            e.printStackTrace();
        }

        ReadExcel readExcel = new ReadExcel();
        try {
            map = readExcel.readExcelDataBasedOnEnvironment();
            } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (ReadExcelException e) {
            e.printStackTrace();
        }


    }

    @Before(order = 1)
    public void launchBrowser() {
        try {

            String browserName = properties.get(FrameworkConstant.BROWSER_NAME).toString();
            driverUtilities = new DriverUtilities();
            driver = driverUtilities.initDriver(browserName);
        } catch (DriverUtilitiesException e) {
            e.printStackTrace();
        }
    }

    @After(order = 0)
    public void tearDown() {
        try {
            driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @After(order = 1)
    public void screenshot(Scenario scenario) {
        try {
            if (scenario.isFailed()) {
                String scenarioName = scenario.getName().replaceAll(" ", "_");
                TakesScreenshot screenshot = (TakesScreenshot) driver;
                byte[] file = screenshot.getScreenshotAs(OutputType.BYTES);
                scenario.attach(file, "image/png", scenarioName);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
