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
Feature: [SMSM-76] Thrive - Zeon Tab Options

  Background: User logs in to Thrive and navigate to Manage Alert option under settings on Thrive System
    Given User Navigates to Thrive URL
    Then Thrive login page is displayed
    When User enters a valid username for thrive
    And User enters a valid password for thrive
    And User clicks the sign in button for thrve
    Then Thrive Dashboard page is displayed
    When User clicks Zeon from the top menu bar
    Then the Zeon menu is expanded and Zeon options are displayed

  @[SMSM-224]-Verify-Sales-Appointment-List-Option-under-Zeon-tab-at-Thrive-system @RegressionTest
  Scenario: Verify Overall Appointments Set page through zeon option
    When User clicks on the Sales Appointment List option
    Then User is redirected to the Overall Appointments Set page
    When User clicks the date textfield, and specify a date and clicks the Apply button
    Then User get overall appointments set displayed

  @[SMSM-224]-Verify-user-is-on-Work-Orders-page @RegressionTest 
  Scenario: Verify user is on Work Orders page
    When User clicks on the Orders option
    Then User is redirected to the Orders page
    And User verifies that a list of orders are displayed

  @[SMSM-224]-Verify-the-available-menus-on-Work-Orders-page @RegressionTest
  Scenario: Verify the available menus on Work Order page
    When User clicks on the Orders option
    Then User is redirected to the Orders page
    Then User verifies the New button is available
    And User verifies that the Reseller textbox is available
    And User verifies that the Status filter is available
    And User verifies that Order field is available
    And User verifies Next-Previous options are available
    And User verifies the show n Entries ia available

  @[SMSM-224]-Verify-the-edit-page-to-add-new-order @RegressionTest
  Scenario: Verify the edit page to add new order
    When User clicks on the Orders option
    Then User is redirected to the Orders page
    When User clicks the New button on the Orders page
    Then the Create Order page is opened
    And User verifies the Order Details section is available
    And User verifies the Acquire Leads section is available
    And User verifies the Acquire button ia available

  @[SMSM-224]-Verify-the-validation-messages @RegressionTest @OnlyMe
  Scenario: Verify the Validation messages
    When User clicks on the Orders option
    Then User is redirected to the Orders page
    When User clicks the New button on the Orders page
    Then the Create Order page is opened
    When User clicks the Acquire Leads button while keeping blank all fields
    Then error message is displayed for mandatory fields
    When User enters valid data onto the madatory fields
    Then the error messages get hidden
    When Users leave a single mandatory field blank
    Then User verifies that the Acquire Leads button is disabled
    
    
    
    
    
    
