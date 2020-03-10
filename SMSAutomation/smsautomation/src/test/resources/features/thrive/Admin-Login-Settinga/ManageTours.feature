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

Feature: Manage tours under settings in admin dashboard for Thrive system

  Background: User logs in and navigates to the Thrive's Dashboard
    Given User Navigates to Thrive URL
    Then Thrive login page is displayed
    When User enters a valid username for thrive
    And User enters a valid password for thrive
    And User clicks the sign in button for thrve
    Then Thrive Dashboard page is displayed
    Given User clicks on settings on top menu bar
    Then the settings options are displayed
    Given User clicks on Tours under settings
    Then User is redirected to Tours page

 	@SMSM-185-Navigate-to-manage-tour-option @RegressionTest
  Scenario: Navigate to manage tour option under settings on thrive system.
    Given User clicks on settings on top menu bar
    Then the settings options are displayed
    Given User clicks on Tours under settings
    Then User is redirected to Tours page

 	@SMSM-185-Search-and-edit-existing-tour-in-the-edit @RegressionTest
  Scenario: Search and Edit existing tour in the list
    Given User types in a Tour name on the search textfield
    And User clicks the Search button
    Then the Tour is displayed on the page
    When User clicks the Edit button on the Tour
    Then the Edit Tour Page is opened
    And User edits the Tour Name
    And User edits the path
    And User selects additional Role from the dropdown
    And User navigate to a step and edit the step
    And User clicks the Save Tour button
    Then the tour is saved successfuland user confirmed the changes

  @SMSM-185-Deactivate-existing-tour-in-the-edit @RegressionTest
  Scenario: Deactivate existing tour in the list
    Given User types in a Tour name on the search textfield to open an active tour
    And User clicks the Search button for the active tour
    Then the searched Tour is displayed on the page
    When User clicks the dropdown button near edit
    Then a list of actions for activated tour were displayed
    When User clicks the Deactivate
    Then the Deactivate Tour pop up is opened
    When User clicks the Deactivate button on the Deactivate Tour popo up
    And User searches for the deactivated Tour 
    Then the status of the Tour changes to Inactive

  @SMSM-185-Activate-existing-deactivated-tour-in-the-list @RegressionTest
  Scenario: Activate existing deactivated tour in the list
    Given User types in a Tour name on the search textfield to open the deactivated tour
    And User clicks the Search button to bring up the deactivated tour
    Then the deactivated Tour is displayed on the page
    When User clicks the dropdown button near edit button for the deactivated tour
    Then a list of actions for deactivated tour is displayed
    And User clicks the Activate
    Then the Activate Tour pop up is opened
    When User clicks the Activate button on the Activate Tour popo up
    Then the status of the Tour changes to Active
    
   @SMSM-185-Verify-the-help-option-for-manage-tours-page @RegressionTest
   Scenario: Verify the Help option for Manage tours page
    Given User clicks on the Help button on top right of screen
    And Tour guide should starts successfully.
    When User clicks on Next button on Manage user group
    Then Tour guide should proceed to next step
    When User clicks on Previous button on Manage user group
    Then Tour guide is navigated to previous step
    When User clicks on End Tour button
    Then Tour ends successfully
    
   @SMSM-185-Edit-the-existing-tour-in-the-list-add-a-step
   Scenario: Edit the existing tour in the list - add a step
    Given User type a tour name to search in the search textfield 
    And User clicks the Search button
    Then the searched Tour is displayed 
    When User clicks the Edit button on the Tour displayed
    Then the Edit Tour Page is opened
    And User click on the Add Step button
    And User enters details for selector, title, path and message
    And User clicks the Save Tour button
    Then the tour is saved successful and user confirmed the changes
