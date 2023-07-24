package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;
import pages.LogInPage;


public class TC101_UserLogin extends BaseTest {


    LogInPage LPOBJ;
    @Given("User goes back to home page after registration")
    public void user_in_the_login_page_after_registration() {
        LPOBJ = new LogInPage(driver);
        Assert.assertTrue(driver.findElement(By.linkText("Log in")).isDisplayed());

    }

    @When("User clicked on Login link and entered the data {string}, {string}")
    public void user_entered_the_data(String userEmail, String userPassword) {
        LPOBJ.UserLogIn(userEmail, userPassword);


    }

    @When("User Login with his account done successfully")
    public void user_login_with_his_account_done_successfully() {

        Assert.assertEquals(LPOBJ.WelcomeMessage.getText(),"Welcome to our store");
    }
    @Then("User can Log out")
    public void User_can_Log_out() {
        Assert.assertTrue(LPOBJ.LogOutLink.isDisplayed());
        LPOBJ.UserLogout();
    }
}
