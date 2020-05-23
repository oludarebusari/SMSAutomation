package stepDefinitions.testSuite.regression.thrive;

import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import components.elements.CommonElementLocator;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.thrive.CreatePageTemplatePage;
import pageObjects.thrive.PageTemplatesPage;
import pageObjects.thrive.PagesConfigurationPage;
import pageObjects.thrive.modal.ActivatePageModal;
import pageObjects.thrive.modal.DeactivatePageModal;
import pageObjects.thrive.modal.DeletePageModal;
import pageObjects.thrive.modal.PageSettingsModal;
import utils.DriverFactory;

public class AddPageTemplatesUnderSettingsSteps extends DriverFactory {

	public ActivatePageModal activatePageModal = PageFactory.initElements(driver, ActivatePageModal.class);
	public CommonElementLocator commonElementLocator = PageFactory.initElements(driver, CommonElementLocator.class);
	public CreatePageTemplatePage createPageTemplatePage = PageFactory.initElements(driver,
			CreatePageTemplatePage.class);
	public DeactivatePageModal deactivatePageModal = PageFactory.initElements(driver, DeactivatePageModal.class);
	public DeletePageModal deletePageModal = PageFactory.initElements(driver, DeletePageModal.class);
	public PageSettingsModal pageSettingsModal = PageFactory.initElements(driver, PageSettingsModal.class);
	public PagesConfigurationPage pagesConfigurationPage = PageFactory.initElements(driver,
			PagesConfigurationPage.class);
	public PageTemplatesPage pageTemplatesPage = PageFactory.initElements(driver, PageTemplatesPage.class);
	Actions actions = new Actions(driver);

//	@Verify-admin-can-add-a-page-template-and-page-is-added-under-Page-Templates-page
	@When("User Clicks on the New button on the Page Templates page")
	public void user_Clicks_on_the_New_button_on_the_Page_Templates_page() throws Exception {
		commonElementLocator.waitAndClickElement(commonElementLocator.btn_New);
	}

	@Then("the Create Page Template window is opened")
	public void the_Create_Page_Template_window_is_opened() throws Exception {
		Assert.assertEquals("Create Page Template",
				createPageTemplatePage.getElementText(createPageTemplatePage.mod_Title));
	}

	@Then("User enters name into the Name field")
	public void user_enters_name_into_the_Name_field() throws Exception {
		createPageTemplatePage.sendKeysToWebElement(createPageTemplatePage.txtF_Name, "AutoTest");
	}

	@Then("User selects single or multiple categories")
	public void user_selects_single_or_multiple_categories() throws Exception {
		createPageTemplatePage.waitAndClickElement(createPageTemplatePage.categoriesDDown);
		createPageTemplatePage.waitAndClickElement(createPageTemplatePage.selectCategoriesh("All Automotive"));
		createPageTemplatePage.waitAndClickElement(createPageTemplatePage.selectCategoriesh("All Education"));
		createPageTemplatePage.waitAndClickElement(createPageTemplatePage.mod_Title);
	}

	@Then("User clicks the Create Page Template button")
	public void user_clicks_the_Create_Page_Template_button() throws Exception {
		createPageTemplatePage.waitAndClickElement(createPageTemplatePage.btn_CreatePageTemplate);
	}

	@Then("User confirms that the Page Template is created successfully")
	public void user_confirms_that_the_Page_Template_is_created_successfully() throws Exception {
		commonElementLocator.sendKeysToWebElement(commonElementLocator.txtF_Search, "AutoTest");
		commonElementLocator.waitAndClickElement(commonElementLocator.btn_Search);
		Assert.assertTrue(pageTemplatesPage.CellValue("AutoTest").isDisplayed());
	}

//	@Verify-Admin-is-able-to-Add-Content-on-template-page
	@When("User verifies the options on the left menu bar of the newly created page")
	public void user_verifies_the_options_on_the_left_menu_bar_of_the_newly_created_page() throws Exception {
		commonElementLocator.sendKeysToWebElement(commonElementLocator.txtF_Search, "AutoTest");
		commonElementLocator.waitAndClickElement(commonElementLocator.btn_Search);
		pageTemplatesPage.waitAndClickElement(pageTemplatesPage.btn_Edit);
		Assert.assertTrue(pagesConfigurationPage.sideMenu_Header.isDisplayed());
		Assert.assertTrue(pagesConfigurationPage.sideMenu_Footer.isDisplayed());
		Assert.assertTrue(pagesConfigurationPage.sideMenu_Content.isDisplayed());
		Assert.assertTrue(pagesConfigurationPage.sideMenu_Media.isDisplayed());
		Assert.assertTrue(pagesConfigurationPage.sideMenu_Streams.isDisplayed());
		Assert.assertTrue(pagesConfigurationPage.sideMenu_Parallax.isDisplayed());
	}

