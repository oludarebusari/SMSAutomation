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

  @[SMSM-220] @verify-results-are-displayed-based-on-the-filter-selected-in-Manage-Billing-page-:-Pending
  Scenario: Verify results are displayed based on the filter selected in manage billing page : Pending [C22393408]
    When User clicks on the Billing menu option
    Then the Billing drop down options are displayed
    When User clicks on Manage Billing from the options
    Then User is redirected to the Manage Billing page
    And User verifies the default filter selected
    When User clicks the Pending filter
    Then all the records with Pending status are displayed

  @[SMSM-220] @Add-a-feature-from-Edit-Merchant-Plan 
  Scenario: Add a feature from Edit Merchant plan [C22378137]
    When User clicks on the Billing menu option
    Then the Billing drop down options are displayed
    When User clicks on Manage Billing from the options
    Then User is redirected to the Manage Billing page
    When User clicks the Edit Recurring Plan from drop down
    Then User is redirected to the Edit Merchant plan page
    When User navigate to Feature clicks on add icon
    Then the new field is added
    When User enters the values for a field record and clicks on the Save Plan button
    Then User verifies that the feature is added
 
 @[SMSM-220] @Verify-Edit-Recurring-Plan-option
 Scenario: Verify Edit Recurring plan option [C22393466]
 		When User clicks on the Billing menu option
 		Then the Billing drop down options are displayed
 		Then the Billing drop down options are displayed
 		When User clicks on Manage Billing from the options
 		Then User is redirected to the Manage Billing page
 		When User clicks the Edit Recurring Plan from drop down
 		Then User is redirected to the Edit Merchant plan page
 		And User verifies that the plan name is present 
 		And User verifies that the Plan Description is present
 		And User verifies that the Status drop down is present
 		 
 @[SMSM-220] @Edit-a-feature-in-Edit-Merchant-Plan 
 Scenario: Edit a feature in Edit Merchant Plan [C22378674]
 		When User clicks on the Billing menu option
 		Then the Billing drop down options are displayed
 		When User clicks on Manage Billing from the options
 		Then User is redirected to the Manage Billing page
 		When User clicks the Edit Recurring Plan from drop down
 		Then User is redirected to the Edit Merchant plan page
 		When User navigate to feature and edits some values and clicks the Save Plan button
 		Then User verifies that the feature is updated

  @[SMSM-220] @Remove-a-feature-from-Edit-Merchant-plan
  Scenario: Remove a feature from Edit Merchant plan [C22378181]
    When User clicks on the Billing menu option
    Then the Billing drop down options are displayed
    When User clicks on Manage Billing from the options
    Then User is redirected to the Manage Billing page
    When User clicks the Edit Recurring Plan from drop down
    Then User is redirected to the Edit Merchant plan page
    When User clicks the remove button of a feature and clicks the Save plan button
    Then User verifies that the feature is removed
   
 @[SMSM-220] @Verify-merchant-info-details-in-manage-billing-page 
 Scenario: Verify merchant info details in manage billing page
 		When User clicks on the Billing menu option
 		Then the Billing drop down options are displayed
 		When User clicks on Manage Billing from the options
 		Then User is redirected to the Manage Billing page
 		When User clicks the Merchant Info option
 		Then User is redirected to the Edit Merchant page
 		And User verifies that the Business Information section is displayed
 		And User verifies that the Billing Information section is displayed

@[SMSM-220] @Verify-Invoice-details-are-displayed-on-clicking-view-button-on-Manage-billing-page 
Scenario: Verify Invoice details are displayed on clicking view button on Manage billing page
		When User clicks on the Billing menu option
		Then the Billing drop down options are displayed
		When User clicks on Manage Billing from the options
		Then User is redirected to the Manage Billing page
		When User clicks the view button under actions to view selected merchant invoice details
		Then User is redirected to the invoice page for the selected merchant
		And User verifies the sub sections under the Invoice section
		And User verifies the links on the page
		And User verifies Company Information section is available
		And User verifies Users Section is available on the page
		And User verifies that Transaction History section is available on the page

@[SMSM-220] @Verify-all-merchant-invoices-page-is-displayed @OnlyMe
Scenario: Vewrify all merchant invoices page is displayed
		When User clicks on the Billing menu option
		Then the Billing drop down options are displayed
		When User clicks on Manage Billing from the options
		Then User is redirected to the Manage Billing page
		When User clicks on All Merchant Invoices from the drop down 
    Then User is redirected to Merchant Invoice page
    And User verifies the columns on the invoice page  
		 
		
 