package pageObjects.thrive.Tab;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class ExperienceDDown extends BasePage {

	public ExperienceDDown() throws IOException {
		super();
	}

	
	 // Experience Menu Options
		public @FindBy(xpath = "//li[@class=\"first\"]//a[text()[normalize-space()=\"Pages\"]]") WebElement opt_Pages;
		public @FindBy(xpath = "//a[text()[normalize-space()=\"SmartCode\"]]") WebElement opt_SmartCode;
		public @FindBy(xpath = "//a[text()[normalize-space()=\"Captivate\"]]") WebElement opt_Captivate;
		public @FindBy(xpath = "//a[text()[normalize-space()=\"Easy Connect\"]]") WebElement opt_EasyConnect;
		public @FindBy(xpath = "//li[contains(@class, \"last\")]//a[text()[normalize-space()=\"Streams\"]]") WebElement opt_Streams;
}