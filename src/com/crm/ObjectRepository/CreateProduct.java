package com.crm.ObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateProduct {
	
	@FindBy(name="productname")
	WebElement prdNameEdt;
	
	@FindBy(name="button")
	WebElement saveBtn;
	
	/**
	 * 
	 * @param productname
	 * This method is used to create new product
	 */
	public void createNewProduct(String productname)
	{
		prdNameEdt.sendKeys(productname);
		saveBtn.click();
	}

}
