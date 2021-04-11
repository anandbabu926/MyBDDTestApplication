Feature: This feature covers the 2 scenarios of modifying user details and ordering T-shirt and verifying in order history

Scenario Outline: Sceanrio 001/001 -Verify whether user is able to select & place order for T-shirt and check in order history
Given User navigate to Home Page
When User navigate to Sign in Page
And User enters email as xyz@xyz.com and password as password
And User clicks <Category> category
And User selects product - <Product Name> with Size <Size> and color <Color> of quantity <Quantity> & checksout
And User clicks Proceed to Checkout in order summary page
And User clicks Proceed to Checkout in address summary page
And User clicks TOS checkbox and clicks Proceed to Checkout in shipping summary page
And User selects payment method as <Payment> and completes the checkout
Then Verify success order messsage is displayed
And Check order number in order history

Examples:
|Category | Product Name 				| Size 	| Color | Quantity 	| Payment	|
| TSHIRTS|Faded Short Sleeve T-shirts 	| M		| Blue	| 2			| WIRE		|


Scenario Outline: Sceanrio 001/002 - Verify whether user is able to edit firstname & lastname
Given User navigate to Home Page
When User navigate to Sign in Page
And User enters email as <Email> and password as <Password>
And User clicks My Personal Information section
And User modifies the below basic information
| FieldName | FieldValue 	|
| firstname	| Williams		|
| lastname	| Nick			|
And User clicks save button with valid <Password>

Examples:
|Email			|Password|
|xyz@xyz.com 	|password|