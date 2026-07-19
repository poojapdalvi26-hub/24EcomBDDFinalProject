package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/resources/features/DashboardValidation.feature"},
        glue = {"stepDefinitions","hooks"},
        publish = true,
        plugin = {"pretty"}


)

public class VCEcomRunner extends AbstractTestNGCucumberTests {


}
