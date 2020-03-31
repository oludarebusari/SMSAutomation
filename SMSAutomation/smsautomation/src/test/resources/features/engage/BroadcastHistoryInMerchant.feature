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

  @SMSM-125-Verify-that-user-is-redirected-to-new-windows-of-merchant's-dashboard-and-locate-the-Broadcast-menu @RegressionTest
  Scenario: Verify that User is redirected to new windows of merchant's dashboard and locate the "Boradcasts" menu
    When User clicks the broadcast option tab
    Then the Broadcast menu is opened
    And User verifies the available option on the KHS of the page

  @SMSM-125-Verify-that-user-is-able-to-see-all-existing-broadcast-messages-(send-or-scheduled)-according-to-Date-Selected-in-Broadcast-History @RegressionTest @OnlyMe
  Scenario: Verify that User is able to see all existing broadcast messages (send or scheduled) according to Date Selected in BroadCast History
    When User clicks the broadcast option tab
    Then the Broadcast menu is opened
    When User clicks on Broadcast History option
    Then the User is redirected to the Broadcast History page
    When User clicks on Dates
    Then a list of Date options is displayed and verified by the user
    When User clicks on Date and Selects All Data and clicks apply button
    Then all existing broadcast messages were displayed
    
    
    
    
    
