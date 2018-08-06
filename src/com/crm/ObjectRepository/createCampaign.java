package com.crm.ObjectRepository;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.crm.genericLib.BaseClass;

public class createCampaign {
	
	@FindBy(name="campaignname")
	private WebElement campNameEdt;
	
	@FindBy(xpath="//tr[5]/td[4]/img")
	private WebElement prdPlusSymb;
	
	@FindBy(name="button")
	private WebElement SaveBtn;
	
	@FindBy(name="Delete")
	private WebElement deleteBtn;

	
	@FindBy(id="1")
	private WebElement mapproduct;
	/**
	 * 
	 * @param campaignName
	 * This method creates a campaign 
	 */
	public void createCampaign(String campaignName)
	{
		campNameEdt.sendKeys(campaignName);
		SaveBtn.click();
	}
	/**
	 * 
	 * @param campaignName
	 * This method creates a campaign with product
	 */
	public void createCampaignMapProduct(String campaignName)
	{
		campNameEdt.sendKeys(campaignName);
		prdPlusSymb.click();
		Set<String> set=BaseClass.driver.getWindowHandles();
		Iterator<String> itr=set.iterator();
		String parentId=itr.next();
		String childId=itr.next();
		
		BaseClass.driver.switchTo().window(childId);
		mapproduct.click();
		BaseClass.driver.switchTo().window(parentId);
		SaveBtn.click();
		
	}


}
