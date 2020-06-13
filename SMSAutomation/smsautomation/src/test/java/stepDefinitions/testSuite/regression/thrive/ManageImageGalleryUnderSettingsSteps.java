package stepDefinitions.testSuite.regression.thrive;

import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import components.elements.CommonElementLocator;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.thrive.GalleryPage;
import pageObjects.thrive.ManageImageGalleryPage;
import pageObjects.thrive.ThriveLoginPage;
import pageObjects.thrive.Tab.SettingsDDown;
import pageObjects.thrive.modal.UpdateMediaModal;
import utils.DriverFactory;

public class ManageImageGalleryUnderSettingsSteps extends DriverFactory {

	public CommonElementLocator commonElementLocator = PageFactory.initElements(driver, CommonElementLocator.class);
	public GalleryPage gallleryPage = PageFactory.initElements(driver, GalleryPage.class);
	public ManageImageGalleryPage manageImageGalleryPage = PageFactory.initElements(driver,
			ManageImageGalleryPage.class);
	public SettingsDDown settingsDDown = PageFactory.initElements(driver, SettingsDDown.class);
	public UpdateMediaModal updateMediaModal = PageFactory.initElements(driver, UpdateMediaModal.class);
	public ThriveLoginPage thriveLoginPage = PageFactory.initElements(driver, ThriveLoginPage.class);


	Actions actions = new Actions(driver);
	private int numberOfImages = 0;
	private String URLAddress = "";

	@Then("User verifies that Settings menu option is available")
	public void user_verifies_that_Settings_menu_option_is_available() {
		Assert.assertTrue(commonElementLocator.menu_Settings.isDisplayed());
	}

	@When("user clicks the Settings menu")
	public void user_clicks_the_Settings_menu() throws InterruptedException {
		commonElementLocator.waitAndClickElement(commonElementLocator.menu_Settings);
	}

	@Then("all options under Settings menu are displayed")
	public void all_options_under_Settings_menu_are_displayed() {
		Assert.assertTrue(settingsDDown.opt_Settings.isDisplayed());
		Assert.assertTrue(settingsDDown.opt_Language_Strings.isDisplayed());
		Assert.assertTrue(settingsDDown.opt_Message_Templates.isDisplayed());
		Assert.assertTrue(settingsDDown.opt_Page_Templates.isDisplayed());
		Assert.assertTrue(settingsDDown.opt_Screen_Templates.isDisplayed());
		Assert.assertTrue(settingsDDown.opt_Image_Gallery.isDisplayed());
		Assert.assertTrue(settingsDDown.opt_Video_Gallery.isDisplayed());
		Assert.assertTrue(settingsDDown.opt_Alerts.isDisplayed());
		Assert.assertTrue(settingsDDown.opt_Tours.isDisplayed());
	}

	@When("User clicks the Image Gallery option")
	public void user_clicks_the_Image_Gallery_option() throws Exception {
		settingsDDown.waitAndClickElement(settingsDDown.opt_Image_Gallery);
	}

	@Then("the Manage Image Gallery page is displayed")
	public void the_Manage_Image_Gallery_page_is_displayed() throws Exception {
		Assert.assertEquals("Manage Image Gallery",
				commonElementLocator.getElementText(commonElementLocator.pag_Title));
	}

//	@Verify-Admin-can-see-all-existing-Image-Galleries-on-Manage-Image-Gallery
	@Then("User verifies the columns on the Manage Image Gallery page")
	public void user_verifies_the_columns_on_the_Manage_Image_Gallery_page() {
		Assert.assertTrue(manageImageGalleryPage.col_Name.isDisplayed());
		Assert.assertTrue(manageImageGalleryPage.col_Count.isDisplayed());
		Assert.assertTrue(manageImageGalleryPage.col_Actions.isDisplayed());
	}

//	@Verify-Admin-is-directed-to-a-specified-Image-Gallery-by-clicking-"Manage"-under-Action-column-for-any-Gallery-on-"Manage-Image-Gallery"-page
	@When("User clicks the Manage button under actions column on the Manage Galeery page")
	public void user_clicks_the_Manage_button_under_actions_column_on_the_Manage_Galeery_page() throws Exception {
		manageImageGalleryPage.waitAndClickElement(manageImageGalleryPage.btn_Manage("Holiday Video"));
	}

