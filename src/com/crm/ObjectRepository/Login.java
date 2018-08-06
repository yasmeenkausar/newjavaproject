package com.crm.ObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
/**
 * 
 * @author Yasmeen
 *
 */
public class Login {
	
	@FindBy(xpath="//div/input[@name='user_name']")
	private WebElement usernameEdt;
	
	@FindBy(xpath="//div/input[@type='password']")
	private WebElement passwordEdit;
	
	@FindBy(id="submitButton")
	private WebElement loginBtn;
	
	public WebElement getUsernameEdt() {
		return usernameEdt;
	}

	public WebElement getPasswordEdit() {
		return passwordEdit;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}

	/**
	 * 
	 * @param username
	 * @param password
	 * This method is used to login to app using the credentials
	 */
	public void login(String username,String password)
	{
		usernameEdt.sendKeys(username);
		passwordEdit.sendKeys(password);
		loginBtn.click();
		
	}

}
