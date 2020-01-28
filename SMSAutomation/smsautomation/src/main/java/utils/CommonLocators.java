package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CommonLocators {
	
	public static @FindBy(xpath = "//div[contains(@class, \"input-group-sm\")]") WebElement parentSize;
	public static WebElement num_PageSize(String num) { 
		 return parentSize.findElement(By.xpath("//option[text()='" + num + "']")); 
	};

}
