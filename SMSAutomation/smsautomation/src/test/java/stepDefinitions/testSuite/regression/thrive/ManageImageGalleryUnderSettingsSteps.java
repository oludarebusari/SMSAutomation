package stepDefinitions.testSuite.regression.thrive;

import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import components.elements.CommonElementLocator;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.thrive.GallleryPage;
import pageObjects.thrive.ManageImageGalleryPage;
import pageObjects.thrive.Tab.SettingsDDown;
import utils.DriverFactory;

public class ManageImageGalleryUnderSettingsSteps extends DriverFactory {

	public CommonElementLocator commonElementLocator = PageFactory.initElements(driver, CommonElementLocator.class);
	public GallleryPage gallleryPage = PageFactory.initElements(driver, GallleryPage.class);
	public ManageImageGalleryPage manageImageGalleryPage = PageFactory.initElements(driver,
			ManageImageGalleryPage.class);
	public SettingsDDown settingsDDown = PageFactory.initElements(driver, SettingsDDown.class);
	
	Actions actions = new Actions(driver);
	private int numberOfImages = 0;

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
		actions.moveToElement(gallleryPage.image).perform();
	}

	@Then("the action options on the image are displayed")
	public void the_action_options_on_the_image_are_displayed() {
	  Assert.assertTrue(gallleryPage.btn_Update.isDisplayed());
	  Assert.assertTrue(gallleryPage.btn_Delete.isDisplayed());
	}

//	@Verify-number-of-Images-in-an-Image-Gallery-is-as-per-the-"Count"-column-of-that-specified-gallery-on-Manage-Image-Gallery-page
	@When("User clicks the Manage button for a gallery with zero count of images")
	public void user_clicks_the_Manage_button_for_a_gallery_with_zero_count_of_images() throws Exception {
		System.out.println(manageImageGalleryPage.btn_Manage(2, "Welcome"));
		manageImageGalleryPage.waitAndClickElement(manageImageGalleryPage.btn_Manage(2, "Welcome"));
	}

	@Then("user is redirected to the specified gallery page and no image notification is displayed")
	public void user_is_redirected_to_the_specified_gallery_page_and_no_image_notification_is_displayed() throws Exception {
		Assert.assertTrue(commonElementLocator.getElementText(commonElementLocator.pag_Title).contains("Welcome"));
		Assert.assertEquals("There are no images, please upload some!", gallleryPage.getElementText(gallleryPage.noImage));
	}

	@When("User selects a gallery with a count greater than zero")
	public void user_selects_a_gallery_with_a_count_greater_than_zero() throws NumberFormatException, InterruptedException {
		gallleryPage.waitAndClickElement(gallleryPage.lnk_Gallery);
		numberOfImages = Integer.parseInt(manageImageGalleryPage.getElementText(manageImageGalleryPage.countValue("Holiday")));
		manageImageGalleryPage.waitAndClickElement(manageImageGalleryPage.btn_Manage("Holiday"));
	}

	@Then("user confirms that the images displayed equals the count")
	public void user_confirms_that_the_images_displayed_equals_the_count() throws NumberFormatException, InterruptedException {
		System.out.println(gallleryPage.getNumberOfElements(gallleryPage.getALLIMAGESLOCATOR()));
		Assert.assertEquals(numberOfImages, gallleryPage.getNumberOfElements(gallleryPage.getALLIMAGESLOCATOR()));
	}
	
	
//	@Verify-a-new-Image-can-be-added-under-Image--Gallery-by-clicking-New-button
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
		gallleryPage.sendKeysToWebElement(gallleryPage.txtF_InputFile, "C:/Development/SMSAutomation/smsautomation/lib/gallery_small.jpeg");
		gallleryPage.waitAndClickElement(gallleryPage.btn_Upload);
	}

	@Then("User verifies that the file is uploaded successfully")
	public void user_verifies_that_the_file_is_uploaded_successfully() throws Exception {
		Assert.assertEquals("The images have been successfully uploaded", gallleryPage.getElementText(gallleryPage.uploadNotificationAlert));
	}

}
