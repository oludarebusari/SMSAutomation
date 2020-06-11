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
    
 @[SMSM-214] @Verify-the-functionality-of-Edit-Recurring-Plan-for-selected-Businesses-invoice-from-Invoices-page @OnlyMe
 Scenario: Verify the functionality of the Edit Recurring Plan for selected Businesses invoice from Invoices page   
	  When User clicks on the Invoices option from the Billing options
	  Then User is redirected to the Invoice page
	  When User clicks the drop down action button for an Invoice
	  Then the drop down action options are displayed
	  When User clicks on Edit Recurring Plan 
	  Then User is redirected to the Edit Business plan page
	  When User edits the required details and clicks Save Plan
	  Then changes were updated and notication alert displayed.
	  
@[SMSM-214] @Verify-the-functionality-of-View-Merchant-Info-from-Invoices-page
Scenario: Verify the functionality of View Merchant Info from Invoices page