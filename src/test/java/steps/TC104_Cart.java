package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.CartPage;
import pages.UserSearchForProducts;

public class TC104_Cart extends BaseTest{
    UserSearchForProducts searchOBJ;
    CartPage cartOBJ;
    @Given("Search for product using and add the product to cart")
    public void Search_for_product_using(DataTable product){
        searchOBJ = new UserSearchForProducts(driver);
        cartOBJ = new CartPage(driver);
        searchOBJ.AutoCompleteForUserSearch(product.cell(0,0));
        searchOBJ.SelectTheChosenProduct();
        cartOBJ.addProductsAndUpdateCart();
    }
    @When("Notification bar is displayed")
    public void Notification_bar_is_displayed (){

        Assert.assertTrue(cartOBJ.barNotification.isDisplayed());
        Assert.assertEquals(cartOBJ.barNotification.getText(), "The product has been added to your shopping cart");
    }
    @Then("User visit Cart to see the product")
    public void User_visit_Cart_to_see_the_product(){
        cartOBJ.LogIntoCart();

        Assert.assertEquals(cartOBJ.addedProduct.getText(), "Asus N551JK-XO076H Laptop");
        Assert.assertTrue(cartOBJ.updateCartButton.isDisplayed());
    }

//    Edit Cart
    @Given("User can decides to continue search")
    public void User_can_decides_to_continue_search(){
        cartOBJ = new CartPage(driver);
        cartOBJ.ContinueShopping();

    }
    @When("User go back and remove product")
    public void User_go_back_and_remove_product(){
        Assert.assertEquals(cartOBJ.pageTitleContent.getText(), "Shopping cart");
        Assert.assertEquals(cartOBJ.addedProduct.getText(), "Asus N551JK-XO076H Laptop");
    }
    @Then("Cart became empty")
    public void Cart_became_empty(){
        cartOBJ.removeProduct();
        Assert.assertEquals(cartOBJ.emptyCartContent.getText(), "Your Shopping Cart is empty!");
    }
}
