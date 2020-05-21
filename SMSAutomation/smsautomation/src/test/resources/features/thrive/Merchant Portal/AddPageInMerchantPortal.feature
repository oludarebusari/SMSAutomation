#Author: your.email@your.domain.com
#Keywords Summary :

#User is assumed to have Admin access unless stated Otherwise
#Step Definition File - AddPageInMerchantPortalSteps.java
@thrive @RegressionTest
Feature: [SMSM-228] Add page in merchant portal for Thrive system

  Background: User logs in to Thrive and navigate to Business Dashboard
    Given User Navigates to Thrive URL
    Then Thrive login page is displayed
    When User enters a valid username for thrive
    And User enters a valid password for thrive
    And User clicks the sign in button for thrve
    Then Thrive Dashboard page is displayed
    When User navigates to Companies menu and clicks the Businesses option
    Then the user is redirected to the Manage Businesses page
    When User navigates to the actions column of a Business and clicks Sign In button
    Then User is logged into the Business and the business dashboard is opened

  @SMSM-136 @Verify-the-user-is-able-to-create-a-new-page-in-merchant-portal 
  Scenario: Verify the user is able to create a new page in merchants portal
    When User clicks on the Experience Menu option
    Then the Experience options are displayed
    When User clicks the Pages option
    Then users is redirected to the Pages page
    When User clicks on the New button
    Then the Create Page window is opened
    When User enters a Name, select a template and clicks the Create Page button
    Then the new page is created

  @SMSM-136 @Verify-all-the-available-menus-on-merchant-page 
  Scenario: Verify all the available menus on merchant pages
    When User clicks on the Experience Menu option
    Then the Experience options are displayed
    When User clicks the Pages option
    Then users is redirected to the Pages page
    When Users clicks edit button beside a page
    Then the page window is opened
    And User confirms that the Header option is available
    And User confirms that the Footer option is available
    And User confirms that the Content option is available
    And User confirms that the Media option is available
    And User confirms that the Touchpoint option is available
    And User confirms that the Streams option is available
    And User confirms that the Parallax option is available

  @SMSM-136 @Verify-the-4-options-appear-on-the-left-top-side-of-the-snippet
  Scenario: Verify the 4 option appears on left top side of snippet
    When User clicks on the Experience Menu option
    Then the Experience options are displayed
    When User clicks the Pages option
    Then users is redirected to the Pages page
    When Users clicks edit button beside a page
    Then the page window is opened
    When User clicks the text on the image
    Then the four action options for the image is displayed
    
  @SMSM-136 @Verify-the-all-code-is-visible-to-user-by-clicking-on-the-</>-icon 
  Scenario: Verify the all code is visible to user by clicking on this "</>" icon
    When User clicks on the Experience Menu option
    Then the Experience options are displayed
    When User clicks the Pages option
    Then users is redirected to the Pages page
    When Users clicks edit button beside a page
    Then the page window is opened
    When User clicks the text on the image
    And User clicks the html icon at the left side of the snippet
    Then a new pop-up window with a textarea and snippet code is displayed
   
 @SMSM-136 @Verify-the-same-snippet-is-added-on-the-page-by-clicking-on-plus-icon  
  Scenario: Verify the same snippet is added on the page by clicking on Plus icon
    When User clicks on the Experience Menu option
    Then the Experience options are displayed
    When User clicks the Pages option
    Then users is redirected to the Pages page
    When Users clicks edit button beside a page
    Then the page window is opened
    When User clicks the text on the image
    And User clicks the plus icon at the left side of the snippet
    
  @SMSM-136 @Verify-the-user-is-aable-to-delete-the-snippet-on-the-page-by-clicking-on-delete-icon 
  Scenario: Verify the user is able to delete the snippet on the page by clicking on delete icon
  When User clicks on the Experience Menu option
    Then the Experience options are displayed
    When User clicks the Pages option
    Then users is redirected to the Pages page
    When Users clicks edit button beside a page
    Then the page window is opened
    When User clicks the text on the image
    And User clicks the Delete icon at the left side of the snippet
    Then User verifies that the image is deleted
    
   @SMSM-136 @Verify-the-user-is-able-to-activate-the-page-by-clicking-on-Activate-button 
  Scenario: Verify the user is able to activate the page by clicking on Activate button
   When User clicks on the Experience Menu option
    Then the Experience options are displayed
    When User clicks the Pages option
    Then users is redirected to the Pages page
    When Users clicks the action dropdown button beside a page
    Then the actiion options are displayed
    When User clicks the Activate button option
  	Then the page is activated successfully
        
  @SMSM-136 @Verify-user-is-able-to-delete-the-page-by-clicking-on-delete-button 
  Scenario: Verify user is able to delete the page by clicking on delete button
   When User clicks on the Experience Menu option
    Then the Experience options are displayed
    When User clicks the Pages option
    Then users is redirected to the Pages page
    When Users clicks the action dropdown button beside a page
    And  User clicks the Delete button option
  	Then the page is deleted successfully
  	
  
  
  
  
  