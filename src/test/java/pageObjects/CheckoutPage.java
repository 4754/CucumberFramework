package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
	
	public WebDriver driver;
	
	public CheckoutPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

//	Locators
	By cartBag = By.cssSelector("[alt='Cart']");
	By checkOutButton = By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]");
	By promoButton = By.cssSelector(".promoBtn");
	By placeOrderButton = By.xpath("//button[contains(text(),'Place Order')]");
	
	public void checkOutItems() {
		driver.findElement(cartBag).click();
		driver.findElement(checkOutButton).click();
	}
	
	public boolean verifyPromoButton() {
		return driver.findElement(promoButton).isDisplayed();
	}
	
	public boolean verifyPlaceOrderButton() {
		return driver.findElement(placeOrderButton).isDisplayed();
	}
	

}
