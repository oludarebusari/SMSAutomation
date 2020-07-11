package stepDefinitions.testSuite.regression.thrive;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import components.elements.CommonElementLocator;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.license.menu.LeadTrackingSubMenu;
import pageObjects.thrive.AppointmentsSetPage;
import pageObjects.thrive.EditUserPage;
import pageObjects.thrive.LeadsPage;
import pageObjects.thrive.LeadsStatusCorporationPage;
import pageObjects.thrive.OrdersPage;
import pageObjects.thrive.OverallAppointmentsSetPage;
import pageObjects.thrive.ResellerUsersPage;
import pageObjects.thrive.ThriveLoginPage;
import pageObjects.thrive.Tab.UsersDDown;
import utils.DriverFactory;

public class AccessToLeadTrackingResellerUserLevelSteps extends DriverFactory {

	
	AppointmentsSetPage appointmentsSetPage = PageFactory.initElements(driver, AppointmentsSetPage.class);
	CommonElementLocator commonElementLocator = PageFactory.initElements(driver, CommonElementLocator.class);
	EditUserPage editUserPage = PageFactory.initElements(driver, EditUserPage.class);
	LeadsPage leadsPage = PageFactory.initElements(driver, LeadsPage.class);
	LeadsStatusCorporationPage leadsStatusCorporationPage = PageFactory.initElements(driver, LeadsStatusCorporationPage.class);
	LeadTrackingSubMenu leadTrackingSubMenu = PageFactory.initElements(driver, LeadTrackingSubMenu.class);
	OrdersPage ordersPage = PageFactory.initElements(driver, OrdersPage.class);
	OverallAppointmentsSetPage overallAppointmentsSetPage = PageFactory.initElements(driver, OverallAppointmentsSetPage.class);
	ResellerUsersPage resellerUsersPage = PageFactory.initElements(driver, ResellerUsersPage.class);
	ThriveLoginPage thriveLoginPage = PageFactory.initElements(driver, ThriveLoginPage.class);
	UsersDDown usersDDown = PageFactory.initElements(driver, UsersDDown.class);

	String userRecord1 = "Automation";
	String userRecord2 = "Automod";
	
	@When("User clicks the User menu")
	public void user_clicks_the_User_menu() throws Exception {
		commonElementLocator.waitAndClickElement(commonElementLocator.menu_Users);
	}

	@Then("the User options are displayed")
	public void the_User_options_are_displayed() {
		Assert.assertTrue(usersDDown.opt_Admin.isDisplayed());
		Assert.assertTrue(usersDDown.opt_Resellers.isDisplayed());
		Assert.assertTrue(usersDDown.opt_Businesses.isDisplayed());
		Assert.assertTrue(usersDDown.opt_Permissions_Template.isDisplayed());
	}

	@When("User clicks on Resellers option from the User menu")
	public void user_clicks_on_Resellers_option_from_the_User_menu() throws Exception {
		usersDDown.waitAndClickElement(usersDDown.opt_Resellers);
	}

	@Then("User is redirected to the Reseller Users page")
	public void user_is_redirected_to_the_Reseller_Users_page() throws Exception {
		Assert.assertEquals("Reseller Users", commonElementLocator.getElementText(commonElementLocator.pag_Title));
	}

	@When("User clicks the edit option for a specific user record")
	public void user_clicks_the_edit_option_for_a_specific_user_record() throws Exception {
		resellerUsersPage.waitAndClickElement(resellerUsersPage.userDDown(userRecord1));
		resellerUsersPage.waitAndClickElement(resellerUsersPage.editAction(userRecord1));
	}

	@Then("User is redirected to the Edit User page")
	public void user_is_redirected_to_the_Edit_User_page() throws Exception {
		Assert.assertEquals("Edit User", commonElementLocator.getElementText(commonElementLocator.pag_Title));
	}

//	@Section2.3.1.2 @Lead-Tracking-Permissions:-Reseller-User-Level:-Displayed-Objects-Verification
	@Then("User verifies the permissions listed on the Lead Tracking permission section")
	public void user_verifies_the_permissions_listed_on_the_Lead_Tracking_permission_section() {
		Assert.assertTrue(editUserPage.lbl_CreateUpdateOrders.isDisplayed());
		Assert.assertTrue(editUserPage.lbl_ManageLeads.isDisplayed());
		Assert.assertTrue(editUserPage.lbl_ViewAppointments.isDisplayed());
	}

