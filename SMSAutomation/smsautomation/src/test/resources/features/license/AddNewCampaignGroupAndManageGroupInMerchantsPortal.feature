

#User is assumed to have Admin access unless stated Otherwise
@license @RegressionTest
Feature: To verify that the user is able to create a new campaign
	Existing user should be able to create a new campaign
@Create-a-campaign @RegressionTest
Scenario: Log in, Access the License Portal and create a new campaign
	Given User navigate to License url 
	And User enters valid username 
	And User enters valid password 
	When User clicks on the SignIn button 
	When User clicks on Businesses menu item
	And User clicks on Login tab for a merchant
	And User clicks on the campaigns menu item 
	Then User clicks campaign groups under campaigns
	And User navigates to the next page
	And User navigates back to the main page
	Then User validates the page length options
	Then User copies the campaign groups
	And User exports the campaign groups
	And User clicks the New button on the campaign groups page
	And User validates empty fields
	And User validates the help icons
	And User enters valid details in each of the text fields
	And User clicks the toggle button to allow or disallow group redemption
	Then User clicks on save button and validate data 
	And User clicks the edit button on the newly created campaign group
	And User edits the text fields of the campaign
	And User clicks the Save button
	And User clicks the edit dropdown button on the campaign
	And User clicks the delete button 
	Then User confirm the campaign is deleted