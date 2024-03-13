package com.thinktimetechno.projects.website.fredperry.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.thinktimetechno.driver.DriverManager;
import com.thinktimetechno.keywords.WebUI;

public class PaymentPage {

	private By cashondelivery = By.id("checkmo");

	private By Firstname = By.xpath("//div[@name='billingAddresscheckmo.firstname']");
	private By Lastname = By.xpath("//div[@name='billingAddresscheckmo.lastname']");
	private By address = By.xpath("//div[@name='billingAddresscheckmo.street.0']");
	private By phoneno = By.xpath("//div[@name='billingAddresscheckmo.telephone']");
	private By city = By.xpath("//div[@name='billingAddresscheckmo.city']");
	private By postcode = By.xpath("//div[@name='billingAddresscheckmo.postcode']");
	private By updating=By.xpath("(//button[contains(@class,'action-update')])[1]");
	private By check1=By.xpath("(//input[@type='checkbox'])[2]");
	private By check2=By.xpath("(//input[@type='checkbox'])[3]");
	private By placeorder=By.xpath("(//button[contains(@class,checkout)])[17]");
	private By titlecheck=By.xpath("//h1[@class='page-title']");
	

	public void clickcashonDel() throws InterruptedException {
		WebUI.clickElement(cashondelivery);
		
	}

	public void provideAddress(String Fname, String LNmae, String Address1, String Cities, String Pcode,
			String Tellno) throws InterruptedException {
		Actions a=new Actions(DriverManager.getDriver());
		 a.moveToElement(WebUI.getWebElement(Firstname)).click().sendKeys(Fname).build().perform();
		 a.moveToElement(WebUI.getWebElement(Lastname)).click().sendKeys(LNmae).build().perform();
		 a.moveToElement(WebUI.getWebElement(address)).click().sendKeys(Address1).build().perform();
		 a.moveToElement(WebUI.getWebElement(city)).click().sendKeys(Cities).build().perform();
		 a.moveToElement(WebUI.getWebElement(postcode)).click().sendKeys(Pcode).build().perform();
		 a.moveToElement(WebUI.getWebElement(phoneno)).click().sendKeys(Tellno).build().perform();
		 WebUI.clickElementWithJs(updating);
		 Thread.sleep(4000);
//		WebUI.getWebElement(address).sendKeys(Address1);
//		WebUI.getWebElement(city).sendKeys(Cities);
//		WebUI.getWebElement(postcode).sendKeys(Pcode);
//		WebUI.getWebElement(phoneno).sendKeys(Tellno);
	}

	public void placeorder() throws InterruptedException {
		DriverManager.getDriver().navigate().refresh();
		 WebUI.clickElementWithJs(updating);
		 Thread.sleep(4000);
		WebUI.clickElement(check1);
		WebUI.clickElement(check2);
		WebUI.clickElement(placeorder);
		Thread.sleep(4000);
		Assert.assertEquals(WebUI.getWebElement(titlecheck).getText(), "THANK YOU FOR YOUR PURCHASE!");
		
	}
	
}