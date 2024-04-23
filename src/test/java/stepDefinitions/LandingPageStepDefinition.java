package stepDefinitions;

import java.io.IOException;
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
import utils.TestContextSetup;

public class LandingPageStepDefinition {

//	public WebDriver driver;
//	public String offerPageProductName;
//	public String landingPageProductName;
	TestContextSetup testContextSetup;
	LandingPage landingPage;

	public LandingPageStepDefinition(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		this.landingPage = testContextSetup.pageObjectManager.getLandingPage();
	}

	@Given("User is on GreenCart Landing Page")
	public void user_is_on_green_cart_landing_page() throws IOException {
//		System.out.println("User is on GreenKart Landing page");
		Assert.assertTrue(landingPage.getTitleLandingPage().contains("GreenKart")); 		
	}

	@When("^user search with SortName called (.+) and extract actual name of product$")
	public void user_search_with_sort_name_called_and_extract_actual_name_of_product(String shortName)
			throws InterruptedException {
		
//		LandingPage landingPage = new LandingPage(testContextSetup.driver);
		landingPage.searchItem(shortName);
//		testContextSetup.testBaseClass.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Thread.sleep(5000);
		testContextSetup.landingPageProductName = landingPage.getProductName().split("-")[0].trim();
		System.out.println(testContextSetup.landingPageProductName + " extracted from Home page");
	}
	@When("Added {string} items of the selected product to cart")
	public void Added_items_product(String quantity) throws InterruptedException {
		
		landingPage.incrementQuantity(Integer.parseInt(quantity));
		testContextSetup.testBaseClass.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		landingPage.addToCart();
		testContextSetup.testBaseClass.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	}
	

}
