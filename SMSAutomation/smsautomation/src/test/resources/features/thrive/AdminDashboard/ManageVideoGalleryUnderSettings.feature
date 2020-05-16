#Author: your.email@your.domain.com
#Keywords Summary :
#User is assumed to have Admin access unless stated Otherwise
#Step Definition File - ManageImageGalleryUnderSettingsSteps.java
Feature: [SMSM-175] Manage Video Gallery under settings in admin dashboard for Thrive system

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
    When User clicks the Video Gallery option
    Then the Manage Video Gallery page is displayed
    
  @[SMSM-175] @Verify-Admin-can-see-all-existing-Video-Galleries-on-Manage-Video-Gallery
  Scenario: Verify Admin can see all existing Video Galleries on Manage Video Gallery [C22326097]
    And User verifies the columns on the Manage Video Gallery page
    
  @[SMSM-175] @Verify-number-of-Videos-on-Video-Gallery-is-as-per-the-"Count"-column-of-that-specified-gallery-on-Manage-Video-Gallery-page 
  Scenario: Verify number of Videos on Video Gallery is as per the "Count" column of that specified gallery on Manage Video Gallery page [C22344199]
  	When User clicks managae button of a video gallery with zero count
  	Then a notification indicating no videos arre available is displayed
  	When User clicks manage button of a gallery with count greater than zero
  	Then User confirms the number of videos correspond to the count on Manage Video Gallery page
  	When User hovers over the any of the videos
  	Then User confirms the options on the video
  	
  	
  
  
   