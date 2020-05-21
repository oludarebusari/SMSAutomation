#Author: your.email@your.domain.com
#Keywords Summary :

#User is assumed to have Admin access unless stated Otherwise
@thrive @RegressionTest 
Feature: [SMSM-135] View invoice, edit payment info & billing information in Merchant's portal for Thrive system

  Background: User logs in to Thrive and navigate to Business Dashboard
    Given User Navigates to Thrive URL
    Then Thrive login page is displayed
    When User enters a valid username for thrive
    And User enters a valid password for thrive
    And User clicks the sign in button for thrve
    Then Thrive Dashboard page is displayed
    When User navigates to Companies menu and clicks the Businesses option
    Then the user is redirected to the Manage Businesses page
    When User navigates to the actions column of a Business and clicks Sign In button
    Then User is logged into the Business and the business dashboard is opened
    When User clicks the Billing menu option
    Then User is redirected to Billing page

  @SMSM-135 @Validate-the-options-in-Billing-page 
  Scenario: Validate the options in Billing page
    And User verifies the Current Balance Tile
    And User verifies the Invoice Method Payment Tile
    And User verifies the Billing information Tile
    And User verifies that the Invoice History section is present

  @SMSM-135 @View-the-Invoice-and-Current-Balance 
  Scenario: View the Invoice and Current Balance
    And User verifies that the View Invoice link is present
    When User clicks on View Invoice link
    Then the View Invoice page is opened
    And User verifies One TimePrice, Recurring price and Date is present on the page
    And User verifies the Current Balance on the Invoice page

  @SMSM-135 @Print-the-Invoice
  Scenario: Print the Invoice
    When User clicks on View Invoice link
    Then the View Invoice page is opened
    When User clicks the Print Invoice
    Then the windows print dialog is opened

  @SMSM-135 @Edit-User-Information-from-Invoice-page  
  Scenario: Edit User Information from Invoice page
    When User clicks on View Invoice link
    Then the View Invoice page is opened
    And user verifies that he Users panel is present
    When User navigates to a desired user object and click the Edit icon beside it
    Then the Edit User page is displayed
    And User edits the first name
    And User edits the last name
    And user edits the primary email
    And user edits the password
    And User edits the cell phone
    And User selects a status from System Notifications
    When User clicks on Save button on the edit User page
    Then a success message about the update is displayed
    #Revert-changes-to-Company
    When User changes first name, last name email amd Cell phone to their original values
    When User clicks on Save button on the edit User page
    Then a success message about the update is displayed

  @SMSM-135 @Edit-Company-information-from-Invoice-page
  Scenario: Edit Company information from Invoice page
    When User clicks on View Invoice link
    Then the View Invoice page is opened
    And User validate the Company Information is present
    When User clicks the Edit icon from Company Information panel
    Then the Edit Company page is opened
    And User edits the Business name
    And User edits the Support email
    And User edits the Business phone
    And User clicks the company logo choose button, selects a file and clicks open
    When User clicks on Save button
    Then a success message is displayed
    #Revert-changes-to-Company
    When User changes Business name, support email and business phone to their original value
    When User clicks on Save button
    Then a success message is displayed

  @SMSM-135 @Edit-Billing-information-from-Invoice-page 
  Scenario: Edit Billing information from Invoice page
    When User clicks on View Invoice link
    Then the View Invoice page is opened
    When User clicks Edit Billing Information link
    Then the Edit Company page is opened
    And User verifies that Business Information section exists
    And User edits the Business Information pnhone number
    And User verifies that Billing Information section exists
    And User edits the State and Country from billing Info Section
    When User clicks on Save button
    Then a success message is displayed
    When User clicks the Billing menu option
    And User clicks on View Invoice link
    And User clicks the Edit icon from Company Information panel
    Then User verifies that the edited Billing info fields were saved correctly
    #Revert-changes-to-Billing Information
    When User changes Business phone, State and country to thier original value
    When User clicks on Save button
    Then a success message is displayed

  @SMSM-135 @Check-for-transaction-history-from-Invoice-page 
  Scenario: Check for Transaction History from Invoice page
    When User clicks on View Invoice link
    Then the View Invoice page is opened
    And User verifies that the Transaction History panel is present on the View Invoice page
    And User verifies that Date column is present under Transaction history
    And USer verifies that Status columnr is present under Transaction history
    And User verifies that Amount Due column is present under Transaction history

  @SMSM-135 @Edit-Payment-Information-from-Billing-page 
  Scenario: Edit Payment information from Billing page
    When User clicks the Edit Payment link from the Billing page
    Then the Edit Company page is opened
    And User edits the Address field
    And User edits the City field
    And User edits the ZipCode field
    When User clicks on Save button
    Then a success message is displayed
    When User clicks the Billing menu option
    And User clicks the Edit Payment link from the Billing page
    Then User verifies that the edited fields were saved correctly
    #Revert-changes-to-Billing Information
    And User changes Address City and ZipCode fields to thier original value
    When User clicks on Save button
    Then a success message is displayed

  @SMSM-135 @Edit-Billing-Information-from-Billing-page 
  Scenario: Edit Billing Information from Billing page
    When User clicks the Edit Billing Information link
    Then the Edit Company page is opened
    And User verifies that Business Information section exists
    And User edits the Business Information pnhone number
    And User verifies that Billing Information section exists
    And User edits the State and Country from billing Info Section
    When User clicks on Save button
    Then a success message is displayed
    When User clicks the Billing menu option
    And User clicks on View Invoice link
    And User clicks the Edit icon from Company Information panel
    Then User verifies that the edited Billing info fields were saved correctly
    #Revert-changes-to-Billing Information
    When User changes Business phone, State and country to thier original value
    When User clicks on Save button
    Then a success message is displayed

  @SMSM-135 @check-for-Invoice-History-from-Billing-page 
  Scenario: Check for Invoice History from Billing page
    And User verifies that the Invoice History section is present
    And User verifies that Due Column is present
    And User verifies Amount Column is present
    And User verifies Status column is present
    And User verifies Action Column is present

  @SMSM-135 @View-the-selected-Invoice-details-from-Invoice-History  
  Scenario: View the selected Invoice details from Invoice History
    And User verifies that the Invoice History section is present
    When User clicks the View button for an Invoice
    Then the details of the Invoice clicked is displayed on the Invoice page

  @SMSM-135 @Verify-Help-option-for-Billing-page 
  Scenario: Verify Help option for Billing page
    And User verifies that Help button is present on the page
    When User clicks the Help button
    Then the help tour guide is opened
    When USer clicks the Next button
    Then the tour guide proceeds to the next step for Billing
    When User clicks the Previous button
    Then the tour guide navigates to the previous for Billing
    When User clicks the End Tour button
    Then the Tour ends successfully

  @SMSM-135 @Verify-Help-option-for-Invoice-page  
  Scenario: Verify Help option for Invoice page
    When User clicks on View Invoice link
    Then the View Invoice page is opened
    And User verifies that Help button is present on the page
    When User clicks the Help button
    Then the help tour guide is opened
    When USer clicks the Next button
    Then the tour guide proceeds to the next step for Invoice
    When User clicks the Previous button
    Then the tour guide navigates to the previous step for Invoice
    When User clicks the End Tour button
    Then the Tour ends successfully
    
  @SMSM-135 @Change-the-Show-Entry-Count-for-Invoice-History-in-Billing-Page 
  Scenario: Change the Show Entry count for Invoice History in Billing page
   #ToDO - There is not sufficient data to complete this test.
    
    
    
