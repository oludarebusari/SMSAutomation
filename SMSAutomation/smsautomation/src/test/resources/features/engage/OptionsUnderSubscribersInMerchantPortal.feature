
#User is assumed to have Admin access unless stated Otherwise
##Step Definition File - OptionsUnderSubscribersInMerchantsPortal.java
@engage @RegressionTest
Feature: View & access all option under subscriber list in Merchant's portal

  Background: User is logged in and navigates to the Merchant's Dashboard
    Given User navigate to Engage url
    And User enters a valid username
    And User enters a valid password
    And User clicks on the login button
    Then User should be taken to Engage SMS home page

  @SMSM-131-Verify-that-user-is-able-to-check-Manage-Resellers-page-content
  Scenario: Verify that User is able to check Manage Resellers page content
    And User checks the page content Title, list of Resellers, search and Status
    And User confirms the possibility to Copy to clipboard and export to csv
    When User clicks the Manage Resellers menubar option
    Then user is redirected to the manage site page
    And User verifies the columns of the table of columns
    And User verifiles the license logins are enabled

  @SMSM-131-Verify-that-user-is-able-to-review-Businesses-page-content
  Scenario: Verify that User is able to review Businesses Page content
    When User clicks the Manage Resellers menubar option
    And User logs in to a reseller
    Then User is redirected to the Engaged Admin Dashboard page
    And User clicks Business tabs at the left side
    Then the Businesses page is opened
    And User verify the contents - Search textbox, New button, Show Terminated button and table grid
    And User confirms the Table Grid elements
    And User confirms the Table columns

  @SMSM-131-Opening-Subscribers-Page, 
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

  @SMSM-131-Verify-that-user-is-able-to-view-list-of-Subscribers
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

  @SMSM-131-Send-Meesage-To-Reply-Subscriber
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
    When user clicks the Reply button
    Then The Send Message window is displayed
    When User clicks the Send as MMS toggle and fill in the required fields
    And User clicks on the Send button
    Then a message sent notification is displayed.

  @SMSM-200-Verify-the-Giftbar-Profile
  Scenario: Verify the Giftbar Profile in Giftbar option on Add-on
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

  @SMSM-200-Verify-that-user-is-able-to-Blacklist,-unsubscribe-with-text-and-without-text 
  Scenario: Verify that User is able to Blacklist, Unsubscribe with text and without text
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
    When User clicks the dropdown under Action column of a subscriber
    Then User verifies that Blacklist option is available
    And User verifies that Unsubscribe with text is available
    And User verifies that Unsubscribe without Text is available

  @SMSM-200-Verify-that-user-is-able-to-Bulk-edit 
  Scenario: Verify that User is able to Bulk edit
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
    And User selects one or more Subscribers
    Then the Bulk Edit button is enabled
    When User clicks the Bulk Edit button
    Then User verifies the options Under the Bulk Edit button
    When User selects Reply to selected option
    And User types in a message into the Message textarea
    Then a success notification message is displayed

  @SMSM-200-Verify-that-user-is-able-to-Search-for-any-subscriber 
  Scenario: Verify that User is able to Search for any subscriber
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
    When User enters a string into the search box
    Then user confirms the record is displayed
    And User confirms the Table Header
    And User confirms the Table content
    
