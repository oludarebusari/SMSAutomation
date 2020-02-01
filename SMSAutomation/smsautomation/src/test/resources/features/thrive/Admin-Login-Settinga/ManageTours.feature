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

@tag-SMSM-185 @RegressionTest
Feature: Manage tours under settings in admin dashboard for Thrive system

 Background: User logs in and navigates to the Thrive's Dashboard
   Given User Navigates to Thrive URL
   Then Thrive login page is displayed
   When User enters a valid username for thrive
   And User enters a valid password for thrive
   And User clicks the sign in button for thrve
   Then Thrive Dashboard page is displayed
   Given User clicks on settings on top menu bar
   Then the settings options are displayed
   Given User clicks on Tours under settings
   Then User is redirected to Tours page
    
  @tag1
  Scenario: Navigate to manage tour option under settings on thrive system.
    Given User clicks on settings on top menu bar
    Then the settings options are displayed
    Given User clicks on Tours under settings
    Then User is redirected to Tours page
    

  @tag2
  Scenario: Edit existing tour in the list
		Given User types in a Tour name on the search textfield
		And User clicks the Search button
		Then the Tour is displayed on the page
		