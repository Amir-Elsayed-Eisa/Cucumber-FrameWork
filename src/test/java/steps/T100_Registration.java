package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.HomePage;
import pages.Registration;

public class T100_Registration extends BaseTest{
 HomePage homeOBJ;
 Registration regOBJ;

    @Given("Open home page and navigate to register page")
    public void Open_home_page_and_navigate_to_register_page(){
        homeOBJ = new HomePage(driver);
        homeOBJ.OpenRegistrationPage();
    }
    @When("User enters the data {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
    public void User_enters_the_data(String fName, String lName, String D, String M, String Y, String userEmail, String companyName, String userPassword){
        regOBJ = new Registration(driver);
        regOBJ.UserRegistrationSteps(fName, lName, D, M, Y, userEmail, companyName, userPassword);
    }
    @Then("Registration passed successfully")
    public void Registration_passed_successfully(){
        Assert.assertTrue(regOBJ.SuccessfullyRegistered.isDisplayed());
        regOBJ.ContinueToLogin.click();
    }

//    User Registration doesn't pass
    @Given("User clicked on register link again")
    public void User_clicked_on_register_link_again(){
        homeOBJ = new HomePage(driver);
        homeOBJ.OpenRegistrationPage();
    }
    @When("User enters the same data again {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
    public void User_enters_the_same_data_again(String fName, String lName,String D, String M, String Y, String userEmail, String companyName, String userPassword){
        regOBJ = new Registration(driver);
        regOBJ.UserRegistrationSteps(fName, lName, D, M, Y, userEmail, companyName, userPassword);
    }
    @Then("System refuses to register the same email")
    public void refuses_to_register_the_same_email(){
        Assert.assertTrue(regOBJ.errorMessage.isDisplayed());
    }
}
