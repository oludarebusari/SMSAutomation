package stepDefinitions.testSuite.regression.thrive;

import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.en.Then;
import pageObjects.thrive.AdminDashboardPage;
import utils.DriverFactory;

public class AdminDashboardSteps extends DriverFactory {
	
	public AdminDashboardPage thrDashboardPage = PageFactory.initElements(driver, AdminDashboardPage.class);
	
//  @SMSM-203 @Verify-User-is-landed-on-AdminDashboard-page @RegressionTest
	@Then("User verifies the Dashboard title is available")
	public void user_verifies_the_Dashboard_title_is_available() {
		Assert.assertTrue(thrDashboardPage.pag_Title.isDisplayed());
	}

	@Then("user verifies the Reseller list is available")
	public void user_verifies_the_Reseller_list_is_available() throws NumberFormatException, InterruptedException {
		Assert.assertTrue(thrDashboardPage.list_Reseller.isDisplayed());
		Assert.assertTrue(Integer.parseInt(thrDashboardPage.getElementText(thrDashboardPage.num_Reseller)) > 0);
	}

	@Then("User verifies the Resellers tab is available")
	public void user_verifies_the_Resellers_tab_is_available() {
		Assert.assertTrue(thrDashboardPage.reseller_Summary.isDisplayed());
	}

	@Then("user verifies the Business tab is available")
	public void user_verifies_the_Business_tab_is_available() {
		Assert.assertTrue(thrDashboardPage.business_Summary.isDisplayed());
	}
	
	@Then("User verifies the Social Post is available")
	public void user_verifies_the_Social_Post_is_available() {
		Assert.assertTrue(thrDashboardPage.socialPost_Summary.isDisplayed());
	}

	@Then("User verifies the Revenue tab is available")
	public void user_verifies_the_Revenue_tab_is_available() {
		Assert.assertTrue(thrDashboardPage.revenue_Summary.isDisplayed());
	}

	@Then("User verifies the Help button is available")
	public void user_verifies_the_Help_button_is_available() {
	Assert.assertTrue(thrDashboardPage.btn_Help.isDisplayed());
	}
	
//	@SMSM-203 @Verify-all-reseller-data @RegressionTest
	@Then("User verifies company column is available")
	public void user_verifies_company_column_is_available() {
		Assert.assertTrue(thrDashboardPage.col_Company.isDisplayed());
	}

	@Then("user verifies Location column is available")
	public void user_verifies_Location_column_is_available() {
		Assert.assertTrue(thrDashboardPage.col_Locaton.isDisplayed());
	}

	@Then("User verifies Phone column is available")
	public void user_verifies_Phone_column_is_available() {
		Assert.assertTrue(thrDashboardPage.col_Phone.isDisplayed());
	}

	@Then("user verifies Support email column is available")
	public void user_verifies_Support_email_column_is_available() {
		Assert.assertTrue(thrDashboardPage.col_SupportEmail.isDisplayed());
	}

	@Then("User verifies Created date column is available")
	public void user_verifies_Created_date_column_is_available() {
		Assert.assertTrue(thrDashboardPage.col_Created.isDisplayed());
	}

	@Then("User verifies Action column is available")
	public void user_verifies_Action_column_is_available() {
		Assert.assertTrue(thrDashboardPage.col_Action.isDisplayed());
	}
	
}
