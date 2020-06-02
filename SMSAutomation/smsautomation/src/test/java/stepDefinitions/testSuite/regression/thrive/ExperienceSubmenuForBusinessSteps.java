package stepDefinitions.testSuite.regression.thrive;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import components.elements.CommonElementLocator;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.thrive.ManageBusinessPage;
import pageObjects.thrive.Tab.CompaniesDDown;
import pageObjects.thrive.Tab.ExperienceDDown;
import utils.DriverFactory;

public class ExperienceSubmenuForBusinessSteps extends DriverFactory  {

	public ExperienceSubmenuForBusinessSteps() throws IOException {
		super();
	}

	public CompaniesDDown companiesDDown = PageFactory.initElements(driver, CompaniesDDown.class);
	public CommonElementLocator commonElementLocator = PageFactory.initElements(driver, CommonElementLocator.class);
	public ExperienceDDown experienceDDown = PageFactory.initElements(driver, ExperienceDDown.class);
	public ManageBusinessPage manageBusinessPage = PageFactory.initElements(driver, ManageBusinessPage.class);

	
//	@Verify-Business-user-is-able-to-navigate-to-Experience->Pages
	@When("User Clicks Company menu and clicks the Business option")
	public void user_Clicks_Company_menu_and_clicks_the_Business_option() throws Exception {
		commonElementLocator.waitAndClickElement(commonElementLocator.menu_Companies);
		companiesDDown.waitAndClickElement(companiesDDown.opt_Businesses);
	}

	@Then("the Manage Business page is displayed")
	public void the_Manage_Business_page_is_displayed() throws Exception {
		Assert.assertEquals("Manage Business", commonElementLocator.getElementText(commonElementLocator.pag_Title));
	}

	@When("User clicks on the SignIn button on of a Business")
	public void user_clicks_on_the_SignIn_button_on_of_a_Business() throws Exception {
		commonElementLocator.sendKeysToWebElement(commonElementLocator.txtF_Search, "Johnson & Fanger Painting");
		commonElementLocator.waitAndClickElement(commonElementLocator.btn_Search);
		manageBusinessPage.waitAndClickElement(manageBusinessPage.btn_SignIn("Johnson & Fanger Painting"));
	}

	@Then("the Business Dashboard page is displayed")
	public void the_Business_Dashboard_page_is_displayed() throws Exception {
		Assert.assertEquals("Dashboard", commonElementLocator.getElementText(commonElementLocator.pag_Title));
		Assert.assertEquals("https://thrive.stage2-aut.mastermindsdigital.com/merchant/dashboard", driver.getCurrentUrl());
	}

	@When("User clicks on Experience menu from the Business page and clicks pages")
	public void user_clicks_on_Experience_menu_from_the_Business_page_and_clicks_pages() throws Exception {
		commonElementLocator.waitAndClickElement(commonElementLocator.menu_Experience);
		experienceDDown.waitAndClickElement(experienceDDown.opt_Pages);
	}

	@Then("Pages page is displayed")
	public void pages_page_is_displayed() throws InterruptedException {
		Assert.assertEquals("Pages", commonElementLocator.getElementText(commonElementLocator.pag_Title));
	}
	
//	 @Verify-Business-user-is-able-to-navigate-to-Experience->Captivate
	@When("User clicks on Experience menu from the Business page and clicks Captivate")
	public void user_clicks_on_Experience_menu_from_the_Business_page_and_clicks_Captivate() throws Exception {
		commonElementLocator.waitAndClickElement(commonElementLocator.menu_Experience);
		commonElementLocator.waitAndClickElement(commonElementLocator.opt_Captivate);
	}

	@Then("Captivate page is displayed")
	public void captivate_page_is_displayed() throws Exception {
	 Assert.assertEquals("Captivate",  commonElementLocator.getElementText(commonElementLocator.pag_Title));
	}
	
//	Verify Business user is able to navigate to Experience-> Streams
	@When("User clicks on Experience menu from the Business page and clicks Streams")
	public void user_clicks_on_Experience_menu_from_the_Business_page_and_clicks_Streams() throws InterruptedException {
		commonElementLocator.waitAndClickElement(commonElementLocator.menu_Experience);
		commonElementLocator.waitAndClickElement(commonElementLocator.opt_Streams);
	}

	@Then("Streams page is displayed")
	public void streams_page_is_displayed() throws InterruptedException {
		Assert.assertEquals("Streams", commonElementLocator.getElementText(commonElementLocator.pag_Title));
	}



	
}
