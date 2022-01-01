package automation.stepdefinitions;

import automation.pages.ContactPage;
import automation.pages.StoreHomePage;
import framework.driver.DriverUtilities;
import framework.exception.UIActionException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class ContactStep {

    ContactPage contactPage = new ContactPage(DriverUtilities.getDriver());
    StoreHomePage storeHomePage = new StoreHomePage(DriverUtilities.getDriver());

    @Given("I click on contact tab")
    public void i_click_on_contact_tab() throws UIActionException {
      contactPage.clickOnContactTab();
    }

    @Given("I see new contact message form")
    public void i_see_new_message_popup() throws UIActionException {
       Assert.assertTrue(contactPage.isContactFormDisplayed());
    }

    @Given("i enter contact details {string}")
    public void i_enter_contact_details(String contact) throws UIActionException {
    String [] contactDetails = contact.split(",");
    Assert.assertEquals(contactPage.enterContactEmail(contactDetails[0]),contactDetails[0]);
    Assert.assertEquals(contactPage.enterContactName(contactDetails[1]),contactDetails[1]);
    Assert.assertEquals(contactPage.enterContactQueryOrMessage(contactDetails[2]),contactDetails[2]);
    }

    @When("I submit on send message button")
    public void i_submit_on_send_message_button() throws UIActionException {
        contactPage.clickOnSubmitMessage();
    }

    @Then("I should get contact message submitted alert pop up with message {string}")
    public void i_should_get_popup_alert_with_message(String alertPopup) {
       Assert.assertEquals(contactPage.getContactFormAlertMessage(),alertPopup);
    }

    @When("I click on cancel submit message")
    public void i_click_on_cancel_submit_message() throws UIActionException {
        contactPage.clickOnCloseMessage();
    }

    @Then("Contact message popup should be closed")
    public void contact_message_popup_should_be_closed() {

    }

}
