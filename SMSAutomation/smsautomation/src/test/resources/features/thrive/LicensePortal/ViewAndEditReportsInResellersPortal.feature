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
    When User clicks on the Reports tab on the top menu bar
    Then User confirms the options under the Report menu

  @[SMSM-221] @Verify-that-User-is-able-to-Hover-the-mouse-on-merchants-(heading),-then-description-appears-for-that-particular-heading
  Scenario: Verify that User is able to Hover the mouse on merchants (heading), then description appears for that particular heading [C22326541]
    When User clicks on the Reports tab on the top menu bar
    Then User confirms the options under the Report menu
    When User clicks on the Businesses option
    Then the Businesses page is displayed
    And User verifies that all businesses count as per the month
    When User hovers over Active Merchants
    Then User is able to see Active Merchants description
    When User hovers over New Merchants
    Then User is able to see the New Merchants description
    When User hovers over Canceled Merchants
    Then User is able to see the Canceled Merchants
    When User hovers over Period Net Merchants
    Then User is able to see Period Net Merchants

  @[SMSM-221] @Verify-that-user-is-able-to-change-selected-count-and-view-more-entries-on-page
  Scenario: Verify that user is able to change selected count and view more entries on page [C22326620]
    When User clicks on the Reports tab on the top menu bar
    Then User confirms the options under the Report menu
    When User clicks on the Businesses option
    Then the Businesses page is displayed
    When User clicks the page drop down count
    Then the page drop down is expanded
    When User clicks on a number from the drop down
    Then User confirms the page count is updated successfully

  @[SMSM-221] @Verify-that-user-is-able-to-see-data-in-the-table-reordered-accordingly 
  Scenario: Verify that user is able to see dat in the table reordered accordingly
    When User clicks on the Reports tab on the top menu bar
    Then User confirms the options under the Report menu
    When User clicks on the Businesses option
    Then the Businesses page is displayed
    And User verifies that the Active Business column is available
    When User clicks the Active Business column
    Then the data on the table is reordered accordingly

  @[SMSM-221] @Verify-that-user-us-able-to-see-create-digital-audit-window-pops-up @OnlyMe
  Scenario: Verify that user is able to see create digital audit window pops-up
  	When User clicks on the Reports tab on the top menu bar
  	Then User confirms the options under the Report menu
  	When User clicks on the Digital Audit option
  	Then the Digital Audit page is displayeed
  	When User clicks on the New button on the Digital Audit page
  	Then the create digital audit window pop up is opened
  	When User enters a URL and Keyword and clicks Add button
  	Then User verifies that the Digital Audit is created
  	
