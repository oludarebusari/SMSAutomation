package stepDefinitions.engage;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.engage.EngLoginPage;
import utils.DriverFactory;

public class EngLoginSteps extends DriverFactory {
	
	public EngLoginPage engLoginPage = PageFactory.initElements(driver, EngLoginPage.class);

	@Given("User navigate to Engage url")
	public void user_navigate_to_Engage_url() throws IOException {
		engLoginPage.getLoginPage();
	}

	@And("User enters a valid username")
	public void user_enters_a_valid_username() throws Exception {
		engLoginPage.enterUserName("superadmin");
	}

	@And("User enters a valid password")
	public void user_enters_a_valid_password() throws Exception {
		engLoginPage.enterPassWord("2nC01BdPs");
	}

	@When("User clicks on the login button")
	public void user_clicks_on_the_login_button() throws Exception {
		engLoginPage.clickOnSubmiButton();
	}

	@Then("User should be taken to Engage SMS home page")
	public void user_should_be_taken_to_Engage_SMS_home_page() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
