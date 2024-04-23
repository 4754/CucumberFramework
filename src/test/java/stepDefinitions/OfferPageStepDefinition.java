package stepDefinitions;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import pageObjects.OfferPage;
import utils.TestContextSetup;

public class OfferPageStepDefinition {

	public String offerPageProductName;
	TestContextSetup testContextSetup;

	public OfferPageStepDefinition(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
	}

	@Then("^user search for (.+) shortname in offers page to check if product exist with same name$")
	public void user_search_for_shortname_in_offers_page_to_check_if_product_exist_with_same_name(String shortName)
			throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		LandingPage landingPage = testContextSetup.pageObjectManager.getLandingPage();
		landingPage.selectTopDealsPage();
		testContextSetup.genericUtils.switchToChildWindow();
		OfferPage offerPage = testContextSetup.pageObjectManager.getOfferPage();
		offerPage.searchItem(shortName);
		offerPageProductName = offerPage.getProductName();
		Assert.assertEquals(testContextSetup.landingPageProductName, offerPageProductName);

	}

}
