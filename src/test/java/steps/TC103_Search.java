package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.UserSearchForProducts;

public class TC103_Search extends BaseTest {
    UserSearchForProducts searchOBJ;
    @Given("User enters the data in search field")
    public void User_enters_the_data_in_search_field(DataTable product){
        searchOBJ = new UserSearchForProducts(driver);
        searchOBJ.UserSearch(product.cell(0, 0));
    }
    @When("User click on search to see the results")
    public void User_click_on_search_to_see_the_results(){
        searchOBJ.SearchedProductResult.click();
    }
    @Then("User can see the product")
    public void User_can_see_the_product(){
        Assert.assertEquals(searchOBJ.SearchedProductName.getText(), "Apple MacBook Pro 13-inch");
    }

    @Given("User enters the data")
    public void User_enters_the_data(DataTable product){
        searchOBJ =new UserSearchForProducts(driver);
        searchOBJ.AutoCompleteForUserSearch(product.cell(0,0));

    }
    @When("User choose the autocomplete suggestions")
    public void User_choose_the_autocomplete_suggestions(){
        searchOBJ.SelectTheChosenProduct();
    }
    @Then("User can see the chosen product")
    public void User_can_see_the_chosen_product(){
        Assert.assertEquals(searchOBJ.autoSearchedProduct.getText(), "Asus N551JK-XO076H Laptop");
    }
}
