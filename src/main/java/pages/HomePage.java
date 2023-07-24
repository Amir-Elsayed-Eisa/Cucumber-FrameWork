package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends Base{

    public HomePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(linkText = "Register")
    WebElement RegisterPage;
    public void OpenRegistrationPage(){
        RegisterPage.click();

    }
}
