package stepDefinitions.testSuite.regression.engage;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import components.elements.CommonElementLocator;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.engage.EditCampaignPage;
import pageObjects.engage.SingleCampaignsPage;
import pageObjects.license.menu.CampaignsSubMenu;
import pageObjects.license.menu.MerchantMenu;
import utils.DriverFactory;

public class ManageUpsellScreenSteps extends DriverFactory {

	CommonElementLocator commonElementLocator = PageFactory.initElements(driver, CommonElementLocator.class);
	CampaignsSubMenu campaignsSubMenu = PageFactory.initElements(driver, CampaignsSubMenu.class);
	EditCampaignPage editCampaignPage = PageFactory.initElements(driver, EditCampaignPage.class);
	MerchantMenu merchantMenu = PageFactory.initElements(driver, MerchantMenu.class);
	SingleCampaignsPage singleCampaignsPage = PageFactory.initElements(driver, SingleCampaignsPage.class);

	Actions actions = new Actions(driver);

//	@Verify-that-user-can-access-the-"Upsell-Screen"-from-Advanced-Settings-of-a-selected-campaign
	@When("User clicks the Campaign option tab")
	public void user_clicks_the_Campaign_option_tab() throws Exception {
		merchantMenu.waitAndClickElement(merchantMenu.menu_Campaigns);
	}

	@Then("the Campaign menu is opened")
	public void the_Campaign_menu_is_opened() throws Exception {
		Assert.assertEquals("Campaigns", campaignsSubMenu.getElementText(campaignsSubMenu.title_CampaignsSubMenu));
	}

	@When("User clicks on Single Campaigns option")
	public void user_clicks_on_Single_Campaigns_option() throws Exception {
		campaignsSubMenu.waitAndClickElement(campaignsSubMenu.menu_SingleCampaigns);
	}

	@Then("User is redirected to the Single Campaigns page")
	public void user_is_redirected_to_the_Single_Campaigns_page() throws Exception {
		Assert.assertEquals("Single Campaigns",
				singleCampaignsPage.getElementText(singleCampaignsPage.page_Title).replace(" New", ""));
	}

	@When("User clicks on Edit button of a campaign")
	public void user_clicks_on_Edit_button_of_a_campaign() throws Exception {
		singleCampaignsPage.waitAndClickElement(singleCampaignsPage.campignEditBtn("AutomationTest"));
	}

	@Then("the Edit Campaign Page is displayed")
	public void the_Edit_Campaign_Page_is_displayed() throws InterruptedException {
		Assert.assertEquals("Edit Campaign",
				editCampaignPage.getElementText(editCampaignPage.page_Title).replace("\nExpand All", ""));
	}

	@When("User clicks the configure advanced settings link")
	public void user_clicks_the_configure_advanced_settings_link() throws Exception {
		editCampaignPage.waitAndClickElement(editCampaignPage.configAdvancedSettings);
	}

	@Then("the Advanced section of the Edit Campaign page is expanded")
	public void the_Advanced_section_of_the_Edit_Campaign_page_is_expanded() {
		Assert.assertTrue(editCampaignPage.section_AdvancedSetttings.isDisplayed());
	}

	@When("User clicks on the Upsell Screen link")
	public void user_clicks_on_the_Upsell_Screen_link() throws Exception {
		editCampaignPage.waitAndClickElement(editCampaignPage.upsellScreenLnk);
	}

	@Then("the Upsell Screen setting is displayed")
	public void the_Upsell_Screen_setting_is_displayed() {
		Assert.assertTrue(editCampaignPage.section_UpsellScreen.isDisplayed());
	}

//	@verify-that-user-can-enable-the-"Upsell-Screen"-from-Advanced-Settings-of-a-selected-campaign
	@When("User clicks on the Disabled toggle button")
	public void user_clicks_on_the_Disabled_toggle_button() throws Exception {
		editCampaignPage.waitAndClickElement(editCampaignPage.tog_Disabled);
	}