	@Then("User verifies each permission has AllowDeny toggle switch")
	public void user_verifies_each_permission_has_AllowDeny_toggle_switch() throws Exception {
		Assert.assertTrue(editUserPage.tog_CreateUpdateOrders.isDisplayed());
		Assert.assertTrue(editUserPage.tog_ManageLeads.isDisplayed());
		Assert.assertTrue(editUserPage.tog_ViewAppointments.isDisplayed());
	}

//	@Section2.3.1.2 @Lead-Tracking-Permissions:-Reseller-User-Level:-Enable-Option
	@Then("User verifies the states of the Lead Tracking toggles")
	public void user_verifies_the_states_of_the_Lead_Tracking_toggles() throws Exception {
		Assert.assertEquals("Deny", editUserPage.getElementText(editUserPage.tog_Deny_CreateUpdateOrders()));
		Assert.assertEquals("Allow", editUserPage.getElementText(editUserPage.tog_Allow_ManageLeads()));
		Assert.assertEquals("Deny", editUserPage.getElementText(editUserPage.tog_Deny_ViewAppointments()));
	}

	@When("User clicks the Enable button above the Lead tracking permissions")
	public void user_clicks_the_Enable_button_above_the_Lead_tracking_permissions() throws Exception {
		editUserPage.waitAndClickElement(editUserPage.leadPermissionEnable);
	}

	@Then("User verifies that the state for all the permission changes to Allow")
	public void user_verifies_that_the_state_for_all_the_permission_changes_to_Allow() throws InterruptedException {
		Assert.assertEquals("Allow", editUserPage.getElementText(editUserPage.tog_Allow_CreateUpdateOrders()));
		Assert.assertEquals("Allow", editUserPage.getElementText(editUserPage.tog_Allow_ManageLeads()));
		Assert.assertEquals("Allow", editUserPage.getElementText(editUserPage.tog_Allow_ViewAppointments()));
	}

	@When("User clicks the Enable option again")
	public void user_clicks_the_Enable_option_again() throws InterruptedException {
		editUserPage.waitAndClickElement(editUserPage.leadPermissionEnable);
	}

	@Then("User verifies that there was no changes to the permission settings")
	public void user_verifies_that_there_was_no_changes_to_the_permission_settings() throws Exception {
		Assert.assertEquals("Allow", editUserPage.getElementText(editUserPage.tog_Allow_CreateUpdateOrders()));
		Assert.assertEquals("Allow", editUserPage.getElementText(editUserPage.tog_Allow_ManageLeads()));
		Assert.assertEquals("Allow", editUserPage.getElementText(editUserPage.tog_Allow_ViewAppointments()));
	}

	@When("User clicks the Save Reseller button to Save the record")
	public void user_clicks_the_Save_Reseller_button_to_Save_the_record() throws Exception {
		editUserPage.waitAndClickElement(editUserPage.btn_SaveUser);
	}

	@When("User queries the same User record")
	public void user_queries_the_same_User_record() throws Exception {
		commonElementLocator.waitAndClickElement(commonElementLocator.menu_Users);
		usersDDown.waitAndClickElement(usersDDown.opt_Resellers);
		resellerUsersPage.waitAndClickElement(resellerUsersPage.userDDown(userRecord1));
		resellerUsersPage.waitAndClickElement(resellerUsersPage.editAction(userRecord1));
	}

	@Then("User verifies that all Lead Tracking permissions are set to Allow")
	public void user_verifies_that_all_Lead_Tracking_permissions_are_set_to_Allow() throws InterruptedException {
		Assert.assertEquals("Allow", editUserPage.getElementText(editUserPage.tog_Allow_CreateUpdateOrders()));
		Assert.assertEquals("Allow", editUserPage.getElementText(editUserPage.tog_Allow_ManageLeads()));
		Assert.assertEquals("Allow", editUserPage.getElementText(editUserPage.tog_Allow_ViewAppointments()));
	}

	@When("User makes changes to the Lead Tracking permission")
	public void user_makes_changes_to_the_Lead_Tracking_permission() throws Exception {
		editUserPage.waitAndClickElement(editUserPage.tog_Deny_ManageLeads());
		editUserPage.waitAndClickElement(editUserPage.tog_Deny_ViewAppointments());
	}

	@When("User navigates away from the page without saving")
	public void user_navigates_away_from_the_page_without_saving() throws Exception {
		commonElementLocator.waitAndClickElement(commonElementLocator.menu_Dashboard);
	}

