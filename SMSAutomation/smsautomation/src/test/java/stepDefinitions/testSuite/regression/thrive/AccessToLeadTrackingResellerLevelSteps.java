package stepDefinitions.testSuite.regression.thrive;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import components.elements.CommonElementLocator;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pageObjects.thrive.EditResellerPage;
import pageObjects.thrive.ManageResellerPage;
import pageObjects.thrive.Tab.CompaniesDDown;
import utils.DriverFactory;

public class AccessToLeadTrackingResellerLevelSteps extends DriverFactory {

	CompaniesDDown companiesDDown = PageFactory.initElements(driver, CompaniesDDown.class);
	CommonElementLocator commonElementLocator = PageFactory.initElements(driver, CommonElementLocator.class);
	EditResellerPage editResellerPage = PageFactory.initElements(driver, EditResellerPage.class);
	ManageResellerPage manageResellerPage = PageFactory.initElements(driver, ManageResellerPage.class);
	
	@When("User clicks the Companies menu")
	public void user_clicks_the_Companies_menu() throws InterruptedException {
		commonElementLocator.waitAndClickElement(commonElementLocator.menu_Companies);
	}

	@When("User clicks on the Resellers option")
	public void user_clicks_on_the_Resellers_option() {
	   Assert.assertTrue(companiesDDown.opt_Businesses.isDisplayed());
	   Assert.assertTrue(companiesDDown.opt_Resellers.isDisplayed());
	}

	@When("User clicks on Resellers option")
	public void user_clicks_on_Resellers_option() throws Exception {
		companiesDDown.waitAndClickElement(companiesDDown.opt_Resellers);
	}

	@When("User clicks the edit option for a specific reseller record")
	public void user_clicks_the_edit_option_for_a_specific_reseller_record() throws Exception {
		commonElementLocator.sendKeysToWebElement(commonElementLocator.txtF_Search, "AclateLead");
		commonElementLocator.waitAndClickElement(commonElementLocator.btn_Search);
		manageResellerPage.waitAndClickElement(manageResellerPage.btn_Edit_Dropdown("AclateLead"));
		manageResellerPage.waitAndClickElement(manageResellerPage.btn_Edit("AclateLead"));
	}

	@Then("User is redirected to the Edit Resellers page")
	public void user_is_redirected_to_the_Edit_Resellers_page() throws InterruptedException {
		Assert.assertEquals("Edit Reseller", commonElementLocator.getElementText(commonElementLocator.pag_Title));
	}

//	@Section2.3.1.1 @Lead-Tracking-Permission:-Reseller-Level:-Displayed-Objects-Verification
	@Then("User verifies that Lead Tracking option is not selected")
	public void user_verifies_that_Lead_Tracking_option_is_not_selected() {
		Assert.assertFalse(editResellerPage.isElementVisible(editResellerPage.selectedLicenseOptLocator("Lead Tracking")));
	}

	@Then("User verifies that Lead Tracking option is displayed in the LOV")
	public void user_verifies_that_Lead_Tracking_option_is_displayed_in_the_LOV() throws Exception {
		editResellerPage.waitAndClickElement(editResellerPage.licenseDDown);
		Assert.assertTrue(editResellerPage.licenseOptionInLOV("Lead Tracking").isDisplayed());

	}

//	@Section2.3.1.1 @Lead-Tracking-Permission:-Reseller-Level:-Enable/Disable-Lead-Tracking-Permission
	@When("User selects the Lead Tracking option for license")
	public void user_selects_the_Lead_Tracking_option_for_license() throws InterruptedException {
		editResellerPage.waitAndClickElement(editResellerPage.licenseDDown);
		editResellerPage.waitAndClickElement(editResellerPage.licenseOptionInLOV("Lead Tracking"));
	}

	@Then("User verifies that Lead Tracking is selected")
	public void user_verifies_that_Lead_Tracking_is_selected() throws Exception {
	  Assert.assertTrue(editResellerPage.isElementVisible(manageResellerPage.getElementLocator(editResellerPage.licenseDDown)));
	}

