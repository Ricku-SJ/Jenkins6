package fgaerw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class wwqrqw {
	
	WebDriver driver;
	
	
	@Test
	public void create() throws InterruptedException
	{
		Reporter.log("Create",true);
	}
	@Parameters({"browser"})
	@BeforeClass
	public void open(String browser)
	{
		if(browser.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browser.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if(browser.equals("ie"))
		{
			WebDriverManager.iedriver().setup();
			driver=new  InternetExplorerDriver();
		}
	}
	@Parameters({"url"})
		@BeforeMethod
		public void login(String url) throws InterruptedException
		{
		driver.get(url);
		Thread.sleep(5000);
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.name("pwd")).sendKeys("manager");
		driver.findElement(By.xpath("//div[text()='Login ']")).click();
		}
		@AfterMethod
		public void logout() throws InterruptedException
		{
		Reporter.log("Logout",true);
		Thread.sleep(6000);
		driver.findElement(By.id("logoutLink")).click();
		}
		@AfterClass
		public void close()
		{
		driver.close();
		Reporter.log("Close Browser",true);
	}
}
