#Author: your.email@your.domain.com
#Keywords Summary:
#Step Definition File - AccessOptionsInInvoicesPageUnderBilling.java
@thrive @RegressionTest
Feature: [SMSM-214] Access other options in invoices page under billing in Licensees portal for Thrive system

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
    When User clicks on the Billing menu option
    Then the Billing drop down options are displayed

  @[SMSM-214] @Verify-the-functionality-of-Edit-Recurring-Plan-for-selected-Businesses-invoice-from-Invoices-page
  Scenario: Verify the functionality of the Edit Recurring Plan for selected Businesses invoice from Invoices page [C22424286]
    When User clicks on the Invoices option from the Billing options
    Then User is redirected to the Invoice page
    When User clicks the drop down action button for an Invoice
    Then the drop down action options are displayed
    When User clicks on Edit Recurring Plan
    Then User is redirected to the Edit Business plan page
    When User edits the required details and clicks Save Plan
    Then changes were updated and notification alert displayed.

  @[SMSM-214] @Verify-the-functionality-of-View-Merchant-Info-from-Invoices-page
  Scenario: Verify the functionality of View Merchant Info from Invoices page [C22424295]
    When User clicks on the Invoices option from the Billing options
    Then User is redirected to the Invoice page
    When User clicks the drop down action button for an Invoice
    Then the drop down action options are displayed
    When User clicks on Merchant Info
    Then User is redirected to the Edit Merchant page
    When User edits some of the required fields on the Edit Merchant
    Then User verifies that the changes made on the Edit Merchant were saved correctly
    #Revert changes made to Business
    And User revert the changes made to the business record

  @[SMSM-214] @Verify-User-can-check-for-all-Business-invoices-from-Invoices-Page
  Scenario: Verify User can check for all Business invoices from Invoices Page [C22424297]
    When User clicks on the Invoices option from the Billing options
    Then User is redirected to the Invoice page
    When User clicks the drop down action button for an Invoice
    Then the drop down action options are displayed
    When User clicks on All Merchants Invoices
    Then All all invoices for the Business are displayed

  @[SMSM-214] @Verify-the-Action-drop-down-for-Cancelled-Invoices
  Scenario: Verify the Action drop down for Cancelled Invoices [C22424326]
    When User clicks on the Invoices option from the Billing options
    Then User is redirected to the Invoice page
    When User clicks the drop down action button for a Cancelled Invoice
    Then the drop down action options are displayed

  @[SMSM-214] @Verify-Cancelled-invoices-can-be-restored-from-Invoices-page
  Scenario: Verify Cancelled invoices can be restored from Invoices page [C22424324]
    When User clicks on the Invoices option from the Billing options
    Then User is redirected to the Invoice page
    When User clicks the drop down action button for a Cancelled Invoice
    Then the drop down action options are displayed
    When User clicks on Restore this invoice
    Then the Restore Invoice modal is displayed
    And User clicks the Restore Invoice button on the modal
    Then User verifies that the invoices is restored

  @[SMSM-214] @Verify-the-Action-drop-down-for-Restored-invoices
  Scenario: Verify the Action drop down for Restored invoices [C22424328]
    When User clicks on the Invoices option from the Billing options
    Then User is redirected to the Invoice page
    When User clicks the drop down action button for Restored invoices
    Then the drop down action options for a Restored Invoice are displayed

  @[SMSM-214] @Verify-Invoices-whose-payment-is-not-done-can-be-cancelled
  Scenario: Verify Invoices whose payment is not done can be cancelled [C22424325]
    When User clicks on the Invoices option from the Billing options
    Then User is redirected to the Invoice page
    When User clicks the drop down action button for a Pending Invoice
    Then the drop down action options for a Pending Invoice are displayed
    When User clicks the Cancel this Invoice option
    Then the Confirm Invoice Cancelation modal is displayed
    And User click the Cancel Invoice button
    Then user verifies that the Invoice is cancelled

  @[SMSM-214] @Verify-the-Action-drop-down-for-Paid-Invoices
  Scenario: Verify the Action drop down for Paid Invoices [C22424329]
    When User clicks on the Invoices option from the Billing options
    Then User is redirected to the Invoice page
    When User clicks the drop down action button for Paid
    Then the drop down action options for a Paid Invoice are displayed

  @[SMSM-214] @Verify-the-Help-on-"Invoices"-page-by-clicking-the-Help-button
  Scenario: Verify the Help on Invoices page by clicking the Help button [C22424331]
    When User clicks on the Invoices option from the Billing options
    Then User is redirected to the Invoice page
    And User verifies that Help button is displayed on the page
    When User clicks the Help button on the Invoice page
    Then the Manage Invoices window is displayed
    When User clicks the Next button on the Manage Invoices window
    Then the Search for Merchant Invoices window is displayed
    When User clicks on the Previous button on the Search for Merchant Invoices window
    Then User is navigated back to the Manage Invoices windows
    When User clicks on End Tour button
    Then Tour ends successfully

  @[SMSM-214] @Verify-Admin-is-able-to-search-the-Invoice-by-entering-a-search-criteria-in-Search-box-and-clicking-Search-on-Invoices-page
  Scenario: Verify Admin is able to search the Invoice by entering a search criteria in Search box and clicking Search on Invoices page [C22424352]
  	When User clicks on the Invoices option from the Billing options
  	Then User is redirected to the Invoice page
  	And User verifies the Search textbox and Search buttons
  	When User enters a valid search criteria into the Search box and clicks Search button
  	Then the search result is displayed
  	When User enters an invalid Search criteria into the Search box and clicks the Search  button
  	Then zero result is displayed
  	
 @[SMSM-214] @Verify-Invoices-records-can-be-sorted-by-clicking-on-arrows-icon-on-the-side-of-each-column-heading
 Scenario: Verify Invoices records can be sorted by clicking on arrows icon on the side of each column heading [C22424360]
 		When User clicks on the Invoices option from the Billing options
 		Then User is redirected to the Invoice page
 		And User verifies the columns on the Invoice page
 		When User clicks the Invoice column
 		Then the records are sorted by the column clicked in ascending order
 		
 		
 		
 		
 
 
 
 
 
