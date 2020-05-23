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
    When User clicks the Message Templates
    Then User is redirected to Email Templates page

  @SMSM-193 @Verify-Email-Templates-option-under-Settings-in-admin-dashboard
  Scenario: Verify Email Templates option under Settings in admin dashboard
    And User validates the message templates fields and that records are present

  @SMSM-193 @Verify-user-is-able-to-modify-email-templates-within-templates-list
  Scenario: Verify user is able to modify email templates within templates list
    And User verifies that the edit button is displayed against each message template lit
    When User clicks the edit button for a message template
    Then the Message template window is opened
    And User enters value for all the fields
    When User clicks the Update tab
    Then changes are saved correctly
    #Revert Changes
    And User revert changes made to the Message Template

  ## Screen Templates
  @SMSM-193 @Verfiy-that-on-clicking-(X)-button-user-is-navigated-back-to-email-templates-page @OnlyMe
  Scenario: Verfiy that on clicking (X) button user is navigated back to email templates page
    When User clicks the edit button for a message template
    Then the Message template window is opened
    When User clicks the X button on the right corner of the edit template window
    Then User is navigated back to email templates window

  @SMSM-193 @Verify-that-user-is-not-able-to-update-settings-on-entering-invalid-data-in-different-fields @OnlyMe
  Scenario: Verfiy that on clicking (X) button user is navigated back to email templates page
    When User clicks the edit button for a message template
    Then the Message template window is opened
    When User enters an Invalid email address in To field
    When User enters invalid email address in From field
    And User verifies that the Save Settings button is disabled
    
    
    

