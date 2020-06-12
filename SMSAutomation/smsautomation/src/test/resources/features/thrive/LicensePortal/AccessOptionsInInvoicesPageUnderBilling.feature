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

  @[SMSM-214] @Verify-Cancelled-invoices-can-be-restored-from-Invoices-page @OnlyMe
  Scenario: Verify Cancelled invoices can be restored from Invoices page [C22424324]
  	When User clicks on the Invoices option from the Billing options
  	Then User is redirected to the Invoice page
  	When User clicks the drop down action button for a Cancelled Invoice
  	Then the drop down action options are displayed
  	When User clicks on Restore this invoice
		Then the Restore Invoice modal is displayed
		And User clicks the Restore Invoice button on the modal
		Then User verifies that the invoices is restored
		
		
		
		
		
		
		
			
  	
  	
  	
  	
