package com.thinktimetechno.projects.website.fredperry.pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.thinktimetechno.driver.DriverManager;
import com.thinktimetechno.helpers.ExcelHelpers;
import com.thinktimetechno.keywords.WebUI;
import com.thinktimetechno.utils.LogUtils;

public class FrontPage {

	ExcelHelpers excel = new ExcelHelpers();
	private boolean productFound;
	List<String> product = new ArrayList<>();
	private By uk = By.id("shop-now-popup");
	private By women = By.xpath("(//a[text()='Women'])[2]");

	private By women_polo_shirt = By.linkText("Polo Shirts");
	private By Shirt_name = By
			.xpath("//div[contains(@class,'product-item-details')]//div[@class='product-info-container']//a");
//   private By Shirt_name=By.xpath("//div[@class='product-info-container']//a");
	private By add = By
			.xpath("//div[contains(@class,'product-item-details')]//div[@class='product-item-inner']//div//form");
	private By size6 = By.xpath("//li[contains(@class,'product-item')]//div//div//div//div//div//div[@aria-label='6']");
	private By Size;
	private By checkout = By.xpath("//a[@id='top-cart-btn-checkout']");

	public void selectuk() {
		WebUI.clickElement(uk);
	}

	public void movetowomen() {
		WebUI.hoverOnElement(women);
	}

	public void selectWomenPoloShirt() {
		WebUI.clickElement(women_polo_shirt);
	}

	public void fetchdress() {
		Object[][] data = excel.getExcelData(System.getProperty("user.dir") +"\\src\\test\\resources\\Book1.xlsx", "sample");
		
		for (Object[] row : data) {
			for (Object cell : row) {

				System.out.print(cell + "\t");
				product.add(cell.toString());

			}

		}

	}

	public void selectMuitipledress() throws InterruptedException {

		for (String p : product) {
			List<WebElement> productname = WebUI.getWebElements(Shirt_name);
			for (int i = 0; i < productname.size(); i++) {

				if (productname.get(i).getAttribute("title").contains(p)) {
					List<WebElement> productAddcart = WebUI.getWebElements(add);
					productAddcart.get(i).click();
					Thread.sleep(2000);

					WebUI.getWebElements(size6).get(i).click();

//	 WebUI.clickElement(By.xpath("//div[contains(@class,'products-grid')]"));
					Thread.sleep(4000);

//	 WebUI.mouseHover(By.xpath("//div[@class='shops-wrapper no-arrow desktop-only']"));
					DriverManager.getDriver().navigate().refresh();
					break;
				}
			}
		}
	}

	public void selectdress(String dress_name, String size) throws InterruptedException {

		List<WebElement> productname = WebUI.getWebElements(Shirt_name);
		for (int i = 0; i < productname.size(); i++) {
			productFound = false;
			if (productname.get(i).getAttribute("title").contains(dress_name)) {

				List<WebElement> productAddcart = WebUI.getWebElements(add);
				productAddcart.get(i).click();
				Thread.sleep(3000);
				int j = i + 1;
				Size = By.xpath("(//div[@aria-label='" + size + "'])[" + j + "]");
				try {
					WebUI.getWebElement(Size).click();
				}
				 catch (ElementNotInteractableException e) {
					// Handle the exception here
					LogUtils.info("Element is present but not clickable");
				
				}
				catch (NoSuchElementException e) {
					// Handle the exception here
					Size = By.xpath("(//div[@aria-label='" + size + "'])[" + j + "]");
					WebUI.getWebElement(Size).click();
				
				}

				productFound = true;
				break;
			}
		}
		if (!productFound) {
			Assert.assertTrue(false);
		}

	}

	public void clickcheckout() throws InterruptedException {
		Thread.sleep(5000);
		WebUI.mouseHover(By.xpath("//a[@class='action showcart']"));
		// a[@class='action showcart']
		try {
		WebUI.getWebElement(checkout).click();
		}
		catch(ElementNotInteractableException e) {
			clickcheckout();
		}
	}
	public void selectdress(String dress_name, int size2) throws InterruptedException {

		List<WebElement> productname = WebUI.getWebElements(Shirt_name);
		for (int i = 0; i < productname.size(); i++) {
			productFound = false;
			if (productname.get(i).getAttribute("title").contains(dress_name)) {

				List<WebElement> productAddcart = WebUI.getWebElements(add);
				productAddcart.get(i).click();
				Thread.sleep(3000);
				int j = i + 1;
				Size = By.xpath("(//div[@aria-label='" + size2 + "'])[" + j + "]");
				try {
					WebUI.getWebElement(Size).click();
				}
				 catch (ElementNotInteractableException e) {
					// Handle the exception here
					LogUtils.info("Element is present but not clickable");
				
				}
				catch (NoSuchElementException e) {
					// Handle the exception here
					Size = By.xpath("(//div[@aria-label='" + size2 + "'])[" + j + "]");
					WebUI.getWebElement(Size).click();
				
				}

				productFound = true;
				break;
			}
		}
		if (!productFound) {
			Assert.assertTrue(false);
		}

	}

	public String getthedressnamefromexcel(int row) throws IOException {
		String path=System.getProperty("user.dir") +"\\src\\test\\resources\\Book2.xlsx";
		String sheetName="demo";
		String product=excel.readandgetTestData(path,sheetName,row,1);
	return product;
	}
	public int getthedresssizefromexcel(int row) throws IOException {
		String path=System.getProperty("user.dir") +"\\src\\test\\resources\\Book2.xlsx";
		String sheetName="demo";
		return (int)Double.parseDouble(excel.readandgetTestData(path,sheetName,row,2));
		
	}
}
