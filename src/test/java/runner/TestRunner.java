package runner;

import io.cucumber.testng.CucumberOptions;
import steps.BaseTest;

@CucumberOptions(features = "C:\\Users\\amazon\\IdeaProjects\\Cucumber\\src\\test\\java\\features",
                 glue = {"steps"},
                 plugin = {"pretty", "html:target/cucumber-html-report.html"}, monochrome = true)
public class TestRunner extends BaseTest {

}
