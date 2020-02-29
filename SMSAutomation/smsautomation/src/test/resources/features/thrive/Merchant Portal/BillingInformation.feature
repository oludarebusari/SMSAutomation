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
Feature: [SMSM-135] View invoice, edit payment info & billing information in Merchant's portal for Thrive system

  Background: User logs in to Thrive and navigate to Business Dashboard
    Given User Navigates to Thrive URL
    Then Thrive login page is displayed
    When User enters a valid username for thrive
    And User enters a valid password for thrive
    And User clicks the sign in button for thrve
    Then Thrive Dashboard page is displayed
    When User navigates to Companies menu and clicks the Businesses option
    Then the user is redirected to the Manage Businesses page
    When User navigates to the actions column of a Business and clicks Sign In button
    Then User is logged into the Business and the business dashboard is opened
    When User clicks the Billing menu option
    Then User is redirected to Billing page

  @SMSM-135 @Validate-the-options-in-Billing-page @RegressionTest
  Scenario: Validate the options in Billing page
    And User verifies the Current Balance Tile
    And User verifies the Invoice Method Payment Tile
    And User verifies the Billing information Tile
    And User verifies that Invoice History is present

  @SMSM-135 @View-the-Invoice-and-Current-Balance @RegressionTest
  Scenario: View the Invoice and Current Balance
    And User verifies that the View Invoice link is present
    When User clicks on View Invoice link
    Then the View Invoice page is opened
    And User verifies One TimePrice, Recurring price and Date is present on the page
    And User verifies the Current Balance on the Invoice page
