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

  @SMSM-134 @Edit-a-user-from-user-management @RegressionTest @OnlyMe
  Scenario: Edit a user from user management
    When user clicks on a User's Edit button under the Action column
    Then the Edit User page is displayed
    When user enters the information on the fields to be edited
    And user toggles on some settings on the Edit User page
    When user clicks the Save User button
    Then a notification that the details were saved successfully is displayed

  @SMSM-134 @Updated-user-changes-must-be-reflected-on-user-management-page @RegressionTest @OnlyMe
  Scenario: Updated user changes must be reflected on user management page
    When User clicks the Dashborad menu
    And User clicks the Users menu
    And User searched for the editted record
    Then User confirms the changes were saved correctly.

  @Revert-changes-to-User-record
  Scenario: Revert changes to user record
    When user clicks on a User's Edit button under the Action column
    Then the Edit User page is displayed
    And User revert the changes
