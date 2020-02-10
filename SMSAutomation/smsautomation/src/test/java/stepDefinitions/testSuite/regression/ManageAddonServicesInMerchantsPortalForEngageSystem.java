package stepDefinitions.testSuite.regression;

import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pageObjects.engage.EngageDashboardPage;
import pageObjects.engage.ManageSitesPage;
import pageObjects.license.AddOnGiftbarPage;
import pageObjects.license.AdvertisersPage;
import pageObjects.license.LicAdminPage;
import pageObjects.license.menu.AddOnServicesSubMenu;
import pageObjects.license.menu.MerchantMenu;
import utils.DriverFactory;
import utils.JsonConfigReader;

public class ManageAddonServicesInMerchantsPortalForEngageSystem extends DriverFactory {

	JsonConfigReader reader = new JsonConfigReader();

	AddOnServicesSubMenu addOnServicesSubMenu = PageFactory.initElements(driver, AddOnServicesSubMenu.class);
	AddOnGiftbarPage addOnGiftbarPage = PageFactory.initElements(driver, AddOnGiftbarPage.class);
	AdvertisersPage advertisersPage = PageFactory.initElements(driver, AdvertisersPage.class);
	EngageDashboardPage engDashboard = PageFactory.initElements(driver, EngageDashboardPage.class);
	LicAdminPage licAdminPage = PageFactory.initElements(driver, LicAdminPage.class);
	ManageSitesPage manageSitesPage = PageFactory.initElements(driver, ManageSitesPage.class);
	MerchantMenu merchantMenu = PageFactory.initElements(driver, MerchantMenu.class);
	
	
	@Then("User checks the page content \\(Title, list of Resellers, search and Status)")
	public void user_checks_the_page_content_Title_list_of_Resellers_search_and_Status() throws Exception {
		Assert.assertTrue(driver.getTitle().contentEquals("Engage Dashboard"));
		Assert.assertTrue(engDashboard.txtF_Search.isDisplayed());
		Assert.assertTrue(engDashboard.table_Reseller.isDisplayed());
	}

	@Then("User confirms the possibility to Copy to clipboard and export to csv")
	public void user_confirms_the_possibility_to_Copy_to_clipboard_and_export_to_csv() {
		Assert.assertTrue(engDashboard.btn_Copy.isDisplayed());
		Assert.assertTrue(engDashboard.btn_CSV.isDisplayed());
	}
	
	@Then("user is redirected to the manage site page")
	public void user_is_redirected_to_the_manage_site_page() throws Exception {
		Assert.assertTrue(manageSitesPage.getElementText(manageSitesPage.pag_Title).contentEquals("Manage Resellers"));
		Assert.assertTrue(manageSitesPage.SearchTxtF.isDisplayed());
		Assert.assertTrue(manageSitesPage.table_Reseller.isDisplayed());
		Assert.assertTrue(manageSitesPage.btn_Copy.isDisplayed());
		Assert.assertTrue(manageSitesPage.btn_CSV.isDisplayed());
	}

	@When("User clicks the Manage Resellers menubar option")
	public void user_clicks_the_Manage_Resellers_menubar_option() throws Exception {

		if (reader.getConfigValue("DriverConfig", "environment").equals("remoteHub")) {
			manageSitesPage.waitAndClickElement(manageSitesPage.tog_Navbar);
		}

		manageSitesPage.waitAndClickElement(manageSitesPage.menu_Manage_Resellers);
	}

	@When("User logs in to a reseller")
	public void user_logs_in_to_a_reseller() throws Exception {
		manageSitesPage.sendKeysToWebElement(manageSitesPage.SearchTxtF, "test");
		manageSitesPage.waitAndClickElement(manageSitesPage.loginAS("smsmmtest ", "SUPER"));
	}

	@And("User is redirected to the Engaged Admin Dashboard page")
	public void user_is_redirected_to_the_Engaged_Admin_Dashboard_page() throws Exception {
		manageSitesPage.switchWindow();
		Assert.assertEquals(manageSitesPage.getCurrentURL(), reader.getConfigValue("GeneralSettings", "licBaseURL"));
	}

	@Then("User clicks Business tabs at the left side")
	public void user_clicks_Business_tabs_at_the_left_side() throws Exception {
		/*
		 * if (reader.getConfigValue("DriverConfig", "environment").equals("localHub"))
		 * { licAdminPage.clickCloseUpdateStatusOfBusinesses();
		 * licAdminPage.waitForBusinessesDialogToDisappear(); }
		 */
		licAdminPage.waitAndClickElement(licAdminPage.menu_Businesses);
	}

	@Then("the merchants detailed information is listed")
	public void the_merchants_detailed_information_is_listed() throws Exception {
		Assert.assertTrue(advertisersPage.getElementText(advertisersPage.page_Heading).contentEquals("Businesses"));
	}

	@Then("Users click Login tab for a merchant")
	public void users_click_Login_tab_for_a_merchant() throws Exception {
		advertisersPage.waitAndClickElement(advertisersPage.getLoginBtnByBusinessContact("QA, Aclate"));
	}

	@Then("the user is redirected to a new window of Merchant's Dashboard")
	public void the_user_is_redirected_to_a_new_window_of_Merchant_s_Dashboard() {
		merchantMenu.switchWindow();
		Assert.assertEquals(manageSitesPage.getCurrentURL(), "https://www.smsmmtest.com/advertisercpanel/");
	}

	@Then("User verifies that Add-On Services menu is available")
	public void user_verifies_that_Add_On_Services_menu_is_available() throws Exception {
		Assert.assertTrue(
				merchantMenu.getElementText(merchantMenu.menu_Add_On_Services).contentEquals("Add-On Services"));
	}

	@Then("User clicks the Add-On Services menu option")
	public void user_clicks_the_Add_On_Services_menu_option() throws Exception {
		merchantMenu.waitAndClickElement(merchantMenu.menu_Add_On_Services);
	}

	@Then("the Giftbar menu option is displayed")
	public void the_Giftbar_menu_option_is_displayed() throws Exception {
		Assert.assertTrue(
				addOnServicesSubMenu.getElementText(addOnServicesSubMenu.menu_Giftbar).contentEquals("Giftbar"));
	}

	@When("User clicks the Giftbar menu option")
	public void user_clicks_the_Giftbar_menu_option() throws Exception {
		addOnServicesSubMenu.waitAndClickElement(addOnServicesSubMenu.menu_Giftbar);
	}

	@Then("the giftbar page is opened")
	public void the_giftbar_page_is_opened() throws Exception {
		Assert.assertTrue(addOnGiftbarPage.getElementText(addOnGiftbarPage.page_Title).contentEquals("Giftbar"));
	}

	@Then("User clicks the Interested button")
	public void user_clicks_the_Interested_button() throws Exception {
		addOnGiftbarPage.waitAndClickElement(addOnGiftbarPage.btn_Giftbar_Interested);
	}

	@Then("an interest notification is sent message is displayed")
	public void an_interest_notification_is_sent_message_is_displayed() throws Exception {
		Assert.assertTrue(addOnGiftbarPage.getElementText(addOnGiftbarPage.msg_Giftbar_Notification)
				.contentEquals("Thanks — a notification was sent about your interest!"));
	}

}
