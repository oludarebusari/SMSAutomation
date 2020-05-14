#Author: your.email@your.domain.com
#Keywords Summary :

#User is assumed to have Admin access unless stated Otherwise
Feature: [SMSM-134] Manage (view, edit, delete) Users in Merchant's portal for Thrive system

  Background: User logs in to Thrive and navigate to Business Dashboard
    Given User Navigates to Thrive URL
    Then Thrive login page is displayed
    When User enters a valid username for thrive
    And User enters a valid password for thrive
    And User clicks the sign in button for thrve
    Then Thrive Dashboard page is displayed
    When User navigates to Companies menu and clicks the Businesses option
    Then the user is redirected to the Manage Businesses page
    When User navigates to the actions column of a Business and clicks Sign In button
    Then User is logged into the Business and the business dashboard is opened
    When User clicks the Users menu option
    Then User is redirected to User Management page

  @SMSM-134 @View-User--On-user-Management-page,-Confirm-all-existing-Users-are-visible @RegressionTest
  Scenario: On user Management page, Confirm all existing Users are visible
    And User verifies that existing users are displayed on the page

  @SMSM-134 @verify-user-should-be-able-to-view-all-entries-on-user-management-page @RegressionTest 
  Scenario: Verify user should able to view ALL entries on user management page.
    When User clicks the Show entries dropdown
    Then the dropdown should open successfully
    When User selects All option from the drop down
    Then All option was selected successfully
    And User verifies that all the records are displayed

  @SMSM-134 @verify-the-user-record-by-sorting-first-name-column @RegressionTest 
  Scenario: View the user record by sorting "First Name" column
    When User clicks the first name column
    Then the user records should be sorted in ascending order by firstname column
    When User clicks the first name column again
    Then the user records should be sorted in descending order by firstname column

  @SMSM-134 @verify-the-user-record-by-sorting-last-name-column @RegressionTest  
  Scenario: View the user record by sorting "Last Name" column
    When User clicks the last name column
    Then the user records should be sorted in ascending order by lastname column
    When User clicks the last name column again
    Then the user records should be sorted in descending order by lastname column

  @SMSM-134 @verify-the-user-record-by-sorting-status-column @RegressionTest 
  Scenario: View the user record by sorting "Status" column
    When User clicks the status column
    Then the user records should be sorted in ascending order by status column
    When User clicks the status column again
    Then the user records should be sorted in descending order by status column

  @SMSM-134 @verify-the-user-record-by-sorting-updated-column @RegressionTest 
  Scenario: View the user record by sorting "Updated" column
    When User clicks the updated column
    Then the user records should be sorted in ascending order by updated column
    When User clicks the updated column again
    Then the user records should be sorted in descending order by updated column

  @SMSM-134 @Edit-a-user-from-user-management @RegressionTest 
  Scenario: Edit a user from user management
    When user clicks on a User's Edit button under the Action column
    Then the Edit User page is displayed
    When user enters the information on the fields to be edited
    And user toggles on some settings on the Edit User page
    When user clicks the Save User button
    Then a notification that the details were saved successfully is displayed

  @SMSM-134 @Updated-user-changes-must-be-reflected-on-user-management-page @RegressionTest 
  Scenario: Updated user changes must be reflected on user management page
    When User clicks the Dashborad menu
    And User clicks the Users menu
    And User searched for the editted record
    Then User confirms the changes were saved correctly.

  @Revert-changes-to-User-record @RegressionTest 
  Scenario: Revert changes to user record
    When user clicks on a User's Edit button under the Action column
    Then the Edit User page is displayed
    And User revert the changes

  @Create-a-test-user @RegressionTest  
  Scenario: I want to create a test user
    When User clicks the New button
    Then the Create User page is opened
    When user types in the information for a test user and clicks the Save User button
    Then a notification that the user has been created is displayed

  @SMSM-134 @Clicking-on-cancel-on-delete-user-popup-should-not-delete-the-user @RegressionTest 
  Scenario: Clicking cancel on delete user popup should not delete the user.
    When user clicks on a User's dropdown button under the Action column
    Then the Actions option is displayed
    When User clicks the Delete option
    Then the Delete User modal is displayed
    When user clicks the Cancel button on the Delete User modal
    Then confirms that the user is not deleted

  @SMSM-134 @User-can-be-deleted-from-user-management-page @RegressionTest 
  Scenario: User can be deleted from user management page
    When user clicks on a User's dropdown button under the Action column
    Then the Actions option is displayed
    When User clicks the Delete option
    Then the Delete User modal is displayed
    When user clicks the Delete button on the Delete User modal
    Then a notification confirming successfully deletion is displayed.

  @SMSM-134 @Verfy-that-deleted-user-is-not-displayed-on-user-management-page @RegressionTest
  Scenario: Verify that deleted user is not displayed on user management page.
    When the deleted username is typed into the search field and the search button is clicked
    Then no result should be displayed.

  @SMSM-134 @User-search-by-different-search-parameters @RegressionTest 
  Scenario: User search by different search parameters
    When User enters first name of any user in the search field
    And User clicks the search button
    Then the search result record with the typed in first name is displayed successfully
    When User enters last name of the user in the search field
    And User clicks the search button
    Then the search result record with the typed in last name is displayed successfully

  @SMSM-134 @Help-tour-should-starts-on-clicking-help-button @RegressionTest 
  Scenario: Help tour should starts on clicking "Help" button
    When User clicks on Help button on the top right of the screen
    Then the Help Tour guide is displayed
    When User clicks on Next button on Manage user popup
    Then the tour guide should proceed to next step
    When User clicks on Previous button on Manage user popup
    Then the tour guide should be navigated to previous step

  @SMSM-134 @Help-tour-should-terminate-on-clicking-End-Tour-button @RegressionTest
  Scenario: Help tour should terminate on clicking "End Tour" button
    When User clicks on Help button on the top right of the screen
    Then the Help Tour guide is displayed
    When User clicks on End Tour button
    Then the tour guide closes successfully
    
