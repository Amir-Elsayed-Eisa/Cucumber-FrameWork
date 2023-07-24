package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UserAccount extends Base{
    public UserAccount(WebDriver driver) {
        super(driver);
    }

   @FindBy(linkText = "My account")
    WebElement MyAccount;
    @FindBy(linkText = "Change password")
    WebElement ChangePasswordLink;
    @FindBy(id = "OldPassword")
    WebElement OldPassword;
    @FindBy(id = "NewPassword")
    WebElement NewPassword;
    @FindBy(id = "ConfirmNewPassword")
    WebElement ConfirmNPassword;
    @FindBy(css = "button.button-1.change-password-button")
    WebElement ChangePasswordButton;
    @FindBy(id = "bar-notification")
    WebElement Notification;

    //Password was changed
    public String passwordNotify = Notification.getText();
    @FindBy(css = "span.close")
    public WebElement NotificationCloseButton;

    @FindBy(linkText = "Log out")
    WebElement LogOutLink;



    public void UserEntersHisAccount(){
        MyAccount.click();
    }
    public void ChangeUSerPassword(String userPassword,String newPassword){

        ChangePasswordLink.click();
        OldPassword.sendKeys(userPassword);
        NewPassword.sendKeys(newPassword);
        ConfirmNPassword.sendKeys(newPassword);
        ChangePasswordButton.click();
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(Notification)).isDisplayed();

    }
    public void UserCanLogout(){
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(LogOutLink)).click();
    }
}
