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
Feature: [SMSM-125] View and access all options under Broadcast History in Merchant's portal (Engage system)

  Background: User is logged in and navigates to the Merchant's Dashboard
    Given User navigate to Engage url
    And User enters a valid username
    And User enters a valid password
    And User clicks on the login button
    Then User should be taken to Engage SMS home page
    When User clicks the Manage Resellers menubar option
    And User logs in to a reseller
    Then User is redirected to the Engaged Admin Dashboard page
    When User clicks Business tabs at the left side
    Then the Businesses page is opened
    And Users click Login tab for a merchant
    Then the user is redirected to a new window of Merchant's Dashboard
    When User clicks the broadcast option tab
    Then the Broadcast menu is opened
    And User verifies the available option on the KHS of the page
    When User clicks on Manage Broadcasts option
    Then User is redirected to the Manage Broadcasts page

  @SMSM-124-User-can-change-number-of-broadcast-messages-per-page @RegressionTest
  Scenario: User can change number of broadcast messages per page
    And User verifies that the pagination count dropdown is available
    When User clicks the pagination drop down
    Then the drop down is opened and user verifies the number of records per page
    When User selects a value from the drop down
    Then User confirms the value was selected successfully.

  @SMSM-124-User-can-search-the-broadcast-message @RegressionTest
  Scenario: User can search the broadcast message
    And User verifies that Search textfield is available on Manage Broadcast page
    When User enters some search string into the Search text box
    Then User verifies the search results is displayed based on search string
    When User enters some invalid search string
    Then a message indicating no matching records found is displayed

  @SMSM-124-User-can-export-broadcast-messages-in-csv-file @RegressionTest
  Scenario: User can export broadcast messages in CSV file
    And User verifies that CSV button is available on the page
    When user clicks the CSV button
    Then the Broadcast messages are exported to a CSV file

  @SMSM-124-User-can-sort-the-broadcast-messages-wrt-respective-column-header @RegressionTest
  Scenario: User can sort the broadcast messages w.r.t respective column header
    And User verifies the sort icon along column header
    When User clicks the sort icon for a column ie Message
    Then the records are sorted in ascending order by message column
    When User clicks the sort icon for message column again
    Then the records sorted in descending order by messages

  @SMSM-124-User-can-edit-existing-broadcast-message @RegressionTest
  Scenario: User can edit existing broadcast message
    When User clicks the Edit button corresponding to the broadcast to edit
    Then User is redirected to the Edit broadcast page
    And User edits a field from the page displayed
    And User clicks the Schedule broadcast button
    And User clicks the Schedule Broadcast button on Preview popup
    Then the editted message should be broadcasted successfully

  @Revert-changes-to-broadcast @RegressionTest
  Scenario: User can edit existing broadcast message
    When User clicks the Edit button corresponding to the changed broadcast
    Then User is redirected to the Edit broadcast page
    And User revert changes made to broadcast

  @SMSM-124-User-can-preview-broadcast-message-before-sending @RegressionTest
  Scenario: User can preview broadcast message before sending
    When User clicks the Edit button corresponding to the broadcast to edit
    Then User is redirected to the Edit broadcast page
    And User verifies that Preview Broadcast button
    When user clicks the Preview Broadcast button
    Then the Broadcast Preview window is opened

  @SMSM-124-Verify-valid-alert-is-been-shown-for-missing-record-while-editing-the-broadcast-message @RegressionTest
  Scenario: Verify valid alert is been shown for missing record while editing the broadcast message
    When User clicks the Edit button corresponding to a broadcast
    Then User is redirected to the Edit broadcast page
    When User removes the current campaign and clicks Schedule Broadcast button
    And User clicks the Schedule Broadcast button
    And User closes the Broadcast Preview window
    Then User verifies missing record message is displayed

  @SMSM-124-User-can-delete-a-broadcast-message @RegressionTest
  Scenario: User can delete a broadcast message
    When User verifies number of records and clicks on the Action dropdown button for a broadcast
    Then User verifies that Delete option is displayed
    When User clicks the Delete option for the broadcast
    And an alert window to confirm delete action is opened and User clicks OK
    Then the broadcast is deleted
