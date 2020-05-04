#Author: your.email@your.domain.com
#Keywords Summary :
#User is assumed to have Admin access unless stated Otherwise
#Step Definition File - AddAndManageModulesSteps.java
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

  @SMSM-179 @Verify-the-navigation-to-Modules-page-under-Billing-menu @RegressionTest
  Scenario: Verify the navigation to Modules page under Billing menu  [C22389071]
    When User clicks on the Modules option
    Then user is redirected to the Modules page

  @SMSM-179 @Verify-the-navigation-to-"Module-Details"-page-by-clicking-New-button-on-Modules-page-or-clicking-Add-Modules-directly-from-Billing-menu @RegressionTest 
  Scenario: Verify the navigation to "Module Details" page by clicking New button on Modules page or clicking Add Modules directly from Billing menu  [C22393349]
    When User clicks on the Modules option
    Then user is redirected to the Modules page
    When User clicks on the New button on the Modules page
    Then the Create Module page is displayed
    And User navigates back to the Dasboard page
    When User clicks on the Billing Menu option on the dasboard
    And User clicks the Add Module option
    Then the Create Module page is displayed

  @SMSM-179 @Verify-the-UI-and-fields-available-on-"Module-Details"-page @RegressionTest
  Scenario: Verify the UI and fields available on "Module Details" page  [C22393350]
    When User clicks on the Modules option
    Then user is redirected to the Modules page
    When User clicks on the New button on the Modules page
    Then the Create Module page is displayed
    And User verifies the fields present on the Create Modules page
    And User verifies the details in the Feature panel
    And User verifies that a Save Module button is present on the page

  @SMSM-179 @Verify-the-validation-messages-on-"Module-Details"-page-when-required-information-is-missing-or-invalid @RegressionTest @OnlyMe
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
    
    
    