	@Then("User verifies that the changes made to Lead Tracking permission were not saved")
	public void user_verifies_that_the_changes_made_to_Lead_Tracking_permission_were_not_saved() throws Exception {
		Assert.assertEquals("Allow", editUserPage.getElementText(editUserPage.tog_Allow_CreateUpdateOrders()));
		Assert.assertEquals("Allow", editUserPage.getElementText(editUserPage.tog_Allow_ManageLeads()));
		Assert.assertEquals("Allow", editUserPage.getElementText(editUserPage.tog_Allow_ViewAppointments()));
	}

//	#Revert Lead Tracking Permissions to it's original state
	@Then("User reverts changes to the Lead Tracking permissions")
	public void user_reverts_changes_to_the_Lead_Tracking_permissions() throws Exception {
		editUserPage.waitAndClickElement(editUserPage.tog_CreateUpdateOrders);
		editUserPage.waitAndClickElement(editUserPage.tog_ViewAppointments);
		editUserPage.waitAndClickElement(editUserPage.btn_SaveUser);
	}

//	@Section2.3.1.2 @Lead-Tracking-Permissions:-Reseller-User-Level:-Disable-Option 
	@Then("User vrifies the states of the Lead Tracking toggles")
	public void user_vrifies_the_states_of_the_Lead_Tracking_toggles() throws Exception {
		Assert.assertEquals("Deny", editUserPage.getElementText(editUserPage.tog_Deny_CreateUpdateOrders()));
		Assert.assertEquals("Allow", editUserPage.getElementText(editUserPage.tog_Allow_ManageLeads()));
		Assert.assertEquals("Deny", editUserPage.getElementText(editUserPage.tog_Deny_ViewAppointments()));
	}

	@When("User clicks the Disable button above the Lead Tracking permissions")
	public void user_clicks_the_Disable_button_above_the_Lead_Tracking_permissions() throws Exception {
		editUserPage.waitAndClickElement(editUserPage.leadPermissionDisable);
	}

	@Then("User verifies that the state for all the permission changes to Deny")
	public void user_verifies_that_the_state_for_all_the_permission_changes_to_Deny() throws Exception {
		Assert.assertEquals("Deny", editUserPage.getElementText(editUserPage.tog_Deny_CreateUpdateOrders()));
		Assert.assertEquals("Deny", editUserPage.getElementText(editUserPage.tog_Deny_ManageLeads()));
		Assert.assertEquals("Deny", editUserPage.getElementText(editUserPage.tog_Deny_ViewAppointments()));
	}

	@When("User clicks the Disable option again")
	public void user_clicks_the_Disable_option_again() throws Exception {
		editUserPage.waitAndClickElement(editUserPage.leadPermissionDisable);
	}

	@Then("User verifies that the permission settings were not changed")
	public void user_verifies_that_the_permission_settings_were_not_changed() throws InterruptedException {
		Assert.assertEquals("Deny", editUserPage.getElementText(editUserPage.tog_Deny_CreateUpdateOrders()));
		Assert.assertEquals("Deny", editUserPage.getElementText(editUserPage.tog_Deny_ManageLeads()));
		Assert.assertEquals("Deny", editUserPage.getElementText(editUserPage.tog_Deny_ViewAppointments()));
	}

	@Then("User verifies that all Lead Tracking permissions are set to Deny")
	public void user_verifies_that_all_Lead_Tracking_permissions_are_set_to_Deny() throws Exception {
		Assert.assertEquals("Deny", editUserPage.getElementText(editUserPage.tog_Deny_CreateUpdateOrders()));
		Assert.assertEquals("Deny", editUserPage.getElementText(editUserPage.tog_Deny_ManageLeads()));
		Assert.assertEquals("Deny", editUserPage.getElementText(editUserPage.tog_Deny_ViewAppointments()));
	}

	@When("User modifies the Lead Tracking permissions")
	public void user_modifies_the_Lead_Tracking_permissions() throws Exception {
		editUserPage.waitAndClickElement(editUserPage.tog_Deny_ManageLeads());
		editUserPage.waitAndClickElement(editUserPage.tog_Deny_ViewAppointments());
	}

