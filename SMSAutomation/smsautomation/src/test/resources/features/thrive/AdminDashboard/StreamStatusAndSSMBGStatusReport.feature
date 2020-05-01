#Author: your.email@your.domain.com
#Keywords Summary :
#User is assumed to have Admin access unless stated Otherwise
#Step Definition File - StreamAndSSMBGStatusReportPageSteps.java
Feature: [SMSM-179] View Stream Status Report & SSMBG status report in admin dashboard for Thrive system

  Background: User logs in to Thrive and navigate to Business Dashboard
    Given User Navigates to Thrive URL
    Then Thrive login page is displayed
    When User enters a valid username for thrive
    And User enters a valid password for thrive
    And User clicks the sign in button for thrve
    Then Thrive Dashboard page is displayed
    When User clicks on the Report Menu option on the dashboard
    Then the Reports option is displayed

  @SMSM-179 @Verify-the-details-on-Streams-Connection-Status-report-page-and-verify-the-columns @RegressionTest
  Scenario: Verify the details on "Streams Connection Status" report page and verify the sorting [C22409430]
    When User clicks the Stream Status Report option
    Then the Streams Connection Status page is displayed for the Reseler
    And User verifies the columns on the page

  @SMSM-179 @Verify-functionality-of-Sorting-and-Show-entries-dropdown-on-Streams-Connection-Status-report-page @RegressionTest
  Scenario: Verify functionality of Sorting and  Show entries dropdown  on "Streams Connection Status" report page [C22409446]
    When User clicks the Stream Status Report option
    Then the Streams Connection Status page is displayed for the Reseler
    When User clicks on the Reseller column title to sort record in ascending order
    Then the Streams Reports are sorted in ascending order
    When User clicks on the Reseller column title to sort records in descending order
    Then the Streams Reports are sorted in descending order
    When User clicks on the Business column title to sort record in ascending order
    Then the Streams Reports are sorted in ascending order by Business
    When User clicks on the Business column title to sort record in descending order
    Then the Streams Reports are sorted in descending order by Business
    And User verifies the default number of records displayed on the Stream page
    And User navigates to anoother page on the Stream page

  @SMSM-179 @Verify-Admin-is-able-to-search-the-Streams-connection-Status-Reports-by-entering-a-search-criteria-in-Search-box-and-clicking-Search @RegressionTest
  Scenario: Verify Admin is able to search the "Streams Connection Status"  Reports by entering a search criteria in Search box and clicking Search [C22409452]
    When User clicks the Stream Status Report option
    Then the Streams Connection Status page is displayed for the Reseler
    When User enters a valid search criteria into the search box of the Stream page and click search
    Then the reseller record is displayed on the Stream page
    When User enters an invalid search criteria into the search box of the Stream page and click search
    Then No record is displayed on the Stream page

  @SMSM-179 @Verify-the-Help-on-Streams-Connection-Status-Reports-page-by-clicking-the-Help-button @RegressionTest 
  Scenario: Verify functionality of Sorting and  Show entries dropdown  on "Streams Connection Status" report page [C22409457]
    When User clicks the Stream Status Report option
    Then the Streams Connection Status page is displayed for the Reseler
    When User clicks on the Help button on the Stream Connection Status page
    Then a tour guide for is opened on the Stream page
    When User clicks on the Next button from the Stream Connection Status window
    Then the Search window is opened
    When User clicks on the previous button from the Search window
    Then the tour guide is navigate back to the Stream Connection Status window
    When User clicks on End Tour button
    Then Tour ends successfully

  @SMSM-179 @Verify-the-Help-on-Streams-Connection-Status-Reports-page-by-clicking-the-Help-button @RegressionTest @OnlyMe
  Scenario: Verify functionality of Sorting and  Show entries dropdown  on "Streams Connection Status" report page [C22409460]
    When User clicks the SSMBG Status Report option
    Then the SSMBG Status Report page is displayed 
    And User verifies the column headers present on SSMBG Status Report page
    And User verifies that each record has a View Appointment buttom
    
    
