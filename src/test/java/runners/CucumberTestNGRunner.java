package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "C:/Users/yash.gangwar1/eclipse-workspace/testcucumber1/resources/features/crossbrowser.feature",
        glue = "stepdefs",
        plugin = {"pretty"}
)
public class CucumberTestNGRunner extends AbstractTestNGCucumberTests {
}