	@When("user clicks on an option to add content")
	public void user_clicks_on_an_option_to_add_content() throws InterruptedException {
		pagesConfigurationPage.waitAndClickElement(pagesConfigurationPage.sideMenu_Header);
	}

	@Then("the option is expanded and the snippets are displayed")
	public void the_option_is_expanded_and_the_snippets_are_displayed() throws Exception {
		Assert.assertTrue(pagesConfigurationPage.OptionDDown.isDisplayed());
	}

	@When("User selects a snippet and drag to the right pane")
	public void user_selects_a_snippet_and_drag_to_the_right_pane() throws Exception {

		Action dragAndDrop = actions.clickAndHold(pagesConfigurationPage.imgToDrag)
				.moveToElement(pagesConfigurationPage.emptyHeaderBox).release(pagesConfigurationPage.emptyHeaderBox)
				.build();
		dragAndDrop.perform();

	}

	@Then("the Header, Body content and Footer are displayed")
	public void the_Header_Body_content_and_Footer_are_displayed() throws Exception {

	}

//	@Verify-the-validations-on-"Add-page-template"-page-on-clicking-"+New"-button
	@When("User leaves all the fields blank and clicks Create Page Template button")
	public void user_leaves_all_the_fields_blank_and_clicks_Create_Page_Template_button() throws Exception {
		createPageTemplatePage.waitAndClickElement(createPageTemplatePage.btn_CreatePageTemplate);
	}

	@Then("the validation message is displayed")
	public void the_validation_message_is_displayed() {
		Assert.assertTrue(createPageTemplatePage.nameFieldErrorMsg.isDisplayed());
	}

	@Then("User verifies the state of the Create Page Template button")
	public void user_verifies_the_state_of_the_Create_Page_Template_button() {
		Assert.assertTrue(createPageTemplatePage.btn_CreatePageTemplate.getAttribute("class").contains("disabled"));
	}

	@Then("User enters a name into the name field and verifies the state of the Create Page Template button")
	public void user_enters_a_name_into_the_name_field_and_verifies_the_state_of_the_Create_Page_Template_button()
			throws Exception {
		createPageTemplatePage.sendKeysToWebElement(createPageTemplatePage.txtF_Name, "AutoTest");
		Assert.assertFalse(createPageTemplatePage.btn_CreatePageTemplate.getAttribute("class").contains("disabled"));
	}

//	@Verify-admin-can-view/change-the-source-code-of-the-snippet
	@When("User clicks the edit button on a page")
	public void user_clicks_the_edit_button_on_a_page() throws Exception {
		commonElementLocator.sendKeysToWebElement(commonElementLocator.txtF_Search, "AutomationQA1");
		commonElementLocator.waitAndClickElement(commonElementLocator.btn_Search);
		pageTemplatesPage.waitAndClickElement(pageTemplatesPage.btn_Edit("AutomationQA1"));
	}

	@Then("the page template edit window is opened")
	public void the_page_template_edit_window_is_opened() throws Exception {
		Assert.assertTrue(
				commonElementLocator.getElementText(commonElementLocator.pag_Title).contains("AutomationQA1"));
	}

	@When("User clicks on an Image and clicks on the html snippet")
	public void user_clicks_on_an_Image_and_clicks_on_the_html_snippet() throws Exception {
		pagesConfigurationPage.waitAndClickElement(pagesConfigurationPage.image);
		pagesConfigurationPage.waitAndClickElement(pagesConfigurationPage.snip_Html);
	}

	@Then("the html text window is opened")
	public void the_html_text_window_is_opened() throws Exception {
		Assert.assertTrue(pagesConfigurationPage.snip_HtmlTextArea.isDisplayed());
	}

	@Then("User enters html and clicks OK button")
	public void user_enters_html_and_clicks_OK_button() throws Exception {
		pagesConfigurationPage.sendKeysToWebElement(pagesConfigurationPage.snip_HtmlTextArea,
				pagesConfigurationPage.getHTMLTextEdited());
		pagesConfigurationPage.waitAndClickElement(pagesConfigurationPage.btn_HtmlTextAreaOK);
	}

