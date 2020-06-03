#Author: your.email@your.domain.com
#Keywords Summary :
#Step Definition File - ManageBillingUnderResellerPortal.java
@thrive @RegressionTest
Feature: [SMSM-220] Manage Billing under billing section in Licensees portal for Thrive system

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

  @[SMSM-220] @verify-the-details-displayed-within-manage-billing-page
  Scenario: Verify the details displayed within manage billing page [C22378701]
    When User clicks on the Billing menu option
    Then the Billing drop down options are displayed
    When User clicks on Manage Billing from the options
    Then User is redirected to the Manage Billing page
    And User verifies the columns on the Manage Billing page
    And User verifies the filter options displayed on the Manage Billing page

  @[SMSM-220] @verify-results-are-displayed-based-on-the-filter-selected-in-manage-billing-page-:-Cancelled
  Scenario: Verify results are displayed based on the filter selected in manage billing page : Cancelled [C22378700]
    When User clicks on the Billing menu option
    Then the Billing drop down options are displayed
    When User clicks on Manage Billing from the options
    Then User is redirected to the Manage Billing page
    And User verifies the default filter selected
    When User clicks the Cancelled filter
    Then all the records with Cancelled status are displayed

  @[SMSM-220] @verify-results-are-displayed-based-on-the-filter-selected-in-manage-billing-page-:-Late
  Scenario: Verify results are displayed based on the filter selected in Manage Billing page : Late [C22393409]
    When User clicks on the Billing menu option
    Then the Billing drop down options are displayed
    When User clicks on Manage Billing from the options
    Then User is redirected to the Manage Billing page
    And User verifies the default filter selected
    When User clicks the Late filter
    Then all the records with Late status are displayed

  @[SMSM-220] @verify-results-are-displayed-based-on-the-filter-selected-in-Manage-Billing-page-:-Pending @OnlyMe
  Scenario: Verify results are displayed based on the filter selected in manage billing page : Pending [C22393408]
    When User clicks on the Billing menu option
    Then the Billing drop down options are displayed
    When User clicks on Manage Billing from the options
    Then User is redirected to the Manage Billing page
    And User verifies the default filter selected
    When User clicks the Pending filter
    Then all the records with Pending status are displayed
