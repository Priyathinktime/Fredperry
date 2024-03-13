package com.thinktimetechno.projects.website.fredperry.stepdefinitions;

import java.util.List;

import com.thinktimetechno.hooks.TestContext;
import com.thinktimetechno.projects.website.fredperry.pages.PaymentPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PaymentPageSteps {
	
	
	 private PaymentPage paymentpage;
	 public PaymentPageSteps(TestContext testContext) {
		 paymentpage=testContext.getpaymentpage();
	    }

    @When("Opt for Check & Money Order as the payment method.")
    public void opt_for_check_money_order_as_the_payment_method() throws InterruptedException {
    	  
    	paymentpage.clickcashonDel();
    }

    @When("Click Update Address.")
    public void click_update_address(List<String> data) throws InterruptedException {
    	  Thread.sleep(4000);
    	paymentpage.provideAddress(data.get(0), data.get(1), data.get(2), data.get(3),data.get(4),data.get(5));
    }

   

    @Then("place the order.")
    public void place_the_order() throws InterruptedException {
    	paymentpage.placeorder();
    }

}
