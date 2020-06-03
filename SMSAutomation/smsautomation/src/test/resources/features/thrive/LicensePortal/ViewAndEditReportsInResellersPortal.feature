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
  Scenario: Verify that user is able to see dat in the table reordered accordingly [C22326633]
    When User clicks on the Reports tab on the top menu bar
    Then User confirms the options under the Report menu
    When User clicks on the Businesses option
    Then the Businesses page is displayed
    And User verifies that the Active Business column is available
    When User clicks the Active Business column
    Then the data on the table is reordered accordingly

  @[SMSM-221] @Verify-that-user-is-able-to-see-create-digital-audit-window-pops-up
  Scenario: Verify that user is able to see create digital audit window pops-up [C22326649]
    When User clicks on the Reports tab on the top menu bar
    Then User confirms the options under the Report menu
    When User clicks on the Digital Audit option
    Then the Digital Audit page is displayed
    When User clicks on the New button on the Digital Audit page
    Then the create digital audit window pop up is opened

  @[SMSM-221] @Verify-that-digital-audit-is-added-under-digital-audit-page
  Scenario: Verify that digital audit is added under digital audit page [C22326657]
    When User clicks on the Reports tab on the top menu bar
    Then User confirms the options under the Report menu
    When User clicks on the Digital Audit option
    Then the Digital Audit page is displayed
    When User clicks on the New button on the Digital Audit page
    Then the create digital audit window pop up is opened
    When User enters a URL and Keyword and clicks Add button
    Then User verifies that the Digital Audit is created

  @[SMSM-221] @Verify-that-user-is-able-to-download-pdf-file-for-selected-URL-locally-on-your-system
  Scenario: Verify that user is able to download pdf file for selected URL locally on your system [C22326669]
    When User clicks on the Reports tab on the top menu bar
    Then User confirms the options under the Report menu
    When User clicks on the Digital Audit option
    Then the Digital Audit page is displayed
    And User verifies the columns on the digital audit page
    When User clicks the download button for a Digital Audit
    Then user confirms that a pdf file is downloaded

  @[SMSM-221] @Verify-that-user-is-redirected-to-digital-audit-view-page-and-user-can-view-the-data
  Scenario: Verify that user is redirected to digital audit view page and user can view the data [C22326736]
    When User clicks on the Reports tab on the top menu bar
    Then User confirms the options under the Report menu
    When User clicks on the Digital Audit option
    Then the Digital Audit page is displayed
    When User clicks the drop down button for a digital audit
    And User clicks the View button
    Then user is redirected to the view page of the digital audit

  @[SMSM-221] @Verify-that-is-able-to-delete-digital-audit-url-from-the-list
  Scenario: Verify that user is able to delete digital audit url from the list [C22326742]
    When User clicks on the Reports tab on the top menu bar
    Then User confirms the options under the Report menu
    When User clicks on the Digital Audit option
    Then the Digital Audit page is displayed
    When User selects the the Digital Audit URL to delete and clicks the Delete button
    Then the Delete Audit modal is opened
    When User clicks the Delete button on the Delete Audit modal
    Then User confirms that the Digital Audit URL is deleted

  @[SMSM-221] @Verify-that-user-is-able-to-search-for-a-digital-audit-using-keyword 
  Scenario: Verify that is able to search for a digital audit using keyword [C22331044]
    When User clicks on the Reports tab on the top menu bar
    Then User confirms the options under the Report menu
    When User clicks on the Digital Audit option
    Then the Digital Audit page is displayed
    When User types in the keyword to search for into the Search textbox and click Search button
    Then the Digital Audit record is displayed

  @SMSM-171 @Verify-the-help-button-functionaliomty-within-digital-audit-page
  Scenario: Verify the help button functionality within digital audit page [C22331060]
    When User clicks on the Reports tab on the top menu bar
    Then User confirms the options under the Report menu
    When User clicks on the Digital Audit option
    Then the Digital Audit page is displayed
    When User clicks the Help button on the Digital Audit page
    Then the Create New Audit help tour window appears
    When User clicks the Next button on the Create New Audit help window
    Then the URL window is displayed
    When User clicks the previous button on the URL window
    Then User is navigated to the create New Audit window
    When User clicks on End Tour button
    Then Tour ends successfully
   
 @SMSM-171 @Verify-admin-can-edit-a-company's-details-under-a-particular-Reseller 
  Scenario: Verify admin can edit a company's details under a particular Reseller [C22331060]
  	And User verifies that the edit drop down button is available for each Ressler
  	When User clicks the Edit option for a Reseller
  	Then the Edit Business window is opened
  	When User edits some information on the Edit Business page and clicks Save button 
    Then User confirms that the information is saved correctly
    
    #Revert Changes
    And User revert the changes made to Reseller Business

 
