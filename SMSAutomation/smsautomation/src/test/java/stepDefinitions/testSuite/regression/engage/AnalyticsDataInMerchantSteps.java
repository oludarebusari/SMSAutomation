package stepDefinitions.testSuite.regression.engage;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import components.elements.CommonElementLocator;
import io.cucumber.java.en.Then;

import pageObjects.BasePage;
import pageObjects.license.AdvertisersPage;

public class AnalyticsDataInMerchantSteps extends BasePage {

	public AnalyticsDataInMerchantSteps() throws IOException {
		super();
	}

	AdvertisersPage advertisersPage = PageFactory.initElements(driver, AdvertisersPage.class);
	CommonElementLocator commonElementLocator = PageFactory.initElements(driver, CommonElementLocator.class);
	
	String downloadpath =  System.getProperty("user.home") + "//Downloads//";
	String fileName = "report_lonestarloyalty_com_businesses";
	
	

//	 @SMSM-139-Verify-that-user-is-able-to-check-the-Actions-dropdown-menu-copy-and-export-Businesses-to-csv
	@Then("User verifies that all the records have LOG IN button")
	public void user_verifies_that_all_the_records_have_LOG_IN_button() throws Exception {
		System.out.println(advertisersPage.getElementText(advertisersPage.Advertisers_Info).substring(2, 4));
		Assert.assertEquals(Integer.parseInt(advertisersPage.getElementText(advertisersPage.Advertisers_Info).substring(2, 4)), advertisersPage.btn_LOGIN().size());
	}

	@Then("User verifies the content of the Action dropdown button")
	public void user_verifies_the_content_of_the_Action_dropdown_button() throws InterruptedException {
		advertisersPage.waitAndClickElement(advertisersPage.btn_ActionDDown("QA, Aclate"));
		Assert.assertEquals("View Account Details", advertisersPage.getElementText(advertisersPage.opt_ActionDDown("QA, Aclate", "View Account Details")));
		Assert.assertEquals("Email Analytics to Advertiser", advertisersPage.getElementText(advertisersPage.opt_ActionDDown("QA, Aclate", "Email Analytics to Advertiser")));
		Assert.assertEquals("One-Time Charge", advertisersPage.getElementText(advertisersPage.opt_ActionDDown("QA, Aclate", "One-Time Charge")));
		Assert.assertEquals("Log In (LEGACY)", advertisersPage.getElementText(advertisersPage.opt_ActionDDown("QA, Aclate", "Log In (LEGACY)")));
	}
	
	@Then("user confirms data rows are copied")
	public void user_confirms_data_rows_are_copied() throws Exception {
		System.out.println(commonElementLocator.getElementText(commonElementLocator.txt_Copied_To_Clipboard));
		Assert.assertTrue(commonElementLocator.getElementText(commonElementLocator.txt_Copied_To_Clipboard)
				.contentEquals("Copied " + advertisersPage.getElementText(advertisersPage.Advertisers_Info).substring(8, 10) + " rows to clipboard"));
	}
	
	@Then("User confirms that the CSV file for Business is exported to the local machine")
	public void user_confirms_that_the_CSV_file_for_Business_is_exported_to_the_local_machine() throws Exception {
		Assert.assertTrue(advertisersPage.isFileDownloadedWithDynamicFilename(downloadpath, fileName));
	}





}
