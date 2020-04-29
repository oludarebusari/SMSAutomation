package stepDefinitions.testSuite.regression.thrive;


import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import components.elements.CommonElementLocator;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.thrive.PagesConfigurationPage;
import pageObjects.thrive.PagesMainPage;
import pageObjects.thrive.Tab.ExperienceDDown;
import pageObjects.thrive.modal.ActivatePageModal;
import pageObjects.thrive.modal.CreatepagePage;
import pageObjects.thrive.modal.DeletePageModal;
import pageObjects.thrive.modal.PageSettingsModal;
import pageObjects.thrive.modal.SaveChangesToPageModal;
import utils.DriverFactory;

public class AddPageInMerchantPortalSteps extends DriverFactory {
	
	public ActivatePageModal activatePageModal = PageFactory.initElements(driver, ActivatePageModal.class);
	public CommonElementLocator commonElementLocator = PageFactory.initElements(driver, CommonElementLocator.class);
	public CreatepagePage createpagePage = PageFactory.initElements(driver, CreatepagePage.class);
	public DeletePageModal deletePageModal = PageFactory.initElements(driver, DeletePageModal.class);
	public ExperienceDDown experienceDDown = PageFactory.initElements(driver, ExperienceDDown.class);
	public PagesConfigurationPage pagesConfigurationPage = PageFactory.initElements(driver, PagesConfigurationPage.class);
	public PagesMainPage pagesMainPage = PageFactory.initElements(driver, PagesMainPage.class);
	public PageSettingsModal pageSettingsModal = PageFactory.initElements(driver, PageSettingsModal.class);
	public SaveChangesToPageModal saveChangesToPageModal = PageFactory.initElements(driver, SaveChangesToPageModal.class);

//  @SMSM-136 @Verify-the-user-is-able-to-create-a-new-page-in-merchant-portal 
	@When("User clicks on the Experience Menu option")
	public void user_clicks_on_the_Experience_Menu_option() throws Exception {
		commonElementLocator.waitAndClickElement(commonElementLocator.menu_Experience);
	}

	@Then("the Experience options are displayed")
	public void the_Experience_options_are_displayed() {
		Assert.assertTrue(experienceDDown.opt_Pages.isDisplayed());
		Assert.assertTrue(experienceDDown.opt_SmartCode.isDisplayed());
		Assert.assertTrue(experienceDDown.opt_Captivate.isDisplayed());
		Assert.assertTrue(experienceDDown.opt_EasyConnect.isDisplayed());
		Assert.assertTrue(experienceDDown.opt_Streams.isDisplayed());
	}

	@When("User clicks the Pages option")
	public void user_clicks_the_Pages_option() throws Exception {
		experienceDDown.waitAndClickElement(experienceDDown.opt_Pages);
	}

	@Then("users is redirected to the Pages page")
	public void users_is_redirected_to_the_Pages_page() throws Exception {
		Assert.assertEquals("Pages", commonElementLocator.getElementText(commonElementLocator.pag_Title));
	}

	@Then("the Create Page window is opened")
	public void the_Create_Page_window_is_opened() throws Exception {
		Assert.assertEquals("Create Page", createpagePage.getElementText(createpagePage.mod_Title));
	}

	@When("User enters a Name, select a template and clicks the Create Page button")
	public void user_enters_a_Name_select_a_template_and_clicks_the_Create_Page_button() throws Exception {
		createpagePage.sendKeysToWebElement(createpagePage.txtF_Name, "AclateQA");
		createpagePage.waitAndClickElement(createpagePage.template_Spa);
		createpagePage.waitAndClickElement(createpagePage.btn_CreatePage);
	}

	@Then("the new page is created")
	public void the_new_page_is_created() throws Exception {
		pagesConfigurationPage.waitAndClickElement(pagesConfigurationPage.btn_Save);
		commonElementLocator.waitAndClickElement(commonElementLocator.menu_Experience);
		experienceDDown.waitAndClickElement(experienceDDown.opt_Pages);
		saveChangesToPageModal.waitAndClickElement(saveChangesToPageModal.btn_SaveChanges);
		Thread.sleep(3000);
		Assert.assertTrue(pagesMainPage.searchPageByPageName("AclateQA").isDisplayed());
	}

//	@SMSM-136 @Verify-all-the-available-menus-on-merchant-page
	@When("Users clicks edit button beside a page")
	public void users_clicks_edit_button_beside_a_page() throws InterruptedException {
		pagesMainPage.waitAndClickElement(pagesMainPage.btn_EditPageByPageName("AclateQA"));
	}

	@Then("the page window is opened")
	public void the_page_window_is_opened() throws InterruptedException {
		Assert.assertEquals("Pages / AclateQA", pagesMainPage.getElementText(pagesMainPage.pag_title));
	}

	@Then("User confirms that the Header option is available")
	public void user_confirms_that_the_Header_option_is_available() {
		Assert.assertTrue(pagesConfigurationPage.sideMenu_Header.isDisplayed());
	}

	@Then("User confirms that the Footer option is available")
	public void user_confirms_that_the_Footer_option_is_available() {
		Assert.assertTrue(pagesConfigurationPage.sideMenu_Footer.isDisplayed());
	}

	@Then("User confirms that the Content option is available")
	public void user_confirms_that_the_Content_option_is_available() {
		Assert.assertTrue(pagesConfigurationPage.sideMenu_Content.isDisplayed());
	}

	@Then("User confirms that the Media option is available")
	public void user_confirms_that_the_Media_option_is_available() {
		Assert.assertTrue(pagesConfigurationPage.sideMenu_Media.isDisplayed());
	}