	@Then("User verifies that the modifications to Lead Tracking permission were not saved")
	public void user_verifies_that_the_modifications_to_Lead_Tracking_permission_were_not_saved() throws Exception {
		Assert.assertEquals("Deny", editUserPage.getElementText(editUserPage.tog_Deny_CreateUpdateOrders()));
		Assert.assertEquals("Deny", editUserPage.getElementText(editUserPage.tog_Deny_ManageLeads()));
		Assert.assertEquals("Deny", editUserPage.getElementText(editUserPage.tog_Deny_ViewAppointments()));
	}

//	 #Revert Lead Tracking Permissions to it's original state
	@Then("User reverts changes to the Lead Tracking permissions to it's original state")
	public void user_reverts_changes_to_the_Lead_Tracking_permissions_to_it_s_original_state()
			throws InterruptedException {
		editUserPage.waitAndClickElement(editUserPage.tog_ManageLeads);
		editUserPage.waitAndClickElement(editUserPage.btn_SaveUser);
	}

//	@Lead-Tracking-Permissions:-Reseller-User-Level:-Enable/Disable-Create/Update-Orders-Permission
	@Then("User verifies the state of the Create-Update Orders permission")
	public void user_verifies_the_state_of_the_Create_Update_Orders_permission() throws Exception {
		Assert.assertEquals("Deny", editUserPage.getElementText(editUserPage.tog_Deny_CreateUpdateOrders()));
	}

	@When("User clicks on the Create-Update orders toggle")
	public void user_clicks_on_the_Create_Update_orders_toggle() throws Exception {
		editUserPage.waitAndClickElement(editUserPage.tog_CreateUpdateOrders);
	}

	@Then("User verifies the state of Create-Update order toggle after first click")
	public void user_verifies_the_state_of_Create_Update_order_toggle_after_first_click() throws Exception {
		Assert.assertEquals("Allow", editUserPage.getElementText(editUserPage.tog_Allow_CreateUpdateOrders()));
	}

	@When("User clicks the Create-Update Orders toggle again")
	public void user_clicks_the_Create_Update_Orders_toggle_again() throws Exception {
		editUserPage.waitAndClickElement(editUserPage.tog_CreateUpdateOrders);
	}

	@Then("User verifies the state of Create-Update order toggle after the second click")
	public void user_verifies_the_state_of_Create_Update_order_toggle_after_the_second_click() throws Exception {
		Assert.assertEquals("Deny", editUserPage.getElementText(editUserPage.tog_Deny_CreateUpdateOrders()));
	}

	@When("User updates the Create-Update Orders permission to Allow")
	public void user_updates_the_Create_Update_Orders_permission_to_Allow() throws Exception {
		editUserPage.waitAndClickElement(editUserPage.tog_CreateUpdateOrders);
	}

	@Then("User verifies that Create-Update Orders permission is set to Allow")
	public void user_verifies_that_Create_Update_Orders_permission_is_set_to_Allow() throws Exception {
		Assert.assertEquals("Allow", editUserPage.getElementText(editUserPage.tog_Allow_CreateUpdateOrders()));
	}

	@When("User updates the Create-Update Orders permission to Deny")
	public void user_updates_the_Create_Update_Orders_permission_to_Deny() throws Exception {
		editUserPage.waitAndClickElement(editUserPage.tog_CreateUpdateOrders);
	}

	@Then("User verifies that Create-Update Orders permission is set to Deny")
	public void user_verifies_that_Create_Update_Orders_permission_is_set_to_Deny() throws Exception {
		Assert.assertEquals("Deny", editUserPage.getElementText(editUserPage.tog_Deny_CreateUpdateOrders()));
	}

//	@Lead-Tracking-Permissions:-Reseller-User-Level:-Enable/Disable-Manage-Leads-Permission
	@Then("User verifies the state of the Manage Leads permission")
	public void user_verifies_the_state_of_the_Manage_Leads_permission() throws InterruptedException {
		Assert.assertEquals("Allow", editUserPage.getElementText(editUserPage.tog_Allow_ManageLeads()));
	}

	@When("User clicks on the Manage Leads toggle")
	public void user_clicks_on_the_Manage_Leads_toggle() throws InterruptedException {
		editUserPage.waitAndClickElement(editUserPage.tog_ManageLeads);
	}

	@Then("User verifies the state of Manage Leads toggle after first click")
	public void user_verifies_the_state_of_Manage_Leads_toggle_after_first_click() throws Exception {
		Assert.assertEquals("Deny", editUserPage.getElementText(editUserPage.tog_Deny_ManageLeads()));
	}

	@When("User clicks the Manage Leads toggle again")
	public void user_clicks_the_Manage_Leads_toggle_again() throws InterruptedException {
		editUserPage.waitAndClickElement(editUserPage.tog_ManageLeads);
	}

	@Then("User verifies the state of Manage Leads toggle after the second click")
	public void user_verifies_the_state_of_Manage_Leads_toggle_after_the_second_click() throws Exception {
		Assert.assertEquals("Allow", editUserPage.getElementText(editUserPage.tog_Allow_ManageLeads()));
	}

