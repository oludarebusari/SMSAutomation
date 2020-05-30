#Author: your.email@your.domain.com
#Keywords Summary :
#Step Definition File - ViewAndEditSettingsResellersPortal.java
@thrive @RegressionTest @thrive @RegressionTest
Feature: [SMSM-207] View and edit settings in Licensees's portal for Thrive system

  Background: User logs in to Thrive and navigate to Business Dashboard
    Given User Navigates to Thrive URL
    Then Thrive login page is displayed
    When User enters a valid username for thrive
    And User enters a valid password for thrive
    And User clicks the sign in button for thrve
    Then Thrive Dashboard page is displayed
    When User clicks on Companies
    Then the Companies options are displayed
    When User clicks on Resellers
    Then the Resellers Page is opened
    When User selects a Reseller and Clicks Sign In button
    Then the Resellers dashboard is opened

  @[SMSM-221] @Verify-that-user-is-able-to-see-2-options-on-reports-tab
  Scenario: Verify that user is able to see 2 options on reports tab [C22326480]
    When User clicks on the Reports tab on top menu bar
    Then User confirms the options under the Report menu

  @[SMSM-221] @Verify-that-User-is-able-to-Hover-the-mouse-on-merchants-(heading),-then-description-appears-for-that-particular-heading @OnlyMe
  Scenario: Verify that User is able to Hover the mouse on merchants (heading), then description appears for that particular heading [C22326541]
    When User clicks on the Reports tab on top menu bar
    Then User confirms the options under the Report menu
    When User clicks on the Businesses option
    Then the Businesses page is displayed
    And User verifies that all businesses count as per the month
    When User hovers over Active Merchants
    Then User is able to see Active Merchants description
    
