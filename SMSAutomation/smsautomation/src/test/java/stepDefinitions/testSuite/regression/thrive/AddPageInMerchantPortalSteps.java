package stepDefinitions.testSuite.regression.thrive;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import components.elements.CommonElementLocator;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.thrive.PagesConfigurationPage;
import pageObjects.thrive.PagesMainPage;
import pageObjects.thrive.Tab.ExperienceDDown;
import pageObjects.thrive.modal.CreatepagePage;
import pageObjects.thrive.modal.PageSettingsModal;
import pageObjects.thrive.modal.SaveChangesToPageModal;
import utils.DriverFactory;

public class AddPageInMerchantPortalSteps extends DriverFactory {

	public CommonElementLocator commonElementLocator = PageFactory.initElements(driver, CommonElementLocator.class);
	public CreatepagePage createpagePage = PageFactory.initElements(driver, CreatepagePage.class);
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
		Thread.sleep(900);
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

}
