package pageObjects.license.menu;

import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.BasePage;

public class AddOnServicesSubMenu extends BasePage {

	public AddOnServicesSubMenu() throws IOException {
		super();
	}

	// Menu Elements

	public @FindBy(xpath = "//a[text()=\"Giftbar\"]") WebElement menu_Giftbar;

	// Menu Methods

	public AddOnServicesSubMenu clickGiftbar() throws Exception {
		waitAndClickElement(menu_Giftbar);
		return new AddOnServicesSubMenu();
	}

	public AddOnServicesSubMenu getGiftbarTxt() throws Exception {
		menu_Giftbar.getText();
		return new AddOnServicesSubMenu();
	}

}
