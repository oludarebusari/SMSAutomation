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
Feature: [SMSM-136] View and edit settings in Merchant's portal for Thrive system

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
    When User clicks the Settings menu item
    Then a dropdown apears with the Settings options

  @SMSM-136 @View-Settings-Under-Settings-option @RegressionTest
  Scenario: View Settings under Settings option
    When User clicks on Settings option from the dropdown
    Then the Settings page is opened
    And User confirms the columns on the Settings page

  @SMSM-136 @View-Language-String-Under-Settings-option @RegressionTest
  Scenario: View Language String under Settings option
    When User clicks on Language Strings from the dropdown
    Then the Language Strings page is opened
    And User confirms the columns on the Language Strings page

  @SMSM-136 @View-Email-Templates-Under-Settings-option @RegressionTest
  Scenario: View Email Templates under Settings option
    When User clicks on Message Templates from the dropdown
    Then the Message Templates page is opened
    And User confirms the columns on the Message Templates page

  @SMSM-136 @Edit-any-Manage-Settings-option @RegressionTest
  Scenario: Edit any Settings option
    When User clicks on Settings option from the dropdown
    Then the Settings page is opened
    When User types the Settings title in the Search box and click Search button
    Then the Settings record is displayed
    When User clicks the Edit button for the Settings
    Then the Edit Setting popup is displayed
    When User clicks the dropdown textbox on the Edit Setting modal
    And User clicks a Setting option and clicks the Update Setting button
    And User confirms that the changes is reflected on the settings page
    #Revert-changes-to-Company
    And User clicks the Edit button for the Settings
    When User clicks the dropdown textbox on the Edit Setting modal
    When User changes Settings option to it's original value and clicks the Update Setting button

  @SMSM-136 @Edit-any-Language-String-option @RegressionTest
  Scenario: Edit any Language String option
    When User clicks on Language Strings option from the dropdown
    Then the Language Strings page is opened
    When User types the Language String title in the Search box and click Search button
    Then the Language String record is displayed
    When User clicks the Edit button for the Language Strings
    Then the Edit String popup is displayed
    And  User enters the required information into the text field
    And User clicks the Update Setting button
    And User confirms the change is reflected on the settings page
    #Revert-changes-to-Company
    And User clicks the Edit button for Language Strings
    When User changed the Language String to it's original value and clicks the Update Setting button
    
  @SMSM-136 @Edit-any-Email-Template @RegressionTest @OnlyMe
  Scenario: Edit any Email Template
    When User clicks on Message Templates from the dropdown
    Then the Message Templates page is opened
    When User types a Message Templates title in the Search box and click Search button 
    Then the Message Templates record is displayed
    When User clicks the Edit button for the Message Templates
    Then the Edit Message Template popup is displayed
    And User enters the required information into the text field on the popup
    And User clicks the Save Settings button
    And User confirms the change is reflected on the Message Templates page
   #Revert-changes-to-Company
  	And User clicks the Edit button for the Message Template
    When User changed the Message Template fields to it's original value and clicks the Save Settings button
    
  
