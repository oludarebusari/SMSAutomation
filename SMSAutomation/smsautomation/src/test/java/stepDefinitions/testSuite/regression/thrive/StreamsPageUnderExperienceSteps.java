package stepDefinitions.testSuite.regression.thrive;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import components.elements.CommonElementLocator;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.BasePage;
import pageObjects.thrive.AdminStreamPage;
import pageObjects.thrive.Tab.ExperienceDDown;

public class StreamsPageUnderExperienceSteps  extends BasePage {

	public StreamsPageUnderExperienceSteps() throws IOException {
		super();
	}

	public AdminStreamPage adminStreamPage = PageFactory.initElements(driver, AdminStreamPage.class);
	public CommonElementLocator commonElementLocator = PageFactory.initElements(driver, CommonElementLocator.class);
	public ExperienceDDown experienceDDown = PageFactory.initElements(driver, ExperienceDDown.class);

	
	@When("User clicks on the Experience Menu option on the admin dashboard")
	public void user_clicks_on_the_Experience_Menu_option_on_the_admin_dashboard() throws Exception {
		commonElementLocator.waitAndClickElement(commonElementLocator.menu_Experience);
	}

	@Then("the Experience tab option is displayed")
	public void the_Experience_tab_option_is_displayed() {
		Assert.assertTrue(experienceDDown.opt_Streams.isDisplayed());
	}

	@When("User clicks on the Streams option")
	public void user_clicks_on_the_Streams_option() throws Exception {
		experienceDDown.waitAndClickElement(experienceDDown.opt_Streams);
	}

	@Then("the Stream page under Experience is displayed")
	public void the_Stream_page_under_Experience_is_displayed() throws Exception {
		Assert.assertEquals("Streams",  commonElementLocator.getElementText(commonElementLocator.pag_Title));
	}
	
//  @Verify-the-stream-page-is-opened-at-Experience-tab
	@Then("User verifies the URL of the Stream page")
	public void user_verifies_the_URL_of_the_Stream_page() {
	 Assert.assertEquals("https://thrive.stage2-aut.mastermindsdigital.com/admin/streams/", driver.getCurrentUrl());
	}

//	@Verify-the-"Licensee-and-Merchants"-Filter
	@Then("User verifies that the Reseller and Business filter is available")
	public void user_verifies_that_the_Reseller_and_Business_filter_is_available() {
		Assert.assertTrue(adminStreamPage.filter_ResellerAndBusiness.isDisplayed());
	}

	@When("User clicks the Reseller and Business textfield")
	public void user_clicks_the_Reseller_and_Business_textfield() throws Exception {
		adminStreamPage.waitAndClickElement(adminStreamPage.txtF_ResellerAndBusiness);
	}

	@Then("a drop down displaying Busineses is opened")
	public void a_drop_down_displaying_Busineses_is_opened() {
	 Assert.assertTrue(adminStreamPage.resellerAndBusinessOptions.isDisplayed());
	 Assert.assertTrue(adminStreamPage.resellerDataGroup.isDisplayed());
	 Assert.assertTrue(adminStreamPage.businessDataGroup.isDisplayed());
	}

	@When("User selects Business or Reseller")
	public void user_selects_Business_or_Reseller() throws Exception {
		adminStreamPage.waitAndClickElement(adminStreamPage.selectResellerOrBusiness("AcadianaRewards"));
	}

	@Then("the selected Business or Reseller is displayed on the drop down text field")
	public void the_selected_Business_or_Reseller_is_displayed_on_the_drop_down_text_field() throws Exception {
	  Assert.assertEquals("AcadianaRewards", adminStreamPage.getElementText(adminStreamPage.activeResellerOrBusinessOption("AcadianaRewards")).replace("\n×", ""));
	}

	@When("User clicks the close button beside a selected Business")
	public void user_clicks_the_close_button_beside_a_selected_Business() throws Exception {
	  adminStreamPage.waitAndClickElement(adminStreamPage.removeActiveResellerOrBusinessOption("AcadianaRewards"));
	}

	@Then("the Business option is deselected")
	public void the_Business_option_is_deselected() throws Exception {
		Assert.assertTrue(adminStreamPage.getElementText(adminStreamPage.txtF_ResellerAndBusiness).isBlank());
	}

//  @Verify-the-"Platforms"-filter 
	@Then("User verifies that the Platform filter is available")
	public void user_verifies_that_the_Platform_filter_is_available() {
		Assert.assertTrue(adminStreamPage.filter_Platform.isDisplayed());
	}

	@When("User clicks the close button beside a selected platform")
	public void user_clicks_the_close_button_beside_a_selected_platform() throws Exception {
		adminStreamPage.waitAndClickElement(adminStreamPage.removeActiveResellerOrBusinessOption("Facebook"));
	}

	@Then("the Platform option is deselected")
	public void the_Platform_option_is_deselected() throws Exception {
		System.out.println(adminStreamPage.getElementText(adminStreamPage.txtF_Platform));
		Assert.assertFalse(adminStreamPage.getElementText(adminStreamPage.txtF_Platform).contains("Facebook"));
	}

//	@Verify-the-"Read"-filter
	@Then("User verifies that the Read filter is available")
	public void user_verifies_that_the_Read_filter_is_available() {
		Assert.assertTrue(adminStreamPage.filter_Read.isDisplayed());
	}

	@Then("User verifies that Unread streams are displayed by deafult")
	public void user_verifies_that_Unread_streams_are_displayed_by_deafult() {
		Assert.assertTrue(adminStreamPage.btn_UnreadEnvelope.isDisplayed());
		Assert.assertFalse(adminStreamPage.isElementVisible(adminStreamPage.getREADENVELOPELOCATOR()));
	}

	@When("User clicks the Filter by Read button")
	public void user_clicks_the_Filter_by_Read_button() throws InterruptedException {
		adminStreamPage.waitAndClickElement(adminStreamPage.btn_Unread);
		adminStreamPage.waitAndClickElement(adminStreamPage.btn_FilterByRead);
		adminStreamPage.waitAndClickElement(adminStreamPage.btn_Unread);
	}

	@Then("User is able to see all read streams")
	public void user_is_able_to_see_all_read_streams() throws Exception {
		Assert.assertTrue(adminStreamPage.btn_ReadEnvelope.isDisplayed());
		Thread.sleep(20000);
		Assert.assertFalse(adminStreamPage.isElementVisible(adminStreamPage.getUNREADENVELOPELOCATOR()));
	
	}


}
