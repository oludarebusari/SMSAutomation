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

#User is assumed to have Admin access unless stated Otherwise
@thrive @RegressionTest
Feature: Verify all the components on the Admin Dashboard

  Background: User is logs in and Thrive Dashboard is displayed
    Given User Navigates to Thrive URL
    Then Thrive login page is displayed
    When User enters a valid username for thrive
    And User enters a valid password for thrive
    And User clicks the sign in button for thrve
    Then Thrive Dashboard page is displayed

  @SMSM-203 @Verify-User-is-landed-on-AdminDashboard-page 
  Scenario: Verify the user is landed to admin dashboard page
    And User verifies the Dashboard title is available
    And user verifies the Reseller list is available
    And User verifies the Resellers tab is available
    And user verifies the Business tab is available
    And User verifies the Social Post is available
    And User verifies the Revenue tab is available
    And User verifies the Help button is available

  @SMSM-203 @Verify-all-reseller-data 
  Scenario: Verify the user is landed to admin dashboard page
    And User verifies company column is available
    And user verifies Location column is available
    And User verifies Phone column is available
    And user verifies Support email column is available
    And User verifies Created date column is available
    And User verifies Action column is available

  @SMSM-203 @Verify-the-user-is-on-Licensee-Dashboard 
  Scenario: Verify the user is on "Licensee Dashboard"
    When User clicks the SignIn button on a Reseller
    Then the Business page is opened
    And User verifies the Merchant list
    And User verifies the late payment tab
    And User verifies the Pending Payments tab
    And User verifies the Payment Received tab
    And User verifies the Revenue tab

  @SMSM-203 @Verify-the-user-is-able-to-log-out-from-Resellee 
  Scenario: Verify the user is able to logged out from Reseller.
    When User clicks the SignIn button on a Reseller
    Then the Business page is opened
    And user verifies the login user link is available
    When User clicks on the logged In user dropdown link
    Then the dropdown is opened
    And User verifies that Sign Out option is available
    When User clicks on the Sign Out option
    Then user is redirected to the Admin Dashboard page

  @SMSM-203 @Verify-the-options-and-link-from-the-Action-dropdown 
  Scenario: Verify the options and link from the Action dropdown.
    When User clicks a Reseller action dropdown
    Then User verifies two Action options are displayed
    When user clicks the Edit Reseller Company option
    Then user is redirected to the Edit Reseller page
    And User clicks the Dashboard menu option
    When User clicks on Cancel Services options
    Then the Cancel services window is displayed

  @SMSM-203 @Verify-the-user-can-edit-the-Reseller-details 
  Scenario: Verify the User can edit the Reseller details.
    When User clicks a Reseller action dropdown
    Then User verifies two Action options are displayed
    When user clicks the Edit Reseller Company option
    Then user is redirected to the Edit Reseller page
    When Edits some of the Resellers details
    And User clicks the Save Reseller's button
    Then a message indicating the Reseller has been updated is displayed
    When User clicks the Dashboard menu
    Then User is redirected to the Dashboard and and confirms changes to Reseller
    And User revert changes

  @SMSM-203 @Verify-the-admin-can-cancel-service 
  Scenario: Verify the admin can cancel service.
    When User selects a reseller to cancel and clicks the action dropdown button
    And user clicks the Cancel services option
    And User clicks the Cancel Services button
    Then the Manage Resellers page is displayed
    When User types the Resellers name on the search textfield and click Search button
    Then the reseller is displayed
    And User verifies the new status of the Reseller
    When User clicks the Dashboard menu
    Then User verifies that the cancelled reseller services is not displayed
    Then Revert Changes

  @SMSM-203 @Verify-the-pagination-on-the-dashboard 
  Scenario: Verify the pagination on the dashboard.
    And User verifies Show n Entries is available
    And User verifies the number of results displayed
    And User verifies the number of pages available

  @SMSM-203 @Verify-the-previous-and-next-pagination-option
  Scenario: Verify the 'Previous' and 'Next' options are working.
    And User verifies that the Previous and Next buttons are available
    And user verifies the Previous button is disabled when on first page
    When User clicks any ie last page number
    Then User is redirected to that respective page
    And user verifies that the Next button is disabled when on the last page
    When User clicks on the Previous button
    Then User is redirected to the previous page
    When User clicks on the Next button
    Then User is navigated to the Next page

  @SMSM-294 @Verify-admin-can-be-redirected-to-Manage-Resellers-page-from-View-Resellers-link 
  Scenario: Verify admin can be redirected to the Manage Resellers page from View Reseller link.
    And admin user verifies the View Resellers link is available
    When admin User clicks the View Resellers link
    Then User is redirected to the Manage Resellers page

  @SMSM-294 @Verify-user-is-able-to-access-the-buttons-on-Manage-Reseller-page  
  Scenario: Verify user is able to access the buttons on Manage Reseller page.
    And admin user verifies the View Resellers link is available
    When admin User clicks the View Resellers link
    Then User is redirected to the Manage Resellers page
    And User verifies that the New button is available
    When User clicks on the New button
    Then User is redirected to the Create Reseller page
    When User clicks back on the browser
    Then User verifies all the buttons on the page are available

  @SMSM-294 @Verify-Admin-redirects-to-the-manage-Business-page  
  Scenario: Verify Admin redirects to the Manage Merchants page.
    And Admin User verifies the View Business link is available
    When admin User clicks the View Business link
    Then User is redirected to the Manage Businesses page

  @SMSM-294 @Verify-Admin-user-is-able-to-Sign-into-a-Business-Dashboard 
  Scenario: Verify Admin user is able to sign into a Business Dashboard
    And Admin User verifies the View Business link is available
    When admin User clicks the View Business link
    Then User is redirected to the Manage Businesses page
    When User types in a text in the search field and clicks the Search button
    Then the resut is displayed
    When User clears the search field and clicks Search button
    Then all the data is displayed
    When User clicks on SignIn button
    Then user is redirected to the dashboard

  @SMSM-294 @Verify-Admin-user-can-see-count-of-Social-posts-and-count-Businesses-on-the-dashboard-page 
  Scenario: Verify that Admin can see count of social Posts and count businesses on the dashboard page.
		And User verifies the Social Post is available
		And User verifies the social post count is available
		And User verifies the message displayed about the post
		
  @SMSM-294 @Verify-Admin-user-can-see-Resellers-revenue-on-the-dashboard-page 
  Scenario: Verify that Admin can see Resellers revenue on the dashboard page.
     And User verifies the Revenue tab is available
     And User verifies revenue amount is available
     And User verifies the message displayed about the revenue
     
  @SMSM-294 @Verify-user-is-able-to-edit-the-business-details @OnlyMe
  Scenario: Verify user is able to edit the Business's Details
		When User navigates to Companies menu and clicks the Businesses option
		Then the user is redirected to the Manage Businesses page
		When User clicks the Action drop down beside SignIn button
		Then three action options are displayed.
		When User clicks the Edit option
		Then the Edit Business page is displayed
		When User update some details and Click Save Business button
		Then a notification for that Business is successfully saved is displayed
		And User asserts that the changes were saved correctly
		
		#Revert Changes to Business
		And User revert the changes made to Business
		
		