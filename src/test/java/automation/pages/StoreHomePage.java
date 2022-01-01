package automation.pages;

import framework.constant.FrameworkConstant;
import framework.exception.UIActionException;
import framework.uiaction.UIAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class StoreHomePage {

    private WebDriver driver;

//locators

    private final By phoneTab = By.linkText("Phones");
    private final By laptopTab = By.linkText("Laptops");
    private final By categories = By.id("cat");
    private final By itemList = By.id("itemc");
    private final By monitorLink = By.linkText("Monitors");
    private final By monitorsList = By.cssSelector("div[class=\"card-block\"] a[class=\"hrefch\"]");

    private final By laptopName = By.cssSelector("h4[class=\"card-title\"]");
    private final By laptopPrice = By.cssSelector("div[class=\"card-block\"] h5");
    private final By laptopDescription = By.cssSelector("p[id=\"article\"]");

    UIAction uiAction;

    //Constructor
    public StoreHomePage(WebDriver driver) {
        this.driver = driver;
        uiAction = new UIAction(driver);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public List<String> getProductCategories() {
        List<String> product = new ArrayList<>();

        List<WebElement> productElement = driver.findElements(itemList);
        String category = driver.findElement(categories).getText();
        product.add(category);
        for (WebElement e : productElement) {
            if (e.getText() != null) {
                product.add(e.getText());
            }
        }
        return product;
    }

    public List<String> getMonitorList() throws UIActionException {
        List<String> monitor = new ArrayList<>();
//        List<WebElement> monitorElement = driver.findElements(monitorsList);
//        for (WebElement e : monitorElement) {
//            if (e.getText() != null) {
//                monitor.add(e.getText());
//            }
//        }
//        return monitor;

        monitor = uiAction.getListOfString(monitorsList);
        return monitor;
    }

    public void clickOnMonitorTab() {
        driver.findElement(monitorLink).click();
    }

    public void clickOnPhoneTab() {
        driver.findElement(phoneTab).click();
    }

    public void clickOnLaptopTab() throws InterruptedException {
        driver.findElement(laptopTab).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(FrameworkConstant.MEDIUM_WAIT));
        wait.until(ExpectedConditions.visibilityOfElementLocated(laptopName));
        Thread.sleep(10000);
    }

    public void clickOnDifferentPhone(String phone) throws InterruptedException {
        driver.findElement(By.linkText(""+phone+"")).click();
        Thread.sleep(2000);
        String parentWindow = driver.getWindowHandle();
        Iterator<String> allWindows= driver.getWindowHandles().iterator();
        while(allWindows.hasNext()){
            String childWindow = allWindows.next();
            if(parentWindow!=childWindow){
                driver.switchTo().window(childWindow);
            }
        }

    }

    public List<String> getLaptopNames() throws UIActionException {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(FrameworkConstant.LOW_WAIT));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(laptopName));
        List<String> monitor = new ArrayList<>();
//        List<WebElement> monitorElement = driver.findElements(laptopName);
//        for (WebElement e : monitorElement) {
//            if (e.getText() != null) {
//                monitor.add(e.getText());
//            }
//        }
        monitor = uiAction.getListOfString(laptopName);
        return monitor;
    }

    public List<String> getLaptopPrices() throws UIActionException {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(FrameworkConstant.LOW_WAIT));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(laptopPrice));
//        List<WebElement> monitorElement = driver.findElements(laptopPrice);
//        for (WebElement e : monitorElement) {
//            if (e.getText() != null) {
//                monitor.add(e.getText().replaceAll("[^0-9]",""));
//            }
//        }
        List<String> monitor = new ArrayList<>();
        monitor = uiAction.getListOfString(laptopPrice);
        return monitor;
    }

    public List<String> getLaptopDescriptions() throws UIActionException {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(FrameworkConstant.LOW_WAIT));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(laptopDescription));
        List<String> monitor = new ArrayList<>();
//        List<WebElement> monitorElement = driver.findElements(laptopDescription);
//        for (WebElement e : monitorElement) {
//            if (e.getText() != null) {
//                System.out.println(" text is -------"+ e.getText());
//                monitor.add(e.getText());
//            }
//        }
        monitor = uiAction.getListOfString(laptopDescription);
        return monitor;
    }

}
