package com.thinktimetechno.hooks;

import com.thinktimetechno.driver.DriverManager;
import com.thinktimetechno.driver.TargetFactory;

import com.thinktimetechno.projects.website.fredperry.pages.CheckoutPage;
import com.thinktimetechno.projects.website.fredperry.pages.FrontPage;
import com.thinktimetechno.projects.website.fredperry.pages.PaymentPage;

import com.thinktimetechno.utils.LogUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ThreadGuard;

public class TestContext {

	private WebDriver driver;

	public TestContext() {
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		driver = ThreadGuard.protect(new TargetFactory().createInstance());
		driver.manage().window().maximize();
		DriverManager.setDriver(driver);
		LogUtils.info("Driver in TestContext: " + getDriver());
	}


	private FrontPage frontpage;
	private CheckoutPage checkoutpage;
	private PaymentPage paymentpage;


	public WebDriver getDriver() {
		return DriverManager.getDriver();
	}

	

	public FrontPage getFrontpage() {
		if (frontpage == null) {
			frontpage = new FrontPage();
		}
		return frontpage;
	}

	public CheckoutPage getcheckoutpage() {
		if (checkoutpage == null) {
			checkoutpage = new CheckoutPage();
		}
		return checkoutpage;
	}

	public PaymentPage getpaymentpage() {
		if (paymentpage == null) {
			paymentpage = new PaymentPage();
		}
		return paymentpage;
	}

	
}
