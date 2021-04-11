package com.mytest.cucumber.steps;

import com.mytest.cucumber.steps.serenity.LoginPageSteps;

import net.thucydides.core.annotations.Steps;

import cucumber.api.java.en.When;

public class LoginPageStepDefinition {
	@Steps 
	LoginPageSteps loginPageSteps;
	
	@When("User enters email as (.*) and password as (.*)")
	public void doLogin(String email, String password) {
		loginPageSteps.doLogin(email, password);
	}
	
}
