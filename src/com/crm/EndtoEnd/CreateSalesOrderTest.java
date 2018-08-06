package com.crm.EndtoEnd;

import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.ObjectRepository.CreateOrganization;
import com.crm.ObjectRepository.CreateProduct;
import com.crm.ObjectRepository.CreateSO;
import com.crm.ObjectRepository.Home;
import com.crm.ObjectRepository.Organization;
import com.crm.ObjectRepository.Product;
import com.crm.ObjectRepository.SalesOrder;
import com.crm.genericLib.BaseClass;
import com.crm.genericLib.GenericLib;
import com.crm.genericLib.WebDriverCommonLib;

/**
 * 
 * @author Yasmeen
 *
 */
@Listeners(com.crm.genericLib.SampleListener.class)
public class CreateSalesOrderTest extends BaseClass{
	@Test
	public void createSalesOrder() throws IOException, InterruptedException
	{
		System.out.println("**********");
		GenericLib gLib=new GenericLib();
		Properties pObj1=gLib.getPropertiesFileObj("./TestData/SalesOrder.properties");
		String productN=pObj1.getProperty("Productname");
		String orgN=pObj1.getProperty("Organization");
		String salesS=pObj1.getProperty("SalesSubject");
		String billing=pObj1.getProperty("Billing");
		String shipping=pObj1.getProperty("Shipping");
		String qty=pObj1.getProperty("qty");
		String listPrice=pObj1.getProperty("Listprice");
	
		Random randomNum=new Random();
		int rNum=randomNum.nextInt(100);
		String orgName=orgN+rNum;
		//======================================================================================
		
		Home hp=PageFactory.initElements(driver, Home.class);
hp.navigateToProductsPage();
WebDriverCommonLib wLib=new WebDriverCommonLib();
wLib.waitForPageToLoad();
		
		Product p=PageFactory.initElements(driver, Product.class);
		p.navigateTocreateProdPage();
		
		CreateProduct create=PageFactory.initElements(driver, CreateProduct.class);
		create.createNewProduct(productN);
		wLib.waitForPageToLoad();		
		
		hp.navigateToOrganizationsPage();
		
		Organization org=PageFactory.initElements(driver, Organization.class);
		org.navigateToOrgPage();
		wLib.waitForPageToLoad();
		CreateOrganization createorg=PageFactory.initElements(driver, CreateOrganization.class);
		
		createorg.createOrg(orgName);
		
		hp.navigateToSalesOrderPage();
		wLib.waitForPageToLoad();
		
		SalesOrder so=PageFactory.initElements(driver, SalesOrder.class);
		so.navigateToCreateOrderPage();
		wLib.waitForPageToLoad();
		CreateSO createorder=PageFactory.initElements(driver, CreateSO.class);
		createorder.createSalesOrder(salesS, billing, shipping, qty, listPrice);
	}

}
