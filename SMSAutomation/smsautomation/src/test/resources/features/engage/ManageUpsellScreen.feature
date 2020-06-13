#Author: your.email@your.domain.com
#Keywords Summary :
#User is assumed to have Admin access unless stated Otherwise
#Step Definition File - ManageUpsellScreenSteps.java
@engage @RegressionTest
Feature: [SMSM-916] Upsell Item name doesn't show up on the upsell screen

  Background: User is logged in and navigates to the Merchant's Dashboard
    Given User navigate to Engage url
    And User enters a valid username
    And User enters a valid password
    And User clicks on the login button
    Then User should be taken to Engage SMS home page
    When User clicks the Manage Resellers menubar option
    And User logs in to a reseller
    Then User is redirected to the Engaged Admin Dashboard page
    When User clicks Business tabs at the left side
    Then the Businesses page is opened
    And Users click Login tab for a merchant
    Then the user is redirected to a new window of Merchant's Dashboard
    When User clicks the Campaign option tab
    Then the Campaign menu is opened
    When User clicks on Single Campaigns option
    Then User is redirected to the Single Campaigns page

  @[SMSM-916] @Verify-that-user-can-access-the-"Upsell-Screen"-from-Advanced-Settings-of-a-selected-campaign
  Scenario: Verify that user can access the Upsell Screen from Adavnced Settings of a selected campaign [C24008320]
    When User clicks on Edit button of a campaign
    Then the Edit Campaign Page is displayed
    When User clicks the configure advanced settings link
    Then the Advanced section of the Edit Campaign page is expanded
    When User clicks on the Upsell Screen link
    Then the Upsell Screen setting is displayed

  @[SMSM-916] @verify-that-user-can-enable-the-"Upsell-Screen"-from-Advanced-Settings-of-a-selected-campaign @OnlyMe
  Scenario: verify that user can enable the "Upsell Screen" from Advanced Settings of a selected campaign [C24008337]
    When User clicks on Edit button of a campaign
    Then the Edit Campaign Page is displayed
    When User clicks the configure advanced settings link
    Then the Advanced section of the Edit Campaign page is expanded
    When User clicks on the Upsell Screen link
    Then the Upsell Screen setting is displayed
    When User clicks on the Disabled toggle button
    Then button changes to Enabled and the Upsell Screen setting panel is displayed
