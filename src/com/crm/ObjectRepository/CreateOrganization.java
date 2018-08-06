package com.crm.ObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


/**
 * 
 * @author Yasmeen
 *
 */
public class CreateOrganization {
	
	@FindBy(xpath="//td/input[@name='accountname']")
	WebElement orgNameEdt;
	
@FindBy(name="button")
private WebElement saveBtn;

/**
 * 
 * @param orgName
 * this method is used to create org name
 */
public void createOrg(String orgName)
{
	orgNameEdt.sendKeys(orgName);
	saveBtn.click();
}
}
