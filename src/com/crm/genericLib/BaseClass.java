package com.crm.genericLib;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.crm.ObjectRepository.Login;
import com.crm.ObjectRepository.Logout;
import com.relevantcodes.extentreports.ExtentReports;


/**
 * 
 * @author Yasmeen
 *
 */
public class BaseClass{
	public static WebDriver driver;
	public ExtentReports extent;
	
	@BeforeSuite
	public void configBs()
	{
		 extent=new ExtentReports("./TestData/abc.html");
		// extent.loadConfig(new File(""));
		
	}
	@BeforeClass(groups= {"smokeTest","regressionTest"})
	
	public void configBC() throws IOException
	{
		GenericLib glib= new GenericLib();
		Properties pObj=glib.getPropertiesFileObj("./TestData/commonData.properties");
		String bName= pObj.getProperty("browser");
		if(bName.equals("firefox")) {
		driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}
		else if (bName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\Downloads\\chromeDriver.exe");
			driver=new ChromeDriver();
		}
		else if (bName.equals("ie"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\Downloads\\IEDriverServer.exe");
			driver=new InternetExplorerDriver();
		}
			
	}
	
	@BeforeMethod
	public void login() throws IOException
	{
		GenericLib glib= new GenericLib();
		Properties pObj=glib.getPropertiesFileObj("./TestData/commonData.properties");
		driver.get(pObj.getProperty("Url"));
		Login lp=PageFactory.initElements(driver, Login.class);
		lp.login(pObj.getProperty("Username"), pObj.getProperty("password"));
		
	}
	
	
	@AfterMethod
	public void logout()
	{
		WebDriverCommonLib wLib=new WebDriverCommonLib();
		wLib.waitForPageToLoad();

		Logout l=PageFactory.initElements(driver,Logout.class);
		l.logout();
		System.out.println("Logout");
		wLib.waitForPageToLoad();
	}
	
	
	@AfterClass(groups= {"smokeTest","regressionTest"})
	public void closeBrowser()
	{
		driver.close();
	}
	@AfterSuite
	public void configAftSuite()
	{
		extent.flush();
	
	}
}