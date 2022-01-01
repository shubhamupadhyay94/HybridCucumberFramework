package framework.driver;

import framework.exception.DriverUtilitiesException;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.logging.Level;

public class DriverUtilities {

    public WebDriver driver;

    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();


    /*
     * This is used to create a driver for different browser
     * @return WebDriver
     * */
    public WebDriver initDriver(String browser) throws DriverUtilitiesException {

        try {
            System.out.println("Browser name is " + browser);
            if (browser.equals("chrome")) {
                WebDriverManager.chromedriver().setup();

                ChromeOptions option = new ChromeOptions();
                option.addArguments("--test-type");
                option.addArguments("--disable-popup-bloacking");

                DesiredCapabilities chrome = new DesiredCapabilities();
                chrome.setJavascriptEnabled(true);

                LoggingPreferences logPrefs = new LoggingPreferences();

                logPrefs.enable(LogType.PERFORMANCE, Level.ALL);

                chrome.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);

                option.setCapability(ChromeOptions.CAPABILITY, option);
                //Create driver object for Chrome

                tlDriver.set(new ChromeDriver(option));

            } else if (browser.equals("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                tlDriver.set(new FirefoxDriver());
            } else if (browser.equals("edge")) {
                WebDriverManager.edgedriver().setup();
                tlDriver.set(new EdgeDriver());
            } else if (browser.equals("ie")) {
                WebDriverManager.iedriver().setup();
                tlDriver.set(new InternetExplorerDriver());
            } else {
                System.out.println("Browser is not supported.");
            }

            getDriver().manage().deleteAllCookies();
            getDriver().manage().window().maximize();
            getDriver().get("https://www.demoblaze.com/");
            Thread.sleep(2000);
            return getDriver();
        } catch (Exception e) {
            throw new DriverUtilitiesException(e.getMessage(), e);
        }


    }

    /*
     * This is used to get the driver with ThreadLocal
     * @return
     * */
    public static synchronized WebDriver getDriver() {
        return tlDriver.get();
    }

    public static void main(String args[]) throws DriverUtilitiesException {

        DriverUtilities driverUtilities = new DriverUtilities();
        WebDriver driver = driverUtilities.initDriver("ie");
        driver.get("https://www.upwork.com/");
    }

}
