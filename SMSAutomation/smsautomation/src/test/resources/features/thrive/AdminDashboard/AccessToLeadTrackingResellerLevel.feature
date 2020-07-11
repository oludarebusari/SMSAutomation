#Author: your.email@your.domain.com
#Keywords Summary :
#User is assumed to have Admin access unless stated Otherwise
#Step Definition File - AccessToLeadTrackingResellerLevelSteps.java
@engage @RegressionTest
Feature: Enabling Access to Lead Tracking

  Background: User is logs in and Thrive Dashboard is displayed
    Given User Navigates to Thrive URL
    Then Thrive login page is displayed
    When User enters a valid username for thrive
    And User enters a valid password for thrive
    And User clicks the sign in button for thrve
    Then Thrive Dashboard page is displayed
    When User clicks the Companies menu
    Then the Companies options are displayed
    When User clicks on Resellers option
    Then User is redirected to the Manage Resellers page
    When User clicks the edit option for a specific reseller record
    Then User is redirected to the Edit Resellers page

  @Section2.3.1.1 @Lead-Tracking-Permission:-Reseller-Level:-Displayed-Objects-Verification
  Scenario: Lead Tracking Permission: Reseller Level: Displayed Objects Verification
    And User verifies that Lead Tracking option is not selected
    And User verifies that Lead Tracking option is displayed in the LOV

  @Section2.3.1.1 @Lead-Tracking-Permission:-Reseller-Level:-Enable/Disable-Lead-Tracking-Permission
  Scenario: Lead Tracking Permission: Reseller Level: Enable/Disable Lead Tracking Permission
    When User selects the Lead Tracking option for license
    Then User verifies that Lead Tracking is selected
    And User saves the Reseller record
    When User queries the same Reseller and Edit
    Then User confirms that the license setting is retained and has Lead Tracking selected
    When User removes the Lead Tracking option and saves the Reseller record
    And User queries the same Reseller and Edit
    Then User confirms that the Lead Tracking license removed is not displayed
    When User adds the Lead Tracking license
    And User navigates away from the Edit Reseller page without saving
    And User queries the same Reseller and Edit
    Then User confirms that the Lead Tracking license is not displayed
    When User adds the Lead Tracking license
    And User saves the Reseller record
    When User queries the same Reseller and Edit
    Then User confirms that the license setting is retained and has Lead Tracking selected
    When User removes the Lead Tracking option
    And User navigates away from the Edit Reseller page without saving
    And User queries the same Reseller and Edit
    Then User confirms that the Lead Tracking license is not removed
    #Revert License changes to the Reseller Record
    And User revert the changes to the reseller record
