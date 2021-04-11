package com.mytest.pages;

public class AccountsPage extends BasePage {
	
		
		//Create User > YOUR ADDRESS
		private static final String  FIRST_NAME_ADDED_ALREADY = "//input[@id='firstname']";
		private static final String  LAST_NAME_ADDED_ALREADY = "//input[@id='lastname']";
		private static final String  EMAIL_ADDED_ALREADY = "//input[@id='email']";
		
		
		//MY ACCOUNT SECTION - ACCOUNTS PAGE
		private static final String  MY_PERSONAL_INFO = "//a[@title='Information']";
		
		//Edit MY PERSONAL INFO Page 
		private static final String CURRENT_PASSWORD = "//input[@id='old_passwd']";
		private static final String SAVE_BUTTON = "//span[text()='Save']/parent::button";
		private static final String  MSG_HEADER = "//div[@id='center_column']/div/p";
		
		
		public AccountsPage clickMyPersonalInformation() {
			waitForTextToAppear("MY PERSONAL INFORMATION");
			$(MY_PERSONAL_INFO).click();
			return this;
		}
		
		public AccountsPage clickSave(String password) {
			$(CURRENT_PASSWORD).type(password);
			$(SAVE_BUTTON).click();
			return this;
		}
		
		public AccountsPage updateUserInfo(String fieldname, String fieldValue) {
			
			switch (fieldname) {
			case "firstname":
					$(FIRST_NAME_ADDED_ALREADY).type(fieldValue);
					return this;
			case "lastname":
					$(LAST_NAME_ADDED_ALREADY).type(fieldValue);
					return this;
			case "email":
				$(EMAIL_ADDED_ALREADY).type(fieldValue);
				return this;
			default:
				break;
			}
			return null;
			
		}
		public String getSuccessOrErrorListHeader() {
			return $(MSG_HEADER).getText();
			
		}
}
