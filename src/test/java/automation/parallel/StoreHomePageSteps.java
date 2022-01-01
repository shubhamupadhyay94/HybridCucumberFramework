package automation.parallel;

import automation.constant.StoreHomePageConstant;
import automation.pages.StoreHomePage;
import framework.driver.DriverUtilities;
import framework.exception.UIActionException;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.*;

public class StoreHomePageSteps {

 private StoreHomePage storeHomePage = new StoreHomePage(DriverUtilities.getDriver());

 //(\\d+)

    @Given("^I am on the Store home page$")
    public void i_am_on_the_store_home_page() {
        Assert.assertEquals(storeHomePage.getPageTitle(),StoreHomePageConstant.PAGE_TITLE);
    }

    @When("^I verify the store home page details$")
    public void i_verify_the_store_home_page_details() {

    }

    @Then("I should be able to see {string} tab")
    public void i_should_be_able_to_see_tab(String product) {
        String[] prodCategory =product.split(",");
        List<String> getProduct = new ArrayList<>();
        getProduct= storeHomePage.getProductCategories();
        Assert.assertEquals(Arrays.asList(prodCategory),getProduct);
    }

    @When("I click on monitors tab")
    public void i_click_on_monitors_tab() {
       storeHomePage.clickOnMonitorTab();
    }

    @Then("I should be able to see {string} monitor list")
    public void i_should_be_able_to_see_monitor_list(String monitor) throws UIActionException {
        String[] monitorCategory =monitor.split(",");
        List<String> getMonitor = new ArrayList<>();
        getMonitor= storeHomePage.getMonitorList();
        Assert.assertEquals(Arrays.asList(monitorCategory),getMonitor);
    }

    @Then("I should be able to see page title as {string}")
    public void i_should_be_able_to_see_page_title_as(String title) {
        Assert.assertEquals(storeHomePage.getPageTitle(), title);
    }

    @Given("I click on phones tab")
    public void i_click_on_phones_tab() {
        storeHomePage.clickOnPhoneTab();
    }

    @When("I click on different phone {string}")
    public void i_click_on_different_phone(String phone) throws InterruptedException {
        storeHomePage.clickOnDifferentPhone(phone);
    }

    @When("I click on laptop tab")
    public void i_click_on_laptop_tab() throws InterruptedException {
     storeHomePage.clickOnLaptopTab();
    }

    @Then("I should be able to see the <laptopName> and <laptopPrice> and <laptopDescription> details on laptop tab")
    public void i_should_be_able_to_see_the_laptop_name_and_laptop_price_and_laptop_description_details_on_laptop_tab(DataTable dataTable) throws UIActionException {
        List<Map<String,String>> getProdDetails= dataTable.asMaps(String.class,String.class);
        Iterator itr = getProdDetails.iterator();
        while(itr.hasNext()){
            Map<String,String> eachProduct= (Map<String, String>) itr.next();
            Set set =eachProduct.keySet();
            Assert.assertTrue(storeHomePage.getLaptopNames().contains(eachProduct.get("laptopName")));
            Assert.assertTrue(storeHomePage.getLaptopPrices().contains(eachProduct.get("laptopPrice")));
            Assert.assertTrue(storeHomePage.getLaptopDescriptions().contains(eachProduct.get("laptopDescription")));
        }
    }

}
