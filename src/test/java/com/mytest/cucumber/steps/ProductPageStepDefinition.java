package com.mytest.cucumber.steps;

import com.mytest.cucumber.steps.serenity.ProductPageSteps;
import static org.junit.Assert.*;

import java.util.List;

import org.hamcrest.CoreMatchers;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class ProductPageStepDefinition {
	
	@Steps
	ProductPageSteps userInProductPage;
	
	@When("User selects product - (.*) with Size (.*) and color (.*) of quantity (.*) & checksout")
	public void selectProduct(String productName, String size, String color, int quantity ) {
		userInProductPage.selectProduct(productName, size, color, quantity);
		userInProductPage.proceedToCheckout();
	}
	
	@And("User clicks Proceed to Checkout in order summary page")
	public void userInOrderSummaryAndClicksCheckOut() {
		userInProductPage.summaryCheckOut();
	}
	
	@And("User clicks Proceed to Checkout in address summary page")
	public void userInAddressSummaryAndClicksCheckOut() {
		userInProductPage.summaryCheckOut();
	}
	
	@And("User clicks TOS checkbox and clicks Proceed to Checkout in shipping summary page")
	public void userInShippingSummaryAndClicksCheckOut() {
		userInProductPage.proceedToCheckoutInShippingSummary();
	}
	@And("User selects payment method as (.*) and completes the checkout")
	public void selectPaymentMethodAndCheckout(String paymentMethod) {
		userInProductPage.selectPaymentMethodAndCheckout(paymentMethod);
	}
	
	@Then("Verify success order messsage is displayed")
	public void orderSuccessMessage() {
		String successMsg =  userInProductPage.orderSuccessMessage();
		assertEquals("Your order on My Store is complete.", successMsg);
	}
 
	@And("Check order number in order history")
	public void orderHistory() {
		String orderNumber = userInProductPage.getOrderNumber();
		
		List<WebElement> orderDetails = userInProductPage.verifyOrderHistory(orderNumber);
		
		for(WebElement e: orderDetails) {
			String orderString = e.getText();
			if(orderString.contains(orderNumber)){
				assertThat(orderString, CoreMatchers.containsString(orderNumber));
			}
			
		}
		
	}
	
	
}
