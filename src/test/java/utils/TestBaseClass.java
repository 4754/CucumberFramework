package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBaseClass {

	public WebDriver driver;

	public WebDriver webDriverManager() throws IOException  {
		
		File configFile = new File(System.getProperty("user.dir")+"\\src\\test\\resource\\global.properties");
		FileInputStream stream = new FileInputStream(configFile);
		Properties prop = new Properties();
		prop.load(stream);
		
		String url = prop.getProperty("QAUrl");
		String browser_prop = prop.getProperty("browser");
		String browser_maven = System.getProperty("browser");
		String browser = browser_maven != null ? browser_maven : browser_prop;
		
		
		if(driver == null) {

			if(browser.equalsIgnoreCase("chrome")) {
				System.out.println("In chrome section");
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir")+"\\src\\test\\resource\\chromedriver.exe");
				driver = new ChromeDriver();
			} else if(browser.equalsIgnoreCase("firefox")) {
				System.out.println("____________Firefox___________");
				System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\src\\test\\resource\\geckodriver.exe");
				driver = new FirefoxDriver();
			}
			
			
			driver.manage().window().maximize();
			driver.get(url);
		}
		return driver;
	}

}
