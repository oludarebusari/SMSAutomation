#Author: your.email@your.domain.com
#Keywords Summary :
#User is assumed to have Admin access unless stated Otherwise
#Step Definition File - LeadTimeDateTimeConfigurationSteps.java
@engage @RegressionTest
Feature: Date/Time Configuration

  Background: User is logs in and Thrive Dashboard is displayed
    Given User Navigates to Thrive URL
    Then Thrive login page is displayed
    When User enters a valid username for thrive
    And User enters a valid password for thrive
    And User clicks the sign in button for thrve
    Then Thrive Dashboard page is displayed

  @Section2.3.1.2 @Date/Time-Configuration:-Reseller-Level:-Verify-Display
  Scenario: Date/Time Configuration: Reseller Level: Verify Display [C26189556]
    When User clicks the Companies menu
    Then the Companies options are displayed
    When User clicks on Resellers option
    Then User is redirected to the Manage Resellers page
    When User clicks the edit option for a specific reseller record
    Then User is redirected to the Edit Resellers page
    And User verifies the Office Hour Information sections available.
    And User verifies the available Days options
    And User verifies the Office Hours Start options
    And User verifies the Office Hours End Options
    And User verifies the Time Zone options
    And User clicks the Save Reseller button
    When User queries the same Reseller record
    Then User verifies that the changes to the Reseller record were saved correctly
    When User makes a change to the Days available setting
    And User clicks the Save Reseller button
    And User queries the same Reseller record
    Then User verifies the changes made to the Days available setting
    When User makes a change to the Office Hours Start setting
    And User clicks the Save Reseller button
    And User queries the same Reseller record
    Then User verifies the changes made to Office Hours Start setting
    Then User verifies the changes made to the Time Zone setting
    When User makes a change to the Office Hours Start setting
    And User clicks the Save Reseller button
    And User queries the same Reseller record
    Then User verifies the changes made to thwe Time Zone setting
    #Revert changes to Reseller
    And User reverts changes made to Reseller

  @Section2.3.1.2 @Date/Time-Configuration:-Reseller-User-Level:-Verify-Display
  Scenario: Date/Time Configuration: Reseller User Level: Verify Display [C26189571]
    When User clicks the User menu
    Then the User options are displayed
    When User clicks on Resellers option from the User menu
    Then User is redirected to the Reseller Users page
    When User clicks the edit button for a selected user
    Then User is redirected to the Edit User page
    And User verifies the Time Zone Information is displayed
    And User verifies User level timezone option
    When User updates the Time Zone value
    And User clicks the Save User button
    And User re-query the same user record
    Then User verifies that the updated timezone value is reflected
    #Revert changes to User
    And User reverts changes made to User record