	@Then("User confirms that the Touchpoint option is available")
	public void user_confirms_that_the_Touchpoint_option_is_available() {
		Assert.assertTrue(pagesConfigurationPage.sideMenu_EasyConnect.isDisplayed());
	}

	@Then("User confirms that the Streams option is available")
	public void user_confirms_that_the_Streams_option_is_available() {
		Assert.assertTrue(pagesConfigurationPage.sideMenu_Streams.isDisplayed());
	}

	@Then("User confirms that the Parallax option is available")
	public void user_confirms_that_the_Parallax_option_is_available() {
		Assert.assertTrue(pagesConfigurationPage.sideMenu_Parallax.isDisplayed());
	}

//	@SMSM-136 @Verify-the-4-options-appear-on-the-left-top-side-of-the-snippet
	@When("User clicks the text on the image")
	public void user_clicks_the_text_on_the_image() throws Exception {
		pagesConfigurationPage.waitAndClickElement(pagesConfigurationPage.img_Text);
	}

	@Then("the four action options for the image is displayed")
	public void the_four_action_options_for_the_image_is_displayed() throws Exception {
		Assert.assertTrue(pagesConfigurationPage.snip_Pointer.isDisplayed());
		Assert.assertTrue(pagesConfigurationPage.snip_Html.isDisplayed());
		Assert.assertTrue(pagesConfigurationPage.snip_Plus.isDisplayed());
		Assert.assertTrue(pagesConfigurationPage.snip_Delete.isDisplayed());
	}
	
	
//	 @SMSM-136 @Verify-the-all-code-is-visible-to-user-by-clicking-on-the-</>-icon
	@When("User clicks the html icon at the left side of the snippet")
	public void user_clicks_the_html_icon_at_the_left_side_of_the_snippet() throws Exception {
		pagesConfigurationPage.waitAndClickElement(pagesConfigurationPage.snip_Html);
	}

	@Then("a new pop-up window with a textarea and snippet code is displayed")
	public void a_new_pop_up_window_with_a_textarea_and_snippet_code_is_displayed() throws Exception {
		Assert.assertTrue(pagesConfigurationPage.snip_HtmlTextArea.isDisplayed());
	}

//	@SMSM-136 @Verify-the-same-snippet-is-added-on-the-page-by-clicking-on-plus-icon
	@When("User clicks the plus icon at the left side of the snippet")
	public void user_clicks_the_plus_icon_at_the_left_side_of_the_snippet() throws Exception {
		pagesConfigurationPage.waitAndClickElement(pagesConfigurationPage.snip_Plus);
		Assert.assertEquals(3, pagesConfigurationPage.getNumberOfImage("Tagline for your business").size());
	}
	
//	@SMSM-136 @Verify-the-user-is-able-to-delete-the-snippet-on-the-page-by-clicking-on-delete-icon
	@When("User clicks the Delete icon at the left side of the snippet")
	public void user_clicks_the_Delete_icon_at_the_left_side_of_the_snippet() throws Exception {
		pagesConfigurationPage.waitAndClickElement(pagesConfigurationPage.snip_Delete);
	}

	@Then("User verifies that the image is deleted")
	public void user_verifies_that_the_image_is_deleted() {
		Assert.assertTrue(pagesConfigurationPage.emptyHeaderBox.isDisplayed());		
	}
	
//	@SMSM-136 @Verify-the-user-is-able-to-activate-the-page-by-clicking-on-Activate-button	
	@When("Users clicks the action dropdown button beside a page")
	public void users_clicks_the_action_dropdown_button_beside_a_page() throws Exception {
		pagesMainPage.waitAndClickElement(pagesMainPage.btn_ActionDropdownByPageName("AclateQA"));
	}

	@Then("the actiion options are displayed")
	public void the_actiion_options_are_displayed() throws Exception {
		Assert.assertTrue(pagesMainPage.btn_ActivateActionOptByPageName("AclateQA").isDisplayed());
		Assert.assertTrue(pagesMainPage.btn_DeleteActionOptByPageName("AclateQA").isDisplayed());
	}

	@When("User clicks the Activate button option")
	public void user_clicks_the_Activate_button_option() throws Exception {
		pagesMainPage.waitAndClickElement(pagesMainPage.btn_ActivateActionOptByPageName("AclateQA"));
		activatePageModal.waitAndClickElement(activatePageModal.btn_Activate);
	}

	@Then("the page is activated successfully")
	public void the_page_is_activated_successfully() {
		Assert.assertTrue(pagesMainPage.lbl_Status("AclateQA", "Active").isDisplayed());
	}

//	Verify user is able to delete the page by clicking on delete button
	@When("User clicks the Delete button option")
	public void user_clicks_the_Delete_button_option() throws Exception {
		pagesMainPage.waitAndClickElement(pagesMainPage.btn_DeleteActionOptByPageName("AclateQA"));
		deletePageModal.waitAndClickElement(deletePageModal.btn_Delete);
	}

	@Then("the page is deleted successfully")
	public void the_page_is_deleted_successfully() throws Exception {
		/*
		 * boolean result = true; try {
		 * Assert.assertTrue(pagesMainPage.waitUntilElementDissapears(pagesMainPage.
		 * searchPageByPageName("AclateQA"))); } catch (NoSuchElementException NSE) {
		 * result = false; Assert.assertFalse(result); }
		 */
		System.out.println(pagesMainPage.isElementVisible(pagesMainPage.searchPageByNameLocator("AclateQA")));
		Assert.assertFalse(pagesMainPage.isElementVisible(pagesMainPage.searchPageByNameLocator("AclateQA")));
	}

}
