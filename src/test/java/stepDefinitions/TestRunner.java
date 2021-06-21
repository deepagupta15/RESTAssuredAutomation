package stepDefinitions;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


//@RunWith(Cucumber.class)
//@CucumberOptions(plugin = {"pretty", "html:target/cucumber-report.html"},
//        features="src/test/resources/Features",
//       glue={"stepDefinition"}
       // tags= "@RegressionTest or @SmokeTest"
//        )

//@CucumberOptions(features = "src/test/resources/Features/",glue = {"stepDefinitions"})


@RunWith(Cucumber.class)
@CucumberOptions(
        features = ".\\src\\test\\resources\\Features\\",
        glue = {"stepDefinitions"},
        monochrome = true,
        strict = true
)
public class TestRunner {

}
