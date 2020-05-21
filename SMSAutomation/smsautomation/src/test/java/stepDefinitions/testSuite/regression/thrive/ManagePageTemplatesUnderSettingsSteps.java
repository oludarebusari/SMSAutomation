package stepDefinitions.testSuite.regression.thrive;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import components.elements.CommonElementLocator;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.thrive.CreatePageTemplatePage;
import pageObjects.thrive.PageTemplatesPage;
import pageObjects.thrive.PagesConfigurationPage;
import pageObjects.thrive.Tab.SettingsDDown;
import pageObjects.thrive.modal.ActivatePageModal;
import pageObjects.thrive.modal.DeactivatePageModal;
import pageObjects.thrive.modal.DeletePageModal;
import utils.DriverFactory;

public class ManagePageTemplatesUnderSettingsSteps extends DriverFactory {
		
	public ActivatePageModal activatePageModal = PageFactory.initElements(driver, ActivatePageModal.class);
	public CommonElementLocator commonElementLocator = PageFactory.initElements(driver, CommonElementLocator.class);
	public CreatePageTemplatePage createPageTemplatePage = PageFactory.initElements(driver, CreatePageTemplatePage.class);
	public DeactivatePageModal deactivatePageModal = PageFactory.initElements(driver, DeactivatePageModal.class);
	public DeletePageModal deletePageModal = PageFactory.initElements(driver, DeletePageModal.class);
	public PagesConfigurationPage pagesConfigurationPage = PageFactory.initElements(driver, PagesConfigurationPage.class);
	public PageTemplatesPage pageTemplatesPage = PageFactory.initElements(driver, PageTemplatesPage.class);
	public SettingsDDown settingsDDown = PageFactory.initElements(driver, SettingsDDown.class);
	
	private String timeBeforeSave = "";
	private String URLAddress = "";
	
	@When("User clicks the Page Templates option")
	public void user_clicks_the_Page_Templates_option() throws Exception {
	   settingsDDown.waitAndClickElement(settingsDDown.opt_Page_Templates);
	}

	@Then("the Page Templates screen is displayed")
	public void the_Page_Templates_screen_is_displayed() throws InterruptedException {
	  Assert.assertEquals("Page Templates", commonElementLocator.getElementText(commonElementLocator.pag_Title));
	}

//	@Verify-Admin-can-see-all-existing-Page-Templates-under-Settings>-Page-Templates-page
	@Then("User verifies the Column headers on Page Templates page")
	public void user_verifies_the_Column_headers_on_Page_Templates_page() {
	  Assert.assertTrue(pageTemplatesPage.col_Page.isDisplayed());
	  Assert.assertTrue(pageTemplatesPage.col_User.isDisplayed());
	  Assert.assertTrue(pageTemplatesPage.col_Status.isDisplayed());
	  Assert.assertTrue(pageTemplatesPage.col_Updated.isDisplayed());
	  Assert.assertTrue(pageTemplatesPage.col_Action.isDisplayed());
	}
	
	
//	@Verify-functionality-of-Show-entries-dropdown-and-pagination-on-"Page-Templates"-page
	@Then("User verifies the Show entries drop down")
	public void user_verifies_the_Show_entries_drop_down() {
	  Assert.assertTrue(commonElementLocator.lbl_ShowEntries.isDisplayed());
	}

	@Then("User verifies the default value selected for Show Enteries drop")
	public void user_verifies_the_default_value_selected_for_Show_Enteries_drop() throws Exception {
	  Assert.assertEquals("10", commonElementLocator.getElementText(commonElementLocator.lbl_PaginationEnd));
	  Assert.assertTrue(commonElementLocator.lbl_ShowEntries.isDisplayed());
	}

	@When("User clicks on Show Entries drop down")
	public void user_clicks_on_Show_Entries_drop_down() throws Exception {
		commonElementLocator.waitAndClickElement(commonElementLocator.lov_ShowEntries);
	}

	@Then("list of option that can be selected are displayed")
	public void list_of_option_that_can_be_selected_are_displayed() throws InterruptedException {
		Assert.assertEquals("10", commonElementLocator.getElementText(commonElementLocator.showEntriesOption("10")).replace(" " , "").replace("\n", ""));
		Assert.assertEquals("25", commonElementLocator.getElementText(commonElementLocator.showEntriesOption("25")).replace(" " , "").replace("\n", ""));
		Assert.assertEquals("All", commonElementLocator.getElementText(commonElementLocator.showEntriesOption("All")).replace(" " , "").replace("\n", ""));
	}

