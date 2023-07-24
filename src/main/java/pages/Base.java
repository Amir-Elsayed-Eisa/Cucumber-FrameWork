package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Base {
    protected WebDriver driver;
    public Base(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
    public void PageExplore() {
        JavascriptExecutor SD = (JavascriptExecutor) driver;
        SD.executeScript("scrollBy(0,1500)");
        SD.executeScript("scrollBy(1500, 0)");
    }
}
