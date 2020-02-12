#@RegressionTest
Feature: Manage Add On Services in Merchant's portal for Engage System

  Background: User is logged in and navigates to the Merchant's Dashboard
    Given User navigate to Engage url
    And User enters a valid username
    And User enters a valid password
    And User clicks on the login button
    Then User should be taken to Engage SMS home page

  @SMSM-131-Check-Manage-Page-Content, @RegressionTest
  Scenario: Verify that User is able to check Manage Resellers page content
    And User checks the page content (Title, list of Resellers, search and Status)
    And User confirms the possibility to Copy to clipboard and export to csv
    When User clicks the Manage Resellers menubar option
    Then user is redirected to the manage site page

  @SMSM-131-Review-Bussiness-Page-Content, @RegressionTest
  Scenario: Verify that User is able to review Businesses Page content
    When User clicks the Manage Resellers menubar option
    And User logs in to a reseller
    Then User is redirected to the Engaged Admin Dashboard page
    And User clicks Business tabs at the left side
    Then the Businesses page is opened
    And User verify the contents - Search textbox, New button, Show Terminated button and table grid
    And User confirms the Table Grid elements
    And User confirms the Table columns
    

  @SMSM-131-Opening-Subscribers-Page, @RegressionTest
  Scenario: Opening Subscribers Page
    When User clicks the Manage Resellers menubar option
    And User logs in to a reseller
    Then User is redirected to the Engaged Admin Dashboard page
    And User clicks Business tabs at the left side
    Then the Businesses page is opened
    And Users click Login tab for a merchant
    Then the user is redirected to a new window of Merchant's Dashboard
    And User verifies that the Subscribers menu is present
    When User clicks the Subscribers menu
    Then the Subscribers page is opened
    
  @SMSM-131-Open-And-View-Subscribers-list, @RegressionTest
  Scenario: Verify that User is able to view list of Subscribers
    When User clicks the Manage Resellers menubar option
    And User logs in to a reseller
    Then User is redirected to the Engaged Admin Dashboard page
    And User clicks Business tabs at the left side
    Then the Businesses page is opened
    And Users click Login tab for a merchant
    Then the user is redirected to a new window of Merchant's Dashboard
    And User verifies that the Subscribers menu is present
    When User clicks the Subscribers menu
    Then the Subscribers page is opened
		And User verifies the list of Subscribers
    
  @SMSM-131-Send-Meesage-To-Reply-Subscriber, @RegressionTest
  Scenario: Verify that User is able to Send a message to reply subscriber
    When User clicks the Manage Resellers menubar option
    And User logs in to a reseller
    Then User is redirected to the Engaged Admin Dashboard page
    And User clicks Business tabs at the left side
    Then the Businesses page is opened
    And Users click Login tab for a merchant
    Then the user is redirected to a new window of Merchant's Dashboard
    And User verifies that the Subscribers menu is present
    When User clicks the Subscribers menu
    Then the Subscribers page is opened
  	And User verifies the list of Subscribers
    When user types in a subscriber's name in the textbox and click Get Result button
    Then the Subscriber is displayed
    When user clicks the view button for the Subcriber
    Then the Subscriber View page is opened
    When user clicks the Send Message button
    Then the Send message window is opened
    When user enters a message and click Send button
    Then Message sent notification is displayed on the Subscriber View page
    
  @SMSM-200-Verify-the-Giftbar-Profile, @RegressionTest
  Scenario: Verify the Giftbar Profile in Giftbar option on Add on
    When User clicks the Manage Resellers menubar option
    And User logs in to a reseller
    Then User is redirected to the Engaged Admin Dashboard page
    And User clicks Business tabs at the left side
    Then the Businesses page is opened
    And Users click Login tab for a merchant
    Then the user is redirected to a new window of Merchant's Dashboard
    And User verifies that Add-On Services menu is available
    And User clicks the Add-On Services menu option
    Then the Giftbar menu option is displayed
    When User clicks the Giftbar menu option
    Then the giftbar page is opened
    And User clicks the Interested button
    Then an interest notification is sent message is displayed