	@Then("User verifies that Manage Leads permission is set to Allow")
	public void user_verifies_that_Manage_Leads_permission_is_set_to_Allow() throws Exception {
		Assert.assertEquals("Allow", editUserPage.getElementText(editUserPage.tog_Allow_ManageLeads()));
	}

	@When("User updates the Manage Leads permission to Deny")
	public void user_updates_the_Manage_Leads_permission_to_Deny() throws Exception {
		editUserPage.waitAndClickElement(editUserPage.tog_ManageLeads);
	}

	@Then("User verifies that Manage Leads permission is set to Deny")
	public void user_verifies_that_Manage_Leads_permission_is_set_to_Deny() throws Exception {
		Assert.assertEquals("Deny", editUserPage.getElementText(editUserPage.tog_Deny_ManageLeads()));
	}

	@When("User updates the Manage Leads permission to Allow")
	public void user_updates_the_Manage_Leads_permission_to_Allow() throws Exception {
		editUserPage.waitAndClickElement(editUserPage.tog_ManageLeads);
	}

//	#Revert Manage Leads Permission to it's original state
	@Then("User reverts changes to Manage Leads permission to it's original state")
	public void user_reverts_changes_to_Manage_Leads_permission_to_it_s_original_state() throws InterruptedException {
		editUserPage.waitAndClickElement(editUserPage.tog_ManageLeads);
		editUserPage.waitAndClickElement(editUserPage.btn_SaveUser);
	}

//	@Lead-Tracking-Permissions:-Reseller-User-Level:-Enable/Disable-View-Appointments-Permission
	@Then("User verifies the state of the View Appointments permission")
	public void user_verifies_the_state_of_the_View_Appointments_permission() throws Exception {
		Assert.assertEquals("Deny", editUserPage.getElementText(editUserPage.tog_Deny_ViewAppointments()));
	}

	@When("User clicks on the View Appointment toggle")
	public void user_clicks_on_the_View_Appointment_toggle() {
		editUserPage.waitAndclickElementUsingJS(editUserPage.tog_ViewAppointments);
	}

	@Then("User verifies the state of View Appointment toggle after first click")
	public void user_verifies_the_state_of_View_Appointment_toggle_after_first_click() throws Exception {
		Assert.assertEquals("Allow", editUserPage.getElementText(editUserPage.tog_Allow_ViewAppointments()));
	}

	@When("User clicks the View Appointment toggle again")
	public void user_clicks_the_View_Appointment_toggle_again() throws Exception {
		editUserPage.waitAndClickElement(editUserPage.tog_ViewAppointments);
	}

	@Then("User verifies the state of View Appointment toggle after the second click")
	public void user_verifies_the_state_of_View_Appointment_toggle_after_the_second_click() throws Exception {
		Assert.assertEquals("Deny", editUserPage.getElementText(editUserPage.tog_Deny_ViewAppointments()));
	}

	@When("User updates the View Appointments permission to Allow")
	public void user_updates_the_View_Appointments_permission_to_Allow() throws Exception {
		editUserPage.waitAndClickElement(editUserPage.tog_ViewAppointments);
	}

	@Then("User verifies that View Appointments permission is set to Allow")
	public void user_verifies_that_View_Appointments_permission_is_set_to_Allow() throws Exception {
		Assert.assertEquals("Allow", editUserPage.getElementText(editUserPage.tog_Allow_ViewAppointments()));
	}

	@When("User updates the View Appointments permission to Deny")
	public void user_updates_the_View_Appointments_permission_to_Deny() throws Exception {
		editUserPage.waitAndClickElement(editUserPage.tog_ViewAppointments);
	}

	@Then("User verifies that View Appointments permission is set to Deny")
	public void user_verifies_that_View_Appointments_permission_is_set_to_Deny() throws Exception {
		Assert.assertEquals("Deny", editUserPage.getElementText(editUserPage.tog_Deny_ViewAppointments()));
	}

//	@Lead-Tracking-Permissions:-Reseller-User-Level:-Create/Update-Orders-Permissions-Functional-Test
	@When("User clicks the edit option of a User")
	public void user_clicks_the_edit_option_of_a_User() throws Exception {
		resellerUsersPage.waitAndClickElement(resellerUsersPage.userDDown(userRecord2));
		resellerUsersPage.waitAndClickElement(resellerUsersPage.editAction(userRecord2));
	}