	@Then("user is redirected to the  specified gallery page")
	public void user_is_redirected_to_the_specified_gallery_page() throws Exception {
		Assert.assertEquals("Gallery / Holiday Video",
				commonElementLocator.getElementText(commonElementLocator.pag_Title));
	}

//	@Verify-the-options-available-on-hovering-over-an-image-in-an-Image-Gallery
	@When("User hoever over an image")
	public void user_hoever_over_an_image() {
		actions.moveToElement(gallleryPage.TestImage1).perform();
	}

	@Then("the action options on the image are displayed")
	public void the_action_options_on_the_image_are_displayed() {
		Assert.assertTrue(gallleryPage.btn_Update.isDisplayed());
		Assert.assertTrue(gallleryPage.btn_Delete.isDisplayed());
	}

//	@Verify-number-of-Images-in-an-Image-Gallery-is-as-per-the-"Count"-column-of-that-specified-gallery-on-Manage-Image-Gallery-page
	@When("User clicks the Manage button for a gallery with zero count of images")
	public void user_clicks_the_Manage_button_for_a_gallery_with_zero_count_of_images() throws Exception {
		manageImageGalleryPage.waitAndClickElement(manageImageGalleryPage.btn_Manage(2, "Welcome"));
	}

	@Then("user is redirected to the specified gallery page and no image notification is displayed")
	public void user_is_redirected_to_the_specified_gallery_page_and_no_image_notification_is_displayed()
			throws Exception {
		Assert.assertTrue(commonElementLocator.getElementText(commonElementLocator.pag_Title).contains("Welcome"));
		Assert.assertEquals("There are no images, please upload some!",
				gallleryPage.getElementText(gallleryPage.noImage));
	}

	@When("User selects a gallery with a count greater than zero")
	public void user_selects_a_gallery_with_a_count_greater_than_zero()
			throws NumberFormatException, InterruptedException {
		gallleryPage.waitAndClickElement(gallleryPage.lnk_Gallery);
		numberOfImages = Integer
				.parseInt(manageImageGalleryPage.getElementText(manageImageGalleryPage.countValue("Holiday")));
		manageImageGalleryPage.waitAndClickElement(manageImageGalleryPage.btn_Manage("Holiday"));
	}

	@Then("user confirms that the images displayed equals the count")
	public void user_confirms_that_the_images_displayed_equals_the_count()
			throws NumberFormatException, InterruptedException {
		System.out.println(gallleryPage.getNumberOfElements(gallleryPage.getALLIMAGESLOCATOR()));
		Assert.assertEquals(numberOfImages, gallleryPage.getNumberOfElements(gallleryPage.getALLIMAGESLOCATOR()));
	}

//	@Verify-a-new-Image-can-be-added-under-Image--Gallery-by-clicking-New-button
	@When("User clicks the Manage button for a gallery to add image to")
	public void user_clicks_the_Manage_button_for_a_gallery_to_add_image_to() throws InterruptedException {
		manageImageGalleryPage.waitAndClickElement(manageImageGalleryPage.btn_Manage("Holiday Video"));
	}

	@Then("user is redirected to the specified gallery page of the  gallery to add image to")
	public void user_is_redirected_to_the_specified_gallery_page_of_the_gallery_to_add_image_to() throws Exception {
		Assert.assertTrue(
				commonElementLocator.getElementText(commonElementLocator.pag_Title).contains("Holiday Video"));
	}

