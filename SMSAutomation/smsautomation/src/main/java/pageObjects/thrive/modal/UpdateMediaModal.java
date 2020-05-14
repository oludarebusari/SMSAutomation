package pageObjects.thrive.modal;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class UpdateMediaModal extends BasePage {

	public UpdateMediaModal() throws IOException {
		super();
	}

	public @FindBy(xpath = "//div[@class=\"modal-content\"]//h4[normalize-space()=\"Update Media\"]") WebElement mod_title;
	public @FindBy(xpath = "//div[@class=\"modal-content\"]//div[@class=\"form-group\" and ./label[normalize-space()=\"Vertical\"]]//div[contains(@class, \"selectize-input\")]") WebElement verticalDDown;
	public @FindBy(xpath = "//div[@class=\"modal-content\"]//div[@class=\"form-group\" and ./label[normalize-space()=\"Tagged with\"]]//div[contains(@class, \"selectize-input\")]") WebElement taggedWithDDown;
	public @FindBy(xpath = "//div[@class=\"selectize-dropdown-content\"]") WebElement parentElement;
	public @FindBy(xpath = "//button[@id=\"admin_media_update_type_Update\"]") WebElement btn_Update;
	public WebElement selectVertical(String option) {
		return parentElement.findElement(By.xpath("//div[text()=\'" + option + "']"));
	}
	
}
