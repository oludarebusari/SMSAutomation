package pageObjects.thrive;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class EditResellerPage extends BasePage {

	public EditResellerPage() throws IOException {
		super();
	}
	
	public @FindBy(xpath = "//h1[@class=\"pull-left\" and text()[normalize-space()]]") WebElement pag_Title;
	public @FindBy(xpath = "//button[contains(@class, \"btn-block\")]") WebElement btn_Save_Reseller;
}