	@Then("User saves the Reseller record")
	public void user_saves_the_Reseller_record() throws InterruptedException {
		editResellerPage.waitAndClickElement(editResellerPage.btn_SaveReseller);
	}

	@When("User queries the same Reseller and Edit")
	public void user_queries_the_same_Reseller_and_Edit() throws Exception {
		commonElementLocator.waitAndClickElement(commonElementLocator.menu_Companies);
		companiesDDown.waitAndClickElement(companiesDDown.opt_Resellers);
		commonElementLocator.sendKeysToWebElement(commonElementLocator.txtF_Search, "AclateLead");
		commonElementLocator.waitAndClickElement(commonElementLocator.btn_Search);
		editResellerPage.waitAndClickElement(manageResellerPage.btn_Edit_Dropdown("AclateLead"));
		editResellerPage.waitAndClickElement(manageResellerPage.btn_Edit("AclateLead"));
	}

	@Then("User confirms that the license setting is retained and has Lead Tracking selected")
	public void user_confirms_that_the_license_setting_is_retained_and_has_Lead_Tracking_selected() {
		Assert.assertTrue(editResellerPage.isElementVisible(editResellerPage.selectedLicenseOptLocator("Lead Tracking")));
	}
	
	@When("User removes the Lead Tracking option and saves the Reseller record")
	public void user_removes_the_Lead_Tracking_option_and_saves_the_Reseller_record() throws Exception {
		editResellerPage.waitAndClickElement(editResellerPage.removeSelectedLicenseOptBtn("Lead Tracking"));
		editResellerPage.waitAndClickElement(editResellerPage.btn_SaveReseller);
	}
	
	@Then("User confirms that the Lead Tracking license removed is not displayed")
	public void user_confirms_that_the_Lead_Tracking_license_removed_is_not_displayed() {
		Assert.assertFalse(editResellerPage.isElementVisible(editResellerPage.selectedLicenseOptLocator("Lead Tracking")));
	}

	@When("User adds the Lead Tracking license")
	public void user_adds_the_Lead_Tracking_license() throws Exception {
		editResellerPage.waitAndClickElement(editResellerPage.licenseDDown);
		editResellerPage.waitAndClickElement(editResellerPage.licenseOptionInLOV("Lead Tracking"));
	}

	@When("User navigates away from the Edit Reseller page without saving")
	public void user_navigates_away_from_the_Edit_Reseller_page_without_saving() throws Exception {
		commonElementLocator.waitAndClickElement(commonElementLocator.menu_Dashboard);
	}

	@Then("User confirms that the Lead Tracking license is not displayed")
	public void user_confirms_that_the_Lead_Tracking_license_is_not_displayed() {
		Assert.assertFalse(editResellerPage.isElementVisible(editResellerPage.selectedLicenseOptLocator("Lead Tracking")));
	}
	
	@When("User removes the Lead Tracking option")
	public void user_removes_the_Lead_Tracking_option() throws InterruptedException {
		editResellerPage.waitAndClickElement(editResellerPage.removeSelectedLicenseOptBtn("Lead Tracking"));
	}
	
	@Then("User confirms that the Lead Tracking license is not removed")
	public void user_confirms_that_the_Lead_Tracking_license_is_not_removed() throws Exception  {
		Assert.assertTrue(editResellerPage.isElementVisible(editResellerPage.selectedLicenseOptLocator("Lead Tracking")));
	}

//	#Revert License changes to the Reseller Record
	@Then("User revert the changes to the reseller record")
	public void user_revert_the_changes_to_the_reseller_record() throws InterruptedException {
		editResellerPage.waitAndClickElement(editResellerPage.removeSelectedLicenseOptBtn("Lead Tracking"));
		editResellerPage.waitAndClickElement(editResellerPage.btn_SaveReseller);
	}
}
