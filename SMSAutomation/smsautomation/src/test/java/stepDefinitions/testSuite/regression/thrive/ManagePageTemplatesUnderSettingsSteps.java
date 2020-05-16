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
import utils.DriverFactory;

public class ManagePageTemplatesUnderSettingsSteps extends DriverFactory {
	
	
	public CommonElementLocator commonElementLocator = PageFactory.initElements(driver, CommonElementLocator.class);
	public CreatePageTemplatePage createPageTemplatePage = PageFactory.initElements(driver, CreatePageTemplatePage.class);
	public PagesConfigurationPage pagesConfigurationPage = PageFactory.initElements(driver, PagesConfigurationPage.class);
	public PageTemplatesPage pageTemplatesPage = PageFactory.initElements(driver, PageTemplatesPage.class);
	public SettingsDDown settingsDDown = PageFactory.initElements(driver, SettingsDDown.class);
	
	private String timeBeforeSave = "";
	
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
	public void the_next_page_on_the_pagination_buttons_is_highlighted() {
		Assert.assertTrue(commonElementLocator.pageButtonNumber("2").getAttribute("class").contains("active"));
	}

	@When("User Selects All from the drop down list")
	public void user_Selects_All_from_the_drop_down_list() throws Exception {
	  commonElementLocator.waitAndClickElement(commonElementLocator.lov_ShowEntries);
	}

	@Then("User verifies all the records are displayed on one page")
	public void user_verifies_all_the_records_are_displayed_on_one_page() {
		Assert.assertTrue(commonElementLocator.btn_PaginationNextDisabled.isDisplayed());
		Assert.assertTrue(commonElementLocator.btn_PaginationPreviousDisabled.isDisplayed());
		Assert.assertTrue(commonElementLocator.pageButtonNumber("1").isDisplayed());
		Assert.assertFalse(commonElementLocator.isElementVisible(commonElementLocator.getElementLocator(commonElementLocator.pageButtonNumber("2"))));
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
	
}
