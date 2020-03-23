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
    

  @[SMSM-224]-Verify-Sales-Appointment-List-Option-under-Zeon-tab-at-Thrive-system @RegressionTest
  Scenario: Verify Overall Appointments Set page through zeon option
    When User clicks Zeon from the top menu bar
    Then the Zeon menu is expanded and Zeon options are displayed
    When User clicks on the Sales Appointment List option
    Then User is redirected to the Overall Appointments Set page
    When User clicks the date range from date picker and clicks the Apply button
    Then User get overall appointments set displayed
