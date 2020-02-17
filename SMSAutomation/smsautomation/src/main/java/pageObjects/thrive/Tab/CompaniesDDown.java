package pageObjects.thrive.Tab;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class CompaniesDDown extends BasePage {

	public CompaniesDDown() throws IOException {
		super();
	}
	
	public @FindBy(xpath = "//li[@class=\"first\"]//a[text()[normalize-space()=\"Resellers\"]]") WebElement opt_Resellers;
	public @FindBy(xpath = "//li[@class=\"first\"]//a[text()[normalize-space()=\"Resellers\"]]") WebElement opt_Businesses;

}
