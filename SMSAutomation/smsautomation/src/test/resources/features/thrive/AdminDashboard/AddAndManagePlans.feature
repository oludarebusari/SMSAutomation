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

  @SMSM-146 @Verify-the-creation-of-a-new-Plan-from-"Plan-Details"-page @RegressionTest
  Scenario: Verify the creation of a new Plan from "Plan Details" page  [C22398128]
    When User clicks on Plan option
    Then user is redirected to the Manage Plans page
    When User clicks the New button on the Manage Plans page
    Then the Create Plan page is opened
    When User enters the details on a new plan and click the Save plan button
    Then a new plan with the entered details is created

  @SMSM-146 @Verify-Plan-can-be-edited-from-"Manage-Plans"-page-by-clicking-the-Edit-button-against-the-specified-Plan @RegressionTest
  Scenario: Verify Plan can be edited from "Manage Plans" page by clicking the Edit button against the specified Plan  [C22398311]
    When User clicks on Plan option
    Then user is redirected to the Manage Plans page
    And User verifies the Edit and dropdown button exist on a plan
    When User clicks the Edit button on a plan
    Then the Edit Plan page is opened
    When User moidifies few fields and clicks the Save Plan button
    Then an update alert notification is displayed
    And User confirms the modifications were saved correctly.

  @SMSM-146 @Verify-that-an-"Active"-plan-can-be-deactivated-by-clicking-on-Deactivate-in-the-Edit-dropdown @RegressionTest
  Scenario: Verify that an "Active" plan can be deactivated by clicking on Deactivate in the Edit dropdown [C22398323]
    When User clicks on Plan option
    Then user is redirected to the Manage Plans page
    When User clicks the drop down action button for the plan
    Then Deactivate and Delete action options for the plan are displayed
    When User clicks the Deactivate option on the plan
    Then the plan is deactivated and the Plan status has changed to "Inactive"
    When User clicks the drop down action button for the plan again
    Then Activate and Delete action options for the plan are displayed

  @SMSM-146 @Verify-that-an-"Inactive"-plan-can-be-activated-by-clicking-on-Activate-in-the-Edit-drop-down @RegressionTest
  Scenario: Verify that an "Inactive" plan can be activated by clicking on Activate in the Edit drop down [C22398337]
    When User clicks on Plan option
    Then user is redirected to the Manage Plans page
    And User verifies the status of the created plan is Inactive
    When User clicks the drop down button of the plan to activate
    Then Activate and Delete action options for the plan are displayed
    When User clicks the Activate button for the plan
    Then the plan is activated and the plan status has changed to Activate

  @SMSM-146 @Verify-clicking-'x'-icon-on-confirm-Delete-Plan-popup-closes-the-popup-and-does-not-delete-the-Plan @RegressionTest
  Scenario: Verify clicking 'x' icon on confirm Delete Plan popup closes the popup and does not delete the Plan [C22398360]
    When User clicks on Plan option
    Then user is redirected to the Manage Plans page
    When User clicks the drop down action button for the plan
    Then Deactivate and Delete action options for the plan are displayed
    When User clicks the Delete action option for the plan
    Then the Delete Plan window is opened
    When User clicks the Close button on the Delete Plan modal
    Then User verifies that the Plan is not delete

  @SMSM-146 @Verify-Deletion-of-an-existing-Plan-on-"Manage-Plans"-dashboard @RegressionTest 
  Scenario: Verify Deletion of an existing Plan on "Manage Plans" dashboard [C22398343]
    When User clicks on Plan option
    Then user is redirected to the Manage Plans page
    When User clicks the drop down action button for the plan
    Then Deactivate and Delete action options for the plan are displayed
    When User clicks the Delete action option for the plan
    Then the Delete Plan window is opened
    When User clicks the Delete button on the Delete Plan modal
    Then user confirms that the plan is deleted successfully