	@Then("User clicks on the Create-Update toggle")
	public void user_clicks_on_the_Create_Update_toggle() throws Exception {
		editUserPage.waitAndClickElement(editUserPage.tog_CreateUpdateOrders);
	}

	@Then("User verifies the states of the toggle")
	public void user_verifies_the_states_of_the_toggle() throws InterruptedException {
		Assert.assertEquals("Allow", editUserPage.getElementText(editUserPage.tog_Allow_CreateUpdateOrders()));
		Assert.assertEquals("Deny", editUserPage.getElementText(editUserPage.tog_Deny_ManageLeads()));
		Assert.assertEquals("Deny", editUserPage.getElementText(editUserPage.tog_Deny_ViewAppointments()));
	}

	@Then("User saves the user record")
	public void user_saves_the_user_record() throws Exception {
		editUserPage.waitAndClickElement(editUserPage.btn_SaveUser);
	}

	@When("Non Admin User sign In")
	public void non_Admin_User_sign_In() throws Exception {
		commonElementLocator.waitAndClickElement(commonElementLocator.loginAccountDDown);
		commonElementLocator.waitAndClickElement(commonElementLocator.btn_SignOut);
		thriveLoginPage.sendKeysToWebElement(thriveLoginPage.txtF_UserName, "aut@mmd.com");
		thriveLoginPage.sendKeysToWebElement(thriveLoginPage.txtF_PassWord, "QA@vnet1");
		thriveLoginPage.waitAndClickElement(thriveLoginPage.btn_SignIn);
	}

	@Then("the non admin User is redirected to the Reseller Dashboard page")
	public void the_non_admin_User_is_redirected_to_the_Reseller_Dashboard_page() throws Exception {
		 Assert.assertEquals("Dashboard", commonElementLocator.getElementText(commonElementLocator.pag_Title));
	}

	@When("the non admin User clicks the Lead Tracking menu")
	public void the_non_admin_User_clicks_the_Lead_Tracking_menu() throws Exception {
		  commonElementLocator.waitAndClickElement(commonElementLocator.menu_LeadTracking);
	}

	@Then("the non Admin User verifies the only option displayed is Orders")
	public void the_non_Admin_User_verifies_the_only_option_displayed_is_Orders() {
		Assert.assertTrue(leadTrackingSubMenu.menu_Orders.isDisplayed());
		Assert.assertFalse(leadTrackingSubMenu.isElementVisible(leadTrackingSubMenu.getElementLocator(leadTrackingSubMenu.menu_LeadsByAppointment)));
		Assert.assertFalse(leadTrackingSubMenu.isElementVisible(leadTrackingSubMenu.getElementLocator(leadTrackingSubMenu.menu_DoNotCallList)));
	}

	@When("the non admin User clicks the Orders Menu")
	public void the_non_admin_User_clicks_the_Orders_Menu() throws Exception {
		 leadTrackingSubMenu.waitAndClickElement(leadTrackingSubMenu.menu_Orders);
	}

	@Then("the Orders list page is displayed")
	public void the_Orders_list_page_is_displayed() throws Exception {
		Assert.assertEquals("Orders", commonElementLocator.getElementText(commonElementLocator.pag_Title));
	}
	
	@Then("non admin User verifies access to Edit an Order")
	public void non_admin_User_verifies_access_to_Edit_an_Order() throws Exception {
		Assert.assertTrue(ordersPage.isElementClickable(ordersPage.btn_Edit("1222")));
	}

	@When("the non admin User clicks on the New button")
	public void the_non_admin_User_clicks_on_the_New_button() throws Exception {
		commonElementLocator.waitAndClickElement(commonElementLocator.btn_New);
	}

	@Then("non admin User is redirected to the Create Order page")
	public void non_admin_User_is_redirected_to_the_Create_Order_page() throws InterruptedException {
		Assert.assertEquals("Create Order", commonElementLocator.getElementText(commonElementLocator.pag_Title));
	}
	
//	 #Admin User reverts changes to Create-Update Order
	@Then("User signs out as non admin user")
	public void user_signs_out_as_non_admin_user() throws Exception {
		commonElementLocator.waitAndClickElement(commonElementLocator.loginAccountDDown);
		commonElementLocator.waitAndClickElement(commonElementLocator.btn_SignOut);
	}

