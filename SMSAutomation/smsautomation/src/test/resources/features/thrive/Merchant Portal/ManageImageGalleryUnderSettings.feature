#Author: your.email@your.domain.com
#Keywords Summary :
#User is assumed to have Admin access unless stated Otherwise
#Step Definition File - ManageImageGalleryUnderSettingsSteps.java
Feature: [SMSM-174] Manage Image Gallery under settings in admin dashboard for Thrive system

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
		  When User clicks the Image Gallery option
    Then the Manage Image Gallery page is displayed
    
  @[SMSM-174] @Verify-Admin-can-see-all-existing-Image-Galleries-on-Manage-Image-Gallery 
  Scenario: Verify Admin can see all existing Image Galleries on Manage Image Gallery
    And User verifies the columns on the Manage Image Gallery page

  @[SMSM-174] @Verify-Admin-is-directed-to-a-specified-Image-Gallery-by-clicking-"Manage"-under-Action-column-for-any-Gallery-on-"Manage-Image-Gallery"-page 
  Scenario: Verify Admin is directed to a specified Image Gallery by clicking "Manage" under Action column for any Gallery on "Manage Image Gallery" page
    When User clicks the Manage button under actions column on the Manage Galeery page
    Then user is redirected to the  specified gallery page
    
   @[SMSM-174] @Verify-the-options-available-on-hovering-over-an-image-in-an-Image-Gallery
  Scenario: Verify the options available on hovering over an image in an Image Gallery
    When User clicks the Manage button under actions column on the Manage Galeery page
    Then user is redirected to the  specified gallery page
    When User hoever over an image 
    Then the action options on the image are displayed
    
  @[SMSM-174] @Verify-number-of-Images-in-an-Image-Gallery-is-as-per-the-"Count"-column-of-that-specified-gallery-on-Manage-Image-Gallery-page 
  Scenario: Verify number of Images in an Image Gallery is as per the "Count" column of that specified gallery on Manage Image Gallery page
    When User clicks the Manage button for a gallery with zero count of images
    Then user is redirected to the specified gallery page and no image notification is displayed
    When User selects a gallery with a count greater than zero
    Then user confirms that the images displayed equals the count
    
  @[SMSM-174] @Verify-a-new-Image-can-be-added-under-Image--Gallery-by-clicking-New-button 
  Scenario: Verify a new Image can be added under Image Gallery by clicking New button
    When User clicks the Manage button for a gallery to add image to
    Then user is redirected to the specified gallery page of the  gallery to add image to
		When User clicks the New button on the Gallery page
		Then Upload Images section is displayed
		When User attach the file to upload and click the upload button
		Then User verifies that the file is uploaded successfully
		
 @[SMSM-174] @Verify-Admin-can-update-the-Image-by-clicking-"Update"-option-for-that-Image 
  Scenario: Verify Admin can update the Image by clicking "Update" option for that Image [C22324778]
    When User clicks the Manage button for a gallery to add image to
    Then user is redirected to the specified gallery page of the  gallery to add image to
		When User hoever over the image and clicks on the Update option 
		Then the Update Media window is opened
		When User selects a Vertical and clicks  Update button
		Then User confirms that the image is updated successfully
	
	@[SMSM-174] @Verify-Admin-can-Delete-the-Image-by-clicking-"Delete"-for-that-Image 
  Scenario: Verify Admin can Delete the Image by clicking "Delete" for that Image [C22324758]
    When User clicks the Manage button for a gallery to add image to
    Then user is redirected to the specified gallery page of the  gallery to add image to
		When User hoever over the image and clicks on the Delete option 
		Then User confirms that the image is deleted
	
  @[SMSM-174] @Verify-that-Filter-Options-available-on-Image-Gallery-page @OnlyMe
  Scenario: Verify that Filter Options available on Image Gallery page.
    When User clicks the Manage button under actions column on the Manage Galeery page
    Then user is redirected to the  specified gallery page
    When User clicks the Filter By Vertical drop down
    Then the drop down options are displayed.
    
		
		
		
    