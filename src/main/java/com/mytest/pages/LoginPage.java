package com.mytest.pages;

public class LoginPage extends BasePage {
	
	// Already Registered
	private static final String LOGIN_EMAIL = "//input[@id='email']";
	private static final String LOGIN_PASSWORD = "//input[@id='passwd']";
	private static final String SIGNIN_BUTTON = "//button[@id='SubmitLogin']";
	
	public LoginPage doLogin(String email, String password) {
		waitForTextToAppear("ALREADY REGISTERED?");
		waitForTextToAppear("Email address");
		waitForTextToAppear("Password");
		$(LOGIN_EMAIL).sendKeys(email);
		$(LOGIN_PASSWORD).sendKeys(password);
		$(SIGNIN_BUTTON).click();
		
		return this;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
