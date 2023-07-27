package mytest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Program1 {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setup()
	{
		//code for opening Chrome browser.
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\shant\\eclipse-workspace\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		
		//code for open URL & Maximizing browser.
		driver.get("https://www.amazon.in");
		driver.manage().window().maximize();
		
		//Applying implicit wait in webDriver.
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	
	@Test
	//Verify the Amazon web title
	public void verifyTitle()
	{
	String actualTitle = driver.getTitle();
	String expectedTitle ="Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
	
	//Validate the test condition is passed or fail.
	Assert.assertEquals(actualTitle, expectedTitle);
	
	}
	
	@Test
	//Verify the Amazon web logo
	public void verifyLogo()
	{
	boolean flag = driver.findElement(By.xpath("//a[@id='nav-logo-sprites']")).isDisplayed();
	Assert.assertTrue(flag);
	}
	
	@AfterMethod
	
	//Code for Driver close
	public void tearDown()
	
	{
		driver.quit();
	}
	
	

}
