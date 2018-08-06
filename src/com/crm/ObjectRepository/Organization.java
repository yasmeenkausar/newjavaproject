package com.crm.ObjectRepository;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.crm.genericLib.BaseClass;
import com.crm.genericLib.GenericLib;

/**
 * 
 * @author Yasmeen
 *
 */
public class Organization extends GenericLib {
	
	@FindBy(xpath="//img[contains(@title,'Create Organization.')]")
private WebElement orgPlusSymb;
	
	@FindBy(xpath="//tr[5]/td[3]/a[text()='qjsp843']")
	private WebElement eleLnk;
	
	@FindBy(name="Delete")
	private WebElement deleteBtn;
	
	@FindBy(name="Edit")
	private WebElement EditBtn;
	@FindBy(name="button")
	private WebElement saveBtn;
	
	@FindBy(xpath="//td/input[@name='accountname']")
	private WebElement orgNameEdt;
	
	/**
	 * This method is used to navigate to create org page
	 */
	public void navigateToOrgPage()
	{
		orgPlusSymb.click();
		WaitForElement(orgPlusSymb);
	}
	
	/**
	 * This method is used to select an org from the table and delete it
	 */
	
	public void deleteOrg()
	{
		eleLnk.click();
		BaseClass.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		deleteBtn.click();
		Alert alt=BaseClass.driver.switchTo().alert();
		alt.accept();
		
	}
	
	/**
	 * This method is used to select an org from the table and edit it
	 */
	public void editOrg(String orgName)
	{
		eleLnk.click();
		EditBtn.click();
		orgNameEdt.sendKeys(orgName);
		saveBtn.click();
		
	}
}
