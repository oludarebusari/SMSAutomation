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

#User is assumed to have Admin access unless stated Otherwise
Feature: [SMSM-178] View Licensee Report & Territory report in admin dashboard for Thrive system

  Background: User logs in to Thrive and navigate to Business Dashboard
    Given User Navigates to Thrive URL
    Then Thrive login page is displayed
    When User enters a valid username for thrive
    And User enters a valid password for thrive
    And User clicks the sign in button for thrve
    Then Thrive Dashboard page is displayed
    When User clicks on the Report Menu option on the dashboard
    Then the Reports option is displayed

  @SMSM-178 @Verify-that-admin-can-view-all-Reseller-details-along-with-their-Businesses-count,-on-Reseller-Reports-page @RegressionTest
  Scenario: Verify that admin can view all Reseller details along with their Businesses count, on Reseller Reports page [C22406807]
    When User clicks the Reseller Report
    Then the Reseller Report page is displayed
    And User verifies the columns on the Report Page

  @SMSM-178 @Verify-that-Admin-is-able-to-filter-the-Reports-with-Date-Range-for-Resellers @RegressionTest
  Scenario: Verify that Admin is able to filter the Reports with Date Range for Resellers
    When User clicks the Reseller Report
    Then the Reseller Report page is displayed
    When User clicks the Date Range Picker from the page
    Then the Date Picker window is opened
    When User clicks on the Last Month option
    Then the Date Range and records are updated
    When User enters a custom range and clicks the Apply button
    Then the Date Range and records are updated as per the date specified

  @SMSM-178 @Verify-functionality-of-Show-entries-drop-down-and-sorting-on-"Reports"-page-for-Licensees @RegressionTest
  Scenario: Verify functionality of Show entries drop down and sorting on "Reports" page for Licensees
    When User clicks the Reseller Report
    Then the Reseller Report page is displayed
    When User clicks the Reseller column title to sort by Reseller in ascending order
    Then the reports are sorted in ascending order
    When User clicks the Reseller column title to sort by Reseller in descending order
    Then the reports are sorted in descending order
    And User verifies the default number of records displayed
    And User navigates to anoother page

  @SMSM-178 @Verify-Admin-is-able-to-search-the-Licensee-Reports-by-entering-a-search-criteria-in-Search-box-and-clicking-Search @RegressionTest
  Scenario: Verify Admin is able to search the Licensee Reports by entering a search criteria in Search box and clicking Search [C22406872]
    When User clicks the Reseller Report
    Then the Reseller Report page is displayed
    When User enters a valid search criteria ino the search box and click search
    Then the reseller record is displayed
    When User enters an invalid search criteria into the search box and click search
    Then No record is displayed

  @SMSM-178 @Verify-the-Help-on-"Reports"-page-for-Licensees-by-clicking-the-Help-button @RegressionTest
  Scenario: Verify the Help on "Reports" page for Licensees by clicking the Help button [C22406877]
    When User clicks the Reseller Report
    Then the Reseller Report page is displayed
    When User clicks on the Help button on the Resellers page
    Then a tour guide for is opened
    When User clicks on the Next button from the Reports window
    Then the Data Range window is opened
    When User clicks on the previous button from the Data Rage window
    Then the tour guide is navigate back to the Reports window
    When User clicks on End Tour button
    Then Tour ends successfully

  @SMSM-178 @Verify-that-admin-can-view-all-Reseller-details-along-with-Business,-City,-State,-Postal-Code,-Country,-Action,-on-"Territory-Report"-page @RegressionTest
  Scenario: Verify that admin can view all Reseller details along with Business, City, State, Postal Code, Country, Action, on "Territory Report" page [C22406897]
    When User clicks the Territory Report
    Then the Territory Report page is displayed
    And User verifies the column headers on the Territory Report page

  @SMSM-178 @Verify-that-Admin-is-able-to-filter-the-Territory-reports-by-clicking-on-Allowed,-Disallowed-&-All-tab @RegressionTest
  Scenario: Verify that Admin is able to filter the Territory reports by clicking on Allowed, Disallowed & All tab [C22406902]
    When User clicks the Territory Report
    Then the Territory Report page is displayed
    And User verifies the button for filtering on the Territory Reports
    When User clicks on the Allowed report filter
    Then user verifies that the Allowed button is active
    When User clicks Disallowed report filter
    Then user verifies that the Disallowed button is active
    When User clicks All report filter
    Then user verifies that the All button is active

  @SMSM-178 @Verify-functionality-of-sorting-and-Show-entries-dropdown-and-pagination-on-"Territory-Report"-page @RegressionTest
  Scenario: Verify functionality of sorting and Show entries dropdown and pagination on "Territory Report" page [C22408965]
    When User clicks the Territory Report
    Then the Territory Report page is displayed
    When User clicks the Reseller column title to sort by Teritory Report in ascending order
    Then the Territory reports are sorted in ascending order
    When User clicks the Reseller column title to sort by Territory Report in descending order
    Then the Territory reports are sorted in descending order
    And User verifies the default number of records is displayed for Territory reports
    And User navigates to anoother page on the territory page

  @SMSM-178 @Verify-Admin-is-able-to-search-the-"Territory-Reports"-by-entering-a-search-criteria-in-Search-box-and-clicking-Search @RegressionTest
  Scenario: Verify Admin is able to search the "Territory Reports" by entering a search criteria in Search box and clicking Search [C22408971]
    When User clicks the Territory Report
    Then the Territory Report page is displayed
    When User enters a valid search criteria ino the search box on Territory report page and click search
    Then the reseller record is displayed on the Territory report page
    When User enters an invalid search criteria into the search box on the Territory page and click search
    Then No record is displayed on the Territory page

  @SMSM-178 @Verify-the-Help-on-"Territory-Reports"-page-by-clicking-the-Help-button @RegressionTest @OnlyMe
  Scenario: Verify the Help on "Territory Reports" page by clicking the Help button [C22408976]
    When User clicks the Territory Report
    Then the Territory Report page is displayed
    When User clicks on the Help button on the Territory Reports page
    Then a tour guide for Territory Report is launched
    When User clicks on the Next button from the Licensee Territory Report window
    Then the Filter Report window is opened
    When User clicks on the previous button from the Filter Report window
    Then the tour guide is navigate back to the Licensee Territory Report window
    When User clicks on End Tour button
    Then Tour ends successfully
