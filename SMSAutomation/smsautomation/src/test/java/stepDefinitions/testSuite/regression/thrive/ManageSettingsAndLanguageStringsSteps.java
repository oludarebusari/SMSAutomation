package stepDefinitions.testSuite.regression.thrive;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import components.elements.CommonElementLocator;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.thrive.AdminLanguageStringsPage;
import pageObjects.thrive.AdminSettingsPage;
import pageObjects.thrive.Tab.SettingsDDown;
import pageObjects.thrive.modal.AdminEditLanguageStringsModal;
import pageObjects.thrive.modal.AdminEditSettingsModal;
import utils.DriverFactory;

public class ManageSettingsAndLanguageStringsSteps extends DriverFactory {

	public AdminSettingsPage adminSettingsPage = PageFactory.initElements(driver, AdminSettingsPage.class);
	public AdminLanguageStringsPage adminLanguageStringsPage = PageFactory.initElements(driver,
			AdminLanguageStringsPage.class);
	public AdminEditSettingsModal adminEditSettingsModal = PageFactory.initElements(driver,
			AdminEditSettingsModal.class);
	public AdminEditLanguageStringsModal adminEditLanguageStringsModal = PageFactory.initElements(driver,
			AdminEditLanguageStringsModal.class);
	public CommonElementLocator commonElementLocator = PageFactory.initElements(driver, CommonElementLocator.class);
	public SettingsDDown settingsDDown = PageFactory.initElements(driver, SettingsDDown.class);

//	@SMSM-170-Verify-manage-settings-page-options-through-settings-drop-down-ing-Admin-dashboard
	@When("User clicks on Settings under Settings drop down")
	public void user_clicks_on_Settings_under_Settings_drop_down() throws Exception {
		settingsDDown.waitAndClickElement(settingsDDown.opt_Settings);
	}

	@Then("User is redirected to Settings page")
	public void user_is_redirected_to_Settings_page() throws Exception {
		Assert.assertEquals("Settings", commonElementLocator.getElementText(commonElementLocator.pag_Title));
	}

	@Then("User verifies the columns on the Settings page")
	public void user_verifies_the_columns_on_the_Settings_page() {
		Assert.assertTrue(adminSettingsPage.col_Title.isDisplayed());
		Assert.assertTrue(adminSettingsPage.col_Group.isDisplayed());
		Assert.assertTrue(adminSettingsPage.col_AccessLevel.isDisplayed());
		Assert.assertTrue(adminSettingsPage.col_Value.isDisplayed());
		Assert.assertTrue(adminSettingsPage.col_Description.isDisplayed());
		Assert.assertTrue(adminSettingsPage.col_Updated.isDisplayed());
		Assert.assertTrue(adminSettingsPage.col_Action.isDisplayed());
	}

//	@SMSM-170-Verify-user-is-able-to-edit-settings-details-within-the-settings-tabs
	@When("User types the Settings to edit on the search text field")
	public void user_types_the_Settings_to_edit_on_the_search_text_field() throws Exception {
		commonElementLocator.sendKeysToWebElement(commonElementLocator.txtF_Search, "Gateway Test Mode");
		commonElementLocator.waitAndClickElement(commonElementLocator.btn_Search);
	}

	@Then("the setting is displayed on the page")
	public void the_setting_is_displayed_on_the_page() {
		Assert.assertTrue(adminSettingsPage.searchRecord("\"Gateway Test Mode\"").isDisplayed());
	}

	@When("User clicks the edit tab of the Setting to modify")
	public void user_clicks_the_edit_tab_of_the_Setting_to_modify() throws Exception {
		adminSettingsPage.waitAndClickElement(adminSettingsPage.editSettingByTitle("\"Gateway Test Mode\""));
	}

	@Then("the Edit Settings window is opened")
	public void the_Edit_Settings_window_is_opened() throws Exception {
		Assert.assertEquals("Edit Setting", adminEditSettingsModal.getElementText(adminEditSettingsModal.mod_Title));
	}

	@Then("User edits all the text fields on the Edit Setting modal")
	public void user_edits_all_the_text_fields_on_the_Edit_Setting_modal() throws Exception {
		adminEditSettingsModal.sendKeysToWebElement(adminEditSettingsModal.txtF_Title, "Gateway Test Mode - edited");
		adminEditSettingsModal.sendKeysToWebElement(adminEditSettingsModal.txtF_Slug, "gateway.test_mode - edited");
		adminEditSettingsModal.sendKeysToWebElement(adminEditSettingsModal.txtF_Group, "Payment Gateway - edited");
		adminEditSettingsModal.clickOnTextFromDropdownList(adminEditSettingsModal.typeDDown, "Checkbox");
		adminEditSettingsModal.clickOnTextFromDropdownList(adminEditSettingsModal.accessLevelDDown, "Merchant");
		adminEditSettingsModal.sendKeysToWebElement(adminEditSettingsModal.txtF_Description,
				"This is for automation demo");
	}

	@When("User clicks on the Save Settings button")
	public void user_clicks_on_the_Save_Settings_button() throws InterruptedException {
		adminEditSettingsModal.waitAndClickElement(adminEditSettingsModal.btn_SaveSettings);
	}

	@Then("user confirms the changes were saved correctly")
	public void user_confirms_the_changes_were_saved_correctly() throws Exception {
		Thread.sleep(1000);
		Assert.assertTrue(adminSettingsPage.cellValue("\"Gateway Test Mode - edited\"").isDisplayed());
		Assert.assertTrue(adminSettingsPage.cellValue("\"Payment Gateway - edited\"").isDisplayed());
		Assert.assertTrue(adminSettingsPage.cellValue("\"Merchant\"").isDisplayed());
		Assert.assertTrue(adminSettingsPage.cellValue("\"This is for automation demo\"").isDisplayed());

	}

//	Revert Changes to the Settings
	@Then("User revert changes made to the setting")
	public void user_revert_changes_made_to_the_setting() throws Exception {
		/*
		 * commonElementLocator.sendKeysToWebElement(commonElementLocator.txtF_Search,
		 * "Gateway Test Mode - edited");
		 * commonElementLocator.waitAndClickElement(commonElementLocator.btn_Search);
		 * adminEditSettingsModal.sendKeysToWebElement(adminEditSettingsModal.
		 * txtF_Title, "Gateway Test Mode");
		 * adminEditSettingsModal.sendKeysToWebElement(adminEditSettingsModal.txtF_Slug,
		 * "gateway.test_mode");
		 * adminEditSettingsModal.sendKeysToWebElement(adminEditSettingsModal.
		 * txtF_Group, "Payment Gateway");
		 * adminEditSettingsModal.clickOnTextFromDropdownList(adminEditSettingsModal.
		 * typeDDown, "Textarea");
		 * adminEditSettingsModal.clickOnTextFromDropdownList(adminEditSettingsModal.
		 * accessLevelDDown, "Admin");
		 * adminEditSettingsModal.sendKeysToWebElement(adminEditSettingsModal.
		 * txtF_Description, "");
		 */
	}

}
