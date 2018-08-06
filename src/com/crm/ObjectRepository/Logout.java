package com.crm.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.crm.genericLib.BaseClass;
import com.crm.genericLib.GenericLib;
import com.crm.genericLib.WebDriverCommonLib;
/**
 * 
 * @author Yasmeen
 *
 */
public class Logout extends GenericLib{
@FindBy(xpath="//tr[1]/td[2][@class='small']/img")
private WebElement element;

@FindBy(linkText="Sign Out")
private WebElement signOutBtn;

/**
 * This method is ised to logout from the app
 */
public void logout()
{
	WaitForElement(element);
	WebDriverCommonLib wLib=new WebDriverCommonLib();
	wLib.performMouseOver(element);
	
	signOutBtn.click();
}

}
