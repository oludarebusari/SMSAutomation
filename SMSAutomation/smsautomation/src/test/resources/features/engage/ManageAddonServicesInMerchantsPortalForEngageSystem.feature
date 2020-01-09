Feature: Manage Add On Services in Merchant's portal for Engage System

  Scenario: User should be redirected to new window of Merchant's Dashboard
    Given User navigate to Engage url
    And User enters a valid username
    And User enters a valid password
    And User clicks on the login button
    Then User should be taken to Engage SMS home page
    When User clicks the Manage Resellers menubar option
    And User logs in to a reseller
    Then User is redirected to the Engaged Admin Dashboard page
    And User clicks Business tabs at the left side
    Then the merchants detailed information is listed
    And Users click Login tab for a merchant
    Then the user is redirected to a new window of Merchant's Dashboard
    And User verifies that Add-On Services menu is available
    And User clicks the Add-On Services menu option
    Then the Giftbar menu option is displayed
    When User clicks the Giftbar menu option
    Then the giftbar page is opened
    And User clicks the Interested button
    Then an interest notification is sent message is displayed
