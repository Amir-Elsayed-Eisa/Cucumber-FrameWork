package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class Registration extends Base{
    public Registration(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "gender-male")
    WebElement Gender;

    @FindBy(id = "FirstName")
    WebElement FirstName;

    @FindBy(id = "LastName")
    WebElement LastName;

    @FindBy(name = "DateOfBirthDay")
    WebElement DOBDay;

    @FindBy(name = "DateOfBirthMonth")
    WebElement DOBMonth;

    @FindBy(name = "DateOfBirthYear")
    WebElement DOBYear;
    @FindBy(id = "Email")
    WebElement Email;

    @FindBy(id = "Newsletter")
    WebElement NewsButton;

    @FindBy(id = "Password")
    WebElement Password;

    @FindBy(id = "ConfirmPassword")
    WebElement ConfirmPassword;

    @FindBy(id = "Company")
    WebElement Company;

    @FindBy(id = "register-button")
    WebElement RegisterButton;

    @FindBy(css = "div [class='result']")
    public WebElement SuccessfullyRegistered;
    @FindBy(css = "div [class='buttons']")
    public WebElement ContinueToLogin;

    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/form/div[1]/ul/li")
    public WebElement errorMessage;
    public void UserRegistrationSteps(String fName,String lNAme,String D, String M, String Y, String userEmail,String companyName, String userPassword) {

        Gender.click();
        FirstName.sendKeys(fName);
        LastName.sendKeys(lNAme);

        Select Day = new Select(DOBDay);
        Day.selectByValue(D);
        Select Month = new Select(DOBMonth);
        Month.selectByValue(M);
        Select Year = new Select(DOBYear);
        Year.selectByValue(Y);

        Email.sendKeys(userEmail);
        Company.sendKeys(companyName);

        if (NewsButton.isSelected()) {
            NewsButton.click();
        } else {
            System.out.println("You will not receive the news automatically");
        }

        Password.sendKeys(userPassword);
        ConfirmPassword.sendKeys(userPassword);
        RegisterButton.click();
    }
}
