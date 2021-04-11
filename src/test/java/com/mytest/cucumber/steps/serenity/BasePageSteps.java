package com.mytest.cucumber.steps.serenity;

import com.mytest.pages.BasePage;
import com.mytest.pages.LoginPage;
import com.mytest.pages.ProductPage;
import com.mytest.utils.DressCategories;

import net.thucydides.core.annotations.Step;

public class BasePageSteps {
	
	BasePage basePage;
	
	/**
	 * Base Page steps
	 * 
	 */

	@Step("navigate to home page")
	public BasePage goToHomePage() {
		
		return basePage.navigateToHomePage();
		}
	@Step("click sign in button")
	public LoginPage signin() {
		
		return basePage.signIntoAccount();
		}
	@Step("click Category - {0}")
	public ProductPage navigateToProductCategory(DressCategories dressCategory) {
		return basePage.navigateToProductCategory(dressCategory);
	}
}
