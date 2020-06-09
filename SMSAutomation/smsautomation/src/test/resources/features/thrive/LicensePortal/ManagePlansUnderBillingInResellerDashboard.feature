#Author: your.email@your.domain.com
#Keywords Summary:
#Step Definition File - ManagePlanUnderBillingInResellerDashboard.java
@thrive @RegressionTest
Feature: [SMSM-210] Manage plans (Edit, delete, deactivate & activate) under billing in Licensees dashboard

  Background: User logs in to Thrive and navigate to Business Dashboard
    Given User Navigates to Thrive URL
    Then Thrive login page is displayed
    When User enters a valid username for thrive
    And User enters a valid password for thrive
    And User clicks the sign in button for thrve
    Then Thrive Dashboard page is displayed
    When User clicks on Companies
    Then the Companies options are displayed
    When User clicks on Resellers
    Then the Resellers Page is opened
    When User selects a Reseller and Clicks Sign In button
    Then the Resellers dashboard is opened
    When User clicks on the Billing menu option
    Then the Billing drop down options are displayed

  @[SMSM-210] @Navigate-to-"Manage-Plans"-under-Licensees's-dashboard-in-Thrive-system,-and-verify-admin-is-able-to-see-all-existing-Plans
  Scenario: Navigate to "Manage Plans" under Licensees's dashboard in Thrive system, and verify admin is able to see all existing Plans [C22416780]
    When User clicks on Plan option from the Billing drop down options
    Then User is redirected to the Plan page

  @[SMSM-210] @Verify-Admin-is-able-to-edit-an-existing-plan-under-Resellers-dashboard-in-Thrive-System
  Scenario: Verify Admin is able to edit an existing plan under Resellers dashboard in Thrive System [C22416785]
    When User clicks on Plan option from the Billing drop down options
    Then User is redirected to the Plan page
    When User clicks the edit button besides a plan
    Then the Edit plan page is opened
    And User edits the Plan name text value
    And User edits the Plan description text value
    And User edits Status value
    When User clicks on the Save Plan button
    Then the update notification alert is displayed
    And User verifies the changes made.
    #Revert Changes made to Plans details
    And User reverted changes made to plans details

  @[SMSM-210] @Verify-Admin-is-able-to-edit-an-existing-Plan-and-Add-a-Feature-Under-Reseller's-dashboard-in-Thrive-System @OnlyMe
  Scenario: Verify Admin is able to edit an existing Plan and Add a Feature under Reseller's dashboard in Thrive System [C22416796]
    When User clicks on Plan option from the Billing drop down options
    Then User is redirected to the Plan page
    When User clicks the edit button besides a plan
    Then the Edit plan page is opened
    And User clicks the add icon under feature to add a feature
    And User enters feature, One-Time Price, Recurring Price and Start Date
    When User clicks the Save Plan button
    Then the update notification alert is displayed
    And User verifies the added feature
   #User Removes the added feature
   And User removes the added feature