	@When("User clicks the New button on the Gallery page")
	public void user_clicks_the_New_button_on_the_Gallery_page() throws InterruptedException {
		commonElementLocator.waitAndClickElement(commonElementLocator.btn_New);
	}

	@Then("Upload Images section is displayed")
	public void upload_Images_section_is_displayed() {
		Assert.assertTrue(gallleryPage.form_UploadImages.isDisplayed());
	}

	@When("User attach the file to upload and click the upload button")
	public void user_attach_the_file_to_upload_and_click_the_upload_button() throws Exception {
		gallleryPage.sendKeysToWebElement(gallleryPage.txtF_InputFile,
				"C:/Development/SMSAutomation/smsautomation/lib/auto_gallery_small.jpeg");
		gallleryPage.waitAndClickElement(gallleryPage.btn_Upload);
	}

	@Then("User verifies that the file is uploaded successfully")
	public void user_verifies_that_the_file_is_uploaded_successfully() throws Exception {
		Assert.assertEquals("The images have been successfully uploaded",
				gallleryPage.getElementText(gallleryPage.uploadNotificationAlert));
	}

//	@Verify-Admin-can-update-the-Image-by-clicking-"Update"-option-for-that-Image
	@When("User hoever over the image and clicks on the Update option")
	public void user_hoever_over_the_image_and_clicks_on_the_Update_option() throws InterruptedException {
		actions.moveToElement(gallleryPage.TestImage2).perform();
		gallleryPage.waitAndClickElement(gallleryPage.btn_UpdateTestImage);
	}

	@Then("the Update Media window is opened")
	public void the_Update_Media_window_is_opened() throws Exception {
		Assert.assertEquals("Update Media", updateMediaModal.getElementText(updateMediaModal.mod_title));
	}

	@When("User selects a Vertical and clicks  Update button")
	public void user_selects_a_Vertical_and_clicks_Update_button() throws Exception {
		updateMediaModal.waitAndClickElement(updateMediaModal.verticalDDown);
		updateMediaModal.waitAndClickElement(updateMediaModal.selectVertical("Comedy Clubs"));
		updateMediaModal.waitAndClickElement(updateMediaModal.mod_title);
		updateMediaModal.waitAndClickElement(updateMediaModal.btn_Update);
	}

	@Then("User confirms that the image is updated successfully")
	public void user_confirms_that_the_image_is_updated_successfully() throws InterruptedException {
		gallleryPage.waitAndClickElement(gallleryPage.txtF_VerticalDDown);
		gallleryPage.waitAndClickElement(gallleryPage.selectVerticalOrTaggedWith("Comedy Clubs"));
		commonElementLocator.waitAndClickElement(commonElementLocator.pag_Title);
		Assert.assertTrue(gallleryPage.TestImage2.isDisplayed());
	}

//	@Verify-Admin-can-Delete-the-Image-by-clicking-"Delete"-for-that-Image
	@When("User hoever over the image and clicks on the Delete option")
	public void user_hoever_over_the_image_and_clicks_on_the_Delete_option() throws InterruptedException {
		actions.moveToElement(gallleryPage.TestImage2).perform();
		gallleryPage.waitAndClickElement(gallleryPage.btn_DeleteTestImage);
	}

	@Then("User confirms that the image is deleted")
	public void user_confirms_that_the_image_is_deleted() throws Exception {
		Assert.assertEquals("The image has been successfully deleted",
				gallleryPage.getElementText(gallleryPage.uploadNotificationAlert));
	}
	
//	@Verify-that-Filter-Options-available-on-Image-Gallery-page
	@Then("User verifies the filter options available on the select image Gallery page")
	public void user_verifies_the_filter_options_available_on_the_select_image_Gallery_page() throws Exception {
		Assert.assertTrue(gallleryPage.txtF_VerticalDDown.isDisplayed());
		Assert.assertTrue(gallleryPage.txtF_TaggedWithDDown.isDisplayed());
	}
	
//	@Verify-that-the-Data-is-filtered-for-images-as-per-the-Verticals-added
	@When("User clicks the Filter By Vertical drop down")
	public void user_clicks_the_Filter_By_Vertical_drop_down() throws Exception {
		gallleryPage.waitAndClickElement(gallleryPage.txtF_VerticalDDown);
	}

