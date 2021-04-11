package com.mytest.cucumber.steps;



import com.mytest.cucumber.steps.serenity.BasePageSteps;
import com.mytest.utils.DressCategories;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class BasePageStepDefinition {
	
	@Steps
	BasePageSteps userInBasepage;
	
	@Given("User navigate to Home Page")
	public void userNavigateToHomePage() {
		userInBasepage.goToHomePage();
	}
	
	@When("User navigate to Sign in Page")
	public void userNavigateToSignInPage() {
		userInBasepage.signin();
	}
	
	@And("User clicks (.*) category")
	public void navigateToProductCategory(DressCategories dressCategory){
		userInBasepage.navigateToProductCategory(dressCategory);
	}
	

}