	@Then("User clicks the Save button on the page")
	public void user_clicks_the_Save_button_on_the_page() throws Exception {
		pagesConfigurationPage.waitAndClickElement(pagesConfigurationPage.btn_Save);
		Thread.sleep(3000);

	}

	@Then("User confirms the change was saved correctly")
	public void user_confirms_the_change_was_saved_correctly() throws Exception {
		pagesConfigurationPage.waitAndClickElement(pagesConfigurationPage.lnk_Pages);
		commonElementLocator.sendKeysToWebElement(commonElementLocator.txtF_Search, "AutomationQA1");
		commonElementLocator.waitAndClickElement(commonElementLocator.btn_Search);
		pageTemplatesPage.waitAndClickElement(pageTemplatesPage.btn_Edit("AutomationQA1"));
		pagesConfigurationPage.waitAndClickElement(pagesConfigurationPage.image);
		pagesConfigurationPage.waitAndClickElement(pagesConfigurationPage.snip_Html);
	}

//	@Verify-admin-can-create-a-copy-of-snippet-on-clicking-"+'-on-snippet
	@When("User clicks the edit button on a page to modify")
	public void user_clicks_the_edit_button_on_a_page_to_modify() throws Exception {
		commonElementLocator.sendKeysToWebElement(commonElementLocator.txtF_Search, "AutomationQA2");
		commonElementLocator.waitAndClickElement(commonElementLocator.btn_Search);
		pageTemplatesPage.waitAndClickElement(pageTemplatesPage.btn_Edit("AutomationQA2"));
	}

	@Then("the page template edit window is displayed")
	public void the_page_template_edit_window_is_displayed() throws Exception {
		Assert.assertTrue(
				commonElementLocator.getElementText(commonElementLocator.pag_Title).contains("AutomationQA2"));
	}

	@When("User clicks on an Image, clicks on the plus snippet and clicks the Save button")
	public void user_clicks_on_an_Image_clicks_on_the_plus_snippet_and_clicks_the_Save_button()
			throws InterruptedException {
		pagesConfigurationPage.clickElementAtOffSet(pagesConfigurationPage.image);
		pagesConfigurationPage.waitAndClickElement(pagesConfigurationPage.snip_Plus);
		pagesConfigurationPage.waitAndClickElement(pagesConfigurationPage.btn_Save);
		Thread.sleep(2500);
	}

	@Then("the snippet is duplicated")
	public void the_snippet_is_duplicated() throws Exception {
		Assert.assertEquals(2, pagesConfigurationPage.getNumberOfImage("Lorem Ipsum is simply dummy text").size());
	}

//	@Verify-admin-can-delete-an-existing-snippet
	@When("User clicks on an Image, clicks on the delete snippet and clicks the Save button")
	public void user_clicks_on_an_Image_clicks_on_the_delete_snippet_and_clicks_the_Save_button()
			throws InterruptedException {
		pagesConfigurationPage.clickElementAtOffSet(pagesConfigurationPage.image);
		pagesConfigurationPage.waitAndClickElement(pagesConfigurationPage.snip_Delete);
		pagesConfigurationPage.waitAndClickElement(pagesConfigurationPage.btn_Save);
		Thread.sleep(2500);
	}

	@Then("the snippet is successfully removed")
	public void the_snippet_is_successfully_removed() {
		Assert.assertEquals(1, pagesConfigurationPage.getNumberOfImage("Lorem Ipsum is simply dummy text").size());
	}

//	@Verify-a-Page-Template-can-be-Activated-from-its-content-page
	@When("User clicks the action drop down for the page to Activate")
	public void user_clicks_the_action_drop_down_for_the_page_to_Activate() throws Exception {
		commonElementLocator.sendKeysToWebElement(commonElementLocator.txtF_Search, "AutoTest");
		commonElementLocator.waitAndClickElement(commonElementLocator.btn_Search);
		pageTemplatesPage.waitAndClickElement(pageTemplatesPage.btn_EditDDown("AutoTest"));
	}

	@Then("the actions options are displayed")
	public void the_actions_options_are_displayed() {
		Assert.assertTrue(pageTemplatesPage.btn_MakeActive("AutoTest").isDisplayed());
		Assert.assertTrue(pageTemplatesPage.btn_Delete("AutoTest").isDisplayed());
	}