	@Then("the drop down options are displayed")
	public void the_drop_down_options_are_displayed() {
	 Assert.assertTrue(gallleryPage.verticalOptions.isDisplayed());
	}

	@When("User selects one or more Verticals")
	public void user_selects_one_or_more_Verticals() throws Exception {
		gallleryPage.waitAndClickElement(gallleryPage.selectVerticalOrTaggedWith("Arcades"));
		commonElementLocator.waitAndClickElement(commonElementLocator.pag_Title);
	}

	@Then("data is filtered as per the vertical selected")
	public void data_is_filtered_as_per_the_vertical_selected() {
		Assert.assertTrue(gallleryPage.TestImage1.isDisplayed());
	}

//	@Verify-that-the-Data-is-filtered-for-images-as-per-the-Tags-added 
	@When("User clicks the Filter By Tagged With drop down")
	public void user_clicks_the_Filter_By_Tagged_With_drop_down() throws Exception {
		gallleryPage.waitAndClickElement(gallleryPage.txtF_TaggedWithDDown);
	}

	@Then("the drop down options for Tagged With are displayed")
	public void the_drop_down_options_for_Tagged_With_are_displayed() {
	    Assert.assertTrue(gallleryPage.taggedWithOptions.isDisplayed());
	}

	@When("User selects one or more Tags")
	public void user_selects_one_or_more_Tags() throws Exception {
		gallleryPage.waitAndClickElement(gallleryPage.selectVerticalOrTaggedWith("red"));
		commonElementLocator.waitAndClickElement(commonElementLocator.pag_Title);
	}

	@Then("data is filtered as per the Tags selected")
	public void data_is_filtered_as_per_the_Tags_selected() throws Exception {
		Assert.assertTrue(gallleryPage.TestImage1.isDisplayed());
	}

//	@Verify-the-Count-for-that-Image-Gallery-on-"Manage-Image-Gallery"-page-for-that-specified-gallery-is-increased-by-1-when-an-Image-is-added-to-a-Gallery
	@Then("User selects an Image Gallery and take notes of the count")
	public void user_selects_an_Image_Gallery_and_take_notes_of_the_count() throws NumberFormatException, InterruptedException {
	  numberOfImages = Integer.parseInt(manageImageGalleryPage.getElementText(manageImageGalleryPage.countValue("Holiday Video")));
	}
	
	@When("User clicks the Manage option for the selected gallery")
	public void user_clicks_the_Manage_option_for_the_selected_gallery() throws InterruptedException {
		manageImageGalleryPage.waitAndClickElement(manageImageGalleryPage.btn_Manage("Holiday Video"));
	}

	@Then("User is redirected to the respective image gallery page and should have the number of images equals to the count column")
	public void user_is_redirected_to_the_respective_image_gallery_page_and_should_have_the_number_of_images_equals_to_the_count_column() throws InterruptedException {
		Assert.assertTrue(
				commonElementLocator.getElementText(commonElementLocator.pag_Title).contains("Holiday Video"));
		Assert.assertEquals(numberOfImages, gallleryPage.getNumberOfElements(gallleryPage.getALLIMAGESLOCATOR()));
	}
	
	@When("User upaloads an image")
	public void user_upaloads_an_image() throws Exception {
		gallleryPage.sendKeysToWebElement(gallleryPage.txtF_InputFile,
				"C:/Development/SMSAutomation/smsautomation/lib/auto_gallery_small.jpeg");
		gallleryPage.waitAndClickElement(gallleryPage.btn_Upload);
	}

