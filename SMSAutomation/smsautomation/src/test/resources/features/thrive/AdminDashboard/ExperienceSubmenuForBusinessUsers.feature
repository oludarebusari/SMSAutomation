#Author: your.email@your.domain.com
#Keywords Summary :

#User is assumed to have Admin access unless stated Otherwise
@thrive @RegressionTest
Feature: Sub menu under "Experience" tab for Business users

  Background: User logs in to Thrive and navigate to Business Dashboard
    Given User Navigates to Thrive URL
    Then Thrive login page is displayed
    When User enters a valid username for thrive
    And User enters a valid password for thrive
    And User clicks the sign in button for thrve
    Then Thrive Dashboard page is displayed
    
  @Verify-Business-user-is-able-to-navigate-to-Experience->Pages 
  Scenario: Verify Business user is able to navigate to Experience-> Pages
    When User Clicks Company menu and clicks the Business option
    Then the Manage Business page is displayed
    When User clicks on the SignIn button on of a Business
    Then the Business Dashboard page is displayed
    When User clicks on Experience menu from the Business page and clicks pages
    Then Pages page is displayed
    
  @Verify-Business-user-is-able-to-navigate-to-Experience->Captivate 
  Scenario: Verify Business user is able to navigate to Experience-> Captivate
    When User Clicks Company menu and clicks the Business option
    Then the Manage Business page is displayed
    When User clicks on the SignIn button on of a Business
    Then the Business Dashboard page is displayed
    When User clicks on Experience menu from the Business page and clicks Captivate
    Then Captivate page is displayed

  @Verify-Business-user-is-able-to-navigate-to-Experience->Streams 
  Scenario: Verify Business user is able to navigate to Experience-> Streams
    When User Clicks Company menu and clicks the Business option
    Then the Manage Business page is displayed
    When User clicks on the SignIn button on of a Business
    Then the Business Dashboard page is displayed
    When User clicks on Experience menu from the Business page and clicks Streams
    Then Streams page is displayed
		


     