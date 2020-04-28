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

  @SMSM-240 @Verify-that-user-is-able-to-navigate-to-streams-page @RegressionTest
  Scenario: Verify that user is able to navigate to streams page [C22431840]
    When User clicks on the Experience Menu option
    Then the Experience options are displayed
    When User clicks the Streams option
    Then the Stream page is opened

  @SMSM-240 @Verify-that-user-is-able-to-navigate-to-streams-configuration-windows-pop-up @RegressionTest
  Scenario: Verify that user is able to navigate to Streams Configuration windows pops-up [C22431852]
    When User clicks on the Experience Menu option
    Then the Experience options are displayed
    When User clicks the Streams option
    Then the Stream page is opened
    And User verifies that Settings button is displayed
    When User clicks the Settings button
    Then a Settings configuration pop is opened
    And User verifies the three tabs on the settings window

  @SMSM-240 @Verify-that-user-is-able-to-set-Reviews-System-value-under-Review-Settings-tab @RegressionTest 
  Scenario: Verify that user is able to set Reviews System value under Review Settings tab [C22431860]
    When User clicks on the Experience Menu option
    Then the Experience options are displayed
    When User clicks the Streams option
    Then the Stream page is opened
    And User verifies that Settings button is displayed
    When User clicks the Settings button
    Then a Settings configuration pop is opened
    When User Clicks the Reviews Settings tab
    Then the Review Settings tab is opened
    When User hovers on Review System
    Then the help description of Review System is displayed
    And User verifies the two button available for Review System
    When User clicks on the Reviews Disabled button
    Then the Review is Disabled
    When User clicks the Review Enabled button
    Then the Review is Enabled

  @SMSM-240 @Verify-that-user-is-able-to-set-send-review-request-after-x-checkins @RegressionTest 
  Scenario: Verify that user is able to set Send Review Request after X checkins value under Review Settings tab [C22434562]
    When User clicks on the Experience Menu option
    Then the Experience options are displayed
    When User clicks the Streams option
    Then the Stream page is opened
    And User verifies that Settings button is displayed
    When User clicks the Settings button
    Then a Settings configuration pop is opened
    When User Clicks the Reviews Settings tab
    Then the Review Settings tab is opened
    And User verifies that Send Review Requestafter x checkins textbox is available
    And User enters a value into the Send Review Requestafter x checkins textbox
    When User hovers over the Send Review Requestafter x checkins title
    Then the help description for Send Review Requestafter x checkins is displayed

  @SMSM-240 @Verify-that-user-is-able-to-set-checkin-review-request-value-under-Review-settings-tab @RegressionTest
  Scenario: Verify that user is able to set Checkin Review Request value under Review Settings tab [C22434551]
    When User clicks on the Experience Menu option
    Then the Experience options are displayed
    When User clicks the Streams option
    Then the Stream page is opened
    And User verifies that Settings button is displayed
    When User clicks the Settings button
    Then a Settings configuration pop is opened
    When User Clicks the Reviews Settings tab
    Then the Review Settings tab is opened
    And User verifies that the CheckIn Review Request dropdown is available
    And User selects a value from the dropdown for CheckIn Review Request
    When User hovers over the Checkin Review Request title
    Then the help description for Checkin Review Request is displayed
 
  @SMSM-240 @Verify-that-user-is-able-to-set-review-submissions-automatic-response-method-value-under-Review-settings-tab @RegressionTest @OnlyMe
  Scenario: Verify that user is able to set Review Submissions Automatic Response Method value under Review Settings tab [C22434554]
    When User clicks on the Experience Menu option
    Then the Experience options are displayed
    When User clicks the Streams option
    Then the Stream page is opened
    And User verifies that Settings button is displayed
    When User clicks the Settings button
    Then a Settings configuration pop is opened
    When User Clicks the Reviews Settings tab
    Then the Review Settings tab is opened
    And User verifies that the Review Submissions Automatic Response Method dropdown is available
    And User selects a value from the dropdown for Review Submissions Automatic Response
    When User hovers over the Review Submissions Automatic Response Method dropdown title
    Then the help description for Review Submissions Automatic Response Method dropdown is displayed
    
    
