#Author: your.email@your.domain.com
#Keywords Summary :
#Step Definition File - AddPageTemplatesUnderSettingsSteps.java
@thrive @RegressionTest
Feature: [SMSM-207] View and edit settings in Licensees's portal for Thrive system

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

  @[SMSM-207] @Verify-the-Help-on-"Manage-Settings"-page-by-clicking-the-Help-button
  Scenario: Verify the Help on "Manage Settings" page by clicking the Help button
    When User clicks on the settings Menu and clicks the Setting option
    Then User is redirected to the Settings page
    When User clicks the Help button on the Settings page
    Then the Settings Management help tour window appears
    When User clicks the Next button on the Settings Management help window
    Then the Search Settings window is displayed
    When User clicks the previous button on the Search Settings Templates window
    Then User is navigated to the Settings Management window
    When User clicks on End Tour button
    Then Tour ends successfully

  @[SMSM-207] @Verify-the-Help-on-"Manage-Settings"-page-by-clicking-the-Help-button
  Scenario: Verify the Help on "Manage Settings" page by clicking the Help button
    When User clicks on the settings Menu and clicks the Setting option
    Then User is redirected to the Settings page
    And User verifies that the Search text box is displayed
    And User verifies that the Search button is displayed
    When User types in a group name into the Search box and clicks Search button
    Then the Settings records are displayed

  @[SMSM-207] @Verify-the-functionality-of-sorting-and-Show-entries-dropdown-and-pagination-on-Manage-Settings-page
  Scenario: Verify the functionality of sorting and Show entries dropdown and pagination on Manage Settings page
    When User clicks on the settings Menu and clicks the Setting option
    Then User is redirected to the Settings page
    And User verifies the arrows icon on the Column heading
    When User clicks the Title column header
    Then data is sorted in ascending order
    When User clicks on the Title column header again
    Then data is sorted in descending order
    And User verifies the Show Entries section is displayed
    When User clicks on the Next button
    Then User verifies that button two is selected
    When User selects All from Show entries drop down
    Then User verfies that all the records are displayed on one page

  @[SMSM-207] @Verify-Admin-can-edit-settings-from-the-available-list-from-Companies-menu-for-Licensees
  Scenario: Verify Admin can edit settings from the available list from Companies menu for Licensees
    When User clicks on the settings Menu and clicks the Setting option
    Then User is redirected to the Settings page
    And User verifies the arrows icon on the Column heading
    And User verifies the edit button for each setting
    When User clicks on the Edit button for a Setting
    Then the Edit Setting pop up window is opened
    When User enters a value and click the close button
    Then User verifies that the selected settings is not updated
    When User clicks on the Edit button for a Setting
    Then the Edit Setting pop up window is opened
    When User enters a value and click the Update Settings button
    Then User verifies the value field is updated
    #Revert Changes
    And User revert the changes to the Setting record

  @[SMSM-207] @Verify-Admin-can-edit-Email-Templates-from-the-available-list-from-Companies-menu-for-Licensees
  Scenario: Verify Admin can edit Email Templates from the available list from Companies menu for Licensees
    When User clicks on the settings Menu and clicks the Setting option
    Then User is redirected to the Settings page
    When User clicks the settings Menu and clicks the Message Templates
    Then User is redirected to the Message Templates
    And User verifies the Edit buttons for Message Templates
    When User selects a Message Template and clicks on Edit button
    Then the Message Templates opens in edit mode
    When User edits some fields and clicks on the close button
    Then User verifies that the fields were not updated
    When User selects a Message Template and clicks on Edit button
    Then the Message Templates opens in edit mode
    When User edits some fields and clicks on the Save Settings button
    Then all updated fields were updated successfully
    #Revert Changes
    And User revert the changes to the Message Templates record
    
   @[SMSM-207] @Verify-the-Help-on-"Email-Templates"-page-by-clicking-the-Help-button @OnlyMe
  Scenario: Verify the Help on "Email Templates" page by clicking the Help button [C22403688]
    When User clicks on the settings Menu and clicks the Setting option
    Then User is redirected to the Settings page
    When User clicks the settings Menu and clicks the Message Templates
    Then User is redirected to the Message Templates
    When User clicks the Help button on the Email Templates page
    Then the Email Templates help tour is opened
    When User clicks the Next button on the Message Template Management window
    Then the Search Templates window is displayed
    When User clicks the previous button on the Search Templates window
    Then User is navigated to the Message Template Management window
    When User clicks on End Tour button
    Then Tour ends successfully
    

  @[SMSM-207] @Verify-admin-is-able-to-search-Specific-Template-by-entering-a-search-criteria-in-Search-box-and-clicking-Search-tab
  Scenario: Verify admin is able to search Specific Template by entering a search criteria in Search box and clicking Search tab
    When User clicks on the settings Menu and clicks the Setting option
    Then User is redirected to the Settings page
    When User clicks the settings Menu and clicks the Message Templates
    Then User is redirected to the Message Templates
    And User verifies the Search textbox and the Search button
    When User enters a text in the Search box and clicks on the Search butoon
    Then records are displayed per the search criterion

  @[SMSM-207] @Verify-the-navigation-to-"Language-Strings"-page-under-Settings-menu-from-Companies-menu-for-Licensees
  Scenario: Verify the navigation to "Language Strings" page under Settings menu from Companies menu for Licensees
    When User clicks on the settings Menu
    Then User verifies the options displayed
    When User clicks the Language Strings
    Then User is redirected to the Language Strings page

  @[SMSM-207] @Verify-Admin-can-edit-Language-Strings-from-the-available-list-from-Companies-menu-for-Licensees
  Scenario: Verify Admin can edit Language Strings from the available list from Companies menu for Licensees
    When User clicks on the settings Menu
    Then User verifies the options displayed
    When User clicks the Language Strings
    Then User is redirected to the Language Strings page
    And User verifies the Language Strings columns
    And User verifies that edit button is displayed for each record
    When User selects a Language String and clicks on the Edit button
    Then the Edit String pop up window is opened
    When User enters a value into the Edit String text box and clicks the close button
    Then User verifies that the value field is not updated
    When User enters a value into the Edit String text box and clicks the Save Setting button
    Then User verifies that the value field is updated
    #Revert Changes
    And User revert the changes to the Language Strings record

  @[SMSM-207] @Verify-the-Help-on-"Language-Strings"-page-by-clicking-the-Help-button 
  Scenario: Verify the Help on "Language Strings" page by clicking the Help button
    When User clicks on the settings Menu
    Then User verifies the options displayed
    When User clicks the Language Strings
    Then User is redirected to the Language Strings page
    When User clicks the Help button on the Language String page
    Then the Language String help tour is opened
    When User clicks the Next button on the Language Strings Management window
    Then the Search Language Strings window is displayed
    When User clicks the previous button on the Search Language Strings window
    Then User is navigated to the Language Strings Management window
    When User clicks on End Tour button
    Then Tour ends successfully
