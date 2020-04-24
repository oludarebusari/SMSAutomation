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
Feature: View & edit manage settings & Language strings in admin dashboard for Thrive system

  Background: User logs in and navigates to the Thrive's Dashboard
    When User Navigates to Thrive URL
    Then Thrive login page is displayed
    When User enters a valid username for thrive
    And User enters a valid password for thrive
    And User clicks the sign in button for thrve
    Then Thrive Dashboard page is displayed
    When User clicks on settings on top menu bar
    Then the settings options are displayed

  @SMSM-170-Verify-manage-settings-page-options-through-settings-drop-down-in-Admin-dashboard @RegressionTest
  Scenario: Verify Manage Settings page options through Settings drop down in Admin dashboard [C22393564]
    When User clicks on Settings under Settings drop down
    Then User is redirected to Settings page
    And User verifies the columns on the Settings page

  @SMSM-170-Verify-user-is-able-to-edit-settings-details-within-the-settings-tabs @RegressionTest
  Scenario: Verify user is able to edit settings details within the settings tab [C22393572]
    When User clicks on Settings under Settings drop down
    Then User is redirected to Settings page
    When User types the Settings to edit on the search text field
    Then the setting is displayed on the page
    When User clicks the edit tab of the Setting to modify
    Then the Edit Settings window is opened
    And User edits all the text fields on the Edit Setting modal
    When User clicks on the Save Settings button
    Then user confirms the changes were saved correctly
    #Revert Changes to the Settings
    And User revert changes made to the setting

  @SMSM-170-Verify-the-help-button-functionality-within-settings @RegressionTest 
  Scenario: Validate the help button functionality within settings page [C22393597]
    When User clicks on Settings under Settings drop down
    Then User is redirected to Settings page
    And User verifies that the help button is displayed
    When User clicks on the Help button
    Then the Tour guide on the Settings page is opened
    When User clicks on Next button on Settings Management
    Then Tour guide should proceed to Search Settings window
    When User clicks on Previous button from the Search Settings windows
    Then Tour guide is navigated to Settings Management window
    When User clicks on End Tour button
    Then Tour ends successfully

  @SMSM-170-Verify-language-strings-page-through-settings-drop-down-in-Admin-dashboard @RegressionTest
  Scenario: Verify Language Strings page through Settings drop down in Admin dashboard [C22393580]
    When User clicks on Language Strings under Settings drop down
    Then User is redirected to Language String page
    And User verifies the columns on the Language String page

  @SMSM-170-Cancel-edit-language-strings-process @RegressionTest 
  Scenario: Cancel edit Language String process [C22444036]
    When User clicks on Language Strings under Settings drop down
    Then User is redirected to Language String page
    When User types the Language Strings to edit on the search text field
    Then the Language strings is displayed on the page
    When User clicks the edit button of the Language String to modify
    Then the Edit Language Strings window is opened
    And User edits all the text fields on the Edit Language Strings modal
    When User closes the Edit Language Strings windows without saving
    Then user confirms that the record is not changed

  @SMSM-170-Verify-user-is-able-to-edit-details-within-the-language-strings-tab @RegressionTest
  Scenario: Verify user is able to edit details within the Language strings tab [C22393583]
    When User clicks on Language Strings under Settings drop down
    Then User is redirected to Language String page
    When User types the Language Strings to edit on the search text field
    Then the Language strings is displayed on the page
    When User clicks the edit button of the Language String to modify
    Then the Edit Language Strings window is opened
    And User edits all the text fields on the Edit Language Strings modal
    When User clicks on the Save Settings button on the Edit Language Strings
    Then user confirms the changes to the Language Strings were saved correctly
    #Revert Changes to the Settings
    And User revert changes made to the language strings

  @SMSM-170-Verify-the-help-functionality-for-Language-Strings-page @RegressionTest 
  Scenario: Verify the Help functionality for Language Strings page [C22444035]
    When User clicks on Language Strings under Settings drop down
    Then User is redirected to Language String page
    And User verifies that the help button is displayed
    When User clicks on the Help button
    Then the Tour guide on the Language Strings page is opened
    When User clicks on Next button on Language Strings Management
    Then Tour guide should proceed to Search Language Strings window
    When User clicks on Previous button from the Search Language Strings windows
    Then Tour guide is navigated to Language Strings Management window
    When User clicks on End Tour button
    Then Tour ends successfully
