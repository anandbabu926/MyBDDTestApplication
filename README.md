# MyBDDTestApplication

Developed this project in Serenity-Cucumber BDD with Junit. 

Please run the project with below command

**$ mvn clean verify serenity:aggregate**

Feature will be executed as per Serenity-Junit runner and Serenity reports will be generated for the execution. 

Below is the reference serenity report

![image](https://user-images.githubusercontent.com/66834820/114323414-07136300-9b1d-11eb-9b78-dc7cf60971c1.png)

![image](https://user-images.githubusercontent.com/66834820/114323618-f2839a80-9b1d-11eb-82de-0d1c475f2ac6.png)

This project aims to execute 2 BDD scenarios 
1. Order T-Shirt and verify Order History
2. Modify the user firstname and lastname from My accounts page.

Navigation -
src/test/resources/features - all the features and its related scenarios are defined in this package
com.mytest.cucumber - serenity - cucumber runner with feature file definition
com.mytest.cucumber.steps - all the step definition for the scenarios are defined in this package
com.mytest.cucumber.steps.serenity - all the steps for the step definition are defined in this package
com.mytest.pages - all the web driver actions are defined in this package
com.mytest.utils - all the categories of the web application under test is defined in this package.

Development in Progress-
- Develop User Registration  script
- Script to Order different kinds of products
- Develop Contact US page script


