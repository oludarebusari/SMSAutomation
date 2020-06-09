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
    When User clicks on the Billing menu option
    Then the Billing drop down options are displayed
    When User clicks on Manage Billing from the options
    Then User is redirected to the Manage Billing page

  @[SMSM-220] @verify-the-details-displayed-within-manage-billing-page
  Scenario: Verify the details displayed within manage billing page [C22378701]
    And User verifies the columns on the Manage Billing page
    And User verifies the filter options displayed on the Manage Billing page

  @[SMSM-220] @verify-results-are-displayed-based-on-the-filter-selected-in-manage-billing-page-:-Cancelled
  Scenario: Verify results are displayed based on the filter selected in manage billing page : Cancelled [C22378700]
    And User verifies the default filter selected
    When User clicks the Cancelled filter
    Then all the records with Cancelled status are displayed

  @[SMSM-220] @verify-results-are-displayed-based-on-the-filter-selected-in-manage-billing-page-:-Late
  Scenario: Verify results are displayed based on the filter selected in Manage Billing page : Late [C22393409]
    And User verifies the default filter selected
    When User clicks the Late filter
    Then all the records with Late status are displayed

  @[SMSM-220] @verify-results-are-displayed-based-on-the-filter-selected-in-Manage-Billing-page-:-Pending
  Scenario: Verify results are displayed based on the filter selected in manage billing page : Pending [C22393408]
    And User verifies the default filter selected
    When User clicks the Pending filter
    Then all the records with Pending status are displayed

  @[SMSM-220] @Add-a-feature-from-Edit-Merchant-Plan
  Scenario: Add a feature from Edit Merchant plan [C22378137]
    When User clicks the Edit Recurring Plan from drop down
    Then User is redirected to the Edit Merchant plan page
    When User navigate to Feature clicks on add icon
    Then the new field is added
    When User enters the values for a field record and clicks on the Save Plan button
    Then User verifies that the feature is added

  @[SMSM-220] @Verify-Edit-Recurring-Plan-option
  Scenario: Verify Edit Recurring plan option [C22393466]
    When User clicks the Edit Recurring Plan from drop down
    Then User is redirected to the Edit Merchant plan page
    And User verifies that the plan name is present
    And User verifies that the Plan Description is present
    And User verifies that the Status drop down is present

  @[SMSM-220] @Edit-a-feature-in-Edit-Merchant-Plan
  Scenario: Edit a feature in Edit Merchant Plan [C22378674]
    When User clicks the Edit Recurring Plan from drop down
    Then User is redirected to the Edit Merchant plan page
    When User navigate to feature and edits some values and clicks the Save Plan button
    Then User verifies that the feature is updated

  @[SMSM-220] @Remove-a-feature-from-Edit-Merchant-plan
  Scenario: Remove a feature from Edit Merchant plan [C22378181]
    When User clicks the Edit Recurring Plan from drop down
    Then User is redirected to the Edit Merchant plan page
    When User clicks the remove button of a feature and clicks the Save plan button
    Then User verifies that the feature is removed

  @[SMSM-219] @Verify-merchant-info-details-in-manage-billing-page
  Scenario: Verify merchant info details in manage billing page [C22398538]
    When User clicks the Merchant Info option
    Then User is redirected to the Edit Merchant page
    And User verifies that the Business Information section is displayed
    And User verifies that the Billing Information section is displayed

  @[SMSM-220] @Verify-Invoice-details-are-displayed-on-clicking-view-button-on-Manage-billing-page
  Scenario: Verify Invoice details are displayed on clicking view button on Manage billing page
    When User clicks the view button under actions to view selected merchant invoice details
    Then User is redirected to the invoice page for the selected merchant
    And User verifies the sub sections under the Invoice section
    And User verifies the links on the page
    And User verifies Company Information section is available
    And User verifies Users Section is available on the page
    And User verifies that Transaction History section is available on the page

  @[SMSM-219] @Verify-all-merchant-invoices-page-is-displayed
  Scenario: Verify all merchant invoices page is displayed [C22406287]
    When User clicks on All Merchant Invoices from the drop down
    Then User is redirected to Merchant Invoice page
    And User verifies the columns on the invoice page

  @[SMSM-219] @Restore-invoice-option-in-manage-billing-page
  Scenario: Restore invoice option in manage billing page [C22406328]
    When User clicks on Restore this Invoice from action drop down options
    Then the Restore Invoice modal is displayed
    And User sets a new date to invoice
    And User clicks on the checkbox to Send an Invoice restore alert email to the Merchant
    When User clicks on the Restore Invoice button
    Then the Invoice is restored and status is changed due

  @[SMSM-219] @Cancel-invoice-option-in-manage-billing-page
  Scenario: Cancel Invoice option in manage billing page [C22406345]
    When User clicks on Cancel this invoice from action drop down options
    Then the Confirm Invoice Cancelation modal is displayed
    And User clicks on the checkbox to Send an invoice cancelation alert emailto the merchant
    When User clicks on the Cancel Invoice button
    Then the Invoice is cancelled and status of the Invoice changed to Cancelled

  @[SMSM-219] @Validate-the-help-button-functionality-on-Manage-Billing-page
  Scenario: Validate the help button functionality on Manage Billing page [C22406353]
    When User clicks the help button on the Manage Billing page
    Then Actionable Tiles modal is displayed
    When User clicks the Next button on the Actionable Tiles modal
    Then the Late Payments Tile modal is displayed
    When User clicks on the previous button on the Late Payments Tile modal
    Then User is navigated to the Actionable Tiles modal Modal
    When User clicks on End Tour button
    Then Tour ends successfully

  #Skipping Add a credit card in Edit merchant info details test case because of lack of Credit Card Info
  @[SMSM-219] @Change-the-billing-type-to-Credit-Card-in-Edit-Merchant-Page
  Scenario: Change the billing type to Credit card in Edit Merchant Page [C22437540]
    And User clicks on Merchant Info from action drop down options
    When User clicks the Invoice toggle under Billing Information
    Then the toggle changes to Credit Card and Credit card detail elemets displayed

  @[SMSM-219] @Edit-merchant-info-details-select-the-previously-purchased-domain 
  Scenario: Edit merchant info details - select the previously purchased domain [C22437519]
    When User clicks on Merchant Info from drop down options
    And User selects a different Business Category option
    And User clicks on the Site toggle
    And User clicks on the Save button
    And User verifies the changes made to the merchant info details
    #Revert Changes made to merchant info details
    And User reverted changes made to merchant info details

  @[SMSM-219] @Edit-the-address-in-Billing-information-in-Edit-Merchant-page
  Scenario: Edit the address in Billing information in the Edit Merchant page [C22437545]
    And User clicks on Merchant Info from drop down options
    And User edits the Address field under Billing information
    And User edits the City field under Billing information
    And User select a country from the Country drop down
    And User selects a state from the State drop down
    And User enters a zipcode
    And User clicks the Save button and verifies the nottification alert
    And User verifies the changes made to the Billing information
    #Revert Changes made to the Billing Address
    And User Revert the changes made to the Billing Information
    
    

