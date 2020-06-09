package stepDefinitions.testSuite.regression.license;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import components.elements.CommonElementLocator;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.BasePage;
import pageObjects.thrive.AddAndEditPlansPage;
import pageObjects.thrive.ManagePlansPage;
import pageObjects.thrive.Tab.BillingDDown;

public class ManagePlanUnderBillingInResellerDashboard extends BasePage {

	public ManagePlanUnderBillingInResellerDashboard() throws IOException {
		super();
	}

	AddAndEditPlansPage addAndEditPlansPage = PageFactory.initElements(driver, AddAndEditPlansPage.class);
	BillingDDown billingDDown = PageFactory.initElements(driver, BillingDDown.class);
	CommonElementLocator commonElementLocator = PageFactory.initElements(driver, CommonElementLocator.class);
	ManagePlansPage managePlansPage = PageFactory.initElements(driver, ManagePlansPage.class);

	
//	@Navigate-to-"Manage-Plans"-under-Licensees's-dashboard-in-Thrive-system,-and-verify-admin-is-able-to-see-all-existing-Plans
	@When("User clicks on Plan option from the Billing drop down options")
	public void user_clicks_on_Plan_option_from_the_Billing_drop_down_options() throws Exception {
		billingDDown.waitAndClickElement(billingDDown.opt_Plans);
	}

	@Then("User is redirected to the Plan page")
	public void user_is_redirected_to_the_Plan_page() throws Exception {
		Assert.assertEquals("Manage Plans", commonElementLocator.getElementText(commonElementLocator.pag_Title));
	}
	
//	@Verify-Admin-is-able-to-edit-an-existing-plan-under-Resellers-dashboard-in-Thrive-System
	@When("User clicks the edit button besides a plan")
	public void user_clicks_the_edit_button_besides_a_plan() throws Exception {
	   managePlansPage.waitAndClickElement(managePlansPage.editBtn("AutoPlan"));
	}

	@Then("the Edit plan page is opened")
	public void the_Edit_plan_page_is_opened() throws Exception {
	   Assert.assertEquals("Edit %entity%", commonElementLocator.getElementText(commonElementLocator.pag_Title));
	}

	@Then("User edits the Plan name text value")
	public void user_edits_the_Plan_name_text_value() throws Exception {
		addAndEditPlansPage.sendKeysToWebElement(addAndEditPlansPage.txtF_PlanName, "AutoPlan - Edited");
	}

	@Then("User edits the Plan description text value")
	public void user_edits_the_Plan_description_text_value() throws Exception {
		addAndEditPlansPage.sendKeysToWebElement(addAndEditPlansPage.txtA_PlanDescription, "AutoDescription - Edited");
	}

	@Then("User edits Status value")
	public void user_edits_Status_value() throws Exception {
	    addAndEditPlansPage.clickOnTextFromDropdownList(addAndEditPlansPage.statusDDown, "Inactive");
	}

	@When("User clicks on the Save Plan button")
	public void user_clicks_on_the_Save_Plan_button() throws Exception {
	   addAndEditPlansPage.waitAndClickElement(addAndEditPlansPage.btn_SavePlan);
	}

	@Then("the update notification alert is displayed")
	public void the_update_notification_alert_is_displayed() throws Exception {
	   Assert.assertEquals("×\nClose\nItem has been successfully updated.", managePlansPage.getElementText(managePlansPage.txt_NotificationAlert));
	}

	@Then("User verifies the changes made.")
	public void user_verifies_the_changes_made() throws InterruptedException {
		Assert.assertTrue(managePlansPage.getCellValue("AutoPlan - Edited").isDisplayed());
		Assert.assertTrue(managePlansPage.getCellValue("AutoDescription - Edited").isDisplayed());
		Assert.assertTrue(managePlansPage.getCellValue("Inactive").isDisplayed());
	}
	
//	#Revert Changes made to Plans details
	@Then("User reverted changes made to plans details")
	public void user_reverted_changes_made_to_plans_details() throws Exception {
		managePlansPage.waitAndClickElement(managePlansPage.editBtn("AutoPlan - Edited"));
		addAndEditPlansPage.sendKeysToWebElement(addAndEditPlansPage.txtF_PlanName, "AutoPlan");
		addAndEditPlansPage.sendKeysToWebElement(addAndEditPlansPage.txtA_PlanDescription, "AutoDescription");
		addAndEditPlansPage.clickOnTextFromDropdownList(addAndEditPlansPage.statusDDown, "Active");;
	}
	
//  @Verify-Admin-is-able-to-edit-an-existing-Plan-and-Add-a-Feature-Under-Reseller's-dashboard-in-Thrive-System
	@Then("User clicks the add icon under feature to add a feature")
	public void user_clicks_the_add_icon_under_feature_to_add_a_feature() throws Exception {
	   addAndEditPlansPage.waitAndClickElement(addAndEditPlansPage.addFeatureTopBtn);
	}

	@Then("User enters feature, One-Time Price, Recurring Price and Start Date")
	public void user_enters_feature_One_Time_Price_Recurring_Price_and_Start_Date() throws Exception {
	  addAndEditPlansPage.waitAndClickElement(addAndEditPlansPage.featureDDown);
	  addAndEditPlansPage.waitAndClickElement(addAndEditPlansPage.selectFeature("Package Discount"));
	  addAndEditPlansPage.sendKeysToWebElement(addAndEditPlansPage.txtF_OneTimePrice, "120.00");
	  addAndEditPlansPage.sendKeysToWebElement(addAndEditPlansPage.txtF_RecurringPrice, "10.00");
	  addAndEditPlansPage.waitAndClickElement(addAndEditPlansPage.txtF_Date);
	  addAndEditPlansPage.waitAndClickElement(addAndEditPlansPage.activeDate);	
	}

	@When("User clicks the Save Plan button")
	public void user_clicks_the_Save_Plan_button() throws Exception {
	 addAndEditPlansPage.waitAndClickElement(addAndEditPlansPage.btn_SavePlan);
	}

	@Then("User verifies the added feature")
	public void user_verifies_the_added_feature() throws Exception {
	    managePlansPage.waitAndClickElement(managePlansPage.editBtn("AutoPlan"));
	    Assert.assertTrue(addAndEditPlansPage.feature("Package Discount").isDisplayed());
	    Assert.assertTrue(addAndEditPlansPage.txtF_OneTimePrice.getAttribute("value").contentEquals("120.00"));
	    Assert.assertTrue(addAndEditPlansPage.txtF_RecurringPrice.getAttribute("value").contentEquals("10.00"));
	    Assert.assertTrue(addAndEditPlansPage.txtF_Date.getAttribute("value").contentEquals(addAndEditPlansPage.getCURRENTDate()));
	}
	
	@Then("User removes the added feature")
	public void user_removes_the_added_feature() throws Exception {
	 addAndEditPlansPage.waitAndClickElement(addAndEditPlansPage.removeFeature("Package Discount"));
	 Thread.sleep(500);
	 addAndEditPlansPage.waitAndClickElement(addAndEditPlansPage.btn_SavePlan);
	}
}
