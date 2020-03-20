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
Feature: [SMSM-184] Manage Alerts under settings in admin dashboard for Thrive system

  Background: User logs in to Thrive and navigate to Manage Alert option under settings on Thrive System
    Given User Navigates to Thrive URL
    Then Thrive login page is displayed
    When User enters a valid username for thrive
    And User enters a valid password for thrive
    And User clicks the sign in button for thrve
    Then Thrive Dashboard page is displayed
    When User clicks settings from the top menu bar
    Then the Settings menu is expanded and settings options are displayed
    When User clicks on Alert option
    Then the Manage Alert page is displayed

  @SMSM-184 @Edit-existing-alert-in-the-list @RegressionTest @OnlyMe
  Scenario: Edit existing alert in the list
    When User types in an Alert text on the search box and clicks search
    Then the Alert is displayed on the Manage Alert paage
    When User clicks the Edit button button beside the displayed Alert
    Then the Edit Alert window is displayed
    When User makes modification to the Alert and clicks Save Alert button
    Then User confirms the changes are saved correctly

  @SMSM-184 @Renew-existing-alert-in-the-list @RegressionTest 
  Scenario: Renew Existing alert in the list
    When User types in an Alert text on the search box for alert to renew and clicks search
    Then the Alert to be renewed is displayed on the Manage Alert paage
    When User clicks the Edit button button beside the displayed Alert
    Then the Edit Alert window is displayed
    When User clicks the Date text field
    Then the Date window is displayed
    When User specifies a date in the future and clicks Apply button
    And User clicks the Save Alert button on the Edit Alert page
    Then user confirms that the status of the lert is now active

  Scenario: Delete Existing Alert in the list
    When User types in an Alert text on the search box for alert to renew and clicks search
    Then the Alert to be renewed is displayed on the Manage Alert paage
 		When User clicks the action dropdown button
 		Then the dropdown action options are displayed
 		When User clicks the Delete button
 		And User clicks the Detele button on the Delete Alert window
 		Then the Alert is deleted and User is redirected to the Manage Alert page
 		When User search for the deleted Alert
 		Then zero record is displayed


  Scenario Outline: Deactivate Existing alert in the list
    When User clicks settings from the top menu bar
    Then the Settings menu is expanded and settings options are displayed
    When User clicks on Alert option
    Then the Manage Alert page is displayed

  Scenario Outline: Activate existing alert in the list
    When User clicks settings from the top menu bar
    Then the Settings menu is expanded and settings options are displayed
    When User clicks on Alert option
    Then the Manage Alert page is displayed
