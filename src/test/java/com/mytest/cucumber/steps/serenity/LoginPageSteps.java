package com.mytest.cucumber.steps.serenity;


import com.mytest.pages.LoginPage;

import net.thucydides.core.annotations.Step;

public class LoginPageSteps {
	
	LoginPage loginPage;
	
	
	@Step("Logging into the application with email : {0} and password {1}")
	public LoginPage doLogin(String email, String password) {
		return loginPage.doLogin(email, password);
	}
	
}
