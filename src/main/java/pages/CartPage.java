package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage extends Base{
    public CartPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "add-to-cart-button-5")
    WebElement addToCartButton;
    @FindBy(id = "bar-notification")
    public WebElement barNotification;
    //The product has been added to your
    @FindBy(linkText = "shopping cart")
    WebElement shoppingCartLink;
    @FindBy(css = "div.page-title")
    public WebElement pageTitleContent;
    //Shopping cart
    @FindBy(linkText = "Asus N551JK-XO076H Laptop")
    public WebElement addedProduct;
    @FindBy(css = "button.remove-btn")
    public WebElement removeProductButton;
    @FindBy(css = "div.no-data")
    public WebElement emptyCartContent;
    //Your Shopping Cart is empty!
    @FindBy(id = "updatecart")
    public WebElement updateCartButton;
    @FindBy(css = "button.button-2.continue-shopping-button")
    WebElement continueShoppingButton;
    @FindBy(linkText = "Shopping cart")
    WebElement shoppingCartLabel;
    public void addProductsAndUpdateCart(){
        addToCartButton.click();
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(barNotification));

    }
    public void LogIntoCart(){
        shoppingCartLink.click();
    }
    public void ContinueShopping(){
        continueShoppingButton.click();
        shoppingCartLabel.click();
    }
    public void removeProduct(){
        removeProductButton.click();
    }


}
