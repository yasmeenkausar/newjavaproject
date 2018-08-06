package com.crm.EndtoEnd;

import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.ObjectRepository.CreateOrganization;
import com.crm.ObjectRepository.CreateProduct;
import com.crm.ObjectRepository.CreateQuote;
import com.crm.ObjectRepository.Home;
import com.crm.ObjectRepository.Organization;
import com.crm.ObjectRepository.Product;
import com.crm.ObjectRepository.Quote;
import com.crm.genericLib.BaseClass;
import com.crm.genericLib.GenericLib;
import com.crm.genericLib.WebDriverCommonLib;


/**
 * 
 * @author Yasmeen
 * 
 * 
 */
@Listeners(com.crm.genericLib.SampleListener.class)
public class CreateAcceptedQuoteTest extends BaseClass{
	WebDriverCommonLib wLib=new WebDriverCommonLib();
	@Test
	public void createAcceptedQuote() throws InterruptedException, IOException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		GenericLib gLib=new GenericLib();
		
		
		Properties pObj1=gLib.getPropertiesFileObj("./TestData/createQuote.properties");
		String productN=pObj1.getProperty("Productname");
		
		String orgN=pObj1.getProperty("Organization");
		String quoteS=pObj1.getProperty("QuoteSubject");
		String billing=pObj1.getProperty("Billing");
		String shipping=pObj1.getProperty("Shipping");
		String visibleText=pObj1.getProperty("quoteStage1");
		String qty=pObj1.getProperty("qty");
		String listPrice=pObj1.getProperty("Listprice");
	// Create a product	------------------------------------------------------------------------------------------
		Thread.sleep(6000);
		Home hp=PageFactory.initElements(driver, Home.class);	
		hp.navigateToProductsPage();
		
		Product prod=PageFactory.initElements(driver, Product.class);
				prod.navigateTocreateProdPage();
		
		CreateProduct cp=PageFactory.initElements(driver, CreateProduct.class);
		cp.createNewProduct(productN);
		
		// create an organisation.
		Random randomnum=new Random();
		int rnum=randomnum.nextInt();
		String orgName=orgN+rnum;

		hp.navigateToOrganizationsPage();
		
		Organization org=PageFactory.initElements(driver, Organization.class);
		
		org.navigateToOrgPage();
		wLib.waitForPageToLoad();
		
		CreateOrganization create=PageFactory.initElements(driver, CreateOrganization.class);
		create.createOrg(orgName);
		
		
				
		
		wLib.waitForPageToLoad();
				
				hp.navigateToQuotesPage();
				Quote q=PageFactory.initElements(driver, Quote.class);
				wLib.waitForPageToLoad();
				q.navigateToquote();
				
				CreateQuote quote=PageFactory.initElements(driver, CreateQuote.class);
				
				quote.createQuote(quoteS,visibleText, billing, shipping, qty,listPrice );
			
	}

}
