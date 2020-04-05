#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
Feature: [SMSM-125] View and access all options under Broadcast History in Merchant's portal (Engage system)

  Background: User is logged in and navigates to the Merchant's Dashboard
    Given User navigate to Engage url
    And User enters a valid username
    And User enters a valid password
    And User clicks on the login button
    Then User should be taken to Engage SMS home page
    When User clicks the Manage Resellers menubar option
    And User logs in to a reseller
    Then User is redirected to the Engaged Admin Dashboard page
    When User clicks Business tabs at the left side
    Then the Businesses page is opened
    And Users click Login tab for a merchant
    Then the user is redirected to a new window of Merchant's Dashboard
    When User clicks the broadcast option tab
    Then the Broadcast menu is opened
    And User verifies the available option on the KHS of the page
    When User clicks on Manage Broadcasts option
    Then User is redirected to the Manage Broadcasts page

  @SMSM-124-User-can-change-number-of-broadcast-messages-per-page @RegressionTest 
  Scenario: User can change number of broadcast messages per page
		And User verifies that the pagination count dropdown is available
		When User clicks the pagination drop down
		Then the drop down is opened and user verifies the number of records per page
		When User selects a value from the drop down
		Then User confirms the value was selected successfully.
		 
  @SMSM-124-User-can-search-the-broadcast-message @RegressionTest @OnlyMe
  Scenario: User can search the broadcast message
    And User verifies that Search textfield is available on Manage Broadcast page
    When User enters some search string into the Search text box
    Then User verifies the search results is displayed based on search string
    When User enters some invalid search string
    Then a message indicating no matching records found is displayed
    
    
    
    