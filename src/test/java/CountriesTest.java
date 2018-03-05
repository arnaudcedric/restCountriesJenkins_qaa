import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import java.io.File;

@CucumberOptions(
//        tags = {"@GetAllCountries"},
        format = {"json:target/cucumber.json", "html:target/site/cucumber-pretty"},
        glue = {"stepdefs"},
        features = {"src/test/java/features/GetAllCountries.feature",

        }
//        ,
//        plugin = {"com.cucumber.listener.ExtentCucumberFormatter:output/report.html"}
)

@RunWith(Cucumber.class)
public class CountriesTest {
    //before and after class for the scenarios goes here

//        @AfterClass
//        public static void setup() {
//                Reporter.loadXMLConfig(new File("src/test/resources/extent-config.xml"));
//                Reporter.setSystemInfo("user", System.getProperty("user.name"));
//                Reporter.setSystemInfo("os", "Windows 10");
//                Reporter.setTestRunnerOutput("Sample test runner output message");
//        }


}
