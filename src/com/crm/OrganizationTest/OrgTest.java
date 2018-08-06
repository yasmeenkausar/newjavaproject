package com.crm.OrganizationTest;

import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.ObjectRepository.CreateOrganization;
import com.crm.ObjectRepository.Home;
import com.crm.ObjectRepository.Organization;
import com.crm.genericLib.BaseClass;
import com.crm.genericLib.GenericLib;
import com.crm.genericLib.WebDriverCommonLib;

/**
 * 
 * @author Yasmeen
 *
 */
@Listeners(com.crm.genericLib.SampleListener.class)
public class OrgTest extends BaseClass{
	
	Random randomNum=new Random();

	WebDriverCommonLib wLib=new WebDriverCommonLib();
	@Test
	// TODO Auto-generated method stub
	public void createOrgTest() throws IOException
	{
		GenericLib gLib=new GenericLib();
Properties pObj=gLib.getPropertiesFileObj("./TestData/CreateOrg.properties");
String organization=pObj.getProperty("Organization");
int rString=randomNum.nextInt(100);
String orgName=(organization+rString);
		
		Home hp=PageFactory.initElements(driver, Home.class);
		hp.navigateToOrganizationsPage();
		wLib.waitForPageToLoad();
		
		
		Organization org=PageFactory.initElements(driver,Organization.class );
		org.navigateToOrgPage();
		wLib.waitForPageToLoad();
		CreateOrganization create=PageFactory.initElements(driver,CreateOrganization.class );
		create.createOrg(orgName);
	}
	//=====================================================================================================
	@Test
	public void editOrg() throws IOException {
		
		GenericLib gLib=new GenericLib();
		Properties pObj=gLib.getPropertiesFileObj("./TestData/CreateOrg.properties");
		String organization=pObj.getProperty("Organization");
		int rString=randomNum.nextInt(100);
		String orgName=(organization+rString);
		Home hp=PageFactory.initElements(driver, Home.class);
		hp.navigateToOrganizationsPage();
		wLib.waitForPageToLoad();
		Organization org=PageFactory.initElements(driver,Organization.class );
	}
	//==========================================================================================
	@Test
	public void deleteOrg() throws IOException {
		
		GenericLib gLib=new GenericLib();
		Properties pObj=gLib.getPropertiesFileObj("./TestData/CreateOrg.properties");
		String organization=pObj.getProperty("Organization");
		int rString=randomNum.nextInt(100);
		String orgName=(organization+rString);
		Home hp=PageFactory.initElements(driver, Home.class);
		hp.navigateToOrganizationsPage();
		
		Organization org=PageFactory.initElements(driver,Organization.class );
		org.deleteOrg();
	}
		/*driver.findElement(By.linkText("Organizations")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//img[contains(@title,'Create Organization.')]")).click();
		driver.findElement(By.xpath("//td/input[@name='accountname']")).sendKeys(orgName);
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElement(By.name("button")).click();
				
				driver.findElement(By.name("Delete")).click();
				
				
				Alert alt=driver.switchTo().alert();
				String actual=alt.getText();
				String expected="Deleting this account will remove its related Opportunities & Quotes. Are you sure you want to delete this account?";
				System.out.println(actual);
				Assert.assertEquals(actual, expected);
				
				alt.accept();
	}*/
	//====================================================================================================
}