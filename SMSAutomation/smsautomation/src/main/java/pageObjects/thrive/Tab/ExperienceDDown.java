package pageObjects.thrive.Tab;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class ExperienceDDown extends BasePage {

	public ExperienceDDown() throws IOException {
		super();
	}

	
	// Page elements
	public @FindBy(xpath = "//li[@class=\"open\"]//ul[contains(@class, \"dropdown-menu\")]//a[text()[normalize-space()=\"Streams\"]]") WebElement opt_Streams;
	
	
	// Page methods

	public ExperienceDDown clickModulesOpt() throws Exception {
		waitAndClickElement(opt_Streams);
		return new ExperienceDDown();
	}
}