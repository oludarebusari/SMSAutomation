#Author: your.email@your.domain.com
#Keywords Summary :
#User is assumed to have Admin access unless stated Otherwise
#Step Definition File - ManageImageGalleryUnderSettingsSteps.java
Feature: [SMSM-173] Manage Page Templates under settings in admin dashboard for Thrive system

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

  @[SMSM-173] @Verify-Admin-can-see-all-existing-Page-Templates-under-Settings>-Page-Templates-page
  Scenario: Verify Admin can see all existing Page Templates under Settings> Page Templates page
    And User verifies the Column headers on Page Templates page

  @[SMSM-173] @Verify-functionality-of-Show-entries-dropdown-and-pagination-on-"Page-Templates"-page
  Scenario: Verify functionality of Show entries dropdown and pagination on "Page Templates" page
    And User verifies the Show entries drop down
    And User verifies the default value selected for Show Enteries drop
    When User clicks on Show Entries drop down
    Then list of option that can be selected are displayed
    When User clicks the Next button to navigate to next page
    Then the next page on the pagination buttons is highlighted
    When User Selects All from the drop down list
    Then User verifies all the records are displayed on one page

  @[SMSM-173] @Verify-Templates-can-be-sorted-by-clicking-on-arrows-icon-on-side-of-each-column-heading-on-"Page-Templates"-page
  Scenario: Verify Templates can be sorted by clicking on arrows icon on side of each column heading on "Page Templates" page
    And User verifies the icons on the side of the column heading
    When User clicks on the page column
    Then the records are sorted in ascending order by the page column

  @[SMSM-173] @Verify-Admin-can-Edit-an-existing-"Page-Template"
  Scenario: Verify Admin can Edit an existing "Page Template"
    And User verifies that Edit button exist for each of the records
    When User clicks on the Edit button for a Template
    Then the selected Template page is opened
    When User makes some changes and clicks the Save button
    Then the Changes are successfully saved
    When User clicks the Page link
    Then User is redirected to the Page Template window
    And User confirms the changes by clicking the Edit button of the template again

  @[SMSM-173] @Create-Page-Template
  Scenario: Create Page Template
    When User clicks on the New button on the Page Template
    Then the Create Page Template modal is displayed
    When User enter the required information on the modal and click Create Page Template button
    Then the page template is created successfully

  @[SMSM-173] @Verify-clicking-"Cancel"-or-"X"-on-Activate-page-popup-does-not-Activate-the-template
  Scenario: Verify clicking "Cancel" or "X" on Activate page popup does not Activate the template
    And User verifies that Edit button exist for each of the records
    When User clicks on the Edit button drop down for a Template to activate
    Then the Activate popup window is displayed
    When User clicks the Close button on the Activate popup window
    Then User confirms that the page template was not activated

  @[SMSM-173] @Verify-Admin-can-Activate-a-Deactivate-"Page-Template"
  Scenario: Verify Admin can Activate a Deactivate "Page Template"
    And User verifies that Edit button exist for each of the records
    When User clicks on the Edit button drop down for a Template to activate
    Then the Activate popup window is displayed
    When User clicks the Activate button the window
    Then User confirms that the page template is activated

  @[SMSM-173] @Verify-clicking-"Cancel"-or-"X"-on-Inactivate-page-popup-does-not-Inactivate-the-template
  Scenario: Verify clicking "Cancel" or "X" on Activate page popup does not Activate the template
    And User verifies that Edit button exist for each of the records
    When User clicks on the Edit button drop down for a Template to make Inactive
    Then the Deactivate popup window is displayed
    When User clicks the Close button on the Deactivate popup window
    Then User confirms that the page template was not deactivated

  @[SMSM-173] @Verify-Admin-can-Deactivate-an-Active-"Page-Template"
  Scenario: Verify Admin can Deactivate an Active "Page Template"
    And User verifies that Edit button exist for each of the records
    When User clicks on the Edit button drop down for a Template to make Inactive
    Then the Deactivate popup window is displayed
    When User clicks the Deactivate button the window
    Then User confirms that the page template is deactivated

  @[SMSM-173] @Verify-clicking-"Cancel"-or-"X"-on-Delete-Page-popup-does-not-delete-the-Page-Template 
  Scenario: Verify clicking "Cancel" or "X" on Delete Page popup does not delete the Page Template
    And User verifies that Edit button exist for each of the records
    When User clicks on the Edit button drop down for a Template to delete
    Then the Delete popup window is displayed
    When User clicks the Close button on the Delete popup window
    Then User confirms that the page template was not deleted

  @[SMSM-173] @Verify-Admin-can-delete-an-existing-Page-Template
  Scenario: Verify Admin can delete an existing Page Template
    And User verifies that Edit button exist for each of the records
    When User clicks on the Edit button drop down for a Template to delete
    Then the Delete popup window is displayed
    When User clicks the Delete button on the window
    Then User confirms that the page template is deleted
    
  @[SMSM-173] @Verify-Admin-is-able-to-search-the-Page-Templates-by-entering-a-search-criteria-in-Search-box-and-clicking-Search @OnlyMe
  Scenario: Verify Admin is able to search the Page Templates by entering a search criteria in Search box and clicking Search
    And User verifies that Edit button exist for each of the records
    And User verifies that both Search textbox and Search button are present on the page
    When User enters a text into the Search textbox and clicks Search button
    Then the result of the search is displayed
    When User leaves the search textbox empty and clicks the Search button
    Then all the template records are displayed
