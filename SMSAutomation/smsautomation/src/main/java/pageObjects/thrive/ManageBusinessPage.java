package pageObjects.thrive;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class ManageBusinessPage extends BasePage {

	public ManageBusinessPage() throws IOException {
		super();
	}

	public @FindBy(xpath = "//h1[@class=\"pull-left\" and text()[normalize-space()]]") WebElement pag_Title;
	public @FindBy(xpath = "//input[@id=\"simple_search_searchText\"]") WebElement txtF_Search;
	public @FindBy(xpath = "//button[@id=\"search-text-submit\"]") WebElement btn_Search;
	public @FindBy(xpath = "//a[@id=\"start-tour\"]") WebElement btn_Help;
	public @FindBy(xpath = "//span[@id=\"pagination-total\"]") WebElement lbl_Pagination_Total;
	public @FindBy(xpath = "//span[@id=\"pagination-start\"]") WebElement lbl_Pagination_Start;
	public @FindBy(xpath = "//span[@id=\"pagination-end\"]") WebElement lbl_Pagination_End;
	public @FindBy(xpath = "//tbody") WebElement parent_SelectCompany;
	public WebElement btn_SignIn(String companyName) {
		return parent_SelectCompany.findElement(By.xpath("//tr[contains(@id, \"company\") and ./td[text()=\'" + companyName +"']]//a[@title=\"Sign In\"]"));
		
	}
}
