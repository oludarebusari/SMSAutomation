package pageObjects.thrive;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class OrdersPage extends BasePage {

	public OrdersPage() throws IOException {
		super();

	}
	
	public @FindBy(xpath = "//div[@class=\"form-group\" and ./label[text()[normalize-space()=\"Reseller\"]]]//input[@id=\"work_order_filter_type_licensee-selectized\"]") WebElement txtF_Reseller;
	public @FindBy(xpath = "//div[@class=\"form-group\" and ./label[text()[normalize-space()=\"Status\"]]]//div[contains(@class, \"selectize-input\")]") WebElement lov_Status;
	public @FindBy(xpath = "//div[@class=\"form-group\" and ./label[text()[normalize-space()=\"Status\"]]]//div[contains(@class, \"selectize-input items not-full has-options has-items\")]") WebElement txtF_Order;
	
	
	
}
