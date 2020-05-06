#Author: your.email@your.domain.com
#Keywords Summary :

#User is assumed to have Admin access unless stated Otherwise
#Step Definition file - ManageTourSteps.java

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
  Scenario: Navigate to manage tour option under settings on thrive system [C22331428]
    And User verifies the URL of the Tours page

  @SMSM-185-Search-and-edit-existing-tour-in-the-edit @RegressionTest
  Scenario: Search and Edit existing tour in the list [C22336695]
    When User types in a Tour name on the search textfield
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

  @SMSM-185-Cancel-Deactivate-existing-tour-in-the-list @RegressionTest
  Scenario: Cancel Deactivate existing tour in the list [C22336766]
    Given User types in a Tour name on the search textfield to open an active tour
    And User clicks the Search button for the active tour
    Then the searched Tour is displayed on the page
    When User clicks the dropdown button near edit
    Then a list of actions for activated tour were displayed
    When User clicks the Deactivate
    Then the Deactivate Tour pop up is opened
    When User closes the Deactivate Confirmation window
    Then User verifies that the tour is not deactivated

  @SMSM-185-Deactivate-existing-tour-in-the-edit @RegressionTest
  Scenario: Deactivate existing tour in the list [C22336713]
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

  @SMSM-185-Cancel-Activate-the-existing-deactivate-tour-in-the-list @RegressionTest
  Scenario: Cancel Activate the existing deactivate tour in the list [C22336767]
    Given User types in a Tour name on the search textfield to open the deactivated tour
    And User clicks the Search button to bring up the deactivated tour
    Then the deactivated Tour is displayed on the page
    When User clicks the dropdown button near edit button for the deactivated tour
    Then a list of actions for deactivated tour is displayed
    And User clicks the Activate
    Then the Activate Tour pop up is opened
    When User closes the Activate Confirmation window
    Then User verifies that the tour is not acctivated

  @SMSM-185-Activate-existing-deactivated-tour-in-the-list @RegressionTest
  Scenario: Activate existing deactivated tour in the list [C22336715]
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
  Scenario: Verify the Help option for Manage tours page [C22336727]
    When User clicks on the Help button on top right of screen
    And Tour guide should starts successfully.
    When User clicks on Next button on Manage user group
    Then Tour guide should proceed to next step
    When User clicks on Previous button on Manage user group
    Then Tour guide is navigated to previous step
    When User clicks on End Tour button
    Then Tour ends successfully

  @SMSM-185-Edit-the-existing-tour-in-the-list-add-a-step @RegressionTest
  Scenario: Edit the existing tour in the list - add a step [C22336741]
    When User types a tour name to search in the search textfield
    And User clicks the Search button
    Then the searched Tour is displayed
    When User clicks the Edit button on the Tour displayed
    Then the Edit Tour Page is opened
    And User click on the Add Step button
    And User enters details for selector, title, path and message
    And User clicks the Save Tour button
    Then the tour is saved successful and user confirmed the changes

  @SMSM-185-Edit-the-existing-tour-in-the-list-remove-a-step @RegressionTest
  Scenario: Edit the existing tour in the list - remove a step [C22336741]
    When User searches for a tour to edit
    Then the searched Tour is successfully displayed
    When User clicks the Edit button to modify the tour
    Then the Edit Tour Page is opened
    And User click on the Remove Step button
    And Click the Save Tour button

  @SMSM-185-Create-a-Tour @RegressionTest
  Scenario: Create a Tour
    When User clicks on the New button
    And User enters the details of a new Tour
    And User clicks the Save Tour button

  @SMSM-185-Edit-an-existing-tour-in-the-list-by-removing-the-role-assigned-to-the-tour @RegressionTest
  Scenario: Edit an existing tour in the list by removing the role assigned to the tour [C22336747]
    When User types the tour name to edit into the Search textField
    And User clicks the Search button
    Then the tour is displayed on the tour page
    When User clicks the tour's Edit button
    Then the Edit Tour Page is opened
    When User clicks the Remove role button
    And User clicks the Save Tour button
    Then user confirms the role is removed from the tour

  @SMSM-185-Verify-the-Help-Option-for-Edit-Tour-page @RegressionTest 
  Scenario: Verify the Help option for Edit Tour page  [C22336770]
    When User types the tour name to edit into the Search textField
    And User clicks the Search button
    Then the tour is displayed on the tour page
    When User clicks the tour's Edit button
    Then the Edit Tour Page is opened
    When User clicks on the Help button on top right of screen
    Then the Editing Guided Tour window is opened.
    When User clicks on Next button
    Then Tour guide should proceed to the title window
    When User clicks on Next button
    Then Tour guide should proceed to the roles window
    When User clicks on the previous button
    Then Tour guide is navigated to previous window
    When User clicks on End Tour button
    Then Tour ends successfully

  @SMSM-185-Cancel-Delete-existing-tour-process @RegressionTest
  Scenario: Cancel Delete existing tour process [C22336765]
    When User types the tour name to detele into the Search textField
    And User clicks the Search button
    Then the tour is displayed on the tour page
    When User clicks the tour's drop down button
    Then a list of actions that can be performed on the tour is displayed
    When User clicks the Delete option of the tour to delete
    Then the Delete confirmation window is opened
    When User closes the Delete Confirmation window
    Then User verifies that the tour is not deleted

  @SMSM-185-Delete-existing-tour-in-the-list @RegressionTest
  Scenario: Delete existing tour in the list [C22336765]
    When User types the tour name to detele into the Search textField
    And User clicks the Search button
    Then the tour is displayed on the tour page
    When User clicks the tour's drop down button
    Then a list of actions that can be performed on the tour is displayed
    When User clicks the Delete option of the tour to delete
    Then the Delete confirmation window is opened
    When User clicks the Delete button on the confirmation window
    Then User verifies that the tour is deleted
