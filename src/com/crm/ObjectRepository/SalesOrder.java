package com.crm.ObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.crm.genericLib.GenericLib;

/**
 * 
 * @author Yasmeen
 *
 */
public class SalesOrder extends GenericLib {
	@FindBy(xpath="//img[contains(@title,'Create Sales Order..')]")
	private WebElement sordrplusimg;
	
/**
 * this method is used to navigate to create order page
 */
	public void navigateToCreateOrderPage()
	{
		WaitForElement(sordrplusimg);
		sordrplusimg.click();
	}
	

}
