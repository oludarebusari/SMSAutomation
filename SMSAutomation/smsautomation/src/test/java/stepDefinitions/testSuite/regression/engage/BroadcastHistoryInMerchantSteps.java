package stepDefinitions.testSuite.regression.engage;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import components.elements.CommonElementLocator;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.engage.BroadcastHistoryPage;
import pageObjects.license.menu.BroadCastSubMenu;
import pageObjects.license.menu.MerchantMenu;
import utils.DriverFactory;

public class BroadcastHistoryInMerchantSteps extends DriverFactory {

	BroadcastHistoryPage broadcastHistoryPage = PageFactory.initElements(driver, BroadcastHistoryPage.class);
	BroadCastSubMenu broadCastSubMenu = PageFactory.initElements(driver, BroadCastSubMenu.class);
	MerchantMenu merchantMenu = PageFactory.initElements(driver, MerchantMenu.class);
	CommonElementLocator commonElementLocator = PageFactory.initElements(driver, CommonElementLocator.class);

//	 @SMSM-125-Verify-that-user-is-redirected-to-new-windows-of-merchant's-dashboard-and-locate-the-Broadcast-menu
	@When("User clicks the broadcast option tab")
	public void user_clicks_the_broadcast_option_tab() throws Exception {
		merchantMenu.waitAndClickElement(merchantMenu.menu_Broadcasts);
	}

	@Then("the Broadcast menu is opened")
	public void the_Broadcast_menu_is_opened() throws InterruptedException {
		Assert.assertEquals("Broadcasts", broadCastSubMenu.getElementText(broadCastSubMenu.menu_Title));
	}

	@Then("User verifies the available option on the KHS of the page")
	public void user_verifies_the_available_option_on_the_KHS_of_the_page() {
		Assert.assertTrue(broadCastSubMenu.menu_CreateBroadcast.isDisplayed());
		Assert.assertTrue(broadCastSubMenu.menu_ManageBroadcasts.isDisplayed());
		Assert.assertTrue(broadCastSubMenu.menu_BroadcastHistory.isDisplayed());
	}

//	@SMSM-125-Verify-that-user-is-able-to-see-all-existing-broadcast-messages-(send-or-scheduled)-according-to-Date-Selected-in-Broadcast-History
	@When("User clicks on Broadcast History option")
	public void user_clicks_on_Broadcast_History_option() throws Exception {
		broadCastSubMenu.waitAndClickElement(broadCastSubMenu.menu_BroadcastHistory);
	}

	@Then("the User is redirected to the Broadcast History page")
	public void the_User_is_redirected_to_the_Broadcast_History_page() throws Exception {
		Assert.assertEquals("Broadcast History", broadcastHistoryPage.getElementText(broadcastHistoryPage.pag_Title));
	}

	@When("User clicks on Dates")
	public void user_clicks_on_Dates() throws InterruptedException {
		broadcastHistoryPage.waitAndClickElement(broadcastHistoryPage.lov_DatesDDown);
	}

	@Then("a list of Date options is displayed and verified by the user")
	public void a_list_of_Date_options_is_displayed_and_verified_by_the_user() {
		Assert.assertTrue(broadcastHistoryPage.dateOption("Today").isDisplayed());
		Assert.assertTrue(broadcastHistoryPage.dateOption("Yesterday").isDisplayed());
		Assert.assertTrue(broadcastHistoryPage.dateOption("Last 7 Days").isDisplayed());
		Assert.assertTrue(broadcastHistoryPage.dateOption("Last 30 Days").isDisplayed());
		Assert.assertTrue(broadcastHistoryPage.dateOption("This Month").isDisplayed());
		Assert.assertTrue(broadcastHistoryPage.dateOption("Last Month").isDisplayed());
		Assert.assertTrue(broadcastHistoryPage.dateOption("All data").isDisplayed());
		Assert.assertTrue(broadcastHistoryPage.dateOption("Custom Range").isDisplayed());
	}

	@When("User clicks on Date and Selects All Data and clicks apply button")
	public void user_clicks_on_Date_and_Selects_All_Data_and_clicks_apply_button() throws Exception {
		broadcastHistoryPage.waitAndClickElement(broadcastHistoryPage.dateOption("All data"));
	}

	@Then("all existing broadcast messages were displayed")
	public void all_existing_broadcast_messages_were_displayed() throws Exception, Exception {
		Thread.sleep(1000);
		System.out.println(broadcastHistoryPage.getElementText(broadcastHistoryPage.dataTableInfo).substring(8, 10));
		Assert.assertTrue(Integer.parseInt(
				broadcastHistoryPage.getElementText(broadcastHistoryPage.dataTableInfo).substring(8, 10)) > 0);
	}

}
