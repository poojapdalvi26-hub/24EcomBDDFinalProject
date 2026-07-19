package hooks;

import com.VelocityEcom.driverFactory.DriverFactory;
import com.VelocityEcom.utils.Utility;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Reporter;

import java.io.IOException;
import java.time.Duration;

public class Hooks {

    @Before
    public void launchBrowser() throws IOException {
        DriverFactory.setBrowser(Utility.readDataFromPropertiesFile("browser"));
        DriverFactory.getDriver().get(Utility.readDataFromPropertiesFile("url"));
        DriverFactory.getDriver().manage().window().maximize();
        DriverFactory.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @After(order=1)
    public void closeBrowser(){
        DriverFactory.getDriver().quit();
        System.out.println("closing the browser");
    }

    @After(order=2)
    public void takeScreenshot(Scenario scenario) throws InterruptedException {
        if(scenario.isFailed()) {
            Thread.sleep(9000);
            byte[] screenshot = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.BYTES);
            Reporter.log("screenshot is taken", true);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
    }
}
