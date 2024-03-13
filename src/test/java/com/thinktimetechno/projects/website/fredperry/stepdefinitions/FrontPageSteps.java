package com.thinktimetechno.projects.website.fredperry.stepdefinitions;

import java.io.IOException;

import com.thinktimetechno.hooks.TestContext;
import com.thinktimetechno.keywords.WebUI;
import com.thinktimetechno.projects.website.fredperry.pages.FrontPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FrontPageSteps {

    FrontPage frontpage;

    public FrontPageSteps(TestContext testContext) {
    	frontpage=testContext.getFrontpage();
    }


    @Given("User navigate to Login Page for Admin {string} with username {string} and password {string}")
    public void user_navigate_to_login_page_for_admin_with_username_and_password(String url, String username, String password) {
    	WebUI.getToUrlAuthentication(url, username, password);
//    	WebUI.getURL(url);
    }

    @When("click on Shopping in the UK section.")
    public void click_on_in_the_uk_section() {
    	frontpage.selectuk();
    }

    @When("Navigate to Women Polo Shirts.")
    public void navigate_to_women_polo_shirts() {
    	frontpage.movetowomen();
    	frontpage.selectWomenPoloShirt();
    }

    @When("Add the desired T-shirt {string} with size {string} to the shopping bag.")
    public void add_the_desired_t_shirt_to_the_shopping_bag(String dress_name,String Size) throws InterruptedException {
    	frontpage.selectdress(dress_name,Size);
    	
    }

    @When("Proceed to secure checkout.")
    public void proceed_to_secure_checkout() throws InterruptedException {
    	frontpage.clickcheckout();
    }

    @When("get the desired T-shirt from excel")
    public void get_the_desired_t_shirt_from_excel() {
    	frontpage.fetchdress();
    }
    @When("Add the desired T-shirt to the shopping bag.")
    public void add_the_desired_t_shirt_to_the_shopping_bag() throws InterruptedException {
    	frontpage.selectMuitipledress();
    }
    @When("get the desired T-shirt from excel with {string} to the shopping bag.")
    public void get_the_desired_t_shirt_from_excel_with_to_the_shopping_bag(String ProductNo) throws IOException, InterruptedException {
    	
		String getno=ProductNo.split("t")[1];
		int int1 = Integer.parseInt(getno);
    	
    	frontpage.selectdress(frontpage.getthedressnamefromexcel(int1),frontpage.getthedresssizefromexcel(int1));
    	
    }

}
