package com.crm.ObjectRepository;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.crm.genericLib.BaseClass;

public class CreateSO {
	
	@FindBy(name="subject")
	private WebElement soname;
	
	@FindBy(xpath="//tr[9]/td[4]/img")
	private WebElement orgPlusSymb;
	
	@FindBy (id="2")
	private WebElement selectOrg;
	
	@FindBy(name="bill_street")
	private WebElement billingEdit;
	
	@FindBy(name="ship_street")
	private WebElement shippingEdit;
	
	@FindBy(id="searchIcon1")
	private WebElement prodimg;
	
	@FindBy(id="popup_product_49")
	private WebElement slectprod;
	
	@FindBy(name="button")
	private WebElement saveBtn;
	
	@FindBy(id="qty1")
	private WebElement qtyEdit;
	
	@FindBy(id="listPrice1")
	private WebElement listPriceEdit;
	
	
	/**
	 * 
	 * @param name
	 * @param bill
	 * @param Ship
	 * @param qty
	 * @param listPrice
	 * This method is used to create a sales order with all the mandatory fields
	 */
	public void createSalesOrder(String name,String bill,String Ship,String qty, String listPrice)
	{
		soname.sendKeys(name);
		orgPlusSymb.click();
		Set <String> str12=BaseClass.driver.getWindowHandles();
		Iterator<String> itr13=str12.iterator();
		String par1Id=itr13.next();
		String cl1Id=itr13.next();
		BaseClass.driver.switchTo().window(cl1Id);
		selectOrg.click();
		Alert alt= BaseClass.driver.switchTo().alert();
		alt.dismiss();
		BaseClass.driver.switchTo().window(par1Id);
		
		billingEdit.sendKeys(bill);
		shippingEdit.sendKeys(Ship);
		
		prodimg.click();
		Set <String> str3=BaseClass.driver.getWindowHandles();
		Iterator<String> itr4=str3.iterator();
		String prId=itr4.next();
		String cId=itr4.next();
		BaseClass.driver.switchTo().window(cId);
		
		slectprod.click();
		BaseClass.driver.switchTo().window(prId);
		qtyEdit.sendKeys(qty);
		listPriceEdit.sendKeys(listPrice);
		saveBtn.click();
	}
}
