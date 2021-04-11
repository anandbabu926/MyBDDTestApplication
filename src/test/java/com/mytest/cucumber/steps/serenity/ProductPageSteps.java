package com.mytest.cucumber.steps.serenity;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.mytest.pages.ProductPage;

import net.thucydides.core.annotations.Step;

public class ProductPageSteps {
	
	ProductPage productPage;
	
	@Step("User selects product - {0} with Size {1} and color {2} of quantity {3}")
	public ProductPage selectProduct(String productName, String size, String color, int quantity) {
		productPage.selectItemBasedOnName(productName);
		productPage.customizeProduct(quantity, size, color);
		productPage.clickAddToCart();
		return productPage;
	}
	
	@Step("User clicks Proceed to Checkout in pop up screen")
	public ProductPage proceedToCheckout() {
		return productPage.clickProceedToCheckOut();
		}
	@Step("User clicks Proceed to Checkout in summary page")
	public ProductPage summaryCheckOut() {
		return productPage.summaryCheckOut();
		}
	
	@Step("User clicks Proceed to Checkout in shipping summary page")
	public ProductPage proceedToCheckoutInShippingSummary() {
		productPage.clickTermsOfServiceCheck();
		productPage.summaryCheckOut();
		return productPage;
		}
	
	@Step("User selects payment method as {0} and completes the checkout")
	public ProductPage selectPaymentMethodAndCheckout(String paymentMethod) {
		productPage.clickPaymentMethod(paymentMethod);
		productPage.clickConfirmOrder();
		return productPage;
	}
	
	@Step("Verify success order messsage is displayed")
	public String orderSuccessMessage() {
		return productPage.orderSuccessMessage();
	}
	
	@Step("get order number from order placed")
	public String getOrderNumber() {
		return productPage.getOrderNumber();
	}
	
	@Step("compares the order history with order# - {0}")
	public List<WebElement> verifyOrderHistory(String orderNumber) {
		
		return productPage.verifyOrderHistory(orderNumber);
	}
}
