#Author: Aclate QA
#User is assumed to have Admin access unless stated Otherwise
#Step Definition File - AdminResellerAndTerritoryReportPageSteps.java
Feature: [SMSM-146] Add & manage plans under billing in admin dashboard for Thrive system

  Background: User logs in to Thrive and navigate to Business Dashboard
    Given User Navigates to Thrive URL
    Then Thrive login page is displayed
    When User enters a valid username for thrive
    And User enters a valid password for thrive
    And User clicks the sign in button for thrve
    Then Thrive Dashboard page is displayed
    When User clicks on the Billing Menu option on the dashboard
    Then the Billing options are displayed

  @SMSM-146 @Verify-the-navigation-to-"Manage-Plans"-page-under-Billing-menu @RegressionTest
  Scenario: Verify the navigation to "Manage Plans" page under Billing menu  [C22397797]
    When User clicks on Plan option
    Then user is redirected to the Manage Plans page
    And User verifies the columns on the Manage Plans page

  @SMSM-146 @Verify-the-navigation-to-Plan-Details"-page-by-clicking-New-button-on-"Manage-Plans"-page-or-clicking-Add-Plan-directly-from-Billing-menu @RegressionTest 
  Scenario: Verify the navigation to Plan Details" page by clicking New button on "Manage Plans"  page or clicking Add Plan directly from Billing menu  [C22397826]
    When User clicks on Plan option
    Then user is redirected to the Manage Plans page
    When User clicks the New button on the Manage Plans page
    Then the Create Plan page is opened
    When User clicks Billing menu and clicks Plan
    Then user is redirected to the Manage Plans page
    When User clicks Billing menu and click Add Plan option

  @SMSM-146 @Verify-the-UI-and-fields-available-on-"Plan-Details"-page @RegressionTest
  Scenario: Verify the UI and fields available on "Plan Details" page  [C22397859]
    When User clicks on Plan option
    Then user is redirected to the Manage Plans page
    When User clicks the New button on the Manage Plans page
    Then the Create Plan page is opened
    And User verifies the fields available on the Create Plan page
    

   @SMSM-146 @Verify-the-creation-of-a-new-Plan-from-"Plan-Details"-page @RegressionTest @OnlyMe
  Scenario: Verify the creation of a new Plan from "Plan Details" page  [C22398128]
    When User clicks on Plan option
    Then user is redirected to the Manage Plans page
    When User clicks the New button on the Manage Plans page
    Then the Create Plan page is opened
    When User enters the details on a new plan and click the Save plan button
    Then a new plan with the entered details is created
    