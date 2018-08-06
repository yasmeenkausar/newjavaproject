package com.crm.ObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.crm.genericLib.GenericLib;

/**
 * 
 * @author Yasmeen
 *
 */
public class Quote extends GenericLib{

	@FindBy(xpath="//img[contains(@title,'Create Quote..')]")
	private WebElement  quotePlusBtn;
	
	/**
	 * This method is used to navigate to create quote page
	 */
	public void navigateToquote()
	{
		WaitForElement(quotePlusBtn);
		quotePlusBtn.click();
	}

	
}
