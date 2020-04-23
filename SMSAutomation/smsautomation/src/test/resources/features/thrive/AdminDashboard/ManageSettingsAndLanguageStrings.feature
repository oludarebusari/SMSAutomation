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

  @SMSM-170-Verify-manage-settings-page-options-through-settings-drop-down-ing-Admin-dashboard @RegressionTest
  Scenario: Verify Manage Settings page options through Settings drop down in Admin dashboard [C22393564]
    When User clicks on Settings under Settings drop down
    Then User is redirected to Settings page
    And User verifies the columns on the Settings page

  @SMSM-170-Verify-user-is-able-to-edit-settings-details-within-the-settings-tabs @RegressionTest @OnlyMe
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
    
    
