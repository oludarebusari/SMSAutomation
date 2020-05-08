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
Feature: [SMSM-193] Verify the Stream page under Experience tab for Thrive system

  Background: User logs in to Thrive and navigate to Business Dashboard
    Given User Navigates to Thrive URL
    Then Thrive login page is displayed
    When User enters a valid username for thrive
    And User enters a valid password for thrive
    And User clicks the sign in button for thrve
    Then Thrive Dashboard page is displayed
    When User clicks on the Experience Menu option on the admin dashboard
    Then the Experience tab option is displayed
    When User clicks on the Streams option
    Then the Stream page under Experience is displayed

  @SMSM-193 @Verify-the-stream-page-is-opened-at-Experience-tab @RegressionTest
  Scenario: Verify the stream page is opened at Experience tab
    And User verifies the URL of the Stream page

  @SMSM-193 @Verify-the-"Reseller-and-Business"-Filter @RegressionTest 
  Scenario: Verify the "Reseller and Business" Filter
    And User verifies that the Reseller and Business filter is available
    When User clicks the Reseller and Business textfield
    Then a drop down displaying Busineses is opened
    When User selects Business or Reseller
    Then the selected Business or Reseller is displayed on the drop down text field
    When User clicks the close button beside a selected Business
    Then the Business option is deselected

  @SMSM-193 @Verify-the-"Platforms"-filter @RegressionTest
  Scenario: Verify the "Platforms" filter 
    And User verifies that the Platform filter is available
    When User clicks the close button beside a selected platform
    Then the Platform option is deselected
 
   @SMSM-193 @Verify-the-"Read"-filter @RegressionTest @OnlyMe
  Scenario: Verify the "Read" filter 
    And User verifies that the Read filter is available
    And User verifies that Unread streams are displayed by deafult
    When User clicks the Filter by Read button
    Then User is able to see all read streams 
    
    
    
    
    
    
    
    
