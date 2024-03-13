package com.thinktimetechno.projects.website.fredperry.pages;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.thinktimetechno.driver.DriverManager;
import com.thinktimetechno.keywords.WebUI;

public class CheckoutPage {

    
//    String storeName = "Fred Perry Camden, London";

 private By collectFromStore=By.xpath("//input[@id='place-order-collect_from_store']");
 private By Firstname=By.name("firstname");
 private By Lastname=By.name("lastname");		 
 private By mail=By.name("email");
 private By phoneno=By.name("telephone");
 private By choseStore=By.xpath("//button[contains(@data-bind,'StoreSubmit')]");
 private By StoreTitle=By.xpath("//div[@class='store-overview']//h4[@class='store-title']");
 private By selectthisStore=By.xpath("//div[@class='store-overview']//h4[@class='store-title']/parent::div/div[@class='shop-bottom']");

 private By postcode=By.id("postcodeForStore");
// private By nextcontinue=By.cssSelector("button[class*='continue']");
 private By nextcontinue=By.xpath("(//button[@type='submit'])[6]");
                        
// private By nextcon= By.xpath("//button[@class='button action continue primary']");
                               //div/button[contains(@class,'continue')]
// private By nextcon= By.xpath("//button[contains(.,'Next')]");
// private By nextcon= By.xpath("//button[@data-role='opc-continue']");
// private By nextcon= By.className("continue");

// private By nextcon= By.linkText("Next");
 public void selectCollectfromstore() throws InterruptedException {
	 Thread.sleep(5000);
	 WebUI.clickElement(collectFromStore);
 }
 public void getpersonaldetails(String first,String last,String Email,String number) {
	 WebUI.getWebElement(Firstname).sendKeys(first);
	 WebUI.getWebElement(Lastname).sendKeys(last);
	 WebUI.getWebElement(mail).sendKeys(Email);
	 WebUI.getWebElement(phoneno).sendKeys(number);
	 
 }
 public void selectchosestore() throws InterruptedException {
	 WebUI.clickElement(choseStore); 
	 Thread.sleep(4000);
	 WebUI.getWebElement(postcode).sendKeys("TN49LN");
	 
	 
 }
 public void selectSpecifiedStore(String storeName ) throws InterruptedException {
	 Thread.sleep(5000);
	  List<WebElement> parentElement = WebUI.getWebElements(StoreTitle);
	   

	   for(int i=0;i<parentElement.size();i++) {
	  
	  if(parentElement.get(i).getText().contains(storeName)) {
		   WebElement selectstore=WebUI.getWebElements(selectthisStore).get(i);
//		   System.out.println(selectstore.getText());
		   selectstore.click();
		break;
	  } 
 }	 
}
 public void continuenext() throws InterruptedException {
	 Thread.sleep(3000);
//	 verifyElementClickable
	 
	
	 DriverManager.getDriver().navigate().refresh();
	 Thread.sleep(5000);
	 WebUI.clickElementWithJs(nextcontinue);
//	 WebElement next=WebUI.getWebElement(nextcontinue);
//	 ((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].scrollIntoView(true);", next);
//	 next.sendKeys(Keys.ENTER);
//	 next.sendKeys(Keys.RETURN);
//	 for(int i=0;i<10;i++) {
//		 if (next.isEnabled() && next.isDisplayed()) {
//	 if(!WebUI.getCurrentUrl().equalsIgnoreCase( "https://www.fredperry.com/checkout#payment")) {
//		 next.click();
//	 }
//	 }
//	 }
//	 
//	 Actions a=new Actions(DriverManager.getDriver());
//	 a.moveToElement(next).click().build().perform();
//	 if (next.isEnabled() && next.isDisplayed()) {
//		  WebUI.clickElementWithJs(nextcontinue);
//		}
//	 else {
//		 System.out.println("Element is not clickable");
//	 }
//	 
//	 System.out.println(next.getText());
//	 ( WebUI.getJsExecutor()).executeScript("arguments[0].scrollIntoView(true);", next);
//	 WebUI.verifyElementClickable(nextcon);
//	 for(int i=0;i<10;i++) {
//	 WebUI.clickElement(nextcon);
	 

	 Thread.sleep(5000);
//	 Assert.assertEquals(WebUI.getCurrentUrl(), "[https://www-stagem3.fredperry.com/checkout#payment]");
	
	 

 }
}