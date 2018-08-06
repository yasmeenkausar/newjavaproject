package com.crm.ObjectRepository;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.crm.genericLib.BaseClass;
import com.crm.genericLib.GenericLib;
import com.crm.genericLib.WebDriverCommonLib;


/**
 * 
 * @author Yasmeen
 *
 */
public class CreateQuote extends GenericLib{
	
	@FindBy(name="subject")
	private WebElement quoteNameEdt;
	
	@FindBy(name="button")
	private WebElement saveBtn;
	
	@FindBy(name="quotestage")
	private WebElement quoteselect;
	
	@FindBy(xpath="//tr[7]/td[4]/img")
	private WebElement orgNameimg;
	
	@FindBy(id="2")
	private WebElement orgNamelnk;
	
	@FindBy(name="bill_street")
	private WebElement billEdt;
	
	@FindBy(name="ship_street")
    private	WebElement shipEdt;
	
	@FindBy(id="searchIcon1")
	private WebElement productSymb;
	
	@FindBy(id="popup_product_49")
    private	WebElement prodlnk;
	
	@FindBy(id="qty1")
	private WebElement qtyEdit;
	
	@FindBy(id="listPrice1")
	private WebElement listPriceEdit;
	

	/**
	 * 
	 * @param qName
	 * @param visibleText
	 * @param bill
	 * @param Ship
	 * @param qty
	 * @param listPrice
	 * Create a quote with all the mandatory fields
	 */
	public void createQuote(String qName,String visibleText,String bill,String Ship,String qty, String listPrice)
{
	quoteNameEdt.sendKeys(qName);
	WebDriverCommonLib lib=new WebDriverCommonLib();
	lib.select(quoteselect, visibleText);
	orgNameimg.click();
	Set <String> str12=BaseClass.driver.getWindowHandles();
	Iterator<String> itr13=str12.iterator();
	String par1Id=itr13.next();
	String cl1Id=itr13.next();
	BaseClass.driver.switchTo().window(cl1Id);
	
	orgNamelnk.click();
	Alert alt= BaseClass.driver.switchTo().alert();
	alt.dismiss();
	BaseClass.driver.switchTo().window(par1Id);
	
	billEdt.sendKeys(bill);
	shipEdt.sendKeys(Ship);
	
	productSymb.click();
	Set <String> str3=BaseClass.driver.getWindowHandles();
	Iterator<String> itr4=str3.iterator();
	String prId=itr4.next();
	String cId=itr4.next();
	BaseClass.driver.switchTo().window(cId);
	prodlnk.click();
	BaseClass.driver.switchTo().window(prId);
	qtyEdit.sendKeys(qty);
	listPriceEdit.sendKeys(listPrice);
	saveBtn.click();
	
	
}
	

}
