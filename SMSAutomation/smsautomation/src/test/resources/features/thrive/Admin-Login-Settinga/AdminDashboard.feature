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
@SMSM-203
Feature: Verify all the components on the Admin Dashboard

  Background: User is logs in and Thrive Dashboard is displayed
    Given User Navigates to Thrive URL
    Then Thrive login page is displayed
    When User enters a valid username for thrive
    And User enters a valid password for thrive
    And User clicks the sign in button for thrve
    Then Thrive Dashboard page is displayed

  @SMSM-203 @Verify-User-is-landed-on-AdminDashboard-page @RegressionTest
  Scenario: Verify the user is landed to admin dashboard page
    And User verifies the Dashboard title is available
    And user verifies the Reseller list is available
    And User verifies the Resellers tab is available
    And user verifies the Business tab is available
    And User verifies the Social Post is available
    And User verifies the Revenue tab is available
    And User verifies the Help button is available

  @SMSM-203 @Verify-all-reseller-data @RegressionTest
  Scenario: Verify the user is landed to admin dashboard page
    And User verifies company column is available
    And user verifies Location column is available
    And User verifies Phone column is available
    And user verifies Support email column is available
    And User verifies Created date column is available
    And User verifies Action column is available

  @SMSM-203 @Verify-the-user-is-on-Licensee-Dashboard @RegressionTest
  Scenario: Verify the user is on "Licensee Dashboard"
    When User clicks the SignIn button on a Reseller
    Then the Reseller page is opened
    And User verifies the Merchant list
    And User verifies the late payment tab
    And User verifies the Pending Payments tab
    And User verifies the Payment Received tab
    And User verifies the Revenue tab

  @SMSM-203 @Verify-the-user-is-able-to-log-out-from-Resellee @RegressionTest
  Scenario: Verify the user is able to logged out from Reseller.
    When User clicks the SignIn button on a Reseller
    Then the Reseller page is opened
    And user verifies the login user link is available
    When User clicks on the logged In user dropdown link
    Then the dropdown is opened
    And User verifies that Sign Out option is available
    When User clicks on the Sing Out option
    Then user is redirected to the Admin Dashboard page
    
 @SMSM-203 @Verify-the-options-and-link-from-the-Action-dropdown @RegressionTest @OnlyMe
  Scenario: Verify the options and link from the Action dropdown.
		When User clicks a Reseller action dropdown
		Then User verifies the two Action options displayed
		When user clicks the Edit Reseller Company option
		Then user is redirected to the Edit Reseller page
		When User clicks on Cancel Services options
		Then the Cancel services window is displayed
		