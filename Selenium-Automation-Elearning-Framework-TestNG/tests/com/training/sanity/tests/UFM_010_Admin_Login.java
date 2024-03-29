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
import com.training.pom.LoginForAdmin_POM;
import com.training.pom.LoginForUser_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

//Test to verify that admin can log in using the correct credentials
public class UFM_010_Admin_Login {

	//variables
	private WebDriver driver;
	private String adminURL;
	private LoginForAdmin_POM AUT_loginAdmin;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		AUT_loginAdmin = new LoginForAdmin_POM(driver); 
		adminURL = properties.getProperty("adminURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(adminURL);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	
	@Test
	public void validLoginTest() {
		
		//calling method from AdminLogin_POM to login
		AUT_loginAdmin.loginForAdminMethod("admin","admin@123");
		
		//asserting the page title after log in
		AUT_loginAdmin.assertPageTitle();
		
		//printing the page title after login
		AUT_loginAdmin.printPageTitle();
	}
}

