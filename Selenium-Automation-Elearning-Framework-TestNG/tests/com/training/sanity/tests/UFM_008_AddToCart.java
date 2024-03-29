package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.AddToCart_POM;
import com.training.pom.LoginForUser_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;


//Test to see that a user can add item to the cart
public class UFM_008_AddToCart {

	//variables
	private WebDriver driver;
	private String baseUrl;
	private AddToCart_POM AUT_addToCart;
	private static Properties properties;
	
	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		AUT_addToCart = new AddToCart_POM(driver);
		baseUrl = properties.getProperty("baseURL");
		new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test
	public void addToCart() {
		
		//calling method from AddToCart_POM to add an item to cart
		AUT_addToCart.addedToCart();
		
	}
}

