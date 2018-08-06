package com.crm.ObjectRepository;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.crm.genericLib.BaseClass;


/**
 * 
 * @author Yasmeen
 *
 */

public class Campaign {
	
	@FindBy(xpath="//img[contains(@title,'Create Campaign...')]")
	private WebElement plusSymbol;
	
	@FindBy(xpath="//tr[5]/td[3]/a[text()='Samsung placards']")
	private WebElement campNameLnk;
	
	@FindBy(name="Delete")
	private WebElement deleteBtn;
	
	/**
	 * navigates to create campaign page
	 */
	
	public void navigateTocreateCampaignPage() {
		plusSymbol.click();
	}
	
	/**
	 * This method selects aCampaign from the webTable and deletes it
	 */
	public void deleteCampaign()
	{
		campNameLnk.click();
		deleteBtn.click();
		Alert alt=BaseClass.driver.switchTo().alert();
		alt.accept();
	}

}
