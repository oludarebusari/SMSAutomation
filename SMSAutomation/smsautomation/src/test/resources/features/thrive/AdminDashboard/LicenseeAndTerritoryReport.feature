#Author: Aclate QA
#User is assumed to have Admin access unless stated Otherwise
#Step Definition File - AdminResellerAndTerritoryReportPageSteps.java
@thrive @RegressionTest
Feature: [SMSM-178] View Licensee Report & Territory report in admin dashboard for Thrive system

  Background: User logs in to Thrive and navigate to Business Dashboard
    Given User Navigates to Thrive URL
    Then Thrive login page is displayed
    When User enters a valid username for thrive
    And User enters a valid password for thrive
    And User clicks the sign in button for thrve
    Then Thrive Dashboard page is displayed
    When User clicks on the Report Menu option on the dashboard
    Then the Reports options are displayed

  @SMSM-178 @Verify-that-admin-can-view-all-Reseller-details-along-with-their-Businesses-count,-on-Reseller-Reports-page 
  Scenario: Verify that admin can view all Reseller details along with their Businesses count, on Reseller Reports page [C22406807]
    When User clicks the Reseller Report
    Then the Reseller Report page is displayed
    And User verifies the columns on the Report Page

  @SMSM-178 @Verify-that-Admin-is-able-to-filter-the-Reports-with-Date-Range-for-Resellers 
  Scenario: Verify that Admin is able to filter the Reports with Date Range for Resellers
    When User clicks the Reseller Report
    Then the Reseller Report page is displayed
    When User clicks the Date Range Picker from the page
    Then the Date Picker window is opened
    When User clicks on the Last Month option
    Then the Date Range and records are updated
    When User enters a custom range and clicks the Apply button
    Then the Date Range and records are updated as per the date specified

  @SMSM-178 @Verify-functionality-of-Show-entries-drop-down-and-sorting-on-"Reports"-page-for-Licensees 
  Scenario: Verify functionality of Show entries drop down and sorting on "Reports" page for Licensees
    When User clicks the Reseller Report
    Then the Reseller Report page is displayed
    When User clicks the Reseller column title to sort by Reseller in ascending order
    Then the reports are sorted in ascending order
    When User clicks the Reseller column title to sort by Reseller in descending order
    Then the reports are sorted in descending order
    And User verifies the default number of records displayed
    And User navigates to anoother page

  @SMSM-178 @Verify-Admin-is-able-to-search-the-Licensee-Reports-by-entering-a-search-criteria-in-Search-box-and-clicking-Search 
  Scenario: Verify Admin is able to search the Licensee Reports by entering a search criteria in Search box and clicking Search [C22406872]
    When User clicks the Reseller Report
    Then the Reseller Report page is displayed
    When User enters a valid search criteria ino the search box and click search
    Then the reseller record is displayed
    When User enters an invalid search criteria into the search box and click search
    Then No record is displayed

  @SMSM-178 @Verify-the-Help-on-"Reports"-page-for-Licensees-by-clicking-the-Help-button 
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

  @SMSM-178 @Verify-that-admin-can-view-all-Reseller-details-along-with-Business,-City,-State,-Postal-Code,-Country,-Action,-on-"Territory-Report"-page  
  Scenario: Verify that admin can view all Reseller details along with Business, City, State, Postal Code, Country, Action, on "Territory Report" page [C22406897]
    When User clicks the Territory Report
    Then the Territory Report page is displayed
    And User verifies the column headers on the Territory Report page

  @SMSM-178 @Verify-that-Admin-is-able-to-filter-the-Territory-reports-by-clicking-on-Allowed,-Disallowed-&-All-tab
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

  @SMSM-178 @Verify-functionality-of-sorting-and-Show-entries-dropdown-and-pagination-on-"Territory-Report"-page
  Scenario: Verify functionality of sorting and Show entries dropdown and pagination on "Territory Report" page [C22408965]
    When User clicks the Territory Report
    Then the Territory Report page is displayed
    When User clicks the Reseller column title to sort by Teritory Report in ascending order
    Then the Territory reports are sorted in ascending order
    When User clicks the Reseller column title to sort by Territory Report in descending order
    Then the Territory reports are sorted in descending order
    And User verifies the default number of records is displayed for Territory reports
    And User navigates to anoother page on the territory page

  @SMSM-178 @Verify-Admin-is-able-to-search-the-"Territory-Reports"-by-entering-a-search-criteria-in-Search-box-and-clicking-Search 
  Scenario: Verify Admin is able to search the "Territory Reports" by entering a search criteria in Search box and clicking Search [C22408971]
    When User clicks the Territory Report
    Then the Territory Report page is displayed
    When User enters a valid search criteria ino the search box on Territory report page and click search
    Then the reseller record is displayed on the Territory report page
    When User enters an invalid search criteria into the search box on the Territory page and click search
    Then No record is displayed on the Territory page

  @SMSM-178 @Verify-the-Help-on-"Territory-Reports"-page-by-clicking-the-Help-button 
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

  @SMSM-178 @Verify-Admin-is-able-to-Allow/Disallow-a-Reseller-under-Territory-report 
  Scenario: Verify Admin is able to Allow/Disallow a Licensee under Territory report [C22408980]
    When User clicks the Territory Report
    Then the Territory Report page is displayed
    When User clicks the Allow button under the Action column for Reseller
    Then the Action column for the specified Reseller gets changed to Disallow
    When User clicks the Disallow button under the Action column for Reseller
    Then the Action column for the specified Reseller gets changed to Allow

  @SMSM-178 @Verify-Admin-can-edit-the-Reseller-details-from-Territory-report-page 
  Scenario: Verify Admin can edit the Licensee details from Territory report page [C22409002]
    When User clicks the Territory Report
    Then the Territory Report page is displayed
    When User clicks the drop down button under Action column and clicks Edit Reseller
    Then User is redirected to Edit Reseller page
    When User makes changes and clicks the Save Reseller
    Then the Reseller is updated successfully
    And user confirms the changes made to Reseller were saved correctly

  @SMSM-178 @Verify-Admin-can-edit-the-Business-details-from-Territory-report-page
  Scenario: Verify Admin can edit the Merchant details from Territory report page [C22409051]
    When User clicks the Territory Report
    Then the Territory Report page is displayed
    When User clicks the drop down button under Action column and clicks Edit Business
    Then User is redirected to Edit Business page
    When User makes changes to Business and clicks the Save Business
    Then the Business is updated successfully
    And user confirms the changes made to Business were saved correctly
    #Revert Changes
    And User revert the changes made to Business.
    And User revert changes made to Reseller
    
