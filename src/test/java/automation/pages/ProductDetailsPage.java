package automation.pages;

import framework.exception.UIActionException;
import framework.uiaction.UIAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailsPage {

    private WebDriver driver = null;


    private final By productName = By.cssSelector("h2[class=\"name\"]");
    private final By productPrice = By.cssSelector("h3[class=\"price-container\"]");
    private final By productDescription = By.cssSelector("div[id=\"more-information\"] p");

    UIAction uiAction;

    public ProductDetailsPage(WebDriver driver) {
        this.driver = driver;
        uiAction = new UIAction(driver);
    }

    public String getProductName() throws UIActionException {

       return uiAction.getText(productName);
        //return driver.findElement(productName).getText();
    }

    public String getProductPrice() throws UIActionException {

       return uiAction.getText(productPrice);
        //return driver.findElement(productPrice).getText();
    }

    public String getProductDescription() throws UIActionException {
        return uiAction.getText(productPrice);
       // return driver.findElement(productDescription).getText();
    }
}
