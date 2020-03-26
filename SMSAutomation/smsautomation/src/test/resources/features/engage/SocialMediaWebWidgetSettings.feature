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

  @SMSM-137-Verify-that-user-is-able-to-manually-configure-a-Facebook-account-with-selected-campaign @RegressionTest @OnlyMe
  Scenario: Verify that user is able to manually configure a Facebook account with selected campaign
    When User clicks the Social Media option
    Then the Social Settings page is displayed
    When User selects a Campaign from Select a campaign dropdown
    Then the selected campaign is displayed on the dropdown text box
    And user enters a name into the FB Name textfield
    And User enters a userid into the FB UserID
    And User clicks the Save Integration button
    
    
    
    
    
    
    
    
