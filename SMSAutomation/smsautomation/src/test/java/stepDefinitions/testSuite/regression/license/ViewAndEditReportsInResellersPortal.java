package stepDefinitions.testSuite.regression.license;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import components.elements.CommonElementLocator;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.BasePage;
import pageObjects.thrive.BusinessReportsPage;
import pageObjects.thrive.ResellerDashboardPage;
import pageObjects.thrive.Tab.CompaniesDDown;
import pageObjects.thrive.Tab.ReportsDDown;
import pageObjects.thrive.Tab.SettingsDDown;

public class ViewAndEditReportsInResellersPortal extends BasePage {

	public ViewAndEditReportsInResellersPortal() throws IOException {
		super();
	}

	BusinessReportsPage businessReportsPage = PageFactory.initElements(driver, BusinessReportsPage.class);
	CommonElementLocator commonElementLocator = PageFactory.initElements(driver, CommonElementLocator.class);
	CompaniesDDown companiesDDown = PageFactory.initElements(driver, CompaniesDDown.class);
	ResellerDashboardPage resellerDashboardPage = PageFactory.initElements(driver, ResellerDashboardPage.class);
	ReportsDDown reportsDDown = PageFactory.initElements(driver, ReportsDDown.class);
	SettingsDDown settingsDDown = PageFactory.initElements(driver, SettingsDDown.class);
	
	Actions action = new Actions(driver);
	
//	@Verify-that-user-is-able-to-see-2-options-on-reports-tab
	@When("User clicks on the Reports tab on top menu bar")
	public void user_clicks_on_the_Reports_tab_on_top_menu_bar() throws InterruptedException {
		commonElementLocator.waitAndClickElement(commonElementLocator.menu_Reports);
	}

	@Then("User confirms the options under the Report menu")
	public void user_confirms_the_options_under_the_Report_menu() throws Exception {
		Assert.assertTrue(reportsDDown.opt_Businesses.isDisplayed());
		Assert.assertTrue(reportsDDown.opt_Digital_Audit.isDisplayed());
	}
	
//	@Verify-that-User-is-able-to-Hover-the-mouse-on-merchants-(heading),-then-description-appears-for-that-particular-heading
	@When("User clicks on the Businesses option")
	public void user_clicks_on_the_Businesses_option() throws Exception {
	 reportsDDown.waitAndClickElement(reportsDDown.opt_Businesses);
	}
	
	@Then("the Businesses page is displayed")
	public void the_Businesses_page_is_displayed() throws Exception {
		Assert.assertEquals("Business Reports", commonElementLocator.getElementText(commonElementLocator.pag_Title));
	}
	
	@Then("User verifies that all businesses count as per the month")
	public void user_verifies_that_all_businesses_count_as_per_the_month() {
		Assert.assertTrue(businessReportsPage.col_ActiveBusinessess.isDisplayed());
		Assert.assertTrue(businessReportsPage.col_NewBusiness.isDisplayed());
		Assert.assertTrue(businessReportsPage.col_CanceledBusiness.isDisplayed());
		Assert.assertTrue(businessReportsPage.col_PeriodNetBusinesses.isDisplayed());
	}

	@When("User hovers over Active Merchants")
	public void user_hovers_over_Active_Merchants() {
		action.moveToElement(businessReportsPage.col_ActiveBusinessess).perform();
	}

	@Then("User is able to see Active Merchants description")
	public void user_is_able_to_see_Active_Merchants_description() throws InterruptedException {
		Assert.assertEquals(businessReportsPage.getACTIVEBUSINESSESDESCRIPTION(), businessReportsPage.getElementText(businessReportsPage.activeBusinessDescription));
	}
}