	@Then("User selects the Reseller and reverses the change to Create-Update Order")
	public void user_selects_the_Reseller_and_reverses_the_change_to_Create_Update_Order() throws Exception {
		commonElementLocator.sendKeysToWebElement(commonElementLocator.txtF_Search, userRecord2);
		commonElementLocator.waitAndClickElement(commonElementLocator.btn_Search);
		resellerUsersPage.waitAndClickElement(resellerUsersPage.userDDown(userRecord2));
		resellerUsersPage.waitAndClickElement(resellerUsersPage.editAction(userRecord2));
		editUserPage.waitAndClickElement(editUserPage.tog_CreateUpdateOrders);
		editUserPage.waitAndClickElement(editUserPage.btn_SaveUser);
	}
	
//	@Lead-Tracking-Permissions:-Reseller-User-Level:-Manage-Leads-Permission-Functional-Test
	@Then("User verifies the states of the toggles after Manage leads is set to Allow")
	public void user_verifies_the_states_of_the_toggles_after_Manage_leads_is_set_to_Allow() throws InterruptedException {
		Assert.assertEquals("Deny", editUserPage.getElementText(editUserPage.tog_Deny_CreateUpdateOrders()));
		Assert.assertEquals("Allow", editUserPage.getElementText(editUserPage.tog_Allow_ManageLeads()));
		Assert.assertEquals("Deny", editUserPage.getElementText(editUserPage.tog_Deny_ViewAppointments()));
	}

	@Then("the non Admin User verifies the options displayed")
	public void the_non_Admin_User_verifies_the_options_displayed() throws Exception {
		Assert.assertEquals("Orders", leadTrackingSubMenu.getElementText(leadTrackingSubMenu.menu_Orders));
		Assert.assertEquals("Leads By Appointment", leadTrackingSubMenu.getElementText(leadTrackingSubMenu.menu_LeadsByAppointment));
		Assert.assertEquals("Do Not Call List", leadTrackingSubMenu.getElementText(leadTrackingSubMenu.menu_DoNotCallList));
	}

	@Then("non admin User verifies View Leads is displayed for all records")
	public void non_admin_User_verifies_View_Leads_is_displayed_for_all_records() throws Exception {
	Assert.assertEquals(10, ordersPage.getNumberOfElements(ordersPage.getVIEWLEADSLOCATOR()));
	}

	@Then("non admin user verifies that New and Edit buttons are not displayed")
	public void non_admin_user_verifies_that_New_and_Edit_buttons_are_not_displayed() throws Exception {
		Assert.assertEquals(0, ordersPage.getNumberOfElements(ordersPage.getEDITLOCATOR()));
		Assert.assertFalse(commonElementLocator.isElementVisible(commonElementLocator.getElementLocator(commonElementLocator.btn_New)));
	}

	@When("non admin user clicks on the View Leads button for an existing order")
	public void non_admin_user_clicks_on_the_View_Leads_button_for_an_existing_order() throws InterruptedException {
	  ordersPage.waitAndClickElement(ordersPage.btn_ViewLeads("1222"));
	}

	@Then("the Leads page is displayed")
	public void the_Leads_page_is_displayed() throws Exception {
		Assert.assertEquals("Leads", commonElementLocator.getElementText(commonElementLocator.pag_Title));
	}

	@When("non admin user clicks the Lead button for one of the leads listed")
	public void non_admin_user_clicks_the_Lead_button_for_one_of_the_leads_listed() throws Exception {
		leadsPage.waitAndClickElement(leadsPage.btn_Open("Downtown Thrift"));
	}

	@Then("the Lead Management page is displayed")
	public void the_Lead_Management_page_is_displayed() throws InterruptedException {
		Assert.assertEquals("Status: Corporation", commonElementLocator.getElementText(commonElementLocator.pag_Title));
	}

	@Then("non admin user verifies that the Lead Information is displayed on the Lead Management Page")
	public void non_admin_user_verifies_that_the_Lead_Information_is_displayed_on_the_Lead_Management_Page() {
		Assert.assertTrue(leadsStatusCorporationPage.panel_LeadItem.isDisplayed());
	}

