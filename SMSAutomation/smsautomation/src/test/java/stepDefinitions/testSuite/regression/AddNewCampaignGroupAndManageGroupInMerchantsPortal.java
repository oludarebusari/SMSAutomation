package stepDefinitions.testSuite.regression;

import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.license.AdvertisersPage;
import pageObjects.license.CreateCampaignGroupPage;
import pageObjects.license.CampaignGroupsPage;
import pageObjects.license.LicAdminPage;
import pageObjects.license.menu.CampaignsSubMenu;
import pageObjects.license.menu.MerchantMenu;
import utils.Constant;
import utils.DriverFactory;
import utils.JsonConfigReader;

public class AddNewCampaignGroupAndManageGroupInMerchantsPortal extends DriverFactory {

	JsonConfigReader reader = new JsonConfigReader();

	// Support Files
	LicAdminPage licPortalPage = PageFactory.initElements(driver, LicAdminPage.class);
	AdvertisersPage advertisersPage = PageFactory.initElements(driver, AdvertisersPage.class);
	MerchantMenu merchantMenu = PageFactory.initElements(driver, MerchantMenu.class);
	CampaignsSubMenu campaignsSubMenu = PageFactory.initElements(driver, CampaignsSubMenu.class);
	CampaignGroupsPage campaignGroupsPage = PageFactory.initElements(driver, CampaignGroupsPage.class);
	CreateCampaignGroupPage createCampaignGroupPage = PageFactory.initElements(driver, CreateCampaignGroupPage.class);

	// Get the current window handle
	String parentWinHandle = driver.getWindowHandle();

	@When("User clicks on Businesses menu item")
	public void user_clicks_on_Businesses_menu_item() throws Exception {
		/*
		 * if (reader.getConfigValue("DriverConfig", "environment").equals("localHub"))
		 * { licPortalPage.clickCloseUpdateStatusOfBusinesses();
		 * licPortalPage.waitForBusinessesDialogToDisappear(); }
		 */
		licPortalPage.clickOnElementUsingCustomTimeout(licPortalPage.menu_Businesses, driver, 20);
	}

	@And("User clicks on Login tab for a merchant")
	public void user_clicks_on_Login_tab_for_a_merchant() throws Exception {
		Thread.sleep(500);
		advertisersPage.waitAndClickElement(advertisersPage.getLoginBtnByBusinessContact("QA, Aclate"));
	}

	@And("User clicks on the campaigns menu item")
	public void user_clicks_on_the_campaigns_menu_item() throws Exception {
		merchantMenu.switchWindow();
		merchantMenu.waitAndClickElement(merchantMenu.menu_Campaigns);
	}

	@And("User clicks campaign groups under campaigns")
	public void user_clicks_campaign_groups_under_campaigns() throws Exception {
		campaignsSubMenu.waitAndClickElement(campaignsSubMenu.menu_CampaignGroups);
	}

	@And("User navigates to the next page")
	public void user_navigates_to_the_next_page() throws Exception {
		campaignGroupsPage.waitAndClickElement(campaignGroupsPage.btn_Page_Right_Arrow);
	}

	@And("User navigates back to the main page")
	public void user_navigates_back_to_the_main_page() throws Exception {
		campaignGroupsPage.waitAndClickElement(campaignGroupsPage.btn_Page_Left_Arrow);
		campaignGroupsPage.waitAndClickElement(campaignGroupsPage.drp_Group_Length);
		campaignGroupsPage.selectCampaignGroupsPageGroupsLength("25");
	}

	@Then("User validates the page length options")
	public void user_validates_the_page_length_options() throws Exception {
		Assert.assertTrue(Arrays.toString(campaignGroupsPage.getCampaignGroupsPageLength()).contains("10"));
		Assert.assertTrue(Arrays.toString(campaignGroupsPage.getCampaignGroupsPageLength()).contains("25"));
		Assert.assertTrue(Arrays.toString(campaignGroupsPage.getCampaignGroupsPageLength()).contains("50"));
		Assert.assertTrue(Arrays.toString(campaignGroupsPage.getCampaignGroupsPageLength()).contains("100"));
	}

	@Then("User copies the campaign groups")
	public void user_copies_the_campaign_groups() throws Exception {
		campaignGroupsPage.waitAndClickElement(campaignGroupsPage.btn_Copy);
	}

	@Then("User exports the campaign groups")
	public void user_exports_the_campaign_groups() throws Exception {
		campaignGroupsPage.waitAndClickElement(campaignGroupsPage.btn_CSV);
		Assert.assertEquals(
				(campaignGroupsPage
						.getNumberOfCampaignGroups("C:\\Users\\Oyebode\\Downloads\\Engage Admin Dashboard.csv")) - 1,
				11);
	}

	@And("User clicks the New button on the campaign groups page")
	public void user_clicks_the_New_button_on_the_campaign_groups_page() throws Exception {
		campaignGroupsPage.waitAndClickElement(campaignGroupsPage.btn_CampaignGroupsNewBtn);
	}

	@And("User validates empty fields")
	public void user_validates_empty_fields() throws Exception {
		createCampaignGroupPage.waitAndClickElement(createCampaignGroupPage.btn_Save_Campaign_Group);
		Assert.assertTrue(createCampaignGroupPage.txt_Group_Name.getAttribute("value").isEmpty());
		Assert.assertTrue(createCampaignGroupPage.txt_Keyword.getAttribute("value").isEmpty());
		Assert.assertTrue(createCampaignGroupPage.txt_Description.getAttribute("value").isEmpty());
	}

