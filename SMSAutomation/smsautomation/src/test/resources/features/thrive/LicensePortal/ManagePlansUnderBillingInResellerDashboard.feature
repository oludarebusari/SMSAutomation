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

  @[SMSM-210] @Verify-Admin-is-able-to-edit-an-existing-Plan-and-Add-a-Feature-Under-Reseller's-dashboard-in-Thrive-System
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

  @[SMSM-210] @Verify-Admin-is-able-to-create-a-plan
  Scenario: Verify Admin is able to create a plan
    When User clicks on Plan option from the Billing drop down options
    Then User is redirected to the Plan page
    When User clicks on the New button on the Manage Plans page
    Then User is redirected to the Create Plan page
    And User provides value for Plan Name
    And User provides value for Plan Description
    And User adds a Feature to the Plan
    And User clicks thd Save Plan button
    And User verifies that the plan is created

  @[SMSM-210] @Verify-that-a-Plan-cannot-be-deleted-if-the-"x"-is-clicked-on-"Delete-Plan"-confirmation-popup-for-"Delete-Plan"-action-when-navigated-from-Reseller-Dashboard
  Scenario: Verify that a plan cannot be deleted if the "x" is clicked on "Delete Plan" confirmation popup for "Delete Plan" action when navigated from Reseller Dashboard [C22416799]
    When User clicks on Plan option from the Billing drop down options
    Then User is redirected to the Plan page
    When User clicks the drop down action button
    Then User verifies the actions options available
    When User clicks the Delete option for the Manage Plan
    Then the Delete plan confirmation popup appears
    When User clicks on the close button
    Then the Delete Plan popup is closed and the plan is not deleted

  @[SMSM-210] @Verify-that-an-Active-plan-can-be-deactivated-by-clicking-on-Deactivate-in-the-Edit-drop-down-on-Manage-Plans-Reseller's-dashboard
  Scenario: Verify that an Active plan can be deactivated by clicking on Deactivate in the Edit drop down on Manage Plans Reseller's dashboard [C22416807]
    When User clicks on Plan option from the Billing drop down options
    Then User is redirected to the Plan page
    When User clicks the drop down action button
    Then User verifies the actions options available for an Active Plan
    When User clicks the Deactivate option for the Manage Plan
    Then the plan status changes to Inactive

  @[SMSM-210] @Verify-that-an-Inactive-plan-can-be-activated-by-clicking-on-Activate-in-the-Edit-drop-down-on-Manage-Plans-Reseller's-dashboard
  Scenario: Verify that an Inactive plan can be activated by clicking on Activate in the Edit drop down on Manage Plans Reseller's dashboard [C22416811]
    When User clicks on Plan option from the Billing drop down options
    Then User is redirected to the Plan page
    When User clicks the drop down action button
    Then User verifies the actions options available for an Inactive Plan
    When User clicks the Activate option for the Manage Plan
    Then the plan status changes to Active

  @[SMSM-210] @Verify-that-a-Plan-is-deleted-if-Delete"-is-clicked-on-"Delete-Plan"-confirmation-popup-for-"Delete"-action-from-Manage-Plans-page
  Scenario: Verify that a plan is deleted if "Delete" is clicked on "Delete Plan" confirmation popup for "Delete" action from Manage Plans page [C22416801]
    When User clicks on Plan option from the Billing drop down options
    Then User is redirected to the Plan page
    When User clicks the drop down action button
    Then User verifies the actions options available
    When User clicks the Delete option for the Manage Plan
    Then the Delete plan confirmation popup appears
    When User clicks the Delete button on the confirmation page
    Then User confirms that the plan is deleted

  @[SMSM-210] @Verify-Admin-is-able-to-search-the-Plans-by-entering-a-search-criteria-in-Search-box-and-clicking-Search-on-Manage-Plans-page
  Scenario: Verify Admin is able to search the Plans by entering a search criteria in Search box and clicking Search on Manage Plans page [C22416828]
    When User clicks on Plan option from the Billing drop down options
    Then User is redirected to the Plan page
    When User enters a valid search criteria in the search box at the top right of the page and clicks Search button
    Then The result of the search is displayed correctly
    When User enters an invalid search criteria and clicks Search button
    Then zero record is displayed

  @[SMSM-210] @Verify-the-help-on-Manage-Plans-under-Reseller-dashboard-page-by-clicking-the-Help-button 
  Scenario: Verify the help on Manage Plans under Reseller dashboard page by clicking the Help button [C22416829]
    When User clicks on Plan option from the Billing drop down options
    Then User is redirected to the Plan page
    When User clicks the Help button on the Manage Plans page
    Then the Plan Overview window is opened
    When User clicks the Next button on the Plans Overview window
    Then the Create A Plan window is opened
    When User clicks the Previous button on the Crate A Plan window
    Then User is navigated back to the Plan Overview window
    When User clicks on End Tour button
    Then Tour ends successfully

  @[SMSM-210] @Verify-functionality-of-sorting-and-show-entries-drop-down-on-Manage-Plans-page-for-Resellers-dashboard 
  Scenario: Verify functionality of sorting and show entries drop down on Manage Plans page for Resellers dashboard [C22416835]
    When User clicks on Plan option from the Billing drop down options
    Then User is redirected to the Plan page
    And User verifies the columns on the Manage Plans page
    When User clicks the Plan column
    Then User verifies that the records are sorted by Plan column in ascending order
    When User clicks on the Plan column again
    Then User verifies that the records are sorted by Plan column in descending order
    
 @[SMSM-210] @Verify-a-non-admin-user-cannot-access-the-Manage-Plans-page-both-through-UI-and-direct-URL-access-from-Billing-menu-for-Resellers-dashboard
 Scenario: Verify a non admin user cannot access the Manage Plans page both through UI and direct URL access from Billing menu for Resellers dashboard [C22416837]
 	 When User clicks on Plan option from the Billing drop down options
 	 Then User is redirected to the Plan page
 	 And User copies the current url from the Manage Plans page and sign out
 	 When User signs in with a user without admin access
 	 And User is redirected to the dashboard for the sign in user
 	 When User navigates to the URL copied earlier
 	 Then an error403 page is displayed instead of the Manage Plans page
 	 