	@When("User clicks the Next button to navigate to next page")
	public void user_clicks_the_Next_button_to_navigate_to_next_page() throws Exception {
	  commonElementLocator.waitAndClickElement(commonElementLocator.btn_PaginationNext);
	  
	}

	@Then("the next page on the pagination buttons is highlighted")
	public void the_next_page_on_the_pagination_buttons_is_highlighted() throws InterruptedException {
		Assert.assertTrue(pageTemplatesPage.pageButtonNumber("2").getAttribute("class").contains("active"));
	}

	@When("User Selects All from the drop down list")
	public void user_Selects_All_from_the_drop_down_list() throws Exception {
	  commonElementLocator.waitAndClickElement(commonElementLocator.lov_ShowEntries);
	}

	@Then("User verifies all the records are displayed on one page")
	public void user_verifies_all_the_records_are_displayed_on_one_page() {
		Assert.assertTrue(commonElementLocator.btn_PaginationNextDisabled.isDisplayed());
		Assert.assertTrue(commonElementLocator.btn_PaginationPreviousDisabled.isDisplayed());
		Assert.assertTrue(pageTemplatesPage.pageButtonNumber("1").isDisplayed());
		Assert.assertFalse(pageTemplatesPage.isElementVisible(pageTemplatesPage.getElementLocator(pageTemplatesPage.pageButtonNumber("2"))));
	}

//	@Verify-Templates-can-be-sorted-by-clicking-on-arrows-icon-on-side-of-each-column-heading-on-"Page-Templates"-page
	@Then("User verifies the icons on the side of the column heading")
	public void user_verifies_the_icons_on_the_side_of_the_column_heading() {
		Assert.assertTrue(pageTemplatesPage.col_Page.getAttribute("class").contains("sorting"));
		Assert.assertTrue(pageTemplatesPage.col_User.getAttribute("class").contains("sorting"));
		Assert.assertTrue(pageTemplatesPage.col_Status.getAttribute("class").contains("sorting"));
		Assert.assertTrue(pageTemplatesPage.col_Updated.getAttribute("class").contains("sorting"));
		Assert.assertFalse(pageTemplatesPage.col_Action.getAttribute("class").contains("sorting"));
	}
	
	@When("User clicks on the page column")
	public void user_clicks_on_the_page_column() throws Exception {
		pageTemplatesPage.waitAndClickElement(pageTemplatesPage.col_Page);
	}

	@Then("the records are sorted in ascending order by the page column")
	public void the_records_are_sorted_in_ascending_order_by_the_page_column() {
	  Assert.assertTrue(pageTemplatesPage.SortedCellValue("Anytime Fitness For MobileFyre").isDisplayed());
	}
	
//	@Verify-Admin-can-Edit-an-existing-"Page-Template"
	@Then("User verifies that Edit button exist for each of the records")
	public void user_verifies_that_Edit_button_exist_for_each_of_the_records() throws Exception {
		Assert.assertTrue(pageTemplatesPage.btn_Edit.isDisplayed());
		Assert.assertEquals(Integer.parseInt(commonElementLocator.getElementText(commonElementLocator.lbl_PaginationEnd)), pageTemplatesPage.getNumberOfElements(pageTemplatesPage.getEDITBUTTONLOCATOR()));
	}

	@When("User clicks on the Edit button for a Template")
	public void user_clicks_on_the_Edit_button_for_a_Template() throws Exception {
		pageTemplatesPage.waitAndClickElement(pageTemplatesPage.btn_Edit("Retail"));
	}

	@Then("the selected Template page is opened")
	public void the_selected_Template_page_is_opened() {
	  Assert.assertTrue(commonElementLocator.pag_Title.getText().contains("Retail"));
	}

	@When("User makes some changes and clicks the Save button")
	public void user_makes_some_changes_and_clicks_the_Save_button() throws Exception {
		timeBeforeSave = pagesConfigurationPage.getElementText(pagesConfigurationPage.txt_SaveNotification);
		pagesConfigurationPage.textAreaForEdit.sendKeys(Keys.CONTROL + "a");
		pagesConfigurationPage.textAreaForEdit.sendKeys(Keys.DELETE);
		pagesConfigurationPage.textAreaForEdit.sendKeys(Keys.ENTER);
		pagesConfigurationPage.sendKeysToWebElement(pagesConfigurationPage.textAreaForEdit, "Automation Test");
		pagesConfigurationPage.waitAndClickElement(pagesConfigurationPage.btn_Save);
		Thread.sleep(3000);
	}