	@And("User validates the help icons")
	public void user_validates_the_help_icons() throws Exception {
		createCampaignGroupPage.waitAndClickElement(createCampaignGroupPage.icon_Group_Name_Help);
		Assert.assertEquals(createCampaignGroupPage.icon_Group_Name_Help.getAttribute("data-original-title"),
				Constant.GROUP_NAME_HELP_ICON);
		createCampaignGroupPage.waitAndClickElement(createCampaignGroupPage.icon_Keyword_Help);
		Assert.assertEquals(createCampaignGroupPage.icon_Keyword_Help.getAttribute("data-original-title"),
				Constant.KEYWORD_HELP_ICON);
		createCampaignGroupPage.waitAndClickElement(createCampaignGroupPage.icon_Description_Help);
		Assert.assertEquals(createCampaignGroupPage.icon_Description_Help.getAttribute("data-original-title"),
				Constant.DESCRIPTION_HELP_ICON);
		createCampaignGroupPage.waitAndClickElement(createCampaignGroupPage.icon_Campaigns_Help);
		Assert.assertEquals(createCampaignGroupPage.icon_Campaigns_Help.getAttribute("data-original-title"),
				Constant.CAMPAIGNS_HELP_ICON);
		createCampaignGroupPage.waitAndClickElement(createCampaignGroupPage.icon_Allow_group_reward_redemptions_Help);
		Assert.assertEquals(
				createCampaignGroupPage.icon_Allow_group_reward_redemptions_Help.getAttribute("data-original-title"),
				Constant.ALLOW_GROUP_REWARD_REDEMPTIONS);
		createCampaignGroupPage.waitAndClickElement(createCampaignGroupPage.icon_Group_Name_Help);
	}

	@And("User enters valid details in each of the text fields")
	public void user_enters_valid_details_in_each_of_the_text_fields() throws Exception {
		createCampaignGroupPage.sendKeysToWebElement(createCampaignGroupPage.txt_Group_Name, ("QA Campaign Group"));
		createCampaignGroupPage.sendKeysToWebElement(createCampaignGroupPage.txt_Keyword, "Testing");
		createCampaignGroupPage.sendKeysToWebElement(createCampaignGroupPage.txt_Description, "This is QA Automation");
		createCampaignGroupPage.waitAndClickElement(createCampaignGroupPage.lov_Campaigns);
		createCampaignGroupPage.waitAndClickElement(createCampaignGroupPage.getCampaignOpt("Test2"));
		createCampaignGroupPage.waitAndClickElement(createCampaignGroupPage.icon_Campaigns_Help);
	}

	@And("User clicks the toggle button to allow or disallow group redemption")
	public void user_clicks_the_toggle_button_to_allow_group_redemption() throws Exception {
		createCampaignGroupPage.btn_Allow_Group_Reward_Redemption.click();
	}

	@And("User clicks on save button and validate data")
	public void user_clicks_on_save_button_and_validate_data() throws Exception {
		createCampaignGroupPage.waitAndClickElement(createCampaignGroupPage.btn_Save_Campaign_Group);
	}

	@Then("User clicks the edit button on the newly created campaign group")
	public void user_clicks_the_edit_button_on_the_newly_created_campaign_group() throws Exception {
		campaignGroupsPage.waitAndClickElement(campaignGroupsPage.btn_EditByName("QA Campaign Group"));
	}

	@And("User edits the text fields of the campaign")
	public void user_edits_the_text_fields_of_the_campaign() throws Exception {
		createCampaignGroupPage.sendKeysToWebElement(createCampaignGroupPage.txt_Group_Name, "QA Campaign Group_Edited");
		createCampaignGroupPage.sendKeysToWebElement(createCampaignGroupPage.txt_Keyword, "Testing_Edited");
		createCampaignGroupPage.sendKeysToWebElement(createCampaignGroupPage.txt_Description, "This is QA Automation_Edited");
	}

	@And("User clicks the Save button")
	public void user_clicks_the_Save_button() throws Exception {
		createCampaignGroupPage.waitAndClickElement(createCampaignGroupPage.btn_Save_Campaign_Group);
		campaignGroupsPage.deleteDownloadedFile("C:\\Users\\Oyebode\\Downloads\\Engage Admin Dashboard.csv");
	}

	@And("User clicks the edit dropdown button on the campaign")
	public void user_clicks_the_edit_dropdown_button_on_the_campaign() throws Exception {
		Thread.sleep(800);
		campaignGroupsPage.waitAndClickElement(campaignGroupsPage.btn_EditDropDownByName("QA Campaign Group_Edited"));
	}

	@And("User clicks the delete button")
	public void user_clicks_the_delete_button() throws Exception {
		campaignGroupsPage.waitAndClickElement(campaignGroupsPage.btn_Delete("QA Campaign Group_Edited"));
	}

	@Then("User confirm the campaign is deleted")
	public void user_confirm_the_campaign_is_deleted() throws Exception {
		campaignGroupsPage.waitForCampaignGroupToDisapper("QA Campaign Group_Edited");
	}

}
