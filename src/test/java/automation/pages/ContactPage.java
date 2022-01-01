package automation.pages;

import framework.constant.FrameworkConstant;
import framework.exception.UIActionException;
import framework.uiaction.UIAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ContactPage {

    private WebDriver driver;

    //locators
    private final By contact = By.linkText("Contact");

    //form header
    private final By contactForm = By.id("exampleModalLabel");

    //form details
    private final By contactEmail = By.id("recipient-email");
    private final By contactName = By.id("recipient-name");
    private final By closeSendMessage = By.cssSelector("div[class=\"modal-footer\"] button[class=\"btn btn-secondary\"]");
    private final By contactQueryOrMessage = By.id("message-text");
    private final By submitMessage = By.cssSelector("div[class=\"modal-footer\"] button[class=\"btn btn-primary\"]");

    UIAction uiAction = null;

    //Constructor
    public ContactPage(WebDriver driver)
    {
        this.driver = driver;
        uiAction =  new UIAction(driver);
    }

  //  UIAction uiAction = new UIAction(this.driver);

    public boolean isContactFormDisplayed() throws UIActionException {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(FrameworkConstant.LOW_WAIT));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(contactForm));

        return uiAction.isDisplayed(contactForm);
        //return driver.findElement(contactForm).isDisplayed();
    }

    public void clickOnContactTab() throws UIActionException {
       // driver.findElement(contact).click();
        uiAction.click(contact);
    }

    public String enterContactEmail(String emailId) throws UIActionException {
//        driver.findElement(contactEmail).clear();
//        driver.findElement(contactEmail).sendKeys(emailId);
       // return driver.findElement(contactEmail).getAttribute("value");
        return uiAction.sendKeys(contactEmail,emailId);
    }

    public String enterContactName(String name) throws UIActionException {
//        driver.findElement(contactName).clear();
//        driver.findElement(contactName).sendKeys(name);
//        return driver.findElement(contactName).getAttribute("value");
        return uiAction.sendKeys(contactName,name);
    }

    public String enterContactQueryOrMessage(String message) throws UIActionException {
//        driver.findElement(contactQueryOrMessage).clear();
//        driver.findElement(contactQueryOrMessage).sendKeys(message);
//        return driver.findElement(contactQueryOrMessage).getAttribute("value");
        return uiAction.sendKeys(contactQueryOrMessage,message);
    }

    public void clickOnSubmitMessage() throws UIActionException {
        //driver.findElement(submitMessage).click();
        uiAction.click(submitMessage);
    }

    public void clickOnCloseMessage() throws UIActionException {
        //driver.findElement(closeSendMessage).click();
        uiAction.click(closeSendMessage);
    }

    public String getContactFormAlertMessage() {
        String alertMessage = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        return alertMessage;
    }
}
