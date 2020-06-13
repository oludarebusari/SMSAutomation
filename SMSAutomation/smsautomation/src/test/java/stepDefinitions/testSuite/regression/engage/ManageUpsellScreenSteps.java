package stepDefinitions.testSuite.regression.engage;

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
}