	@Then("button changes to Enabled and the Upsell Screen setting panel is displayed")
	public void button_changes_to_Enabled_and_the_Upsell_Screen_setting_panel_is_displayed() {
		Assert.assertTrue(editCampaignPage.set_UpsellScreen.isDisplayed());
	}

	@Then("User enters value for Upsell Item")
	public void user_enters_value_for_Upsell_Item() throws Exception {
		editCampaignPage.sendKeysToWebElement(editCampaignPage.txtF_UpsellItem, "Upsell Auto Item");
	}

	@Then("User enters value for Upsell Description")
	public void user_enters_value_for_Upsell_Description() throws Exception {
		editCampaignPage.sendKeysToWebElement(editCampaignPage.txtF_UpsellDescription, "Upsell Auto Description");
	}

	/*
	 * // @Verify-that-user-can-upload-a-local-image-in-the-"Upsell-Screen"-from-
	 * Advanced-Settings-of-a-selected-campaign
	 * 
	 * @Then("User upload an image for the Upsell Image") public void
	 * user_upload_an_image_for_the_Upsell_Image() throws Exception {
	 * editCampaignPage.waitAndClickElement(editCampaignPage.img_UpsellImage);
	 * editCampaignPage.sendKeysToWebElement(editCampaignPage.img_UpsellImage,
	 * "C:/Development/SMSAutomation/smsautomation/lib/auto_gallery_small.jpeg");
	 * 
	 * }
	 */

//	@Verify-that-user-can-cancel-the-update-of-"Upsell-Screen"-from-Advanced-Settings-of-a-selected-campaign
	@When("User clicks the Enabled toggle button without entering values for Upsell text fields")
	public void user_clicks_the_Enabled_toggle_button_without_entering_values_for_Upsell_text_fields()
			throws Exception {
		editCampaignPage.waitAndClickElement(editCampaignPage.tog_Disabled);
		editCampaignPage.waitAndClickElement(editCampaignPage.tog_Disabled);
	}

	@Then("User confirms Upsell Screen is not updated")
	public void user_confirms_Upsell_Screen_is_not_updated() throws Exception {
		Assert.assertTrue(editCampaignPage.txtF_UpsellItem.getText().isBlank());

	}

//	@Verify-that-user-can-save-the-settings-of-an-updated-"Upsell-Screen"-from-Advanced-Settings-of-a-selected-campaign
	@Then("User clicks the Save Setting button")
	public void user_clicks_the_Save_Setting_button() throws Exception {
		editCampaignPage.waitAndClickElement(editCampaignPage.saveSettingBotBtn);

	}

	@Then("User verifies that the entered values were saved correctly")
	public void user_verifies_that_the_entered_values_were_saved_correctly() throws Exception {
//		Thread.sleep(1000);
		System.out.println(Integer.parseInt(editCampaignPage.upsellItemCount.getText().substring(0, 2)));
		Assert.assertTrue(Integer.parseInt(editCampaignPage.upsellItemCount.getText().substring(0, 2)) > 0);
		Assert.assertTrue(Integer.parseInt(editCampaignPage.upsellItemDescriptionCount.getText().substring(0, 2)) > 0);
	}

//  Revert changes
	@Then("User enters null value for Upsell Item")
	public void user_enters_null_value_for_Upsell_Item() throws Exception {
		editCampaignPage.sendKeysToWebElement(editCampaignPage.txtF_UpsellItem, "");
	}

	@Then("User enters null value for Upsell Description")
	public void user_enters_null_value_for_Upsell_Description() throws Exception {
		editCampaignPage.sendKeysToWebElement(editCampaignPage.txtF_UpsellDescription, "");

	}

	@Then("User clicks the Save Setting button to save the changes")
	public void user_clicks_the_Save_Setting_button_to_save_the_changes() throws InterruptedException {
		editCampaignPage.waitAndClickElement(editCampaignPage.saveSettingTopBtn);
		editCampaignPage.waitAndClickElement(editCampaignPage.tog_Enabled);
		Thread.sleep(1000);
//		editCampaignPage.waitAndClickElement(editCampaignPage.tog_Enabled);
	}
}
