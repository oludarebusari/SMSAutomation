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

#User is assumed to have Admin access unless stated Otherwise
Feature: [SMSM-128] View all analytics data for offers, Message, Tablets, rewards & subscribers data in Merchant's portal (Engage system)

  Background: User is logged in and navigates to the Merchant's Dashboard
    Given User navigate to Engage url
    And User enters a valid username
    And User enters a valid password
    And User clicks on the login button
    Then User should be taken to Engage SMS home page
    When User clicks the Manage Resellers menubar option
    And User logs in to a reseller
    Then User is redirected to the Engaged Admin Dashboard page

  @SMSM-139-Verify-that-user-is-able-to-check-the-Actions-dropdown-menu-copy-and-export-Businesses-to-csv @RegressionTest
  Scenario: Verify that User is able to check the Actions dropdown menu, copy and export Businesses to CSV
    When User clicks Business tabs at the left side
    Then the Businesses page is opened
    And User verifies that all the records have LOG IN button
    And User verifies the content of the Action dropdown button
    When user clicks the copy button
    Then user confirms data rows are copied
    When User clicks the CSV tab
    Then User confirms that the CSV file for Business is exported to the local machine

  @SMSM-139-Verify-that-user-is-able-to-open-Analytics-page-of-the-selected-merchant @RegressionTest
  Scenario: Verify that User is able to open Analytics Page of the selected merchant
    When User clicks the Analytics tab option
    Then the User is redirected to the Analytics page
    And User verifies the Page Content sections
    
    
    
    
    
    
