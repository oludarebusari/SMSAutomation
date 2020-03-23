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
Feature: [SMSM-184] Manage Alerts under settings in admin dashboard for Thrive system

  Background: User logs in to Thrive and navigate to Manage Alert option under settings on Thrive System
    Given User Navigates to Thrive URL
    Then Thrive login page is displayed
    When User enters a valid username for thrive
    And User enters a valid password for thrive
    And User clicks the sign in button for thrve
    Then Thrive Dashboard page is displayed
    When User clicks settings from the top menu bar
    Then the Settings menu is expanded and settings options are displayed
    When User clicks on Alert option
    Then the Manage Alert page is displayed

  @SMSM-184 @Edit-existing-alert-in-the-list @RegressionTest @OnlyMe
  Scenario: Edit existing alert in the list
    When User types in an Alert text on the search box and clicks search
    Then the Alert is displayed on the Manage Alert paage
    When User clicks the Edit button beside the displayed Alert
    Then the Edit Alert window is displayed
    When User makes modification to the Alert and clicks Save Alert button
    Then User confirms the changes are saved correctly
    #Revert Changes to Alert
    Then User revert the changes made to the Alert record

  @SMSM-184 @Renew-existing-alert-in-the-list @RegressionTest
  Scenario: Renew Existing alert in the list
    When User types in an Alert text on the search box for alert to renew and clicks search
    Then the Alert to be renewed is displayed on the Manage Alert paage
    When User clicks the Edit button besides the Alert
    Then the Edit Alert window is displayed
    When User clicks the Date text field
    Then the Date window is displayed
    When User specifies a date in the future and clicks Apply button
    And User clicks the Save Alert button on the Edit Alert page
    Then user confirms that the status of the alert is now Active

  @SMSM-184 @Cancel-deactivation-of-existing-alert-in-the-list @RegressionTest 
  Scenario: Cancel deactivation of existing Alert in the list
    When User searches for an active alert
    Then the active alert is displayed on the Manage page
    When User clicks the action dropdown button
    Then the dropdown options for active alerts are displayed
    When User clicks the Deactivate button
    And User clicks the close icon on the Deactivate Alert window
    Then User confirms that the Alert is not deactivated

  @SMSM-184 @Deactivate-existing-alert-in-the-list @RegressionTest 
  Scenario: Deactivate Existing alert in the list
    When User searches for an active alert
    Then the active alert is displayed on the Manage page
    When User clicks the action dropdown button
    Then the dropdown options for active alerts are displayed
    When User clicks the Deactivate button
    And User clicks the Deactivate button on the Deactivate Alert window
    Then the alert is deactivated and User is redirected to the Manage Alert page
    When User search for the deactivated Alert
    Then the alert is displayed with an Inactive status

  @SMSM-184 @Cancel-activation-of-existing-alert-in-the-list @RegressionTest 
  Scenario: Cancel activation of existing Alert in the list
    When User types in an Alert text on the search box for a renewed alert and clicks search
    Then the renewed Alert is displayed on the Manage Alert paage
    When User clicks the action dropdown button
    Then the dropdown action options are displayed
    When User clicks the Activate button
    And User clicks the close icon on the Activate Alert window
    Then User confirms that the Alert is not activated

  @SMSM-184 @Activate-existing-alert-in-the-list @RegressionTest 
  Scenario: Activate existing alert in the list
    When User types in an Alert text on the search box for a renewed alert and clicks search
    Then the renewed Alert is displayed on the Manage Alert paage
    When User clicks the action dropdown button
    Then the dropdown action options are displayed
    When User clicks the Activate button
    And User clicks the Activate button on the Activate Alert window
    Then the Alert is activated and User is redirected to the Manage Alert page
    And the alert notification is displayed on the manage alert page
    When User search for the activated Alert
    Then the alert is displayed with an Active status.

  @SMSM-184 @Cancel-delete-existing-alert-in-the-list @RegressionTest
  Scenario: Cancel delete existing Alert in the list
    When User searches for an alert to delete
    Then the alert to be deleted is displayed on the manage page
    When User clicks the action dropdown button
    Then the dropdown options for the alert to be deleted are displayed
    When User clicks the Delete button
    And User clicks the close icon on the Delete Alert window
    Then User confirms that the Alert is not deleted

  @SMSM-184 @Delete-existing-alert-in-the-list @RegressionTest 
  Scenario: Delete existing alert in the list
    When User searches for an alert to delete
    Then the alert to be deleted is displayed on the manage page
    When User clicks the action dropdown button
    Then the dropdown options for the alert to be deleted are displayed
    When User clicks the Delete button
    And User clicks the Delete button on the Delete Alert window
    Then the alert is deleted and user is redirected to the Manage Alerts page
    When User search for the deleted alert
    Then zero result is displayed

  #Create a new Alert with the same information as the deleted alert above
  @SMSM-184 @Create-a-new-alert @RegressionTest 
  Scenario: Create a new Alert
    When User clicks the new button on the Manage Alert poage
    Then the create Alert window is opened
    When User enters the new alert information and clicks Schedule this Alert button
    Then the created and schedule successfully

  @SMSM-184 @Verify-Help-option-for-manage-alert-page @RegressionTest
  Scenario: Verify Help option for manage alert page
    When User clicks on the Help button
    Then the Alert Help popup is displayed
    When User clicks the Next button from the Tour Guide
    Then the tour guide proceeds to the next window
    When User clicks on the previous button
    Then the tour guide navigates back to the previous window
    When User clicks the End Tout button
    Then the tours guide should end successfully
