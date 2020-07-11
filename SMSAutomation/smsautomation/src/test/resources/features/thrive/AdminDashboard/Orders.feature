#Author: your.email@your.domain.com
#Keywords Summary :
#User is assumed to have Admin access unless stated Otherwise
#Step Definition File - OrdersSteps.java
@engage @RegressionTest
Feature: Orders

  Background: User is logs in and Thrive Dashboard is displayed
    Given User Navigates to Thrive URL
    Then Thrive login page is displayed

  @Accessing-Orders-page-with-user-having-“Create/Update-Orders”-permission
  Scenario: Accessing Orders page with user having “Create/Update Orders” permission [C26188772]
    When User enters a valid username with Create-Update Lead permission
    And User enters password for the user with Create-Update Lead Permission
    And User clicks the sign in button for thrve
    Then Thrive Dashboard page is displayed
    When User Clicks on the Lead Tracking menu
    And User clicks the Order option
    Then User is redirected to the Orders page
    And User verifies that New button exists on the Orders page
    And User is able to click the Edit button of an Order
    And User verifies that View Performance option is not available

  @Accessing-Orders-page-with-user-having-"Manage-Leads"-permission
  Scenario: Accessing Orders page with user having "Manage Leads" permission [C26188772]
    When User enters a valid username with Manage Lead tracking permission
    And User enters password for the user with Manage Leads Permission
    And User clicks the sign in button for thrve
    Then Thrive Dashboard page is displayed
    When User Clicks on the Lead Tracking menu
    And User clicks the Order option
    Then User is redirected to the Orders page
    And User is able to click the View Leads button of an Order
    And User is able to access the View Performance button
    And User is not able to see New button to create New Order
    And User Verifies that Edit button is not available on the Orders page

  @Accessing-Orders-page-with-user-having-“Create/Update-Orders”-and-"Manage-Leads"-permissions
  Scenario: Accessing Orders page with user having “Create/Update Orders” and "Manage Leads" permissions [C26188776]
    When User enters a valid username with Create Update and Manage Lead tracking permission
    And User enters password for the user with Create update and Manage Leads Permission
    And User clicks the sign in button for thrve
    Then Thrive Dashboard page is displayed
    When User Clicks on the Lead Tracking menu
    And User clicks the Order option
    Then User is redirected to the Orders page
    And User is able to click the View Leads button of an Order
    And User is able to click the Edit button of an Order on the page
    And User does not have access to the View Performance option

  @Accessing-Orders-page-with-user-not-having-any-of-“Manage-Leads”-or-“Create/Update-Orders”-permissions
  Scenario: Accessing Orders page with user not having any of  “Manage Leads” or “Create/Update Orders” permissions [C26188777]
    When User enters a valid username without Create Update and Manage Lead tracking permission
    And User enters password for the user without Create update and Manage Leads Permission
    And User clicks the sign in button for thrve
    Then Thrive Dashboard page is displayed
    When User Clicks on the Lead Tracking menu
    Then User verifies that the Orders option is not displayed

  @Verify-the-options-available-on-Orders-page
  Scenario: Verify the options available on Orders page [C26188838]
    When User enters a valid username for thrive
    And User enters a valid password for thrive
    And User clicks the sign in button for thrve
    Then Thrive Dashboard page is displayed
    When User Clicks on the Lead Tracking menu
    And User clicks the Order option
    Then User is redirected to the Orders page
    And User verifies that New button is available
    And User verifies that Status filter is available
    And User verifies that Order field is available
    And User verifies that Next-Prevoius buttons are available
    And User verifies ShownEntries is available

  @Search-Order-using-Reseller-name
  Scenario: Search Order using Reseller name [C26196814]
    Then User enters a valid username for thrive
    And User enters a valid password for thrive
    And User clicks the sign in button for thrve
    Then Thrive Dashboard page is displayed
    When User Clicks on the Lead Tracking menu
    And User clicks the Order option
    Then User is redirected to the Orders page
    And User enters a reseller name and select the Reseller

  @Search-Order-using-Status
  Scenario: Search Order using Status [C26196816]
    Then User enters a valid username for thrive
    And User enters a valid password for thrive
    And User clicks the sign in button for thrve
    Then Thrive Dashboard page is displayed
    When User Clicks on the Lead Tracking menu
    And User clicks the Order option
    Then User is redirected to the Orders page
    When User selects Active Status
    Then User verifies only Active orders are displayed
    When User selects Cancelled Status
    Then User verifies only Cancelled orders are displayed
    When User selects Complete Status
    Then User verifies only Completed orders are displayed
    When User selects Fulfilled Status
    Then User verifies only Fulfilled orders are displayed

  @Search-Order-using-Order-number
  Scenario: Search Order using Order number [C26196816]
    Then User enters a valid username for thrive
    And User enters a valid password for thrive
    And User clicks the sign in button for thrve
    Then Thrive Dashboard page is displayed
    When User Clicks on the Lead Tracking menu
    And User clicks the Order option
    Then User is redirected to the Orders page
    When User selects an Order number
    Then User verifies that order is displayed based on the search criteria

  @Sort-results
  Scenario: Sort results [C26196819]
    Then User enters a valid username for thrive
    And User enters a valid password for thrive
    And User clicks the sign in button for thrve
    Then Thrive Dashboard page is displayed
    When User Clicks on the Lead Tracking menu
    And User clicks the Order option
    Then User is redirected to the Orders page
    When User clicks on the Order title
    Then user verifies that the records are sorted in ascending order based on the Order title
    When User clicks on the Order title again
    Then User verifies that the records are sorted in descending order based on the Order title
    And User resets the record to it's original state
    When User clicks on the Busines Name title
    Then user verifies that the records are sorted in ascending order based on the Business Name title
    When User clicks on the Business Name title again
    Then User verifies that the records are sorted in descending order based on the Business Name title
    And User resets the record to it's original state
    When User clicks on the Progress title
    Then user verifies that the records are sorted in ascending order based on the Progress title
    When User clicks on the Progress title again
    Then User verifies that the records are sorted in descending order based on the Progress title
    And User resets the record to it's original state
    When User clicks on the Due date title
    Then user verifies that the records are sorted in ascending order based on the Due date title
    When User clicks on the Due date title again
    Then User verifies that the records are sorted in descending order based on the Due date title
    And User resets the record to it's original state
    When User clicks on the Appointment title
    Then user verifies that the records are sorted in ascending order based on the Appointment title
    When User clicks on the Appointment title again
    Then User verifies that the records are sorted in descending order based on the Appointment title
    And User resets the record to it's original state
    When User clicks on the Required title
    Then user verifies that the records are sorted in ascending order based on the Required title
    When User clicks on the Required title again
    Then User verifies that the records are sorted in descending order based on the Required title
    And User resets the record to it's original state
    When User clicks on the Leads title
    Then user verifies that the records are sorted in ascending order based on the Leads title
    When User clicks on the Leads title again
    Then User verifies that the records are sorted in descending order based on the Leads title
    And User resets the record to it's original state

  @Accessing-Create-Order-page-with-a-user-having-“Create/Update-Orders”-permission
  Scenario: Accessing Create Order page with a user having “Create/Update Orders” permission [C26196819]
    Then User enters a valid username for thrive
    And User enters a valid password for thrive
    And User clicks the sign in button for thrve
    Then Thrive Dashboard page is displayed
    When User Clicks on the Lead Tracking menu
    And User clicks the Order option
    Then User is redirected to the Orders page
    When User clicks on the New button
    Then User is redirected to the Create Order Page

  @Verify-fields/Options-available-on-Create-Order-page
  Scenario: Verify fields/Options available on Create Order page [C26196819]
    Then User enters a valid username for thrive
    And User enters a valid password for thrive
    And User clicks the sign in button for thrve
    Then Thrive Dashboard page is displayed
    When User Clicks on the Lead Tracking menu
    And User clicks the Order option
    Then User is redirected to the Orders page
    And User clicks on the New button on the Create Order page
    And User verifies the available fields on the Create Order page

  @Verify-validation-message-for-mandatory-fields
  Scenario: Verify validation message for mandatory fields [C26188774]
    Then User enters a valid username for thrive
    And User enters a valid password for thrive
    And User clicks the sign in button for thrve
    Then Thrive Dashboard page is displayed
    When User Clicks on the Lead Tracking menu
    And User clicks the Order option
    Then User is redirected to the Orders page
    When User clicks on the New button on the Create Order page
    And User clicks the Acquire Leads button leaving all the Mandatory fields empty
    Then User verifies that error messages appears below the Mandatory fields
    And User verifies that the Acquire Leads button is disabled
    When User enters valid input into the Mandatory fields
    Then User verifies error messages are not displayed
    And User verifies that Acquire Leads button is enablled

  @Create-a-new-Order @OnlyMe
  Scenario: Create a new Order [C26188842]
    Then User enters a valid username for thrive
    And User enters a valid password for thrive
    And User clicks the sign in button for thrve
    Then Thrive Dashboard page is displayed
    When User Clicks on the Lead Tracking menu
    And User clicks the Order option
    Then User is redirected to the Orders page
    When User clicks on the New button on the Create Order page
    And User selects a business name
    And User selects all available Order types
    And User selects a Start date
    And User selects a Due date
    And User enters an appointment limit
    And User a Vertical
    And User enters a postal code
    And User selects At Least 10 for Number of reviews
    And User selects At least 3 for Average ratings
    And User clicks the Acquire Leads button
    Then User verifies the notification message displayed about the order
    When User navigates to Lead Tracking 
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
