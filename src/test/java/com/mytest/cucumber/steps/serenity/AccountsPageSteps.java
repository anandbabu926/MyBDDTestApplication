package com.mytest.cucumber.steps.serenity;



import com.mytest.pages.AccountsPage;
import com.mytest.pages.BasePage;


import net.thucydides.core.annotations.Step;

public class AccountsPageSteps {
	
	AccountsPage accountsPage;
	
	@Step(" user navigates to Home using Home link in registration page")
	public BasePage clickHomeLink() {
		return accountsPage.clickHomeIcon();
	}
	
	
	
	@Step("User clicks My Personal Information section")
	public AccountsPage clickMyPersonalInformation() {
		return accountsPage.clickMyPersonalInformation();
	}
	
	@Step("User modifies the account details with {0} as {1}")
	public AccountsPage updateUserInfo(String fieldname, String fieldValue) {
		return accountsPage.updateUserInfo(fieldname, fieldValue);
	}
	
	@Step("User clicks save button with valid {0}")
	public AccountsPage clickSave(String password) {
		return accountsPage.clickSave(password);
	}
	
	@Step("gets success or error list header in registration page")
	public String getSuccessOrErrorListHeader() {
		return accountsPage.getSuccessOrErrorListHeader();
	}
}