	@Then("the image is uploaded successfully")
	public void the_image_is_uploaded_successfully() throws Exception {
		Assert.assertEquals("The images have been successfully uploaded",
				gallleryPage.getElementText(gallleryPage.uploadNotificationAlert));
	}

	@Then("User navigates back to the Image Gallery page and verifies the new count")
	public void user_navigates_back_to_the_Image_Gallery_page_and_verifies_the_new_count() throws InterruptedException {
		gallleryPage.waitAndClickElement(gallleryPage.lnk_Gallery);
		Assert.assertEquals(numberOfImages+1, Integer.parseInt(manageImageGalleryPage.getElementText(manageImageGalleryPage.countValue("Holiday Video"))));

		
	}
	
//	@Verify-the-Count-for-that-mage-Gallery-on-"Manage-Image-Gallery"-page-for-that-specified-gallery-is-decreased-by-1-when-an-Image-is-Deleted-from-a-gallery
	@When("User clicks the Manage option for the Image to delete")
	public void user_clicks_the_Manage_option_for_the_Image_to_delete() throws Exception {
		manageImageGalleryPage.waitAndClickElement(manageImageGalleryPage.btn_Manage("Holiday Video"));
	}
	@Then("User is redirected to the respective image gallery page and User delete an image")
	public void user_is_redirected_to_the_respective_image_gallery_page_and_User_delete_an_image() throws Exception {
		actions.moveToElement(gallleryPage.TestImage2).perform();
		gallleryPage.waitAndClickElement(gallleryPage.btn_DeleteTestImage);
	}

	@Then("User navigates back to the Image Gallery page and verifies the new count after deletion")
	public void user_navigates_back_to_the_Image_Gallery_page_and_verifies_the_new_count_after_deletion() throws Exception {
		gallleryPage.waitAndClickElement(gallleryPage.lnk_Gallery);
		Assert.assertEquals(numberOfImages-1, Integer.parseInt(manageImageGalleryPage.getElementText(manageImageGalleryPage.countValue("Holiday Video"))));
	}
	
//	@Verify-that-a-user-which-is-not-admin-cannot-access-Settings-Image-Gallery-page-via-menu-as-well-as-via-direct-URL-access
	@Then("User copies the current url and sign out")
	public void user_copies_the_current_url_and_sign_out() throws Exception {
		URLAddress = driver.getCurrentUrl();
		commonElementLocator.waitAndClickElement(commonElementLocator.loginAccountDDown);
		commonElementLocator.waitAndClickElement(commonElementLocator.btn_SignOut);
	}

	@When("User signs in with a user that has Business role")
	public void user_signs_in_with_a_user_that_has_Business_role() throws Exception {
		thriveLoginPage.sendKeysToWebElement(thriveLoginPage.txtF_UserName, "test@automation.com");
		thriveLoginPage.sendKeysToWebElement(thriveLoginPage.txtF_PassWord, "QA@vnet1");
		thriveLoginPage.waitAndClickElement(thriveLoginPage.button_signIn);
	}

	@Then("User is redirected to the Dashboard for the sign In user")
	public void user_is_redirected_to_the_Dashboard_for_the_sign_In_user() throws InterruptedException {
	   Assert.assertTrue(commonElementLocator.getElementText(commonElementLocator.loginAccountDDown).contains("Automation QA"));
	}

	@Then("User verifies that the Settings menus is available")
	public void user_verifies_that_the_Settings_menus_is_available() {
	 Assert.assertTrue(commonElementLocator.menu_Settings.isDisplayed());
	}

	@When("User navigates to the url copied earlier")
	public void user_navigates_to_the_url_copied_earlier() {
	   driver.navigate().to(URLAddress);
	}

	@Then("an error403 page is displayed")
	public void an_error403_page_is_displayed() throws Exception {
		Assert.assertTrue(commonElementLocator.lbl_Error403.isDisplayed());
	}
	
}
