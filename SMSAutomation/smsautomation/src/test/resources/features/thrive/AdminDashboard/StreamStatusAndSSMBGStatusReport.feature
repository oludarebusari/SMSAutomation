#Author: your.email@your.domain.com
#Keywords Summary :

#User is assumed to have Admin access unless stated Otherwise
#Step Definition File - StreamAndSSMBGStatusReportPageSteps.java
@thrive @RegressionTest
Feature: [SMSM-179] View Stream Status Report & SSMBG status report in admin dashboard for Thrive system

  Background: User logs in to Thrive and navigate to Business Dashboard
    Given User Navigates to Thrive URL
    Then Thrive login page is displayed
    When User enters a valid username for thrive
    And User enters a valid password for thrive
    And User clicks the sign in button for thrve
    Then Thrive Dashboard page is displayed
    When User clicks on the Report Menu option on the dashboard
    Then the Reports options are displayed

  @SMSM-179 @Verify-the-details-on-Streams-Connection-Status-report-page-and-verify-the-columns  
  Scenario: Verify the details on "Streams Connection Status" report page and verify the sorting [C22409430]
    When User clicks the Stream Status Report option
    Then the Streams Connection Status page is displayed for the Reseler
    And User verifies the columns on the page

  @SMSM-179 @Verify-functionality-of-Sorting-and-Show-entries-dropdown-on-Streams-Connection-Status-report-page 
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

  @SMSM-179 @Verify-Admin-is-able-to-search-the-Streams-connection-Status-Reports-by-entering-a-search-criteria-in-Search-box-and-clicking-Search 
  Scenario: Verify Admin is able to search the "Streams Connection Status"  Reports by entering a search criteria in Search box and clicking Search [C22409452]
    When User clicks the Stream Status Report option
    Then the Streams Connection Status page is displayed for the Reseler
    When User enters a valid search criteria into the search box of the Stream page and click search
    Then the reseller record is displayed on the Stream page
    When User enters an invalid search criteria into the search box of the Stream page and click search
    Then No record is displayed on the Stream page

  @SMSM-179 @Verify-the-Help-on-Streams-Connection-Status-Reports-page-by-clicking-the-Help-button 
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

  @SMSM-179 @Verify-the-Help-on-Streams-Connection-Status-Reports-page-by-clicking-the-Help-button 
  Scenario: Verify functionality of Sorting and  Show entries dropdown  on "Streams Connection Status" report page [C22409460]
    When User clicks the SSMBG Status Report option
    Then the SSMBG Status Report page is displayed
    And User verifies the column headers present on SSMBG Status Report page
    And User verifies that each record has a View Appointment buttom

  @SMSM-179 @Verify-that-Admin-is-able-to-filter-the"SSMBG-Status-Report"-by-clicking-on-In-Progress,-Fulfilled-&-All-tab 
  Scenario: Verify that Admin is able to filter the "SSMBG Status Report"  by clicking on In Progress, Fulfilled & All tab [C22409793]
    When User clicks the SSMBG Status Report option
    Then the SSMBG Status Report page is displayed
    And User verifies the three tabs for filtering SSMBG Status Reports
    And User verifies the default filtering option
    When User clicks on Fulfilled tab
    Then all records with Status of Fulfilled are displayed
    When User clicks the In Progress tab
    Then all records with Status of In Progress are displayed
    When User clicks on All tab
    Then all the records on SSMBG Status report are displayed

  @SMSM-179 @Verify-functionality-of-Sorting-and-Show-entries-dropdown-on-"SSMBG-Status-Report"-page
  Scenario: Verify functionality of Sorting and Show entries dropdown on "SSMBG Status Report" page [C22409811]
    When User clicks the SSMBG Status Report option
    Then the SSMBG Status Report page is displayed
    When User clicks on the Status column title to sort record in ascending order
    Then the SSMBG Status Reports are sorted in ascending order
    When User clicks on the Status column title to sort records in descending order
    Then the SSMBG Status Reports are sorted in descending order
    And User verifies the default number of records displayed on the SSMBG Status report page
    And User navigates to anoother page on the SSMBG page
    When User changes the show entries option to All
    Then all records are displayed on a single page

  @SMSM-179 @Verify-Admin-is-able-to-search-the-"SSMBG-Status-Report"-by-entering-a-search-criteria-in-Search-box-and-clicking-Search 
  Scenario: Verify Admin is able to search the "SSMBG Status Report" by entering a search criteria in Search box and clicking Search [C22409844]
    When User clicks the SSMBG Status Report option
    Then the SSMBG Status Report page is displayed
    When User enters a valid search criteria into the search box of the SSMBG Status page and click search
    Then the reseller record is displayed on the SSMBG Status page
    When User enters an invalid search criteria into the search box of the SSMBG Status page and click search
    Then No record is displayed on the SSMBG Status page

  @SMSM-179 @Verify-Admin-can-"View-Appointments"-for-a-specified-"SSMBG-Status-Report" 
  Scenario: Verify Admin can "View Appointments" for a specified "SSMBG Status Report" [C22409851]
    When User clicks the SSMBG Status Report option
    Then the SSMBG Status Report page is displayed
		When User clicks View Appointments button for a record on the SSMBG Status report page
		Then the Appointments Set page is opened
		And User verifies that all appintment can be viewed
		And User verifies the columns on the Appointmnents Set page 
		
  @SMSM-179 @Verify-admin-can-filter-the-data-on-"Appointments-Set"-page-by-entering-the-details-in-filter-fields" 
  Scenario: Verify admin can filter the data on "Appointments Set" page by entering the details in filter fields [C22412369]
    When User clicks the SSMBG Status Report option
    Then the SSMBG Status Report page is displayed
		When User clicks View Appointments button for a record on the SSMBG Status report page
		Then the Appointments Set page is opened
		And User verifies the filter option on the Appointment Set page
		When User enters a value for the Vertical filter
		Then Appointments records based on the vertical filter are displayed
		When User clicks the Card view button
		Then the records are presented in card view
		And User enters a value for vertical filter
		
 @SMSM-179 @Verify-admin-can-toggle-the-view-of-"Appointments-Set"-page-to-show-as-Table-or-Tiles-view  
  Scenario: Verify admin can toggle the view of "Appointments Set" page to show as Table or Tiles view [C22412392]
    When User clicks the SSMBG Status Report option
    Then the SSMBG Status Report page is displayed
		When User clicks View Appointments button for a record on the SSMBG Status report page
		Then the Appointments Set page is opened
		And User verifies the toggle view buttons are displayed
		And User verifies that the current view
		When User clicks the Card view button
		Then the records are displayed in card format
		When User clicks the calender view button
		Then the calendar view is displayed
		
 @SMSM-179 @Verify-admin-can-toggle-to-"View-all-Leads"-on-Appointments-Set-page 
  Scenario: Verify admin can toggle to "View all Leads" on Appointments Set page [C22412410]
    When User clicks the SSMBG Status Report option
    Then the SSMBG Status Report page is displayed
		When User clicks View Appointments button for a record on the SSMBG Status report page
		Then the Appointments Set page is opened
		And User verifies that the View all Lead button is available
		And User verifies that all leads are displayed by default
		When User clicks on the view all leads toggle
		Then tthe toggle tooltip text changes and only leads with previous appts or Offers accepted are displayed
		
@SMSM-179 @Verify-that-Admin-can-export-the-data-to-CSV-for-"Appointments-Set"-page  
  Scenario: Verify that Admin can export the data to CSV for "Appointments Set" page [C22412424]
    When User clicks the SSMBG Status Report option
    Then the SSMBG Status Report page is displayed
		When User clicks View Appointments button for a record on the SSMBG Status report page
		Then the Appointments Set page is opened
		And User verifies the Export CSV button and tooltip
		When User clicks the Export CSV button
		Then a CSV file is downloaded and user verifies the filename
		
		
		
		