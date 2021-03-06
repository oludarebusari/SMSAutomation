#Author: your.email@your.domain.com
#Keywords Summary :
#User is assumed to have Admin access unless stated Otherwise
#Step Definition File - AddPageTemplatesUnderSettingsSteps.java
@thrive @RegressionTest
Feature: [SMSM-172] Add Page Templates under settings in admin dashboard for Thrive system

  Background: User logs in to Thrive and navigate to Business Dashboard
    Given User Navigates to Thrive URL
    Then Thrive login page is displayed
    When User enters a valid username for thrive
    And User enters a valid password for thrive
    And User clicks the sign in button for thrve
    Then Thrive Dashboard page is displayed
    And User verifies that Settings menu option is available
    When user clicks the Settings menu
    Then all options under Settings menu are displayed
    When User clicks the Page Templates option
    Then the Page Templates screen is displayed

  @[SMSM-172] @Verify-admin-can-add-a-page-template-and-page-is-added-under-Page-Templates-page 
  Scenario: Verify admin can add a page template and page is added under Page Templates page
    When User Clicks on the New button on the Page Templates page
    Then the Create Page Template window is opened
    And User enters name into the Name field
    And User selects single or multiple categories
    And User clicks the Create Page Template button
    And User clicks the Page link
    And User confirms that the Page Template is created successfully

  #@[SMSM-172] @Verify-Admin-is-able-to-Add-Content-on-template-page
  #Scenario: Verify Admin is able to Add Content on template page

  #	When User verifies the options on the left menu bar of the newly created page
  #	When user clicks on an option to add content
  #	Then the option is expanded and the snippets are displayed
  #	When User selects a snippet and drag to the right pane
  #	Then the Header, Body content and Footer are displayed
  @[SMSM-172] @Verify-the-validations-on-"Add-page-template"-page-on-clicking-"+New"-button
  Scenario: Verify the validations on "Add page template" page on clicking "+New" button
    When User Clicks on the New button on the Page Templates page
    Then the Create Page Template window is opened
    When User leaves all the fields blank and clicks Create Page Template button
    Then the validation message is displayed
    And User verifies the state of the Create Page Template button
    And User enters a name into the name field and verifies the state of the Create Page Template button

  @[SMSM-172] @Verify-admin-can-view/change-the-source-code-of-the-snippet
  Scenario: Verify admin can view/change the source code of the snippet
    When User clicks the edit button on a page
    Then the page template edit window is opened
    When User clicks on an Image and clicks on the html snippet
    Then the html text window is opened
    And User enters html and clicks OK button
    And User clicks the Save button on the page
    And User confirms the change was saved correctly

  @[SMSM-172] @Verify-admin-can-create-a-copy-of-snippet-on-clicking-"+'-on-snippet
  Scenario: Verify admin can create a copy of snippet on clicking "+' on snippet [C22416155]
    When User clicks the edit button on a page to modify
    Then the page template edit window is displayed
    When User clicks on an Image, clicks on the plus snippet and clicks the Save button
    Then the snippet is duplicated

  @[SMSM-172] @Verify-admin-can-delete-an-existing-snippet
  Scenario: Verify admin can delete an existing snippet [C22416186]
    When User clicks the edit button on a page to modify
    Then the page template edit window is displayed
    When User clicks on an Image, clicks on the delete snippet and clicks the Save button
    Then the snippet is successfully removed

  @[SMSM-172] @Verify-a-Page-Template-can-be-Activated-from-its-content-page 
  Scenario: Verify a Page Template can be Activated from its content page [C22416232]
    When User clicks the action drop down for the page to Activate
    Then the actions options are displayed
    When User clicks the Make Active Option
    Then the Activate page window is opened
    When User clicks the Activate button on the modal
    Then the selected page is Activated

  @[SMSM-172] @Verify-a-Page-Template-can-be-deactivate-from-its-content-page 
  Scenario: Verify a Page Template can be deactivate from its content page [C22416229]
    When User clicks the action drop down for the page to Deactivate
    Then the actions options for the selected page to deactivate is displayed
    When User clicks the Make Inactive Option
    Then the Deactivate page window is opened
    When User clicks the Deactivate button on the modal
    Then the selected page is Deactivated


@[SMSM-172] @Verify-the-Settings-can-be-changed-for-Page-Template-from-its-Contents 
  Scenario: Verify the Settings can be changed for Page Template from its Contents
    When User clicks the edit button on a page template
    Then the page edit window is opend
    When User clicks the Settings buttons
    Then the Settings modal window is opened
    When User attaches a file and click the Save Settings button
    Then User verifies the attached file is saved successfully.

  @[SMSM-172] @Verify-the-Page-Template-name-can-be-changed-from-its-content-page 
  Scenario: Verify the Page Template name can be changed from its content page
    When User clicks the edit button on a page template
    Then the page edit window is opend
    When User clicks on the Page template name
    And User modifies the page title
    And user clicks on the editable button
    And User verifies the changes to the title
    
  @[SMSM-172] @Verify-clicking-Cancel-or-'X'-on-"Delete-this-page"-does-not-delete-a-page-template-from-its-content-page 
  Scenario: Verify clicking Cancel or 'X'  on "Delete this page" does not  delete a page template from its content page [C22416228]
    When User clicks the action drop down for the page to delete
    Then the actions options for the page to be deleted is displayed
    When User clicks the Delete Option
    Then the Delete page window is opened
    When User clicks the close button on the modal
    Then the selected page is not deleted and available in the list

  @[SMSM-172] @Verify-admin-can-delete-a-page-template-from-its-content-page 
  Scenario: Verify admin can delete a page template from its content page
    When User clicks the action drop down for the page to delete
     Then the actions options for the page to be deleted is displayed
    When User clicks the Delete Option
    Then the Delete page window is opened
    When User clicks the Delete button on the modal
    Then the selected page is deleted and not available in the list again

  
    
    
