package framework.uiaction;

import framework.constant.FrameworkConstant;
import framework.exception.UIActionException;
import net.thucydides.core.webdriver.exceptions.ElementNotFoundAfterTimeoutError;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class UIAction {

    private WebDriver driver;

    public UIAction() {

    }

    public UIAction(WebDriver driver){
        this.driver = driver;

    }

    public String getText(By by) throws UIActionException {
        try{
            String text=null;
            visibilityOfElement(by);
            WebElement element = driver.findElement(by);
            if(element.getText()!=null){
                text = element.getText();
            }
            return text;
        } catch( Exception e){
            throw new UIActionException(e.getMessage(),e);
        }

    }

    public WebElement findElement(By by) throws UIActionException {
        WebElement element;
        try{
            visibilityOfElement(by);
            element = driver.findElement(by);
        }catch(NoSuchElementException e){
            throw new UIActionException("Element not found ", e);
        }
        catch(Exception e){
            throw new UIActionException(e.getMessage(),e);
        }
        return element;
    }

    public boolean isDisplayed(By by) throws UIActionException {
        boolean status;
        try{
            visibilityOfElement(by);
            status = driver.findElement(by).isDisplayed();
        }catch(NoSuchElementException e){
            throw new UIActionException("Element not found ", e);
        }
        catch(Exception e){
            throw new UIActionException(e.getMessage(),e);
        }
        return status;
    }

    public void click(By by) throws UIActionException {

        try{
            findElement(by).click();

            }catch(NoSuchElementException e){
            throw new UIActionException("No such element ", e);
        }
        catch(Exception e){
            throw new UIActionException(e.getMessage(),e);
        }

    }

    public String sendKeys(By by,String text) throws UIActionException {
        String getText=null;
        try{
            findElement(by).clear();
            findElement(by).sendKeys(text);
            getText=findElement(by).getAttribute("value");
        }
        catch(Exception e){
            throw new UIActionException(e.getMessage(),e);
        }
        return getText;
    }


    public List<WebElement> findElements(By by) throws UIActionException {
        List<WebElement> elements;
        try{
            visibilityOfElement(by);
            elements = driver.findElements(by);
        }catch(NoSuchElementException e){
            throw new UIActionException("Element not found ", e);
        }
        catch(Exception e){
            throw new UIActionException(e.getMessage(),e);
        }
        return elements;
    }

    public List<String> getListOfString(By by) throws UIActionException {
        List<WebElement> elements;
        List<String> getElement = new ArrayList<>();
        try{
          elements = findElements(by);
            for (WebElement e : elements) {
                if (e.getText() != null) {
                    getElement.add(e.getText());
                }
        }
        } catch(NoSuchElementException e){
            throw new UIActionException("Element not found ", e);
        }
        catch(Exception e){
            throw new UIActionException(e.getMessage(),e);
        }
        return getElement;
    }


    public void visibilityOfElement(By by) throws UIActionException {
        try{
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(FrameworkConstant.LOW_WAIT));
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch(Exception e){
            throw new UIActionException(e.getMessage(),e);
        }
    }

}
