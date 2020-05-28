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
    When User clicks on the settings Menu and clicks the Setting option
    Then User is redirected to the Settings page

  @[SMSM-207] @Verify-the-Help-on-"Manage-Settings"-page-by-clicking-the-Help-button
  Scenario: Verify the Help on "Manage Settings" page by clicking the Help button
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
    And User verifies that the Search text box is displayed
    And User verifies that the Search button is displayed
    When User types in a group name into the Search box and clicks Search button
    Then the Settings records are displayed

  @[SMSM-207] @Verify-the-functionality-of-sorting-and-Show-entries-dropdown-and-pagination-on-Manage-Settings-page
  Scenario: Verify the functionality of sorting and Show entries dropdown and pagination on Manage Settings page
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
    
  @[SMSM-207] @Verify-Admin-can-edit-Email-Templates-from-the-available-list-from-Companies-menu-for-Licensees @OnlyMe
  Scenario: Verify Admin can edit Email Templates from the available list from Companies menu for Licensees
  	When User clicks the settings Menu and clicks the Message Templates
  	Then User is redirected to the Message Templates
  	And User verifies the Edit button for the Message Templates
  	When User selects a Message Template and clicks on Edit button
  	Then the Message Templates opens in edit mode
  	When User edits some fields and clicks on the close button
  	Then User verifies that the fields were not updated
  	When User selects a Message Template and clicks on Edit button
  	Then the Message Templates opens in edit mode
  	When User edits some fields and clicks on the close button
    Then all updated fields were updated successfully
  
  
  
    