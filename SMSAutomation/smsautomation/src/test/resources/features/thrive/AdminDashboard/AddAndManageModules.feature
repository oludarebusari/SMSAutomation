#Author: your.email@your.domain.com
#Keywords Summary :
#User is assumed to have Admin access unless stated Otherwise
#Step Definition File - AddAndManageModulesSteps.java
@thrive @RegressionTest 
Feature: [SMSM-147] Add & manage Modules under billing in admin dashboard for Thrive system

  Background: User logs in to Thrive and navigate to Business Dashboard
    Given User Navigates to Thrive URL
    Then Thrive login page is displayed
    When User enters a valid username for thrive
    And User enters a valid password for thrive
    And User clicks the sign in button for thrve
    Then Thrive Dashboard page is displayed
    When User clicks on the Billing Menu option on the dashboard
    Then the Billing options are displayed

  @SMSM-147 @Verify-the-navigation-to-Modules-page-under-Billing-menu 
  Scenario: Verify the navigation to Modules page under Billing menu  [C22389071]
    When User clicks on the Modules option
    Then user is redirected to the Modules page

  @SMSM-147 @Verify-the-navigation-to-"Module-Details"-page-by-clicking-New-button-on-Modules-page-or-clicking-Add-Modules-directly-from-Billing-menu 
  Scenario: Verify the navigation to "Module Details" page by clicking New button on Modules page or clicking Add Modules directly from Billing menu  [C22393349]
    When User clicks on the Modules option
    Then user is redirected to the Modules page
    When User clicks on the New button on the Modules page
    Then the Create Module page is displayed
    And User navigates back to the Dasboard page
    When User clicks on the Billing Menu option on the dasboard
    And User clicks the Add Module option
    Then the Create Module page is displayed

  @SMSM-147 @Verify-the-UI-and-fields-available-on-"Module-Details"-page 
  Scenario: Verify the UI and fields available on "Module Details" page  [C22393350]
    When User clicks on the Modules option
    Then user is redirected to the Modules page
    When User clicks on the New button on the Modules page
    Then the Create Module page is displayed
    And User verifies the fields present on the Create Modules page
    And User verifies the details in the Feature panel
    And User verifies that a Save Module button is present on the page

  @SMSM-147 @Verify-the-validation-messages-on-"Module-Details"-page-when-required-information-is-missing-or-invalid 
  Scenario: Verify the validation messages on "Module Details" page when required information is missing or invalid  [C22393350]
    When User clicks on the Modules option
    Then user is redirected to the Modules page
    When User clicks on the New button on the Modules page
    Then the Create Module page is displayed
    When User clicks on the Save Module button without entering any value
    Then validation error is displayed for Module name and description
    When User enters a short value for Module Name and description and clicks Save Module button
    Then verify that validation error is displayed for Module name field
    When User enters a valid value for Module name, description, clicks the add feature button and clicks save module
    Then verify that validation error is displayed for the feature text field.

  @SMSM-147 @Verify-the-creation-of-a-new-Module-from-"Module-Details"-page  
  Scenario: Verify the creation of a new Module from "Module Details" page  [C22393352]
    When User clicks on the Modules option
    Then user is redirected to the Modules page
    When User clicks on the New button on the Modules page
    Then the Create Module page is displayed
    And user enter values for Module name, description, categories and icon
    When user clicks the add sub module button under Feature
    Then the Feature section is expanded
    And User enters value for feature, price and Interval details
    When User clicks the Save Module button
    Then a success notification is displayed on the module page
    And user confirms that the module is created

  @SMSM-147 @Verify-the-"Module-Details"-added-on-Modules-page-once-a-Module-is-created 
  Scenario: Verify the "Module Details" added on Modules page once a Module is created  [C22393353]
    When User clicks on the Modules option
    Then user is redirected to the Modules page
    And User verifies that modules are displayed in individual tiles
    And User verifies the details on a Module tile
    And User verifies the action available on a Module Tile

  @SMSM-147 @Verify-Modules-can-be-edited-from-"Modules"-page-by-clicking-the-Edit-button-against-the-specified-Module-tile  
  Scenario: Verify Modules can be edited from "Modules" page by clicking the Edit button against the specified Module tile [C22393360]
    When User clicks on the Modules option
    Then user is redirected to the Modules page
    When User click the Edit  button on a Module tile
    Then the Edit Module page is opened
    And User edits the Module Name, Description, categories, icon and Feature Details
    When User clicks Save Module button
    Then an updated notification is displayed on the module page
    And user confirms that the module is updated

  @SMSM-147 @Verify-that-Module-cannot-be-deleted-if-"x"-is-clicked-on-"Delete-Module"-confirmation-popup-for-"Delete-Module"-action 
  Scenario: Verify that Module cannot be deleted if "x" is clicked on "Delete Module" confirmation popup for "Delete Module" action [C22393368]
    When User clicks on the Modules option
    Then user is redirected to the Modules page
    When User click the module action dropdown button on a Module tile
    Then the module action option is displayed
    When User clicks on the Delete Module option
    Then a Delete Module confirmation window is opened
    When User clicks on the X button on the Delete Module window pop up
    Then User verifies that the module is not deleted

  @SMSM-147 @Verify-that-Module-is-deleted-if-"Delete"-is-clicked-on-"Delete-Module"-confirmation-popup-for-"Delete-Module"-action  
  Scenario: Verify that Module is deleted if "Delete" is clicked on "Delete Module" confirmation popup for "Delete Module" action [C22393375]
    When User clicks on the Modules option
    Then user is redirected to the Modules page
    When User click the module action dropdown button on a Module tile
    Then the module action option is displayed
    When User clicks on the Delete Module option
    Then a Delete Module confirmation window is opened
    When User clicks on the Delete button on the Delete Module window pop up
    Then User verifies that the module is deleted

  @SMSM-147 @Verify-the-"Help"-on-Modules-page-by-clicking-the-Help-button  
  Scenario: Verify the "Help" on Modules page by clicking the Help button [C22393378]
    When User clicks on the Modules option
    Then user is redirected to the Modules page
    When User clicks the Help button on the Modules page
    Then the tour guide for the modules page is opened
    When User clicks the Next button on the Modules window pop
    Then the Add A Module help window is opened
    When User clicks the previous button on Add A Module window
    Then the help guide navigates back to Modules help window
    When User clicks on End Tour button
    Then the tour guide closes successfully

  @SMSM-147 @Verify-the-"Help"-on-"Module-Details"-page-by-clicking-the-Help-button  
  Scenario: Verify the "Help" on "Module Details" page by clicking the Help button [C22393379]
    When User clicks on the Modules option
    Then user is redirected to the Modules page
    When User clicks on the New button on the Modules page
    Then the Create Module page is displayed
    When User clicks the Help button on the Create Modules page
    Then the tour guide for the Create Modules page is opened
    When User clicks the Next button on the Name window pop
    Then the Description help window is opened
    When User clicks the previous button on Description window
    Then the help guide navigates back to Name help window
    When User clicks on End Tour button
    Then the tour guide closes successfully
