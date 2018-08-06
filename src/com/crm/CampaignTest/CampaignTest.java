package com.crm.CampaignTest;

import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.util.Properties;

import com.crm.ObjectRepository.Campaign;
import com.crm.ObjectRepository.Home;
import com.crm.ObjectRepository.createCampaign;
import com.crm.genericLib.BaseClass;
import com.crm.genericLib.GenericLib;
import com.crm.genericLib.WebDriverCommonLib;
import com.relevantcodes.extentreports.ExtentTest;


/***
 * @author Yasmeen
 *
 */

public class CampaignTest extends BaseClass{
//Create Campaign============================================================================
	@Test(groups= {"smokeTest"})
	
	public void createCampTest() throws IOException
	{
		ExtentTest logger=extent.startTest("CampaignTest");
//Get the data from the property file which is implemented in the Generic Lib		
		GenericLib glib=new GenericLib();
		Properties pObj=glib.getPropertiesFileObj("./TestData/createCampMapProduct.properties");
		String campaignName=pObj.getProperty("Campaignname");
		String Productname= pObj.getProperty("Productname");
//===================================================================================================
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		Home hp=PageFactory.initElements(driver, Home.class);
		hp.navigateToCampaignsPage();
		
		Campaign cp=PageFactory.initElements(driver, Campaign.class);
		cp.navigateTocreateCampaignPage();
		
		createCampaign create=PageFactory.initElements(driver, createCampaign.class);
		create.createCampaign(campaignName);
	}
	
//Create campaign map product=============================================================	
@Test
	public void createCampMapProduct() throws IOException
	{
	WebDriverCommonLib wLib=new WebDriverCommonLib();
	wLib.waitForPageToLoad();
		GenericLib glib=new GenericLib();
		Properties pObj=glib.getPropertiesFileObj("./TestData/createCampMapProduct.properties");
		String campaignName=pObj.getProperty("Campaignname");
		
		Home hp=PageFactory.initElements(driver, Home.class);
		hp.navigateToCampaignsPage();
		wLib.waitForPageToLoad();
		
		Campaign cp=PageFactory.initElements(driver, Campaign.class);
		cp.navigateTocreateCampaignPage();
		
		createCampaign create=PageFactory.initElements(driver, createCampaign.class);
		   create.createCampaignMapProduct(campaignName);
	}
// delete a campaign======================================================================
	@Test
	public void deleteCampaign() throws IOException
	{
		GenericLib glib=new GenericLib();
		Properties pObj=glib.getPropertiesFileObj("./TestData/createCampMapProduct.properties");
		String campaignName=pObj.getProperty("Campaignname");
	
		Home hp=PageFactory.initElements(driver, Home.class);
		hp.navigateToCampaignsPage();
		
		Campaign cp=PageFactory.initElements(driver, Campaign.class);
		cp.deleteCampaign();
	}
	}


