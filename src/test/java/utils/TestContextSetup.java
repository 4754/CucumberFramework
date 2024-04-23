package utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import pageObjects.PageObjectManager;
import stepDefinitions.Hooks;

public class TestContextSetup {
	

//	public WebDriver driver;
	public String landingPageProductName;
	public PageObjectManager pageObjectManager;
	public TestBaseClass testBaseClass;
	public GenericUtils genericUtils;
	public Hooks hooks;
	
	public TestContextSetup() throws IOException {
		testBaseClass = new TestBaseClass();
		pageObjectManager = new PageObjectManager(testBaseClass.webDriverManager());
		genericUtils = new GenericUtils(testBaseClass.webDriverManager());
	}

}
