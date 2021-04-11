package com.mytest.cucumber.steps;


import java.util.List;
import java.util.Map;
import com.mytest.cucumber.steps.serenity.AccountsPageSteps;
import static org.junit.Assert.*;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;


import net.thucydides.core.annotations.Steps;


public class AccountsPageStepDefinition {
	
	@Steps
	AccountsPageSteps userInAccountsPage;
	
	
	@And("User clicks My Personal Information section")
	public void clickPersonalInfo() {
		userInAccountsPage.clickMyPersonalInformation();
	}
	
	@And("User modifies the below basic information")
	public void updateUserInfo(DataTable arg1) {
		List<Map<String, String>> modification =  arg1.asMaps(String.class, String.class);
		for( Map<String, String> s : modification ) {
			userInAccountsPage.updateUserInfo(s.get("FieldName"),s.get("FieldValue"));
		}
	}
	
	@And("User clicks save button with valid (.*)")
	public void clickSave(String password) {
		userInAccountsPage.clickSave(password);
	}
	
	@Then("Check success message is displayed for modification")
	public void getSuccessMessage() {
		String successMsg = userInAccountsPage.getSuccessOrErrorListHeader();
		assertEquals("Your personal information has been successfully updated.", successMsg);
	}
}
