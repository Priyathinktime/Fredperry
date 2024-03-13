package com.thinktimetechno.projects.website.fredperry.stepdefinitions;

import java.util.List;

import org.openqa.selenium.By;

import com.thinktimetechno.hooks.TestContext;
import com.thinktimetechno.keywords.WebUI;

import com.thinktimetechno.projects.website.fredperry.pages.CheckoutPage;
import com.thinktimetechno.projects.website.fredperry.pages.FrontPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class checkoutPageSteps {

	 private CheckoutPage checkoutpage;

    public checkoutPageSteps(TestContext testContext) {
    	checkoutpage=testContext.getcheckoutpage();
    }

    @Then("Select delivery options collect from store")
    public void select_delivery_options_collect_from_store() throws InterruptedException {
    	
    	checkoutpage.selectCollectfromstore();
    }
    @Then("Give the personal details.")  
  public void enterPersonalDetails(List<String> data) {
	checkoutpage.getpersonaldetails(data.get(0), data.get(1), data.get(2), data.get(3));
}
//  
    @When("Choose a store for pickup.")
    public void choose_a_store_for_pickup() throws InterruptedException {
    	checkoutpage.selectchosestore();
    }


    @When("Select the specified store {string}.")
    public void select_the_specified_store(String storeName) throws InterruptedException {
    	checkoutpage.selectSpecifiedStore(storeName);
    }

    @When("Click Next.")
    public void click_next() throws InterruptedException {
    	checkoutpage.continuenext();
    	
    }

//    @When("Opt for Check & Money Order as the payment method.")
//    public void opt_for_check_money_order_as_the_payment_method() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
//
//    @When("Click Update Address.")
//    public void click_update_address() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
//
//    @When("Add the provided card details")
//    public void add_the_provided_card_details() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
//
//    @Then("place the order.|")
//    public void place_the_order() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }

}