	@When("User clicks the Make Active Option")
	public void user_clicks_the_Make_Active_Option() throws Exception {
		pageTemplatesPage.waitAndClickElement(pageTemplatesPage.btn_MakeActive("AutoTest"));
	}

	@Then("the Activate page window is opened")
	public void the_Activate_page_window_is_opened() throws InterruptedException {
		Assert.assertEquals("activate.page.title", activatePageModal.getElementText(activatePageModal.mod_Title));
	}

	@When("User clicks the Activate button on the modal")
	public void user_clicks_the_Activate_button_on_the_modal() throws Exception {
		activatePageModal.waitAndClickElement(activatePageModal.btn_Activate);
	}

	@Then("the selected page is Activated")
	public void the_selected_page_is_Activated() {
		Assert.assertTrue(pageTemplatesPage.CellValue("Active").isDisplayed());
	}

//	@Verify-a-Page-Template-can-be-deactivate-from-its-content-page
	@When("User clicks the action drop down for the page to Deactivate")
	public void user_clicks_the_action_drop_down_for_the_page_to_Deactivate() throws Exception {
		commonElementLocator.sendKeysToWebElement(commonElementLocator.txtF_Search, "AutoTest");
		commonElementLocator.waitAndClickElement(commonElementLocator.btn_Search);
		pageTemplatesPage.waitAndClickElement(pageTemplatesPage.btn_EditDDown("AutoTest"));
	}

	@Then("the actions options for the selected page to deactivate is displayed")
	public void the_actions_options_for_the_selected_page_to_deactivate_is_displayed() {
		Assert.assertTrue(pageTemplatesPage.btn_MakeInactive("AutoTest").isDisplayed());
		Assert.assertTrue(pageTemplatesPage.btn_Delete("AutoTest").isDisplayed());
	}
	
	@When("User clicks the Make Inactive Option")
	public void user_clicks_the_Make_Inactive_Option() throws Exception {
		pageTemplatesPage.waitAndClickElement(pageTemplatesPage.btn_MakeInactive("AutoTest"));
	}

	@Then("the Deactivate page window is opened")
	public void the_Deactivate_page_window_is_opened() throws Exception {
		Assert.assertEquals("Deactivate", deactivatePageModal.getElementText(deactivatePageModal.btn_Deactivate));
	}

	@When("User clicks the Deactivate button on the modal")
	public void user_clicks_the_Deactivate_button_on_the_modal() throws Exception {
		deactivatePageModal.waitAndClickElement(deactivatePageModal.btn_Deactivate);
	}

	@Then("the selected page is Deactivated")
	public void the_selected_page_is_Deactivated() {
		Assert.assertTrue(pageTemplatesPage.CellValue("Inactive, Hidden").isDisplayed());
	}
	
//	@Verify-the-Settings-can-be-changed-for-Page-Template-from-its-Contents
	@When("User clicks the edit button on a page template")
	public void user_clicks_the_edit_button_on_a_page_template() throws Exception {
		commonElementLocator.sendKeysToWebElement(commonElementLocator.txtF_Search, "AutoTest");
		commonElementLocator.waitAndClickElement(commonElementLocator.btn_Search);
		pageTemplatesPage.waitAndClickElement(pageTemplatesPage.btn_Edit("AutoTest"));
	}

	@Then("the page edit window is opend")
	public void the_page_edit_window_is_opend() {
	Assert.assertTrue(commonElementLocator.pag_Title.getText().contains("AutoTest"));
	}

	@When("User clicks the Settings buttons")
	public void user_clicks_the_Settings_buttons() throws Exception {
	 pagesConfigurationPage.waitAndClickElement(pagesConfigurationPage.btn_Settings);
	}

	@Then("the Settings modal window is opened")
	public void the_Settings_modal_window_is_opened() throws InterruptedException {
	Assert.assertEquals("Settings", pageSettingsModal.getElementText(pageSettingsModal.mod_Title));
	}

	@When("User attaches a file and click the Save Settings button")
	public void user_attaches_a_file_and_click_the_Save_Settings_button() throws Exception {
		pageSettingsModal.sendKeysToWebElement(pageSettingsModal.txtF_ChooseFile, "C:/Development/SMSAutomation/smsautomation/lib/auto_gallery_small.jpeg");
		pageSettingsModal.waitAndClickElement(pageSettingsModal.btn_SaveSettings);
		pagesConfigurationPage.waitAndClickElement(pagesConfigurationPage.btn_Save);
	}

