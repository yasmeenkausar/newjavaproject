package com.crm.ObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.crm.genericLib.BaseClass;
import com.crm.genericLib.GenericLib;
import com.crm.genericLib.WebDriverCommonLib;

public class Home extends GenericLib{
		
	@FindBy(linkText="Calendar")
	private WebElement calenderlnk;
	
	@FindBy(linkText="Leads")
	private WebElement leadsLnk;
	
	@FindBy(linkText="Organizations")
	private WebElement organizationsLnk;

	@FindBy(linkText="Contacts")
	private WebElement contactsLnk;

	@FindBy(linkText="Opportunities")
	private WebElement opportunitiesLnk;

	@FindBy(linkText="Products")
	private WebElement ProductsLnk;
	
	@FindBy(xpath="//tr/td/a[contains(text(),'More')]")
	private WebElement More;


	@FindBy(linkText="Invoice")
	private WebElement invoiceLnk;
	
	@FindBy(linkText="Campaigns")
	private WebElement Campaignslnk;

	@FindBy(linkText="Quotes")
	private WebElement quoteslnk;
	
	@FindBy(linkText="Sales Order")
	private WebElement SalesOrderlnk;

	/**
	 * This method is used to navigate to organization page
	 */
	
	public void navigateToOrganizationsPage()
	{
		organizationsLnk.click();
		WaitForElement(organizationsLnk);
	}

	/**
	 * This method is used to navigate to products page
	 */
	public void navigateToProductsPage()
	{
		ProductsLnk.click();
		WaitForElement(ProductsLnk);
	}
	
	/**
	 * This method is used to navigate to invoice page
	 */
	public void navigateToInvoicePage()
	{
		invoiceLnk.click();
	}
	
	WebDriverCommonLib wLib=new WebDriverCommonLib();
	
	/**
	 * This method is used to navigate to campaigns page
	 */
	public void navigateToCampaignsPage()
	{
		wLib.performMouseOver(More);
		Campaignslnk.click();
		WaitForElement(Campaignslnk);
	}
	
	/**
	 * This method is used to navigate to Quotes page
	 */	
	public void navigateToQuotesPage()
	{
		wLib.performMouseOver(More);
		quoteslnk.click();
		WaitForElement(quoteslnk);
	}
	/**
	 * This method is used to navigate to SalesOrder page
	 */
	public void navigateToSalesOrderPage()
	{
		wLib.performMouseOver(More);
		SalesOrderlnk.click();
		WaitForElement(SalesOrderlnk);
		
	}
	
}
