package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.LogInPage;
import pages.UserAccount;

public class TC102_UserAccount extends BaseTest {
    LogInPage LIOBJ;
    UserAccount AccountOBJ;
    @Given("User Login with data {string}, {string}")
    public void User_Login_with_data(String userEmail, String userPassword){
        LIOBJ = new LogInPage(driver);
        LIOBJ.UserLogIn(userEmail, userPassword);

    }
    @When("User visit his account to change password")
    public void User_visit_his_account_to_change_password(){
        AccountOBJ = new UserAccount(driver);
        AccountOBJ.UserEntersHisAccount();
        Assert.assertEquals(driver.getCurrentUrl(), "https://demo.nopcommerce.com/customer/info");

    }
    @When("User clicks on change password and enters the data {string}, {string}")
    public void User_enters_the_data(String userPassword, String newPassword){
        AccountOBJ.ChangeUSerPassword(userPassword, newPassword);


    }
    @Then("User has changed the password successfully and can log out")
    public void User_has_changed_the_password_successfully_and_can_log_out (){

        AccountOBJ.NotificationCloseButton.click();
        AccountOBJ.UserCanLogout();
    }
}
