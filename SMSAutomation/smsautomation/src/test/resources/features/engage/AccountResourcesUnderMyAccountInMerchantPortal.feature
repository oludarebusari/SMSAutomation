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

@tag-SMSM-138 @RegressionTest
Feature: View and Edit account resources under My Account in Merchant's Portal

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
    Then the merchants detailed information is listed
    And Users click Login tab for a merchant
    Then the user is redirected to a new window of Merchant's Dashboard
    And User clicks on My Accounts from the left hand side menu
    Then User is redirected to my account page

 @tag-Purchase-History
  Scenario: Verify Purchase History option
    Then User verifies the Account Resources section options 
    When User clicks on Purchase History option
    Then Purchase History window pops up and user can view all Purchase history
    When User clicks on the page drop down count to change the number of records per page
    Then The list of page sizes that can be selected is displayed
    When User selects a number from the list 
    Then the number of records displayed should correspond to the number selected
    And User verifies that both CSV and Copy Options are available
    When User clicks on the CSV tab
    Then CSV file is created and exported to the local machine
    
  @tag-Auto-Purchase
  Scenario Outline: Verify Auto Purchase option
  When User clicks the Auto Purchase option
  Then Auto Purchase window pops
  When User hovers over the question mark next to Max Monthly Auto purchases dropdown
  Then information about the Max Monthly Auto purchases dropdown is displayed
  When User selects month from the Max Monthly Auto Purchases and clicks change plan 
  Then a message indicating that your plan is updated is displayed
  
  
  @tag-Blacklist-Whitelist
  Scenario Outline: Verify Blacklist-Whitelist option
  When User clicks the Blacklist-whitelist option
  Then the Blacklist-Whitelist pop up screen appears
  When User clicks the Private Campaign mode toggle (Off)
  Then the blacklist options appears
  When User clicks the New button under Blacklist section
  Then the Add to blacklist window is opened
  When user adds the number to blacklist and cliks Add Number button
  Then the number is added to the blacklist
  
  
   
  
   