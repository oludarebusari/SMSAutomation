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
Feature: Feature:  [SMSM-140] Social media & web widget settings in Merchant's portal (Engage system)
  User should be able to view and edit Social Media and Web Widget settings

  Background: User is logged in and navigates to the Merchant's Dashboard
    Given User navigate to Engage url
    And User enters a valid username
    And User enters a valid password
    And User clicks on the login button
    Then User should be taken to Engage SMS home page
    When User clicks the Manage Resellers menubar option
    And User logs in to a reseller
    Then User is redirected to the Engaged Admin Dashboard page
    And User clicks Business tabs at the left side
    Then the Businesses page is opened
    And Users click Login tab for a merchant
    Then the user is redirected to a new window of Merchant's Dashboard
    And User clicks the Settings menu
    Then the Settings options are displayed

  @SMSM-137-Verify-that-user-is-able-to-view-Account-Defaults-Social-Media-and-Web-Widget-options-in-settings-tab @RegressionTest
  Scenario: Verify that user is able to view Account Defaults,Social Media and Web Widget options in settings tab
    When User hovers over the Social Media option
    Then the color of the selected option changes to blue

  @SMSM-137-Verify-that-user-is-able-to-connect-facebook-account-with-selected-campaign @RegressionTest
  Scenario: Verify that user is able to connect Facebook account with selected campaign
    When User clicks the Social Media option
    Then the Social Settings page is displayed
    When User selects a Campaign from Select a campaign dropdown
    Then the selected campaign is displayed on the dropdown text box
    When User clicks on Connect to Facebook button
    Then User should be navigated to the facebook login page

  @SMSM-137-Verify-that-user-is-able-to-manually-configure-a-Facebook-account-with-selected-campaign @RegressionTest
  Scenario: Verify that user is able to manually configure a Facebook account with selected campaign
    When User clicks the Social Media option
    Then the Social Settings page is displayed
    When User selects a Campaign from Select a campaign dropdown
    Then the selected campaign is displayed on the dropdown text box
    And user enters a name into the FB Name textfield
    And User enters a userid into the FB UserID
    And User clicks the Save Integration button

  @SMSM-137-Verify-that-user-is-able-to-save-social-URL's-successfully @RegressionTest
  Scenario: Verify that user is able to save social URL's successfully
    When User clicks the Social Media option
    Then the Social Settings page is displayed
    And User enters the URL into Facebook URL textbox in Social Properties section
    And User clicks Save Social URLs button
    When User clicks the Back to Dashboard
    Then the User is redirected to the Dashboatd page
    When User clicks the Settings menu
    Then the Settings options are displayed
    When User clicks the Social Media option
    Then User confirms that the URLs was saved correctly

  @SMSM-137-Verify-that-user-is-able-to-edit-details-in-various-fields-to-configure-web-widget @RegressionTest
  Scenario: Verify that user is able to edit details in various fields to configure web widget
    When User clicks the Web Widget option in settings tab
    Then User should be navigated to the Web widget page
    And User Enters the Form Title
    And User enters the Form Description
    And User enters the button text
    And User enters the Thnak You message
    Then User verifies that all the text entered are reflected on the Preview section

  @SMSM-137-Verify-that-user-is-able-to-add-remove-various-options-to-configure-web-widget @RegressionTest
  Scenario: Verify that user is able to add/remove various options to configure web widget
    When User clicks the Web Widget option in settings tab
    Then User should be navigated to the Web widget page
    And User verifies that the state of the Collect Last name toggle button is No
    And User verifies that Last Name textfield is not displayed on the preview section
    When User clicks on the Collect Last name toggle button to changeit's state from No to Yes
    Then User verifies that a Last Name text field is displayed on the preview section
    And User verifies the state of Collect email address toggle on configure your widget section
    And User verifies that email address textbox is displayed on the Preview section
    When User clicks on the toggle for Collect email address
    Then User verifies that Email address textbox is not displayed on the preview section

  @SMSM-137-Verify-that-user-is-able-to-select-a-display-method-and-a-theme-to-configure-web-widget @RegressionTest 
  Scenario: Verify that user is able to select a display method and a theme to configure web widget
    When User clicks the Web Widget option in settings tab
    Then User should be navigated to the Web widget page
    When User clicks the Choose a Display Method button
    Then the Preview section should display Join Our Mobile Rewards Club!
    When User clicks on Choose a Theme button
    Then the Preview section color should change to dark gray

  @SMSM-137-Verify-that-user-is-able-to-copy-embed-code-successfully @RegressionTest @OnlyMe
  Scenario: Verify that user is able to copy embed code successfully
    When User clicks the Web Widget option in settings tab
    Then User should be navigated to the Web widget page
    When User clicks the Select a Campaign drop down and selects a campaign
    Then the Campaign is displayed on the Select a Campaign textbox
    When User Select the code and clicks copy embed code button
    Then User then the code is copied to clipboard
