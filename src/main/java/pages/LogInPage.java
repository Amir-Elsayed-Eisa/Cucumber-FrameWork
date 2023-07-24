package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LogInPage extends Base {


    @FindBy(linkText = "Log in")
    WebElement LogInLink;
    @FindBy(id = "Email")
    WebElement EmailField;
    @FindBy(id = "Password")
    WebElement PasswordField;
    @FindBy(id = "RememberMe")
    WebElement RememberMeButton;
    @FindBy(css = "button.button-1.login-button")
    WebElement LogInButton;
    @FindBy(linkText = "Log out")
    WebElement LogoutBTN;

    //    "Welcome to our store"
    @FindBy(css = "div [class = 'topic-block-title']")
    public WebElement WelcomeMessage;

    @FindBy(linkText = "Log out")
    public WebElement LogOutLink;

    public LogInPage(WebDriver driver) {
        super(driver);
    }


    public void UserLogIn(String userEmail, String userPassword){
        LogInLink.click();
        EmailField.sendKeys(userEmail);
        PasswordField.sendKeys(userPassword);

        LogInButton.click();

    }
    public void UserLogout(){
        LogOutLink.click();
    }


}
