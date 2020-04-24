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
Feature: [SMSM-240] User is able to manage review settings in merchant portal for Thrive system

  Background: User logs in to Thrive and navigate to Business Dashboard
    Given User Navigates to Thrive URL
    Then Thrive login page is displayed
    When User enters a valid username for thrive
    And User enters a valid password for thrive
    And User clicks the sign in button for thrve
    Then Thrive Dashboard page is displayed
    When User navigates to Companies menu and clicks the Businesses option
    Then the user is redirected to the Manage Businesses page
    When User types the business name in the search field and clicks Search
    Then the Business is displayed
    When User navigates to the actions column of the Business for stream testing and clicks Sign In button
    Then User is logged into the Business and the business dashboard is opened

  @SMSM-136 @Verify-that-user-is-able-to-navigate-to-streams-page @RegressionTest
  Scenario: Verify that user is able to navigate to streams page
    When User clicks on the Experience Menu option
    Then the Experience options are displayed
    When User clicks the Streams option
    Then the Stream page is opened

  @SMSM-136 @Verify-that-user-is-able-to-navigate-to-streams-configuration-windows-pop-up @RegressionTest
  Scenario: Verify that user is able to navigate to Streams Configuration windows pops-up
    When User clicks on the Experience Menu option
    Then the Experience options are displayed
    When User clicks the Streams option
    Then the Stream page is opened
    And User verifies that Settings button is displayed
    When User clicks the Settings button
    Then a Settings configuration pop is opened
