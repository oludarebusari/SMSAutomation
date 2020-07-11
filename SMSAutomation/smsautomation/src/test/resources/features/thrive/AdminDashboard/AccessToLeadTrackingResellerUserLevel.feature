#Author: your.email@your.domain.com
#Keywords Summary :
#User is assumed to have Admin access unless stated Otherwise
#Step Definition File - AccessToLeadTrackingResellerUserLevelSteps.java
@engage @RegressionTest
Feature: Enabling Access to Lead Tracking

  Background: User is logs in and Thrive Dashboard is displayed
    Given User Navigates to Thrive URL
    Then Thrive login page is displayed
    When User enters a valid username for thrive
    And User enters a valid password for thrive
    And User clicks the sign in button for thrve
    Then Thrive Dashboard page is displayed
    When User clicks the User menu
    Then the User options are displayed
    When User clicks on Resellers option from the User menu
    Then User is redirected to the Reseller Users page

  @Section2.3.1.2 @Lead-Tracking-Permissions:-Reseller-User-Level:-Displayed-Objects-Verification
  Scenario: Lead Tracking Permissions: Reseller User Level: Displayed Objects Verification [C26188569]
    When User clicks the edit option for a specific user record
    Then User is redirected to the Edit User page
    And User verifies the permissions listed on the Lead Tracking permission section
    And User verifies each permission has AllowDeny toggle switch

  @Section2.3.1.2 @Lead-Tracking-Permissions:-Reseller-User-Level:-Enable-Option
  Scenario: Lead Tracking Permissions: Reseller User Level: Enable Option  [C26188664]
    When User clicks the edit option for a specific user record
    Then User is redirected to the Edit User page
    And User verifies the states of the Lead Tracking toggles
    When User clicks the Enable button above the Lead tracking permissions
    Then User verifies that the state for all the permission changes to Allow
    When User clicks the Enable option again
    Then User verifies that there was no changes to the permission settings
    When User clicks the Save Reseller button to Save the record
    And User queries the same User record
    Then User verifies that all Lead Tracking permissions are set to Allow
    When User makes changes to the Lead Tracking permission
    And User navigates away from the page without saving
    And User queries the same User record
    Then User verifies that the changes made to Lead Tracking permission were not saved
    #Revert Lead Tracking Permissions to it's original state
    And User reverts changes to the Lead Tracking permissions

  @Section2.3.1.2 @Lead-Tracking-Permissions:-Reseller-User-Level:-Disable-Option
  Scenario: Lead Tracking Permissions: Reseller User Level: Disable Option [C26188667]
    When User clicks the edit option for a specific user record
    Then User is redirected to the Edit User page
    And User vrifies the states of the Lead Tracking toggles
    When User clicks the Disable button above the Lead Tracking permissions
    Then User verifies that the state for all the permission changes to Deny
    When User clicks the Disable option again
    Then User verifies that the permission settings were not changed
    When User clicks the Save Reseller button to Save the record
    And User queries the same User record
    Then User verifies that all Lead Tracking permissions are set to Deny
    When User modifies the Lead Tracking permissions
    And User navigates away from the page without saving
    And User queries the same User record
    Then User verifies that the modifications to Lead Tracking permission were not saved
    #Revert Lead Tracking Permissions to it's original state
    And User reverts changes to the Lead Tracking permissions to it's original state

  @Section2.3.1.2 @Lead-Tracking-Permissions:-Reseller-User-Level:-Enable/Disable-Create/Update-Orders-Permission
  Scenario: Lead Tracking Permissions: Reseller User Level: Enable/Disable Create/Update Orders Permission [C26189551]
    When User clicks the edit option for a specific user record
    Then User is redirected to the Edit User page
    And User verifies the state of the Create-Update Orders permission
    When User clicks on the Create-Update orders toggle
    Then User verifies the state of Create-Update order toggle after first click
    When User clicks the Create-Update Orders toggle again
    Then User verifies the state of Create-Update order toggle after the second click
    When User updates the Create-Update Orders permission to Allow
    And User clicks the Save Reseller button to Save the record
    And User queries the same User record
    Then User verifies that Create-Update Orders permission is set to Allow
    When User updates the Create-Update Orders permission to Deny
    And User clicks the Save Reseller button to Save the record
    And User queries the same User record
    Then User verifies that Create-Update Orders permission is set to Deny
    When User updates the Create-Update Orders permission to Allow
    And User navigates away from the page without saving
    And User queries the same User record
    Then User verifies that Create-Update Orders permission is set to Deny

  @Section2.3.1.2 @Lead-Tracking-Permissions:-Reseller-User-Level:-Enable/Disable-Manage-Leads-Permission
  Scenario: Lead Tracking Permissions: Reseller User Level: Enable/Disable Manage Leads Permission [C26189552]
    When User clicks the edit option for a specific user record
    Then User is redirected to the Edit User page
    And User verifies the state of the Manage Leads permission
    When User clicks on the Manage Leads toggle
    Then User verifies the state of Manage Leads toggle after first click
    When User clicks the Manage Leads toggle again
    Then User verifies the state of Manage Leads toggle after the second click
    And User clicks the Save Reseller button to Save the record
    And User queries the same User record
    Then User verifies that Manage Leads permission is set to Allow
    When User updates the Manage Leads permission to Deny
    And User clicks the Save Reseller button to Save the record
    And User queries the same User record
    Then User verifies that Manage Leads permission is set to Deny
    When User updates the Manage Leads permission to Allow
    And User navigates away from the page without saving
    And User queries the same User record
    Then User verifies that Manage Leads permission is set to Deny
    #Revert Lead Tracking Permissions to it's original state
    And User reverts changes to Manage Leads permission to it's original state

  @Section2.3.1.2 @Lead-Tracking-Permissions:-Reseller-User-Level:-Enable/Disable-View-Appointments-Permission
  Scenario: Lead Tracking Permissions: Reseller User Level: Enable/Disable View Appointments Permission [C26189553]
    When User clicks the edit option for a specific user record
    Then User is redirected to the Edit User page
    And User verifies the state of the View Appointments permission
    When User clicks on the View Appointment toggle
    Then User verifies the state of View Appointment toggle after first click
    When User clicks the View Appointment toggle again
    Then User verifies the state of View Appointment toggle after the second click
    When User updates the View Appointments permission to Allow
    And User clicks the Save Reseller button to Save the record
    And User queries the same User record
    Then User verifies that View Appointments permission is set to Allow
    When User updates the View Appointments permission to Deny
    And User clicks the Save Reseller button to Save the record
    And User queries the same User record
    Then User verifies that View Appointments permission is set to Deny
    When User updates the View Appointments permission to Allow
    And User navigates away from the page without saving
    And User queries the same User record
    Then User verifies that View Appointments permission is set to Deny

  @Section2.3.1.2 @Lead-Tracking-Permissions:-Reseller-User-Level:-Create/Update-Orders-Permissions-Functional-Test 
  Scenario: Lead Tracking Permissions: Reseller User Level: Create/Update Orders Permissions Functional Test [C26190992]
    When User clicks the edit option of a User
    Then User is redirected to the Edit User page
    And User clicks on the Create-Update toggle
    And User verifies the states of the toggle
    And User saves the user record
    When Non Admin User sign In
    Then the non admin User is redirected to the Reseller Dashboard page
    When the non admin User clicks the Lead Tracking menu
    Then the non Admin User verifies the only option displayed is Orders
    When the non admin User clicks the Orders Menu
    Then the Orders list page is displayed
    And non admin User verifies access to Edit an Order
    When the non admin User clicks on the New button
    Then non admin User is redirected to the Create Order page
    #Admin User reverts changes to Create-Update Order
    And User signs out as non admin user
    When User enters a valid username for thrive
    And User enters a valid password for thrive
    And User clicks the sign in button for thrve
    Then Thrive Dashboard page is displayed
    When User clicks the User menu
    Then the User options are displayed
    When User clicks on Resellers option from the User menu
    Then User is redirected to the Reseller Users page
    And User selects the Reseller and reverses the change to Create-Update Order

  @Section2.3.1.2 @Lead-Tracking-Permissions:-Reseller-User-Level:-Manage-Leads-Permission-Functional-Test
  Scenario: Lead Tracking Permissions: Reseller User Level: Manage Leads  Permission Functional Test [C26190997]
    When User clicks the edit option of a User
    Then User is redirected to the Edit User page
    And User clicks on the Manage Leads toggle
    And User verifies the states of the toggles after Manage leads is set to Allow
    And User saves the user record
    When Non Admin User sign In
    Then the non admin User is redirected to the Reseller Dashboard page
    When the non admin User clicks the Lead Tracking menu
    Then the non Admin User verifies the options displayed
    When the non admin User clicks the Orders Menu
    Then the Orders list page is displayed
    And non admin User verifies View Leads is displayed for all records
    And non admin user verifies that New and Edit buttons are not displayed
    When non admin user clicks on the View Leads button for an existing order
    Then the Leads page is displayed
    When non admin user clicks the Lead button for one of the leads listed
    Then the Lead Management page is displayed
    And non admin user verifies that the Lead Information is displayed on the Lead Management Page
    And non admin user verifies a clickable phone number is displayed
    #Admin User reverts changes to Manage Leads
    And User signs out as non admin user
    When User enters a valid username for thrive
    And User enters a valid password for thrive
    And User clicks the sign in button for thrve
    Then Thrive Dashboard page is displayed
    When User clicks the User menu
    Then the User options are displayed
    When User clicks on Resellers option from the User menu
    Then User is redirected to the Reseller Users page
    And User selects the Reseller and reverses the change to Manage Leads

  @Section2.3.1.2 @Lead-Tracking-Permissions:-Reseller-User-Level:-View-Appointments-Permission-Functional-Test 
  Scenario: Lead Tracking Permissions: Reseller User Level: View Appointments Permission Functional Test [C26190998]
  	When User clicks the edit option of a User
    Then User is redirected to the Edit User page
    And User clicks on the View Appointments toggle
    And User verifies the states of the toggles after View Appointments is set to Allow
    And User saves the user record
    When Non Admin User sign In
    Then the non admin User is redirected to the Reseller Dashboard page
    When the non admin User clicks the Lead Tracking menu
    Then the non Admin User verifies the only Leads By Appointment menu item is displayed
    When the non admin User clicks the Leads By Appointment menu
    Then the Overall Appointments Set list page is displayed
  	And the non admin user sets a date range
  	When the non admin user clicks on the open button for an existing Appointment
  	Then the Appointment Management page is displayed
  	And non admin user verifies a clickable phone number is displayed
  	
 #Admin User reverts changes to View Appointments
    And User signs out as non admin user
    When User enters a valid username for thrive
    And User enters a valid password for thrive
    And User clicks the sign in button for thrve
    Then Thrive Dashboard page is displayed
    When User clicks the User menu
    Then the User options are displayed
    When User clicks on Resellers option from the User menu
    Then User is redirected to the Reseller Users page
    And User selects the Reseller and reverses the change to View Appointments
  
  
  