	@Then("the Changes are successfully saved")
	public void the_Changes_are_successfully_saved() throws Exception {
	 Assert.assertTrue(timeBeforeSave != pagesConfigurationPage.getElementText(pagesConfigurationPage.txt_SaveNotification));
	}

	@When("User clicks the Page link")
	public void user_clicks_the_Page_link() throws Exception {
	  pagesConfigurationPage.waitAndClickElement(pagesConfigurationPage.lnk_Pages);
	}

	@Then("User is redirected to the Page Template window")
	public void user_is_redirected_to_the_Page_Template_window() throws Exception {
	  Assert.assertEquals("Page Templates", commonElementLocator.getElementText(commonElementLocator.pag_Title));
	}

	@Then("User confirms the changes by clicking the Edit button of the template again")
	public void user_confirms_the_changes_by_clicking_the_Edit_button_of_the_template_again() throws Exception {
		pageTemplatesPage.waitAndClickElement(pageTemplatesPage.btn_Edit("Retail"));
		Assert.assertEquals("Automation Test", pagesConfigurationPage.getElementText(pagesConfigurationPage.textAreaForEdit));
		// Revert Changes
		pagesConfigurationPage.textAreaForEdit.sendKeys(Keys.CONTROL + "a");
		pagesConfigurationPage.textAreaForEdit.sendKeys(Keys.DELETE);
		pagesConfigurationPage.textAreaForEdit.sendKeys(Keys.ENTER);
		pagesConfigurationPage.sendKeysToWebElement(pagesConfigurationPage.textAreaForEdit, "Retail Test");
		pagesConfigurationPage.waitAndClickElement(pagesConfigurationPage.btn_Save);
		Thread.sleep(3000);
	}

//	@Create-Page-Template @OnlyMe
	@When("User clicks on the New button on the Page Template")
	public void user_clicks_on_the_New_button_on_the_Page_Template() throws InterruptedException {
	  commonElementLocator.waitAndClickElement(commonElementLocator.btn_New);
	}

	@Then("the Create Page Template modal is displayed")
	public void the_Create_Page_Template_modal_is_displayed() throws Exception {
		Assert.assertEquals("Create Page Template", createPageTemplatePage.getElementText(createPageTemplatePage.mod_Title));
	}

	@When("User enter the required information on the modal and click Create Page Template button")
	public void user_enter_the_required_information_on_the_modal_and_click_Create_Page_Template_button() throws Exception {
		createPageTemplatePage.sendKeysToWebElement(createPageTemplatePage.txtF_Name, "AutoTest");
		createPageTemplatePage.waitAndClickElement(createPageTemplatePage.categoriesDDown);
		createPageTemplatePage.waitAndClickElement(createPageTemplatePage.selectCategoriesh("All Bars"));
		createPageTemplatePage.waitAndClickElement(createPageTemplatePage.mod_Title);
		createPageTemplatePage.waitAndClickElement(createPageTemplatePage.btn_CreatePageTemplate);
	}

	@Then("the page template is created successfully")
	public void the_page_template_is_created_successfully() {

	}
	
//	@Verify-clicking-"Cancel"-or-"X"-on-Activate-page-popup-does-not-Activate-the-template
	@When("User clicks on the Edit button drop down for a Template to activate")
	public void user_clicks_on_the_Edit_button_drop_down_for_a_Template_to_activate() throws Exception {
		commonElementLocator.sendKeysToWebElement(commonElementLocator.txtF_Search, "AutoTest");
		commonElementLocator.waitAndClickElement(commonElementLocator.btn_Search);
		pageTemplatesPage.waitAndClickElement(pageTemplatesPage.btn_EditDDown("AutoTest"));
		pageTemplatesPage.waitAndClickElement(pageTemplatesPage.btn_MakeActive("AutoTest"));
	}

	@Then("the Activate popup window is displayed")
	public void the_Activate_popup_window_is_displayed() throws Exception {
		Assert.assertEquals("activate.page.title", activatePageModal.getElementText(activatePageModal.mod_Title));
	}

	@When("User clicks the Close button on the Activate popup window")
	public void user_clicks_the_Close_button_on_the_Activate_popup_window() throws Exception {
		activatePageModal.waitAndClickElement(activatePageModal.btn_Close);
	}

