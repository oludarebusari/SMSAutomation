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

  #@tag1
  #Scenario: Exisiting User should be able to login to Thrive System
   # Given User Navigates to Thrive URL
   # Then Thrive login page is displayed
   # When User enters a valid username for thrive
   # And User enters a valid password for thrive
   # And User clicks the sign in button for thrve
   # Then Thrive Dashboard page is displayed
    
  @tag2
  Scenario: Navigate to manage tour option under settings on thrive system.
    Given User clicks on settings on top menu bar
    Then the settings options are displayed
    Given User clicks on Manage tour under settings
    Then User is redirected to Tours page
    

  @tag3
  Scenario Outline: Title of your scenario outline
   