	@Then("User verifies the attached file is saved successfully.")
	public void user_verifies_the_attached_file_is_saved_successfully() throws Exception {
		pagesConfigurationPage.waitAndClickElement(pagesConfigurationPage.btn_Settings);
		Assert.assertTrue(pageSettingsModal.settings_Image.getAttribute("title").contains("auto_gallery_small.jpeg"));
	}
	
//	@Verify-the-Page-Template-name-can-be-changed-from-its-content-page
	@When("User clicks on the Page template name")
	public void user_clicks_on_the_Page_template_name() throws Exception {
		pagesConfigurationPage.waitAndClickElement(pagesConfigurationPage.lbl_ageTemplatesTitle);
	}

	@When("User modifies the page title")
	public void user_modifies_the_page_title() throws Exception {
		pagesConfigurationPage.sendKeysToWebElement(pagesConfigurationPage.txtF_PageTemplatesTitle, "AutoTest2");
	}

	@When("user clicks on the editable button")
	public void user_clicks_on_the_editable_button() throws Exception {
		pagesConfigurationPage.waitAndClickElement(pagesConfigurationPage.btn_Editable);
	}

	@When("User verifies the changes to the title")
	public void user_verifies_the_changes_to_the_title() throws Exception {
		pagesConfigurationPage.waitAndClickElement(pagesConfigurationPage.lnk_Pages);
		commonElementLocator.sendKeysToWebElement(commonElementLocator.txtF_Search, "AutoTest2");
		commonElementLocator.waitAndClickElement(commonElementLocator.btn_Search);
		Assert.assertTrue(pageTemplatesPage.CellValue("AutoTest2").isDisplayed());
	}

	

//	@Verify-clicking-Cancel-or-'X'-on-"Delete-this-page"-does-not-delete-a-page-template-from-its-content-page
	@When("User clicks the action drop down for the page to delete")
	public void user_clicks_the_action_drop_down_for_the_page_to_delete() throws Exception {
		commonElementLocator.sendKeysToWebElement(commonElementLocator.txtF_Search, "AutoTest2");
		commonElementLocator.waitAndClickElement(commonElementLocator.btn_Search);
		pageTemplatesPage.waitAndClickElement(pageTemplatesPage.btn_EditDDown("AutoTest2"));
	}
	
	@Then("the actions options for the page to be deleted is displayed")
	public void the_actions_options_for_the_page_to_be_deleted_is_displayed() {
		Assert.assertTrue(pageTemplatesPage.btn_MakeActive("AutoTest2").isDisplayed());
		Assert.assertTrue(pageTemplatesPage.btn_Delete("AutoTest2").isDisplayed());
	}

	@When("User clicks the Delete Option")
	public void user_clicks_the_Delete_Option() throws Exception {
		pageTemplatesPage.waitAndClickElement(pageTemplatesPage.btn_Delete("AutoTest2"));
	}

	@Then("the Delete page window is opened")
	public void the_Delete_page_window_is_opened() throws Exception {
		Assert.assertEquals("Delete Page", deletePageModal.getElementText(deletePageModal.mod_Title));
	}

	@When("User clicks the close button on the modal")
	public void user_clicks_the_close_button_on_the_modal() throws Exception {
		deletePageModal.waitAndClickElement(deletePageModal.btn_Close);
	}

	@Then("the selected page is not deleted and available in the list")
	public void the_selected_page_is_not_deleted_and_available_in_the_list() {
		Assert.assertTrue(pageTemplatesPage.CellValue("AutoTest2").isDisplayed());
	}

//	@Verify-admin-can-delete-a-page-template-from-its-content-page
	@When("User clicks the Delete button on the modal")
	public void user_clicks_the_Delete_button_on_the_modal() throws Exception {
		deletePageModal.waitAndClickElement(deletePageModal.btn_Delete);
	}

	@Then("the selected page is deleted and not available in the list again")
	public void the_selected_page_is_deleted_and_not_available_in_the_list_again() throws Exception {
		commonElementLocator.sendKeysToWebElement(commonElementLocator.txtF_Search, "AutoTest2");
		commonElementLocator.waitAndClickElement(commonElementLocator.btn_Search);
		Assert.assertTrue(
				Integer.parseInt(commonElementLocator.getElementText(commonElementLocator.lbl_PaginationTotal)) == 0);
	}

}
