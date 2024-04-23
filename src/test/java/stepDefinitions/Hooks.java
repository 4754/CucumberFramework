package stepDefinitions;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import utils.TestContextSetup;

public class Hooks {
	

	
	TestContextSetup testContextSetup;

	public Hooks(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
	}

	@After
	public void afterScenerio() {
		testContextSetup.testBaseClass.driver.quit();
	}

}
