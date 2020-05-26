#Author: your.email@your.domain.com
#Keywords Summary :
#User is assumed to have Admin access unless stated Otherwise
#Step Definition File - StreamsPageUnderExperienceSteps.java
@thrive @RegressionTest
Feature: [SMSM-171] View & edit Email & Screen Templates in admin dashboard for Thrive system

  Background: User logs in to Thrive and navigate to Business Dashboard
    Given User Navigates to Thrive URL
    Then Thrive login page is displayed
    When User enters a valid username for thrive
    And User enters a valid password for thrive
    And User clicks the sign in button for thrve
    Then Thrive Dashboard page is displayed
    And User verifies that Settings menu option is available
    When user clicks the Settings menu
    Then all options under Settings menu are displayed

  @SMSM-193 @Verify-Email-Templates-option-under-Settings-in-admin-dashboard
  Scenario: Verify Email Templates option under Settings in admin dashboard [C22393878]
    When User clicks the Message Templates
    Then User is redirected to Email Templates page
    And User validates the message templates fields and that records are present

  @SMSM-193 @Verify-user-is-able-to-modify-email-templates-within-templates-list
  Scenario: Verify user is able to modify email templates within templates list [C22393896]
    When User clicks the Message Templates
    Then User is redirected to Email Templates page
    And User verifies that the edit button is displayed against each message template lit
    When User clicks the edit button for a message template
    Then the Message template window is opened
    And User enters value for all the fields
    When User clicks the Update tab
    Then changes are saved correctly
    #Revert Changes
    And User revert changes made to the Message Template

  ## Screen Templates
  @SMSM-193 @Verfiy-that-on-clicking-(X)-button-user-is-navigated-back-to-email-templates-page
  Scenario: Verfiy that on clicking (X) button user is navigated back to email templates page [C22468779]
    When User clicks the Message Templates
    Then User is redirected to Email Templates page
    When User clicks the edit button for a message template
    Then the Message template window is opened
    When User clicks the X button on the right corner of the edit template window
    Then User is navigated back to email templates window

  @SMSM-193 @Verify-that-user-is-not-able-to-update-settings-on-entering-invalid-data-in-different-fields
  Scenario: Verify that user is not able to update settings on entering invalid data in different fields [C22469214]
    When User clicks the Message Templates
    Then User is redirected to Email Templates page
    When User clicks the edit button for a message template
    Then the Message template window is opened
    When User enters an Invalid email address in To field
    When User enters invalid email address in From field
    And User verifies that the Save Settings button is disabled

  @SMSM-193 @Verify-that-mandatory-fields-are-marked-red-on-clicking-update-settings-without-entering-any-data
  Scenario: Verify that mandatory fields are marked red on clicking update settings without entering any data [C22469216]
    When User clicks the Message Templates
    Then User is redirected to Email Templates page
    When User clicks the edit button for a message template edit
    Then the Message template window to edit is opened
    When User removes all the default values on the fields on the Edit Message tamplate window and clicks Save Settings button
    Then vaidation messages are displayed for those fields
    And User verifies that the Save Settings button is disabled

  @SMSM-193 @Verify-that-user-is-navigated-to-screen-templates-page
  Scenario: Verify that user is navigated to screen templates page [C22468781]
    When User clicks the Screen Templates
    Then User should be navigated to Screen Templates page

  @SMSM-193 @Verify-that-user-is-able-to-Deactivate-a-screen-template
  Scenario: Verify that user is able to Deactivate a screen template [C22393916]
    When User clicks the Screen Templates
    Then User should be navigated to Screen Templates page
    And User verifies the columns on the Screen templates page
    And user verifies that Deactivate button is present for all the rows under the Action column
    When User clicks on deactivate button for a particular record
    Then the Deactivate Screen Template window is opened
    When User clicks on the deactivate button on the pop-up window
    Then User confirms the status of the screen template is updated

  @SMSM-193 @Verify-that-user-is-able-to-Reactivate-a-deactivated-template
  Scenario: Verify that user is able to Reactivate a deactivated template [C22393919]
    When User clicks the Screen Templates
    Then User should be navigated to Screen Templates page
    When User clicks on Activate button of the deactivated screen templates
    Then the Activate Screen Template window is opened
    When User clicks on the Activate button on the modal
    Then User confirms the status of the screen template that is activated
    
  @SMSM-193 @erify-that-user-is-able-to-filter-the-records-on-the-basis-of-verticals
  Scenario: erify that user is able to filter the records on the basis of verticals [C22398152]
    When User clicks the Screen Templates
    Then User should be navigated to Screen Templates page
    When User clicks on the Verticals dropdown box
    Then the drop down option is displayed
    When User selects a vertical option
    Then records are displayed as per vertical selected
    When User selects Multiple verticals
    Then records are displayed as per verticals selected
   
  @SMSM-193 @Verfiy-that-user-is-able-to-search-the-records @OnlyMe
  Scenario: Verfiy that user is able to search the records [C22398197]
    When User clicks the Screen Templates
    Then User should be navigated to Screen Templates page
    And User verifies that the search textbox is displayed on the page
    When User enters a search keyword in the search textbox and click on Search button
    Then the search result is displayed as per the search criterion
    And User verifies that the Show n entries works correctly
    And User verifies that paginator works correctly
    
    
    
    
    
    
    
