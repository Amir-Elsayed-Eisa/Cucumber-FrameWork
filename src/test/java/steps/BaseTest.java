package steps;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import utilities.Helper;

public class BaseTest extends AbstractTestNGCucumberTests {
    public static WebDriver driver;
    @BeforeSuite
    public void InitiateBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://demo.nopcommerce.com/");
    }
    @AfterSuite
    public void QuitDriver() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
    @AfterMethod
    public void screenshotOnFailure(ITestResult result){
        if (result.getStatus() == ITestResult.FAILURE){
            System.out.println("Failed");
            System.out.println("Taking a screenshot");
            Helper.captureScreenshot(driver, result.getName());
        }else {
            System.out.println("Test is good you are safe");
        }
    }
}
