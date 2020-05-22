
#User is assumed to have Admin access unless stated Otherwise
Feature: Login into Engage App
	Existing user should be able to log into Engage SMS using correct credentials
	
@engage @RegressionTest
Scenario: Login into Engage with correct credential
	Given User navigate to Engage url
	And User enters a valid username 
	And User enters a valid password 
	When User clicks on the login button
	Then User should be taken to Engage SMS home page