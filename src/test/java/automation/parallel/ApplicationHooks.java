package automation.parallel;

import framework.constant.FrameworkConstant;
import framework.driver.DriverUtilities;
import framework.exception.ConfigFileReaderException;
import framework.exception.DriverUtilitiesException;
import framework.utilities.ConfigFileReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class ApplicationHooks {

    private ConfigFileReader config;
    private DriverUtilities driverUtilities;
    private WebDriver driver;
    private Properties properties = new Properties();

    static {

    }

    @Before(order = 0)
    public void getProperty() throws ConfigFileReaderException {
        try {
            config = new ConfigFileReader();
            properties = config.configFile();
        } catch (ConfigFileReaderException e) {
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

    @After(order = 1)
    public void tearDown() {
        try {
            driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @After(order = 0)
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
