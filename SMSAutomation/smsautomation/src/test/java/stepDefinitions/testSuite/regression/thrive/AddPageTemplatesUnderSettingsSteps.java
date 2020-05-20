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
import utils.DriverFactory;

public class AddPageTemplatesUnderSettingsSteps extends DriverFactory {

	public ActivatePageModal activatePageModal = PageFactory.initElements(driver, ActivatePageModal.class);
	public CommonElementLocator commonElementLocator = PageFactory.initElements(driver, CommonElementLocator.class);
	public CreatePageTemplatePage createPageTemplatePage = PageFactory.initElements(driver,
			CreatePageTemplatePage.class);
	public DeactivatePageModal deactivatePageModal = PageFactory.initElements(driver, DeactivatePageModal.class);
	public DeletePageModal deletePageModal = PageFactory.initElements(driver, DeletePageModal.class);
	public PagesConfigurationPage pagesConfigurationPage = PageFactory.initElements(driver,
			PagesConfigurationPage.class);
	public PageTemplatesPage pageTemplatesPage = PageFactory.initElements(driver, PageTemplatesPage.class);

	public String HTMLTextModified = "<div class=\"col-xs-12 col-sm-6\">\r\n" + 
			"            <figure class=\"text-center\">\r\n" + 
			"                <img src=\"/bundles/mastermindsdigitalplatform/images/contentbuilder/07.jpg\" class=\"img-circle\" alt=\"\">\r\n" + 
			"                <figcaption>\r\n" + 
			"                    <h3>Printing</h3>\r\n" + 
			"                    <p>\r\n" + 
			"                        Lorem Ipsum is simply dummy text of the printing and typesetting industry.\r\n" + 
			"                    </p>\r\n" + 
			"                </figcaption>\r\n" + 
			"            </figure>\r\n" + 
			"        </div>\r\n" + 
			"        <div class=\"col-xs-12 col-sm-6\">\r\n" + 
			"            <figure class=\"text-center\">\r\n" + 
			"                <img src=\"/bundles/mastermindsdigitalplatform/images/contentbuilder/08.jpg\" class=\"img-circle\" alt=\"\">\r\n" + 
			"                <figcaption>\r\n" + 
			"                    <h3>Typesetting</h3>\r\n" + 
			"                    <p>\r\n" + 
			"                        Lorem Ipsum is simply dummy text of the printing and typesetting industry Edited.\r\n" + 
			"                    </p>\r\n" + 
			"                </figcaption>\r\n" + 
			"            </figure>\r\n" +  
			"        </div>";
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
		createPageTemplatePage.sendKeysToWebElement(createPageTemplatePage.txtF_Name, "AutomationQA");
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
		commonElementLocator.sendKeysToWebElement(commonElementLocator.txtF_Search, "AutomationQA");
		commonElementLocator.waitAndClickElement(commonElementLocator.btn_Search);
		Assert.assertTrue(pageTemplatesPage.CellValue("AutomationQA").isDisplayed());
	}

//	@Verify-Admin-is-able-to-Add-Content-on-template-page
	@When("User verifies the options on the left menu bar of the newly created page")
	public void user_verifies_the_options_on_the_left_menu_bar_of_the_newly_created_page() throws Exception {
		commonElementLocator.sendKeysToWebElement(commonElementLocator.txtF_Search, "AutomationQA");
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

//
	@When("User clicks the edit button on a page")
	public void user_clicks_the_edit_button_on_a_page() throws Exception {
		commonElementLocator.sendKeysToWebElement(commonElementLocator.txtF_Search, "AutomationQA");
		commonElementLocator.waitAndClickElement(commonElementLocator.btn_Search);
		pageTemplatesPage.waitAndClickElement(pageTemplatesPage.btn_Edit("AutomationQA"));
	}

	@Then("the page template edit window is opened")
	public void the_page_template_edit_window_is_opened() throws Exception {
		Assert.assertTrue(commonElementLocator.getElementText(commonElementLocator.pag_Title).contains("AutomationQA"));
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
		commonElementLocator.sendKeysToWebElement(commonElementLocator.txtF_Search, "AutomationQA");
		commonElementLocator.waitAndClickElement(commonElementLocator.btn_Search);
		pageTemplatesPage.waitAndClickElement(pageTemplatesPage.btn_Edit("AutomationQA"));
		pagesConfigurationPage.waitAndClickElement(pagesConfigurationPage.image);
		pagesConfigurationPage.waitAndClickElement(pagesConfigurationPage.snip_Html);
	}
}
