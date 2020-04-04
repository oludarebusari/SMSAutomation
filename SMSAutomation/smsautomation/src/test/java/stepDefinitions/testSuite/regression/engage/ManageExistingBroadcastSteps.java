package stepDefinitions.testSuite.regression.engage;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import components.elements.CommonElementLocator;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.engage.ManageBroadcastsPage;
import pageObjects.license.menu.BroadCastSubMenu;
import utils.DriverFactory;

public class ManageExistingBroadcastSteps extends DriverFactory {
	
	BroadCastSubMenu broadCastSubMenu = PageFactory.initElements(driver, BroadCastSubMenu.class);
	CommonElementLocator commonElementLocator = PageFactory.initElements(driver, CommonElementLocator.class);
	ManageBroadcastsPage manageBroadcastsPage = PageFactory.initElements(driver, ManageBroadcastsPage.class);
	
	
	
//	 @SMSM-124-User-can-see-all-existing-broadcast-messages 
	@When("User clicks on Manage Broadcasts option")
	public void user_clicks_on_Manage_Broadcasts_option() throws Exception {
	 broadCastSubMenu.waitAndClickElement(broadCastSubMenu.menu_ManageBroadcasts);
	}

	@Then("User is redirected to the Manage Broadcasts page")
	public void user_is_redirected_to_the_Manage_Broadcasts_page() throws Exception {
		Assert.assertEquals("Manage Broadcasts", manageBroadcastsPage.getElementText(manageBroadcastsPage.pag_Heading));
		Assert.assertTrue(Integer.parseInt(commonElementLocator.getElementText(commonElementLocator.tableRecordsCount).substring(7, 9).trim()) > 0 );
	}
	

}
