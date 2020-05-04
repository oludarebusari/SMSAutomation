package pageObjects.thrive;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class ModulesPage extends BasePage {

	public ModulesPage() throws IOException {
		super();
	}
	
	//menu options
	public @FindBy(xpath = "//div[@class=\"panel panel-default\" and .//h4[text()=\"Web Essentials Setup\"]]//a[text()=\"Edit\"]") WebElement btn_WebEssentialsSetupEdit;
	public @FindBy(xpath = "//div[@class=\"panel panel-default\" and .//h4[text()=\"Web Essentials Setup\"]]//button[@data-toggle=\"dropdown\"]") WebElement btn_WebEssentialsSetupDDown;
	public @FindBy(xpath = "//div[@class=\"panel panel-default\" and .//h4[text()=\"Social Essentials Ongoing\"]]//a[text()=\"Edit\"]") WebElement btn_SocialEssentialsOngoingEdit;
	public @FindBy(xpath = "//div[@class=\"panel panel-default\" and .//h4[text()=\"Social Essentials Ongoing\"]]//button[@data-toggle=\"dropdown\"]") WebElement btn_SocialEssentialsOngoingDDown;
	public @FindBy(xpath = "//div[@class=\"panel panel-default\" and .//h4[text()=\"Package Discount\"]]//a[text()=\"Edit\"]") WebElement btn_PackageDiscountEdit;
	public @FindBy(xpath = "//div[@class=\"panel panel-default\" and .//h4[text()=\"Package Discount\"]]//button[@data-toggle=\"dropdown\"]") WebElement btn_PackageDiscountDDown;
	public @FindBy(xpath = "//div[@class=\"panel panel-default\" and .//h4[text()=\"Web Essentials Ongoing\"]]//a[text()=\"Edit\"]") WebElement btn_WebEssentialsOngoingEdit;
	public @FindBy(xpath = "//div[@class=\"panel panel-default\" and .//h4[text()=\"Web Essentials Ongoing\"]]//button[@data-toggle=\"dropdown\"]") WebElement btn_WebEssentialsOngoingDDown;
	public @FindBy(xpath = "//div[@class=\"panel panel-default\" and .//h4[text()=\"Web & Social Essentials Ongoing\"]]//a[text()=\"Edit\"]") WebElement btn_WWebSocialEssentialsOngoingEdit;
	public @FindBy(xpath = "//div[@class=\"panel panel-default\" and .//h4[text()=\"Web & Social Essentials Ongoing\"]]//button[@data-toggle=\"dropdown\"]") WebElement btn_WebSocialEssentialsOngoingDDown;
	public @FindBy(xpath = "//div[@class=\"panel panel-default\" and .//h4[text()=\"Social Essentials Setup\"]]//a[text()=\"Edit\"]") WebElement btn_SocialEssentialsSetupEdit;
	public @FindBy(xpath = "//div[@class=\"panel panel-default\" and .//h4[text()=\"Social Essentials Setup\"]]//button[@data-toggle=\"dropdown\"]") WebElement btn_SocialEssentialsSetupDDOwn;
	
	public @FindBy(xpath = "//div[@class=\"panel panel-default\" and .//h4[text()=\"Package Discount\"]]//a[text()=\"Edit\"]") WebElement parentElement;
	
	public WebElement editModule(String module) {
		return parentElement.findElement(By.xpath(""));
	}
	
}