	@Then("non admin user verifies a clickable phone number is displayed")
	public void non_admin_user_verifies_a_clickable_phone_number_is_displayed() {
		Assert.assertTrue(leadsStatusCorporationPage.isElementClickable(leadsStatusCorporationPage.btn_CallLead));
	}

//	  #Admin User reverts changes to Manage Leads
	@Then("User selects the Reseller and reverses the change to Manage Leads")
	public void user_selects_the_Reseller_and_reverses_the_change_to_Manage_Leads() throws Exception {
		commonElementLocator.sendKeysToWebElement(commonElementLocator.txtF_Search, userRecord2);
		commonElementLocator.waitAndClickElement(commonElementLocator.btn_Search);
		resellerUsersPage.waitAndClickElement(resellerUsersPage.userDDown(userRecord2));
		resellerUsersPage.waitAndClickElement(resellerUsersPage.editAction(userRecord2));
		editUserPage.waitAndClickElement(editUserPage.tog_ManageLeads);
		editUserPage.waitAndClickElement(editUserPage.btn_SaveUser);
	}

//	@Lead-Tracking-Permissions:-Reseller-User-Level:-View-Appointments-Permission-Functional-Test
	@Then("User clicks on the View Appointments toggle")
	public void user_clicks_on_the_View_Appointments_toggle() throws InterruptedException {
		editUserPage.waitAndClickElement(editUserPage.tog_ViewAppointments);
	}

	@Then("User verifies the states of the toggles after View Appointments is set to Allow")
	public void user_verifies_the_states_of_the_toggles_after_View_Appointments_is_set_to_Allow() throws InterruptedException {
		Assert.assertEquals("Deny", editUserPage.getElementText(editUserPage.tog_Deny_CreateUpdateOrders()));
		Assert.assertEquals("Deny", editUserPage.getElementText(editUserPage.tog_Deny_ManageLeads()));
		Assert.assertEquals("Allow", editUserPage.getElementText(editUserPage.tog_Allow_ViewAppointments()));
	}

	@Then("the non Admin User verifies the only Leads By Appointment menu item is displayed")
	public void the_non_Admin_User_verifies_the_only_Leads_By_Appointment_menu_item_is_displayed() {
		Assert.assertTrue(leadTrackingSubMenu.menu_LeadsByAppointment.isDisplayed());
		Assert.assertFalse(leadTrackingSubMenu.isElementVisible(leadTrackingSubMenu.getElementLocator(leadTrackingSubMenu.menu_Orders)));
		Assert.assertFalse(leadTrackingSubMenu.isElementVisible(leadTrackingSubMenu.getElementLocator(leadTrackingSubMenu.menu_DoNotCallList)));
	}

	@When("the non admin User clicks the Leads By Appointment menu")
	public void the_non_admin_User_clicks_the_Leads_By_Appointment_menu() throws InterruptedException {
		leadTrackingSubMenu.waitAndClickElement(leadTrackingSubMenu.menu_LeadsByAppointment);
	}

	@Then("the Overall Appointments Set list page is displayed")
	public void the_Overall_Appointments_Set_list_page_is_displayed() throws Exception {
		Assert.assertEquals("Overall Appointments Set", commonElementLocator.getElementText(commonElementLocator.pag_Title));
	}

	@Then("the non admin user sets a date range")
	public void the_non_admin_user_sets_a_date_range() throws Exception {
		overallAppointmentsSetPage.sendKeysToWebElement(overallAppointmentsSetPage.txtF_LeadFilterRange, "06/01/2020 12:00 AM to 06/30/2020 11:59 PM");
		overallAppointmentsSetPage.waitAndClickElement(overallAppointmentsSetPage.btn_Apply);
	}

	@When("the non admin user clicks on the open button for an existing Appointment")
	public void the_non_admin_user_clicks_on_the_open_button_for_an_existing_Appointment() throws InterruptedException {
		overallAppointmentsSetPage.waitAndClickElement(overallAppointmentsSetPage.btn_Open("AMC Bakersfield 6"));
	}

	@Then("the Appointment Management page is displayed")
	public void the_Appointment_Management_page_is_displayed() throws Exception {
	Assert.assertTrue(commonElementLocator.getElementText(commonElementLocator.pag_Title).contains("Appointment Set"));
	}
	
//	 #Admin User reverts changes to View Appointments
	@Then("User selects the Reseller and reverses the change to View Appointments")
	public void user_selects_the_Reseller_and_reverses_the_change_to_View_Appointments() throws Exception {
		commonElementLocator.sendKeysToWebElement(commonElementLocator.txtF_Search, userRecord2);
		commonElementLocator.waitAndClickElement(commonElementLocator.btn_Search);
		resellerUsersPage.waitAndClickElement(resellerUsersPage.userDDown(userRecord2));
		resellerUsersPage.waitAndClickElement(resellerUsersPage.editAction(userRecord2));
		editUserPage.waitAndClickElement(editUserPage.tog_ViewAppointments);
		editUserPage.waitAndClickElement(editUserPage.btn_SaveUser);
	}

}
