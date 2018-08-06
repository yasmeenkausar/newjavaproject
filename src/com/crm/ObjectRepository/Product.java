package com.crm.ObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.crm.genericLib.GenericLib;

/**
 * 
 * @author Yasmeen
 *
 */
public class Product extends GenericLib{
	@FindBy(xpath="//img[contains(@title,'Create Product..')]")
	private WebElement prodPlusSymb;
	
/**
 * This method is used to navigate to create Product page
 */
	public void navigateTocreateProdPage()
	{
		WaitForElement(prodPlusSymb);
		prodPlusSymb.click();
	}

}
