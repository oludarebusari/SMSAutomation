package stepDefinitions.testSuite.regression.thrive;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import components.elements.CommonElementLocator;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.thrive.GallleryPage;
import pageObjects.thrive.ThriveLoginPage;
import pageObjects.thrive.Tab.SettingsDDown;
import pageObjects.thrive.modal.ManageVideoGalleryPage;
import pageObjects.thrive.modal.UpdateMediaModal;
import utils.DriverFactory;

public class ManageVideoGalleryUnderSettingsSteps extends DriverFactory {
	
	public CommonElementLocator commonElementLocator = PageFactory.initElements(driver, CommonElementLocator.class);
	public GallleryPage gallleryPage = PageFactory.initElements(driver, GallleryPage.class);
	public ManageVideoGalleryPage manageVideoGalleryPage = PageFactory.initElements(driver, ManageVideoGalleryPage.class);
	public SettingsDDown settingsDDown = PageFactory.initElements(driver, SettingsDDown.class);
	public UpdateMediaModal updateMediaModal = PageFactory.initElements(driver, UpdateMediaModal.class);
	public ThriveLoginPage thriveLoginPage = PageFactory.initElements(driver, ThriveLoginPage.class);

	Actions actions = new Actions(driver);
	private int numberOfVideos = 0;
	private String URLAddress = "";
	
	@When("User clicks the Video Gallery option")
	public void user_clicks_the_Video_Gallery_option() throws Exception {
		settingsDDown.waitAndClickElement(settingsDDown.opt_Video_Gallery);
	}

	@Then("the Manage Video Gallery page is displayed")
	public void the_Manage_Video_Gallery_page_is_displayed() throws InterruptedException {
	   Assert.assertEquals("Manage Video Gallery", commonElementLocator.getElementText(commonElementLocator.pag_Title));
	}

//	@Verify-Admin-can-see-all-existing-Video-Galleries-on-Manage-Video-Gallery
	@Then("User verifies the columns on the Manage Video Gallery page")
	public void user_verifies_the_columns_on_the_Manage_Video_Gallery_page() {
		Assert.assertTrue(manageVideoGalleryPage.col_Name.isDisplayed());
		Assert.assertTrue(manageVideoGalleryPage.col_Count.isDisplayed());
		Assert.assertTrue(manageVideoGalleryPage.col_Actions.isDisplayed());
	}
	
//	 @Verify-number-of-Videos-on-Video-Gallery-is-as-per-the-"Count"-column-of-that-specified-gallery-on-Manage-Video-Gallery-page
	@When("User clicks managae button of a video gallery with zero count")
	public void user_clicks_managae_button_of_a_video_gallery_with_zero_count() throws Exception {
		manageVideoGalleryPage.waitAndClickElement(manageVideoGalleryPage.btn_Manage("Core"));
	}

	@Then("a notification indicating no videos arre available is displayed")
	public void a_notification_indicating_no_videos_arre_available_is_displayed() throws Exception {
		Assert.assertTrue(commonElementLocator.getElementText(commonElementLocator.pag_Title).contains("Core"));
		Assert.assertEquals("There are no videos, please upload some!",
				gallleryPage.getElementText(gallleryPage.noImage));
	}

	@When("User clicks manage button of a gallery with count greater than zero")
	public void user_clicks_manage_button_of_a_gallery_with_count_greater_than_zero() throws NumberFormatException, InterruptedException {
		gallleryPage.waitAndClickElement(gallleryPage.lnk_Gallery);
		numberOfVideos = Integer.parseInt(manageVideoGalleryPage.getElementText(manageVideoGalleryPage.countValue("Holiday")));
		manageVideoGalleryPage.waitAndClickElement(manageVideoGalleryPage.btn_Manage("Holiday"));
	}

	@Then("User confirms the number of videos correspond to the count on Manage Video Gallery page")
	public void user_confirms_the_number_of_videos_correspond_to_the_count_on_Manage_Video_Gallery_page() throws NumberFormatException, InterruptedException {
		Assert.assertTrue(gallleryPage.TestVideo1.isDisplayed());
		Assert.assertEquals(numberOfVideos, gallleryPage.getNumberOfElements(gallleryPage.getTESTVIDEOLOCATOR()));
	}

	@When("User hovers over the any of the videos")
	public void user_hovers_over_the_any_of_the_videos() {
		actions.moveToElement(gallleryPage.TestVideo1).perform();
	}

	@Then("User confirms the options on the video")
	public void user_confirms_the_options_on_the_video() {
	 Assert.assertTrue(gallleryPage.btn_Delete.isDisplayed());
	 Assert.assertTrue(gallleryPage.btn_Update.isDisplayed());
	}



}
