package automation.parallel;

import automation.pages.ProductDetailsPage;
import framework.driver.DriverUtilities;
import framework.exception.UIActionException;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class ProductDetailsStep {

    ProductDetailsPage detailsPage = new ProductDetailsPage(DriverUtilities.getDriver());

    @Then("I should be able to see the <mobileName> and <mobilePrice> and <mobileDescription> details in next tab")
    public void i_should_be_able_to_see_the_mobile_name_and_mobile_price_and_mobile_description_details_in_next_tab(DataTable dataTable) throws UIActionException {

        //way 1 to read datatable as asLists
//       List<List<String>> titlist = dataTable.asLists();

//       for(List<String> list:titlist){
//           Assert.assertEquals(list.get(0).trim(),detailsPage.getProductName().trim());
//           Assert.assertEquals(list.get(1),detailsPage.getProductPrice().replaceAll("[^0-9]",""));
//           Assert.assertEquals(list.get(2).trim(),detailsPage.getProductDescription().trim());
//       }

      List<Map<String,String>> getProdDetails= dataTable.asMaps(String.class,String.class);

        Iterator itr = getProdDetails.iterator();
        while(itr.hasNext()){
            Map<String,String> eachProduct= (Map<String, String>) itr.next();
            Set set =eachProduct.keySet();
            Assert.assertEquals(eachProduct.get("mobileName"),detailsPage.getProductName().trim());
            Assert.assertEquals(eachProduct.get("mobilePrice"),detailsPage.getProductPrice().replaceAll("[^0-9]",""));
            Assert.assertEquals(eachProduct.get("mobileDescription"),detailsPage.getProductDescription().trim());
        }
    }

    @Then("I should be able to see the {string} name and details on new tab")
    public void i_should_be_able_to_see_the_name_and_details_on_new_tab(String mobile) throws UIActionException {
        Assert.assertEquals(detailsPage.getProductName().trim(),mobile);
    }

}
