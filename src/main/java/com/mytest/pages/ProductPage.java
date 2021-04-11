package com.mytest.pages;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.webelements.Checkbox;
import net.thucydides.core.pages.components.HtmlTable;


import java.util.List;

import org.openqa.selenium.WebElement;

public class ProductPage extends BasePage {
	
	// PRODUCT PAGE DETAILS
	private static final String QUANTITY = "//input[@id='quantity_wanted']";
	private static final String SIZE_DROPDOWN = "//select[@id='group_1']";
	private static final String ADD_TO_CART = "//p[@id='add_to_cart']/button";
	private static final String ITEM_PRICE = "//span[@id='our_price_display']";
	
		
	// SHORT DESCRIPTION BEFORE CHECKOUT
	private static final String CONTINUE_SHOPPING = "//span[@title = 'Continue shopping']";
	private static final String PROCEED_TO_CHECKOUT_BUTTON = "//a[@title = 'Proceed to checkout']";
	private static final String CLOSE_BUTTON = "//span[@title = 'Close window']";

	//PRODUCT SUMMARY
	private static final String SUMMART_CHECK_OUT_BUTTON = "//p[contains(@class,'cart_navigation')]//span";
	private static final String TOS_CHECKBOX = "//*[@id=\"cgv\"]";
	private static final String PAY_BY_CHECK = "//a[@title='Pay by check.']";
	private static final String PAY_BY_WIRE = "//a[@title='Pay by bank wire']";
	private static final String CONFIRM_ORDER_BUTTON = "//span[text()='I confirm my order']/parent::button";
	private static final String SUCCESS_ORDER_MESSAGE = "//*[@id='center_column']//p/strong";
	private static final String ORDER_REF ="//*[@id='center_column']/div";
	private static final String BACK_TO_ORDERS_LINK = "//a[@title='Back to orders']";
	private static final String ORDER_TABLE = "//table[@id='order-list']";
	
	public ProductPage selectItemBasedOnName(String itemName) {
		
		String itemSelected = "//a[contains(text(),'" + itemName +"')]";
		waitFor(itemSelected).$(itemSelected).click();
		waitForTextToAppear(itemName);
		return this;
	}
	
	
	public ProductPage customizeProduct(int quantity, String size, String color) {
		String price = $(ITEM_PRICE).getText();
		Serenity.setSessionVariable(price).to("price");
		if (quantity > 1) {
			$(QUANTITY).type(String.valueOf(quantity));
		
		}
		if(size !="S") {
			$(SIZE_DROPDOWN).selectByVisibleText(size);
		}
		selectItemBasedOnColor(color);
		return this;
	}
	
	public ProductPage clickAddToCart() {
		$(ADD_TO_CART).click();
		return this;
	}
	
	public ProductPage selectItemBasedOnColor(String color) {

		
		String colorSelected = "//a[@name='" + color +"']";
		$(colorSelected).click();
		
		return this;
	}
	
	public ProductPage clickContinueShopping() {
		$(CONTINUE_SHOPPING).click();
		return this;
	}
	
	public ProductPage clickProceedToCheckOut() {
		$(PROCEED_TO_CHECKOUT_BUTTON).click();
		return this;
	}
	
	public ProductPage clickCloseInBanner() {
		$(CLOSE_BUTTON).click();
		return this;
	}
	
	public ProductPage clickTermsOfServiceCheck() { 
		new Checkbox( $(TOS_CHECKBOX) ).setChecked(true);
		return this;
	}
	public ProductPage clickPaymentMethod(String paymentMethod) { 
		waitForTextToAppear("PLEASE CHOOSE YOUR PAYMENT METHOD");
		switch (paymentMethod) {
		case "WIRE":
			$(PAY_BY_WIRE).click();
			return this;
		case "CHECK":
			$(PAY_BY_CHECK).click();
			return this;
		default:
			break;
		}
		return null;
	}
	
	public ProductPage clickConfirmOrder() { 
		waitForTextToAppear("ORDER SUMMARY");
		$(CONFIRM_ORDER_BUTTON).click();
		return this;
	}
	
	public ProductPage summaryCheckOut() {
		$(SUMMART_CHECK_OUT_BUTTON).click();
		return this;
	}
	
	public String orderSuccessMessage() { 
		waitForTextToAppear("ORDER CONFIRMATION");
		return $(SUCCESS_ORDER_MESSAGE).getText();
		
	}
	
	public String getOrderNumber() {
		String orderNumber = $(ORDER_REF).getText();
		orderNumber = orderNumber.substring(216, 224);
		return orderNumber;
		
	}
	
	public List<WebElement> verifyOrderHistory(String orderNumber) {
		waitFor(BACK_TO_ORDERS_LINK).$(BACK_TO_ORDERS_LINK).click();
		WebElementFacade table = waitFor(ORDER_TABLE).$(ORDER_TABLE);
		List<WebElement> rowValue = HtmlTable.inTable(table).getRowElements();
		return rowValue;
	}
}
