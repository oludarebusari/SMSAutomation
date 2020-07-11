#Author: your.email@your.domain.com
#Keywords Summary :
#User is assumed to have Admin access unless stated Otherwise
#Step Definition File - AgeGateSteps.java
@engage @RegressionTest
Feature: Age Gate Feature

  Background: User is logs in and Thrive Dashboard is displayed
    Given User navigate to Engage url
    And User enters a valid username
    And User enters a valid password
    And User clicks on the login button
    Then User should be taken to Engage SMS home page
    When User clicks the Manage Resellers menubar option
    And User logs in to a reseller
    Then User is redirected to the Engaged Admin Dashboard page
    When User clicks Business tabs at the left side
    Then the Businesses page is opened
    And Users click Login tab for a merchant
    Then the user is redirected to a new window of Merchant's Dashboard
    When User clicks the Campaign option tab
    Then the Campaign menu is opened
    When User clicks on Single Campaigns option
    Then User is redirected to the Single Campaigns page

  @Verify-Age-field-is-not-displayed-when-Age-gate-filter-is-disabled
  Scenario: Verify Age field is not displayed when Age gate filter is disabled [C26167438]
    When User clicks the New button on the Single Campaigns page
    Then the Create A Campaign page is displayed
    When User clicks on the Campaign Information section
    Then the Campaign Information section is opened
    And User verifies that the Age field is not displayed

  @Verify-Age-field-is-displayed-when-Age-gate-filter-is-enabled
  Scenario: Verify Age field is displayed when Age gate filter is enabled [C26167628]
    When User clicks the New button on the Single Campaigns page
    Then the Create A Campaign page is displayed
    When User clicks on the Campaign Information section
    Then the Campaign Information section is opened
    When User clicks on the Disable toggle button
    Then User verifies that the Age field is displayed

  @Verify-default-value-for-Age-field 
  Scenario: Verify default value for Age field [C26167440]
    When User clicks the New button on the Single Campaigns page
    Then the Create A Campaign page is displayed
    When User clicks on the Campaign Information section
    Then the Campaign Information section is opened
    When User clicks on the Disable toggle button
    Then User verifies that the Age field is displayed
    And User verifies the default value for Age field

  @Verify-Age-field-value-is-editable
  Scenario: Verify-Age-field-value-is-editable [C26167441]
    When User clicks the New button on the Single Campaigns page
    Then the Create A Campaign page is displayed
    When User clicks on the Campaign Information section
    Then the Campaign Information section is opened
    When User clicks on the Disable toggle button
    Then User verifies that the Age field is displayed
    And User enters a new value for AgeGate and clicks Save Campaign button
    And User verifies that the values was saved successfully

  @Verify-Age-field-should-only-allow-positive-integer-number
  Scenario: Verify Age field should only allow positive integer number [C26167442]
    When User clicks the New button on the Single Campaigns page
    Then the Create A Campaign page is displayed
    When User clicks on the Campaign Information section
    Then the Campaign Information section is opened
    When User clicks on the Disable toggle button
    Then User verifies that the Age field is displayed
    When User enters alphabetical characters into the Age field
    Then an error message is displayed
    When User enters special characters into the Age field
    Then an error message is displayed
    When User enters a negative number into the Age field
    Then an error message is displayed

  @Verify-valid-interval-for-Age-Gate-(10-40) 
  Scenario: Verify valid interval for Age Gate (10-40) [C26167622]
    When User clicks the New button on the Single Campaigns page
    Then the Create A Campaign page is displayed
    When User clicks on the Campaign Information section
    Then the Campaign Information section is opened
    When User clicks on the Disable toggle button
    Then User verifies that the Age field is displayed
    When User update the Age field value to ten
    Then the Age Gate field is updated with value ten without error message
    When User update the Age field value to forty
    Then the Age Gate field is updated with value forty without error message
    When User update the Age field value to twenty-five
    Then the Age Gate field is updated with value twenty-five without error message

  @Verify-Age-Gate-field-do-not-accept-values-other-than-valid-interval-(10-40) 
  Scenario: Verify Age Gate field do not accept values other than valid interval (10-40) [C26167623]
    When User clicks the New button on the Single Campaigns page
    Then the Create A Campaign page is displayed
    When User clicks on the Campaign Information section
    Then the Campaign Information section is opened
    When User clicks on the Disable toggle button
    Then User verifies that the Age field is displayed
    When User update the Age Gate field value to nine
    Then an error message is displayed
    When User update the Age Gate field value to forty-one
    Then an error message is displayed
    When User update the Age Gate field value to zero
    Then an error message is displayed

  @Create-a-campaign-with-Age-Gate-filter-ON
  Scenario: Create a campaign with Age Gate filter ON [C26171452]
    When User clicks the New button on the Single Campaigns page
    Then the Create A Campaign page is displayed	
    And User clicks What type of business is this section and select a business type  
    And User clicks on Yes button from the Will you be using a Loyalty tablet section
    And User enters Campaign name, keyword, Messages per month
		And User enables the Age Gate filter, set a value and clicks the Continue button
		And User enters the Welcome message and click the continue button from the Texts section
		And User create a reward and clicks the continue button
		And User adds engagement in Engagement section and clicks the continue button
		And User adds a logo on the Tablet design section
		And User clicks the Save to Complete Setup button
		And User verifies that the campaign is created successfully
		And User deletes the created campaign
		    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
