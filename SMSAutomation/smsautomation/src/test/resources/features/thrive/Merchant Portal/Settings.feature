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

  @SMSM-136 @Search-and-Edit-any-Manage-Settings-option @RegressionTest
  Scenario: Search and Edit any Settings option
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

  @SMSM-136 @Search-and-Edit-any-Language-String-option @RegressionTest
  Scenario: Search and Edit any Language String option
    When User clicks on Language Strings option from the dropdown
    Then the Language Strings page is opened
    When User types the Language String title in the Search box and click Search button
    Then the Language String record is displayed
    When User clicks the Edit button for the Language Strings
    Then the Edit String popup is displayed
    And User enters the required information into the text field
    And User clicks the Update Setting button
    And User confirms the change is reflected on the settings page
    #Revert-changes-to-Company
    And User clicks the Edit button for Language Strings
    When User changed the Language String to it's original value and clicks the Update Setting button

  @SMSM-136 @Search-and-Edit-any-Email-Template @RegressionTest
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

  @SMSM-136 @Help-Guide-for-Manage-Settings-page @RegressionTest
  Scenario: Help Guide for Manage Settings page
    When User clicks on Settings option from the dropdown
    Then the Settings page is opened
    When User clicks the Help button on the Setting
    Then the Settings Management pop up is opened
    When User clicks the Next button on the Settings Management pop up window
    Then the Search Setting pop up is displayed
    When User clicks the Next button on Search Settings pop up window
    Then the Title pop up dialog is displayed
    When User clicks the Next button on the Tile pop up window
    Then the Group pop up dialog is displayed
    When User clicks the Next button on the Group pop up window
    Then the Value pop up dialog is displayed
    When User clicks the Next button on the Value pop up window
    Then the Description pop up dialog is displayed
    When User clicks the Next button on the Description pop up window
    Then the Updated pop up dialog is displayed
    When User clicks the Next button on the Updated pop up window
    Then the Action pop up dialog is displayed
    When User clicks the End Tour button on the Action pop up window
    Then the pop up window is closed

  @SMSM-136 @Help-Guide-for-Language-String-page @RegressionTest
  Scenario: Help Guide for Language Strings page
    When User clicks on Language Strings option from the dropdown
    Then the Language Strings page is opened
    When User clicks the Help button on the Setting
    Then the Language String Management pop up is opened
    When User clicks the Next button on the Language String Management pop up window
    Then the Search Language Strings pop up is displayed
    When User clicks the Next button on Search Language Strings pop up window
    Then the Title pop up dialog for Language String is displayed
    When User clicks the Next button on the Tile pop up window for Language Strings
    Then the Group pop up dialog for Language String is displayed
    When User clicks the Next button on the Group pop up window for Language Strings
    # Then the Access Level pop up dialog is displayed
    # When User clicks the Next button on the Access Level pop up window
    Then the Value pop up dialog for Language String is displayed
    When User clicks the Next button on the Value pop up window for Language Strings
    Then the Description pop up dialog for Language String is displayed
    When User clicks the Next button on the Description pop up window for Language String
    Then the Updated pop up dialog for Language String is displayed
    When User clicks the Next button on the Updated pop up window for Language String
    Then the Action pop up dialog for Language String is displayed
    When User clicks the End Tour button on the Action pop up window
    Then the pop up window is closed

  @SMSM-136 @Help-Guide-for-Email-Templates-page @RegressionTest
  Scenario: Help Guide for Email Templates page
    When User clicks on Message Templates from the dropdown
    Then the Message Templates page is opened
    When User clicks the Help button on the Setting
    Then the Message Template Management pop up is opened
    When User clicks the Next button on the Message Template Management pop up window
    Then the Search Message Templates pop up is displayed
    When User clicks the Next button on Search Message Templates pop up window
    Then the Title pop up dialog for Message Templates String is displayed
    When User clicks the Next button on the Tile pop up window for Message Templates
    Then the Subject pop up dialog is displayed
    When User clicks the Next button on the Subject pop up window
    Then the Description pop up dialog for Message Templates is displayed
    When User clicks the Next button on the Description pop up window for Message Templates
    Then the Updated pop up dialog for Message Templates is displayed
    When User clicks the Next button on the Updated pop up window for Message Templates
    Then the Action pop up dialog for Message Templates is displayed
    When User clicks the End Tour button on the Action pop up window
    Then the pop up window is closed

  @SMSM-136 @Apply-Sort-in-Manage-Settings-page @RegressionTest 
  Scenario: Apply Sort in Manage Settings page
    When User clicks on Settings option from the dropdown
    Then the Settings page is opened
    When User clicks the Title column name
    Then the Settings records are sorted by Tilte column
    When User clicks the Group column name
    Then the Settings records are sorted by Group column
    When User clicks the Value column name
    Then the Settings records are sorted by Value column
    When User clicks the Description column name
    Then the Settings record are sorted by Description column.
    When User clicks the Updated column name
    Then the Settings records are sorted by Updated colum

  @SMSM-136 @Apply-Sort-in-Language-String-page @RegressionTest
  Scenario: Apply Sort in Language Strings page
    When User clicks on Language Strings option from the dropdown
    Then the Language Strings page is opened
    When User clicks the Title column name on Language Strings page
    Then the Language Strings records are sorted by Tilte column
    When User clicks the Group column name on Language Strings page
    Then the Language Strings records are sorted by Group column
    When User clicks the Access Level column name
    Then the Language Strings records are sorted by Access Level column
    When User clicks the Value column name on Language Strings page
    Then the Language Strings records are sorted by Value column
    When User clicks the Description column name on Language Strings page
    Then the Language Strings record are sorted by Description column.
    When User clicks the Updated column name on Language String page
    Then the Language Strings records are sorted by Updated column

  @SMSM-136 @Apply-Sort-in-Email-Template-page @RegressionTest
  Scenario: Apply sort in Email Template page
    When User clicks on Message Templates from the dropdown
    Then the Message Templates page is opened
    When User clicks the Title column name on Message Template page
    Then the Message Templates records are sorted by Tilte column
    When User clicks the Subject column name on Message Templates page
    Then the Message Templates records are sorted by Subject column
    When User clicks the Description column name on Message Templates page
    Then the Message Templates record are sorted by Description column.
    When User clicks the Updated column name on Message Templates page
    Then the Message Templates records are sorted by Updated column
    
    
    
    
    
    
    
    