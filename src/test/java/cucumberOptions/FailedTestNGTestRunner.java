package cucumberOptions;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features="@target/failed_Scenario.txt",
		glue="stepDefinitions",
		monochrome=true, 
		plugin= {
				"html:target/cucumber.html",
				"json:target/cucumber.json",
				"rerun:target/failed_Scenario.txt"
				}
		)
public class FailedTestNGTestRunner extends AbstractTestNGCucumberTests {

//	to run parallel test cases in cucumber
	@Override
	@DataProvider(parallel=true)
	public Object[][] scenarios(){
		return super.scenarios();
	}
}
