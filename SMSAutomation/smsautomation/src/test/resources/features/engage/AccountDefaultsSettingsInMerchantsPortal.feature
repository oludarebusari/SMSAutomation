#Author: your.email@your.domain.com
#Keywords Summary :

#User is assumed to have Admin access unless stated Otherwise
#Step Definition File - 
@engage @RegressionTest
Feature: View and Edit Account Default settings
  I want to be able to View & edit Account Defaults settings in Merchant's portal

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

  @SMSM-139-View-Settings-page 
  Scenario: View Settings page
    And User clicks the Accounts Defaults menu
    Then AccountDefaults page is displayed
    And User clicks Social Media from the LHS
    Then user is redirected to the Social Settings and fields like FacebookIntegration,configuremanually and social properties are displayed
    And User clicks on Web Widget link from the LHS menu
    Then User is redirected to the Web Widget page, Configure your widget and preview fields are displayed

  @SMSM-139-View-Settings-Account-Defaults
  Scenario: View Settings-Account Defaults
    And User clicks the Account Defaults
    Then the Accounts Defaults page is displayed
    And User verifies that the Inbox message limit page section exists
    And User enters the number of limit days and click save button
    Then Saved validation message is displayed within the Inbox section
    And User enters the default first name variable value and click save button
    Then Saved validation message is displayed within the Default value section
