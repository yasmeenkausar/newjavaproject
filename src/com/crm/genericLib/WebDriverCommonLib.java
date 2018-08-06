package com.crm.genericLib;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverCommonLib {
	/**
	 * @author Yasmeen
	 */
	public void waitForPageToLoad()
	
	{
		BaseClass.driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
	}

	
	public void waitForEllementPresent(WebElement wb)
	{
		WebDriverWait wait=new WebDriverWait(BaseClass.driver, 20);
		wait.until(ExpectedConditions.visibilityOf(wb));
	}

	/**
	 * 
	 * @param swb
	 * @param value
	 * This selects the value from the drop down based on visibleText
	 */
	public void select(WebElement swb,String value)
	{
		Select sel=new Select(swb);
		sel.selectByVisibleText(value);
	}
	
	/**
	 * 
	 * @param swb
	 * @param index
	 * This selects the value from the drop down based on index
	 */
	public void select(WebElement swb,int index)
	{
		Select sel=new Select(swb);
		sel.selectByIndex(index);
	}
	
	/**
	 * 
	 * @param wb
	 * This method performs mouse over operation
	 */
	public void performMouseOver(WebElement wb)
	
	{
		Actions act=new Actions(BaseClass.driver);
		act.moveToElement(wb).perform();
	}
	}