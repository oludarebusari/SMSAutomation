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

#User is assumed to have Admin access unless stated Otherwise
Feature: [SMSM-240] User is able to manage review settings in merchant portal for Thrive system

  Background: User logs in to Thrive and navigate to Business Dashboard
    Given User Navigates to Thrive URL
    Then Thrive login page is displayed
    When User enters a valid username for thrive
    And User enters a valid password for thrive
    And User clicks the sign in button for thrve
    Then Thrive Dashboard page is displayed
    When User navigates to Companies menu and clicks the Businesses option
    Then the user is redirected to the Manage Businesses page
    When User types the business name in the search field and clicks Search
    Then the Business is displayed
    When User navigates to the actions column of the Business for stream testing and clicks Sign In button
    Then User is logged into the Business and the business dashboard is opened

  @SMSM-240 @Verify-that-user-is-able-to-navigate-to-streams-page @RegressionTest
  Scenario: Verify that user is able to navigate to streams page [C22431840]
    When User clicks on the Experience Menu option
    Then the Experience options are displayed
    When User clicks the Streams option
    Then the Stream page is opened

  @SMSM-240 @Verify-that-user-is-able-to-navigate-to-streams-configuration-windows-pop-up @RegressionTest
  Scenario: Verify that user is able to navigate to Streams Configuration windows pops-up [C22431852]
    When User clicks on the Experience Menu option
    Then the Experience options are displayed
    When User clicks the Streams option
    Then the Stream page is opened
    And User verifies that Settings button is displayed
    When User clicks the Settings button
    Then a Settings configuration pop is opened
    And User verifies the three tabs on the settings window

  @SMSM-240 @Verify-that-user-is-able-to-set-Reviews-System-value-under-Review-Settings-tab @RegressionTest
  Scenario: Verify that user is able to set Reviews System value under Review Settings tab [C22431860]
    When User clicks on the Experience Menu option
    Then the Experience options are displayed
    When User clicks the Streams option
    Then the Stream page is opened
    And User verifies that Settings button is displayed
    When User clicks the Settings button
    Then a Settings configuration pop is opened
    When User Clicks the Reviews Settings tab
    Then the Review Settings tab is opened
    When User hovers on Review System
    Then the help description of Review System is displayed
    And User verifies the two button available for Review System
    When User clicks on the Reviews Disabled button
    Then the Review is Disabled
    When User clicks the Review Enabled button
    Then the Review is Enabled

  @SMSM-240 @Verify-that-user-is-able-to-set-send-review-request-after-x-checkins @RegressionTest
  Scenario: Verify that user is able to set Send Review Request after X checkins value under Review Settings tab [C22434562]
    When User clicks on the Experience Menu option
    Then the Experience options are displayed
    When User clicks the Streams option
    Then the Stream page is opened
    And User verifies that Settings button is displayed
    When User clicks the Settings button
    Then a Settings configuration pop is opened
    When User Clicks the Reviews Settings tab
    Then the Review Settings tab is opened
    And User verifies that Send Review Requestafter x checkins textbox is available
    And User enters a value into the Send Review Requestafter x checkins textbox
    When User hovers over the Send Review Requestafter x checkins title
    Then the help description for Send Review Requestafter x checkins is displayed

  @SMSM-240 @Verify-that-user-is-able-to-set-checkin-review-request-value-under-Review-settings-tab @RegressionTest
  Scenario: Verify that user is able to set Checkin Review Request value under Review Settings tab [C22434551]
    When User clicks on the Experience Menu option
    Then the Experience options are displayed
    When User clicks the Streams option
    Then the Stream page is opened
    And User verifies that Settings button is displayed
    When User clicks the Settings button
    Then a Settings configuration pop is opened
    When User Clicks the Reviews Settings tab
    Then the Review Settings tab is opened
    And User verifies that the CheckIn Review Request dropdown is available
    And User selects a value from the dropdown for CheckIn Review Request
    When User hovers over the Checkin Review Request title
    Then the help description for Checkin Review Request is displayed

  @SMSM-240 @Verify-that-user-is-able-to-set-review-submissions-automatic-response-method-value-under-Review-settings-tab @RegressionTest
  Scenario: Verify that user is able to set Review Submissions Automatic Response Method value under Review Settings tab [C22434554]
    When User clicks on the Experience Menu option
    Then the Experience options are displayed
    When User clicks the Streams option
    Then the Stream page is opened
    And User verifies that Settings button is displayed
    When User clicks the Settings button
    Then a Settings configuration pop is opened
    When User Clicks the Reviews Settings tab
    Then the Review Settings tab is opened
    And User verifies that the Review Submissions Automatic Response Method dropdown is available
    And User selects a value from the dropdown for Review Submissions Automatic Response
    When User hovers over the Review Submissions Automatic Response Method dropdown title
    Then the help description for Review Submissions Automatic Response Method dropdown is displayed

  @SMSM-240 @Verify-that-user-is-able-to-set-social-share-automatic-response-value-under-Review-settings-tab @RegressionTest
  Scenario: Verify that user is able to set Social Share Automatic Response value under Review Settings tab [C22434558]
    When User clicks on the Experience Menu option
    Then the Experience options are displayed
    When User clicks the Streams option
    Then the Stream page is opened
    And User verifies that Settings button is displayed
    When User clicks the Settings button
    Then a Settings configuration pop is opened
    When User Clicks the Reviews Settings tab
    Then the Review Settings tab is opened
    And User verifies the two button available for Social Share Automatic Response
    When User clicks on the Social Share Auto Response Disabled button
    Then the Social Share Auto Response is Disabled
    When User clicks the Social Share Auto Response Enabled button
    Then the Social Share Auto Response is Enabled
    When User hovers over the Social Share Automatic Response title
    Then the help description for Social Share Automatic Response is displayed

  @SMSM-240 @Verify-that-user-is-able-to-set-social-share-automatic-response-delay-value-under-Review-Settings-tab-and-save-the-stream-setting @RegressionTest
  Scenario: Verify that user is able to set Social Share Automatic Response Delay value under Review Settings tab and save the stream settings [C22434559]
    When User clicks on the Experience Menu option
    Then the Experience options are displayed
    When User clicks the Streams option
    Then the Stream page is opened
    And User verifies that Settings button is displayed
    When User clicks the Settings button
    Then a Settings configuration pop is opened
    When User Clicks the Reviews Settings tab
    Then the Review Settings tab is opened
    And User verifies that the Social Share Automatic Response Delay dropdown is available
    And User selects a value for Social Share Automatic Response Delay from the dropdown values
    When User clicks the Save Settings button on the Stream Configuration modal
    Then User confirms the selected value for Social Share Auto Resp Delay was saved correctly

  @SMSM-240 @Verify-that-user-is-able-to-edit-Review-Request-Template-for-Review-Templates-tab @RegressionTest
  Scenario: Verify that user is able to edit Review Request template for Review Templates tab [C22431875]
    When User clicks on the Experience Menu option
    Then the Experience options are displayed
    When User clicks the Streams option
    Then the Stream page is opened
    And User verifies that Settings button is displayed
    When User clicks the Settings button
    Then a Settings configuration pop is opened
    When User clicks on the Review Templates tab
    Then the Review Template section is opened
    And User verifies there are SMS and Email sections for each Review Templates subsection
    And User is able to send text to all the SMS and Email textboxes

  @SMSM-240 @Verify-that-user-is-able-to-edit-Review-Positive-form-submission-templates-for-Review-Templates-tab @RegressionTest
  Scenario: Verify that user is able to edit Review Positive form Submission template for Review Templates tab [C22431911]
    When User clicks on the Experience Menu option
    Then the Experience options are displayed
    When User clicks the Streams option
    Then the Stream page is opened
    And User verifies that Settings button is displayed
    When User clicks the Settings button
    Then a Settings configuration pop is opened
    When User clicks on the Review Templates tab
    Then the Review Template section is opened
    And User verifies SMS and Email textboxes for Review Positive Form Submission
    And User edits the text in SMS textbox for Review Positive Form Submission
    And User edits the text in the Email textbox for Review Positive Form Submission

  @SMSM-240 @Verify-that-user-is-able-to-edit-Review-Negative-form-submission-templates-for-Review-Templates-tab @RegressionTest
  Scenario: Verify that user is able to edit Review Negative form Submission template for Review Templates tab [C22431911]
    When User clicks on the Experience Menu option
    Then the Experience options are displayed
    When User clicks the Streams option
    Then the Stream page is opened
    And User verifies that Settings button is displayed
    When User clicks the Settings button
    Then a Settings configuration pop is opened
    When User clicks on the Review Templates tab
    Then the Review Template section is opened
    And User verifies SMS and Email textboxes for Review Negative Form Submission
    And User edits the text in SMS textbox for Review Negative Form Submission
    And User edits the text in the Email textbox for Review Negative Form Submission

  @SMSM-240 @Verify-that-user-is-able-to-edit-Review-Request-to-share-template-for-Review-Templates-tab @RegressionTest
  Scenario: Verify that user is able to edit Review Request to Share Template template for Review Templates tab [C22431915]
    When User clicks on the Experience Menu option
    Then the Experience options are displayed
    When User clicks the Streams option
    Then the Stream page is opened
    And User verifies that Settings button is displayed
    When User clicks the Settings button
    Then a Settings configuration pop is opened
    When User clicks on the Review Templates tab
    Then the Review Template section is opened
    And User verifies SMS and Email textboxes Review Request to Share Template section
    And User edits the text in SMS textbox Review Request to Share Template section
    And User edits the text in the Email textbox Review Request to Share Template section

  @SMSM-240 @Verify-that-user-is-able-to-save-stream-configuration-for-Review-Settings-tab @RegressionTest
  Scenario: Verify that user is able to save Streams Configuration for Review Settings tab [C22431920]
    When User clicks on the Experience Menu option
    Then the Experience options are displayed
    When User clicks the Streams option
    Then the Stream page is opened
    And User verifies that Settings button is displayed
    When User clicks the Settings button
    Then a Settings configuration pop is opened
    When User clicks on the Review Templates tab
    Then the Review Template section is opened
    And User edits SMS and Email for Review Positive Form Submission
    When User clicks the Review Settings tab
    Then the Review Settings section is opened
    And User selects a value from the dropdown for Review Submissions Automatic Response
    When User clicks the Stream Settings tab
 
   @SMSM-240 @Verify-that-user-is-able-to-edit-data-under-verify-Review-Language-Strings-for-Review-Templates-tab @RegressionTest
  Scenario: Verify that user is able to edit data under Verify Review Language Strings for Review Templates tab [C22431923]
    When User clicks on the Experience Menu option
    Then the Experience options are displayed
    When User clicks the Streams option
    Then the Stream page is opened
    And User verifies that Settings button is displayed
    When User clicks the Settings button
    Then a Settings configuration pop is opened
    When User clicks on the Review Templates tab
    Then the Review Template section is opened
    And User verifies Review Positive Message and Review Negative Messages textbox is available
    And User edits the text in Reviews Positive Message textbox
    And User edits the text in Reviews Negatuive Message textbox
    
		