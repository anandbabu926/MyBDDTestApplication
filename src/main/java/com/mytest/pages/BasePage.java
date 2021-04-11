package com.mytest.pages;

import com.mytest.utils.DressCategories;

import net.serenitybdd.core.pages.PageObject;

public class BasePage extends PageObject{
	
	private static final String BANNER = "//div[@class = 'banner']//a";
	private static final String CONTACT_US = "//div[@id='contact-link']/a";
	private static final String SIGN_IN = "//a[@class='login']";
	private static final String SIGN_OUT = "//a[@class='logout']";
	private static final String SHOP_PHONE = "//span[@class = 'shop-phone']";
	private static final String LOGO_LINK = "//a[@title ='My Store']/img";
	
	private static final String SEARCH_TEXT = "//*[@id='search_query_top']";
	private static final String SEARCH_BUTTON = "//*[@id='searchbox']/button";
	private static final String SHOPPING_CART = "//a[@title = 'View my shopping cart']";

	private static final String WOMEN_CATEGORY = "//a[@title='Women']";
	
	private static final String TOPS_SUB_CATEGORY = "//a[@title='Tops']";
	private static final String TSHIRTS_SUB_CATEGORY = "(//a[@title='T-shirts'])[1]";	
	private static final String BLOUSES_SUB_CATEGORY = "//a[@title='Blouses']";	
	
	private static final String DRESSES_SUB_CATEGORY = "(//a[@title='Dresses'])[1]";
	private static final String CASUAL_DRESSES_NESTED_CATEGORY = "(//a[@title='Casual Dresses'])[2]";
	private static final String EVENINNG_DRESSES_NESTED_CATEGORY = "(//a[@title='Evening Dresses'])[2]";
	private static final String SUMMER_DRESSES_NESTED_CATEGORY = "(//a[@title='Summer Dresses'])[2]";
	
	private static final String DRESSES_CATEGORY = "(//a[@title='Dresses'])[2]";
	private static final String CASUAL_DRESSES_SUB_CATEGORY = "(//a[@title='Casual Dresses'])[1]";
	private static final String EVENINNG_DRESSES_SUB_CATEGORY = "(//a[@title='Evening Dresses'])[1]";
	private static final String SUMMER_DRESSES_SUB_CATEGORY = "(//a[@title='Summer Dresses'])[1]";
	
	private static final String TSHIRTS_CATEGORY = "(//a[@title='T-shirts'])[2]";
	
	private static final String HOME_ICON = "//a[@class=\"home\"]";
	
	public BasePage navigateToHomePage() {
		open();	
		waitFor(SHOP_PHONE);	
		return this;
	}
	
	public BasePage clickLogo() {		
		waitFor(LOGO_LINK).$(LOGO_LINK).click();
		return this;
	}
	
	
	public BasePage navigateToBannerPage() {

		waitFor(SHOP_PHONE);
		waitFor(BANNER).$(BANNER).click();
		
		return this;
	}
	
	
	
	public LoginPage signIntoAccount() {
		waitFor(SIGN_IN).$(SIGN_IN).click();
		waitForTextToAppear("AUTHENTICATION");
		return this.switchToPage(LoginPage.class);
	}
	
	public BasePage signOutOfAccount() {
		
		waitFor(SIGN_OUT).$(SIGN_OUT).click();
		waitForTextToAppear("AUTHENTICATION");
		return this;
	}
	
	public ProductPage searchForAProduct(String searchkeyword) {
		waitFor(SEARCH_TEXT).$(SEARCH_TEXT).sendKeys(searchkeyword);
		waitFor(SEARCH_BUTTON).$(SEARCH_BUTTON).click();
		return this.switchToPage(ProductPage.class);
	}
	
	public BasePage clickHomeIcon() {		
		waitFor(HOME_ICON).$(HOME_ICON).click();
		return this;
	}
	
	
	public ProductPage navigateToProductCategory(DressCategories DressCategory) {
		switch (DressCategory) {
		case WOMEN:
			$(WOMEN_CATEGORY).click();
			return this.switchToPage(ProductPage.class);
		case DRESSES:
			$(DRESSES_CATEGORY).click();
			return this.switchToPage(ProductPage.class);	
		case TSHIRTS:
			$(TSHIRTS_CATEGORY).click();
			return this.switchToPage(ProductPage.class);	
		default:
			break;
		}
		return null;
		
	}
	
	public ProductPage navigateToProductSubCategory(DressCategories DressCategory) {
		switch (DressCategory) {
		case TOPS:
			$(TOPS_SUB_CATEGORY).click();
			return this.switchToPage(ProductPage.class);
		case TSHIRTS:
			$(TSHIRTS_SUB_CATEGORY).click();
			return this.switchToPage(ProductPage.class);	
		case BLOUSES:
			$(BLOUSES_SUB_CATEGORY).click();
			return this.switchToPage(ProductPage.class);	
		case DRESSES:
			$(DRESSES_SUB_CATEGORY).click();
			return this.switchToPage(ProductPage.class);
		case CASUAL_DRESSES:
			$(CASUAL_DRESSES_SUB_CATEGORY).click();
			return this.switchToPage(ProductPage.class);	
		case EVENING_DRESSES:
			$(EVENINNG_DRESSES_SUB_CATEGORY).click();
			return this.switchToPage(ProductPage.class);
		case SUMMER_DRESSES:
			$(SUMMER_DRESSES_SUB_CATEGORY).click();
			return this.switchToPage(ProductPage.class);
		
		default:
			break;
		}
		return null;
		
	}
	
	public ProductPage navigateToProductNestedCategory(DressCategories DressCategory) {
		switch (DressCategory) {
		case CASUAL_DRESSES:
			$(CASUAL_DRESSES_NESTED_CATEGORY).click();
			return this.switchToPage(ProductPage.class);
		case EVENING_DRESSES:
			$(EVENINNG_DRESSES_NESTED_CATEGORY).click();
			return this.switchToPage(ProductPage.class);	
		case SUMMER_DRESSES:
			$(SUMMER_DRESSES_NESTED_CATEGORY).click();
			return this.switchToPage(ProductPage.class);	
		default:
			break;
		}
		return null;
		
	}
	
}
