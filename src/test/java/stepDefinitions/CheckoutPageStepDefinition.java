package stepDefinitions;

import java.time.Duration;

import org.testng.Assert;

import io.cucumber.java.en.Then;
import pageObjects.CheckoutPage;
import utils.TestContextSetup;

public class CheckoutPageStepDefinition {
	
	public TestContextSetup testContextSetup;
	public CheckoutPage checkoutPage;
	
	public CheckoutPageStepDefinition(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		checkoutPage = testContextSetup.pageObjectManager.getCheckoutPage();
	}
	
	@Then("verify user has ability to enter promo code and place order")
	public void verify_user_has_ability_to_enter_promo_code_and_place_order() throws InterruptedException {
		testContextSetup.testBaseClass.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		Assert.assertTrue(checkoutPage.verifyPromoButton());
		Assert.assertTrue(checkoutPage.verifyPlaceOrderButton());
	}
	
	@Then("^User proceeds to Checkout and validate the (.+) items in checkout page$")
	public void User_proceeds_to_Checkout_Method(String Name) throws InterruptedException {
		testContextSetup.testBaseClass.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		checkoutPage.checkOutItems();
//		 Assertion
	}

}