	@Then("User confirms that the page template was not activated")
	public void user_confirms_that_the_page_template_was_not_activated() {
		Assert.assertTrue(pageTemplatesPage.CellValue("Inactive, Hidden").isDisplayed());
	}
	
//	@Verify-Admin-can-Activate-a-Deactivate-"Page-Template" 
	@When("User clicks the Activate button on the Activate page title modal")
	public void user_clicks_the_Activate_button_on_the_Activate_page_title_modal() throws InterruptedException {
		activatePageModal.waitAndClickElement(activatePageModal.btn_Activate);
	}

	@Then("User confirms that the page template is activated")
	public void user_confirms_that_the_page_template_is_activated() {
	   Assert.assertTrue(pageTemplatesPage.CellValue("Active").isDisplayed());
	}
	
//	@Verify-clicking-"Cancel"-or-"X"-on-Inactivate-page-popup-does-not-Inactivate-the-template 
	@When("User clicks on the Edit button drop down for a Template to make Inactive")
	public void user_clicks_on_the_Edit_button_drop_down_for_a_Template_to_make_Inactive() throws Exception {
		commonElementLocator.sendKeysToWebElement(commonElementLocator.txtF_Search, "AutoTest");
		commonElementLocator.waitAndClickElement(commonElementLocator.btn_Search);
		pageTemplatesPage.waitAndClickElement(pageTemplatesPage.btn_EditDDown("AutoTest"));
		pageTemplatesPage.waitAndClickElement(pageTemplatesPage.btn_MakeInactive("AutoTest"));
	}

	@Then("the Deactivate popup window is displayed")
	public void the_Deactivate_popup_window_is_displayed() throws Exception {
		Assert.assertEquals("deactivate.page.title", deactivatePageModal.getElementText(deactivatePageModal.mod_Title));
	}

	@When("User clicks the Close button on the Deactivate popup window")
	public void user_clicks_the_Close_button_on_the_Deactivate_popup_window() throws Exception {
		deactivatePageModal.waitAndClickElement(deactivatePageModal.btn_Close);
	}

	@Then("User confirms that the page template was not deactivated")
	public void user_confirms_that_the_page_template_was_not_deactivated() {
		Assert.assertTrue(pageTemplatesPage.CellValue("Active").isDisplayed());
	}
	
//	@Verify-Admin-can-Deactivate-an-Active-"Page-Template"
	@When("User clicks the Deactivate button the window")
	public void user_clicks_the_Deactivate_button_the_window() throws Exception {
		deactivatePageModal.waitAndClickElement(deactivatePageModal.btn_Deactivate);
	}

	@Then("User confirms that the page template is deactivated")
	public void user_confirms_that_the_page_template_is_deactivated() {
		Assert.assertTrue(pageTemplatesPage.CellValue("Inactive, Hidden").isDisplayed());
	}


//	@Verify-clicking-"Cancel"-or-"X"-on-Delete-Page-popup-does-not-delete-the-Page-Template
	@When("User clicks on the Edit button drop down for a Template to delete")
	public void user_clicks_on_the_Edit_button_drop_down_for_a_Template_to_delete() throws Exception {
		commonElementLocator.sendKeysToWebElement(commonElementLocator.txtF_Search, "AutoTest");
		commonElementLocator.waitAndClickElement(commonElementLocator.btn_Search);
		pageTemplatesPage.waitAndClickElement(pageTemplatesPage.btn_EditDDown("AutoTest"));
		pageTemplatesPage.waitAndClickElement(pageTemplatesPage.btn_Delete("AutoTest"));
	}

	@Then("the Delete popup window is displayed")
	public void the_Delete_popup_window_is_displayed() throws Exception {
		Assert.assertEquals("Delete Page", deletePageModal.getElementText(deletePageModal.mod_Title));
	}

	@When("User clicks the Close button on the Delete popup window")
	public void user_clicks_the_Close_button_on_the_Delete_popup_window() throws Exception {
		deletePageModal.waitAndClickElement(deletePageModal.btn_Close);
	}

	@Then("User confirms that the page template was not deleted")
	public void user_confirms_that_the_page_template_was_not_deleted() {
		Assert.assertTrue(pageTemplatesPage.CellValue("AutoTest").isDisplayed());
	}
	
	
//	@Verify-Admin-can-delete-an-existing-Page-Template
	@When("User clicks the Delete button on the window")
	public void user_clicks_the_Delete_button_on_the_window() throws Exception {
		deletePageModal.waitAndClickElement(deletePageModal.btn_Delete);
	}

