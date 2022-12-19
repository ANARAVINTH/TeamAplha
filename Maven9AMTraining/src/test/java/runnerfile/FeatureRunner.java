package runnerfile;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        features = {"src/test/resources/featurefile/"},
        glue = {"stepdefinationfile"},
        tags = "@LinkList",
        plugin ={"html:test-output/report.html","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)


public class FeatureRunner {

}
