package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class UserSearchForProducts extends Base{

    public UserSearchForProducts(WebDriver driver) {
        super(driver);
    }
    Base PageOBJ;


    @FindBy(id = "small-searchterms")
    WebElement SearchBar;
    @FindBy(css = "button.button-1.search-box-button")
    WebElement SearchButton;

    //    "Apple MacBook Pro 13-inch"
    @FindBy(css = "div.product-name")
    public WebElement SearchedProductName;

    @FindBy(linkText = "Apple MacBook Pro 13-inch")
    public WebElement SearchedProductResult;
    @FindBy(id = "ui-id-1")
    public List<WebElement> ListOfProducts;
    @FindBy(className = "product-name")
    public WebElement autoSearchedProduct;
    public void UserSearch(String SearchKeyWordsP1) {
        PageOBJ = new Base(driver);

        SearchBar.sendKeys(SearchKeyWordsP1);
        SearchButton.click();
        PageOBJ.PageExplore();


        }
    public void AutoCompleteForUserSearch(String SearchKeyWordsP2) {
        SearchBar.sendKeys(SearchKeyWordsP2);


    }
    public void SelectTheChosenProduct(){
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(ListOfProducts.get(0)));
        ListOfProducts.get(0).click();
    }

}