	@Then("User confirms that the page template is deleted")
	public void user_confirms_that_the_page_template_is_deleted() {
		Assert.assertFalse(pageTemplatesPage.isElementVisible(pageTemplatesPage.CELLVALUELOCATOR("AutoTest")));
	}

	
//	@Verify-Admin-is-able-to-search-the-Page-Templates-by-entering-a-search-criteria-in-Search-box-and-clicking-Search
	@Then("User verifies that both Search textbox and Search button are present on the page")
	public void user_verifies_that_both_Search_textbox_and_Search_button_are_present_on_the_page() {
		Assert.assertTrue(commonElementLocator.txtF_Search.isDisplayed());
		Assert.assertTrue(commonElementLocator.btn_Search.isDisplayed());
	}

	@When("User enters a text into the Search textbox and clicks Search button")
	public void user_enters_a_text_into_the_Search_textbox_and_clicks_Search_button() throws Exception {
		commonElementLocator.sendKeysToWebElement(commonElementLocator.txtF_Search, "Carwash");
		commonElementLocator.waitAndClickElement(commonElementLocator.btn_Search);
	}

	@Then("the result of the search is displayed")
	public void the_result_of_the_search_is_displayed() {
		Assert.assertTrue(pageTemplatesPage.CellValue("Carwash").isDisplayed());
	}

	@When("User leaves the search textbox empty and clicks the Search button")
	public void user_leaves_the_search_textbox_empty_and_clicks_the_Search_button() throws Exception {
		commonElementLocator.sendKeysToWebElement(commonElementLocator.txtF_Search, "");
		commonElementLocator.waitAndClickElement(commonElementLocator.btn_Search);
	}

	@Then("all the template records are displayed")
	public void all_the_template_records_are_displayed() throws InterruptedException {
		Assert.assertEquals("35", commonElementLocator.getElementText(commonElementLocator.lbl_PaginationTotal));
		
	}
	
//	@Verify-the-Help-on-"Page-Templates"-page-by-clicking-the-Help-button
	@When("User clicks the Help button on the page Template")
	public void user_clicks_the_Help_button_on_the_page_Template() throws Exception {
	   commonElementLocator.waitAndClickElement(commonElementLocator.btn_Help);
	}

	@Then("the Page Templates help tour window appears")
	public void the_Page_Templates_help_tour_window_appears() throws Exception {
		Assert.assertEquals("Page Templates", commonElementLocator.getElementText(commonElementLocator.mod_Help_Title));
	}

	@When("User clicks the Next button on the Page Templates help window")
	public void user_clicks_the_Next_button_on_the_Page_Templates_help_window() throws Exception {
	commonElementLocator.waitAndClickElement(commonElementLocator.btn_Help_Next);
	}

	@Then("the Create New Page Template window is displayed")
	public void the_Create_New_Page_Template_window_is_displayed() throws Exception {
		Assert.assertEquals("Create New Page Template", commonElementLocator.getElementText(commonElementLocator.mod_Help_Title));
	}

	@When("User clicks the previous button on the Create New Page Template")
	public void user_clicks_the_previous_button_on_the_Create_New_Page_Template() throws Exception {
	commonElementLocator.waitAndClickElement(commonElementLocator.btn_Help_Prev);
	}

	@Then("User is navigated to the Page Templates window")
	public void user_is_navigated_to_the_Page_Templates_window() throws Exception {
		Assert.assertEquals("Page Templates", commonElementLocator.getElementText(commonElementLocator.mod_Help_Title));
	}
	
//	@Verify-that-a-non-admin-user-cannot-access-Settings-Page-Templates-via-menu-as-well-as-via-direct-URL-access
	@Then("User copies the current url for Page Templates and sign out")
	public void user_copies_the_current_url_for_Page_Templates_and_sign_out() throws Exception {
		URLAddress = driver.getCurrentUrl();
		commonElementLocator.waitAndClickElement(commonElementLocator.loginAccountDDown);
		commonElementLocator.waitAndClickElement(commonElementLocator.btn_SignOut);
	}

	@When("User navigates to the url of Page Templates copied earlier")
	public void user_navigates_to_the_url_of_Page_Templates_copied_earlier() {
		 driver.navigate().to(URLAddress);
	}

}
