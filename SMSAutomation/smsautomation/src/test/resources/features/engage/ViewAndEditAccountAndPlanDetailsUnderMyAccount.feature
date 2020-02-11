#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

Feature: View and Edit account and plan details under my account

  Background: User is logged in and navigates to the Merchant's Dashboard
    Given User navigate to Engage url
    And User enters a valid username
    And User enters a valid password
    And User clicks on the login button
    Then User should be taken to Engage SMS home page
    When User clicks the Manage Resellers menubar option
    And User logs in to a reseller
    Then User is redirected to the Engaged Admin Dashboard page
    And User clicks Business tabs at the left side
    Then the Businesses page is opened
    And Users click Login tab for a merchant
    Then the user is redirected to a new window of Merchant's Dashboard
    And User clicks on My Accounts from the left hand side menu
    Then User is redirected to my account page

  @SMSM-137-Verify-Plan-Details @RegressionTest
  Scenario: My Plan details section is present on "My Accounts" screen in Merchant portal
    And User verifies the sections on my account page
    And User verifies My Plan section on my account page
    And User clicks on the Plan Details link
    Then details of the plan is displayed within the Plan Details popup window

  @SMSM-137-Change-Plan @RegressionTest
  Scenario: Verify the plan can be changed by clicking "Change Plan" button under "My Plan"
    And User clicks on the Change Plan button
    Then User confirms a new window popup to select a plan
    And User selects another plan
    Then User verifies that the plan is selected
    And User clicks Change Plan button
    Then Success message is displayed and the plan is changed to the new plan
    #Revert Plan
    And User clicks on the Change Plan button agaian
    And User selects a different plan and clicks and clicks the Change plan button

  @SMSM-137-Edit-Account-Contact-And-Billing @RegressionTest
  Scenario: Verify the user can edit the "Contact" Details by clicking "Edit" button under Contacts section in "Account Details"
    And User clicks the edit button under Contact Details
    Then the Account Contact details screen appears
    And User made some changes and click Save Changes
    Then A successful message indicating that the changes were saved is displayed
    And User clicks edit button again and revert the changes made to Account Details
    And User clicks edit button under Billing contact
    Then the Billing Contact details screen appears
    And User made some changes and click save button
    Then A successful message indicating that the details were saved is displayed
    Then User verifies the changes made to billing contacts
    #Payment Section
    Then User verifies the  Billing section of the Payment section
    And User clicks the Edit button under Credit Card
    Then Credit card details windows is opened
    And User enter valid details on credit card window and click on Update Credit Card button
    Then the details is saved successfully and a successful message is displayed

  @SMSM-137-Change-Password-Account-Contact @RegressionTest
  Scenario: Verify the user can Change the Password by clicking "Change Password" button under Contacts section
    And User clicks the change password button
    Then the change password window is opened
    Then User verifies the fields, icon and button on the Change password window
    And User clicks on the new password tooltip icon
    Then the minimum password requirement window is displayed
    And User leaves current and new password fields blank and clicks on the Change password button
    Then validation message is displayed
    And User enters invalid current password and valid new password and clicks Change Password
    Then Invalid Current password error message is displayed
    And User enters a weak new password
    Then Weak password warning message is displayed
    And User enters the correct password for current password and new password and clicks on Change Password button
    Then Success message is displayed
