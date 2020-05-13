#Author: your.email@your.domain.com
#Keywords Summary :

#User is assumed to have Admin access unless stated Otherwise
#Step Definition File - StreamsPageUnderExperienceSteps.java
Feature: [SMSM-193] Verify the Stream page under Experience tab for Thrive system

  Background: User logs in to Thrive and navigate to Business Dashboard
    Given User Navigates to Thrive URL
    Then Thrive login page is displayed
    When User enters a valid username for thrive
    And User enters a valid password for thrive
    And User clicks the sign in button for thrve
    Then Thrive Dashboard page is displayed
    When User clicks on the Experience Menu option on the admin dashboard
    Then the Experience tab option is displayed
    When User clicks on the Streams option
    Then the Stream page under Experience is displayed

  @SMSM-193 @Verify-the-stream-page-is-opened-at-Experience-tab @RegressionTest
  Scenario: Verify the stream page is opened at Experience tab
    And User verifies the URL of the Stream page

  @SMSM-193 @Verify-the-"Reseller-and-Business"-Filter @RegressionTest 
  Scenario: Verify the "Reseller and Business" Filter
    And User verifies that the Reseller and Business filter is available
    When User clicks the Reseller and Business textfield
    Then a drop down displaying Busineses is opened
    When User selects Business or Reseller
    Then the selected Business or Reseller is displayed on the drop down text field
    When User clicks the close button beside a selected Business
    Then the Business option is deselected
    When User selects an existing Reseller and Business
    Then User confirms that both the Reseller and Business are selected and displayed
    

  @SMSM-193 @Verify-the-"Platforms"-filter @RegressionTest 
  Scenario: Verify the "Platforms" filter
    And User verifies that the Platform filter is available
    When User clicks the close button beside a selected platform
    Then the Platform option is deselected

  @SMSM-193 @Verify-the-"Read"-filter @RegressionTest 
  Scenario: Verify the "Read" filter
    And User verifies that the Read filter is available
    And User verifies that Unread streams are displayed by deafult
    When User clicks the Filter by Read button
    Then User is able to see all read streams
    When User clicks the Filter by Read button again
    Then User is able to see all unread streams

  @SMSM-193 @Verify-the-"Rating"-filter @RegressionTest 
  Scenario: Verify the "Rating" filter
    And User verifies that the Rating filter is available
    When User clicks on the Five Stars rates button
    Then all streamns  with five stars are displayed
    When User clicks on the one star rates button
    Then all streamns  with one star are displayed

  @SMSM-193 @Verify-the-"Status"-filter @RegressionTest
  Scenario: Verify the "Status" filter
    And User verifies that the Status filter for Streams is available
    When User clicks on the Approved button
    Then all approved streams are displayed
    When User clicks on the Suppressed button
    Then all suppressed streams were displayed

  @SMSM-193 @Verify-the-"Recency"-filter @RegressionTest
  Scenario: Verify the "Recency" filter
    And User verifies that the Recency filter for Streams is available
    When User clicks the Newest First button
    Then the newwest streams are displayed first
    When User clicks the oldest First button
    Then the Oldest streams are displayed first
    
 @SMSM-193 @Verify-the-pagination-functionality @RegressionTest
  Scenario: Verify the pagination functionality
    And User verifies pagination is available
    And User verifies the drop down of Show n Entries
    And User selects a number for Show n Entries
    And User verifies that both Previous and Next buttons are available
    And User verifies that the Previous button is displabed when user is on the first page
    And User verifies that the Next button is disabled when user is on the last poage
    
 #@SMSM-193 @Verify-the-"Help"-button-on-the-page @RegressionTest @OnlyMe
  #Scenario: Verify the "Help" button on the page
    #And User verifies that Help button is avaialable on the page
    #When User clicks on the Help button on the Streams page
    #Then a tour for the Streams help page is opened
    #When User clicks on the Next button from the Streams window
    #Then the Companies window is opened
    #When User clicks on the previous button from the Companies window
    #Then the tour guide is navigate back to the Streams window
    #When User clicks on End Tour button
    #Then Tour ends successfully
    
 @SMSM-193 @Verify-the-Contents-of-Streams @RegressionTest 
  Scenario: Verify the Contents of Streams
    And User verifies that Streams are available  
     And User verifies that platform logo is available
     And User verifies that Status is available
     And User verifies that ratings are available
     And User verifies that 'Unread streams are available
     
 @SMSM-193 @Verify-the-popup-by-clicking-on-"reply" @RegressionTest 
  Scenario: Verify the popup by clicking on "reply"
  And User verifies that Reply option is available for the Streams
  When User clicks on the Reply button of a stream
  Then a popup window to respond to the Stream is opened
  When User leaves the response text area empty and clicks Reply button
  Then validation message for the textarea is displayed
  When User clicks on the Create a template from this response checkbox
  Then the Template Title textbox is displayed
  When User types in a response and a Template Title and clicks Reply button

  

