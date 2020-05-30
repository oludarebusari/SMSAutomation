package pageObjects.thrive.Tab;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class ReportsDDown extends BasePage {

	public ReportsDDown() throws IOException {
    	super();
	}

	//Page elements
	public @FindBy(xpath = "//li[@class=\"open\"]//ul[contains(@class, \"dropdown-menu\")]//a[text()[normalize-space()=\"Reseller Report\"]]") WebElement opt_Reseller_Report;
	public @FindBy(xpath = "//li[@class=\"open\"]//ul[contains(@class, \"dropdown-menu\")]//a[text()[normalize-space()=\"Territory Report\"]]") WebElement opt_Territory_Report;
	public @FindBy(xpath = "//li[@class=\"open\"]//ul[contains(@class, \"dropdown-menu\")]//a[text()[normalize-space()=\"Streams Status Report\"]]") WebElement opt_Streams_Status_Report;
	public @FindBy(xpath = "//li[@class=\"open\"]//ul[contains(@class, \"dropdown-menu\")]//a[text()[normalize-space()=\"SSMBG Status Report\"]]") WebElement opt_SSMBG_Status_Report;
	public @FindBy(xpath = "//a[normalize-space()=\"Businesses\"]") WebElement opt_Businesses;
	public @FindBy(xpath = "//a[normalize-space()=\"Digital Audit\"]") WebElement opt_Digital_Audit;
	
	
	
	/*
	 * //Page methods public ReportsDDown clickResellerReportOpt() throws Exception
	 * { waitAndClickElement(opt_Reseller_Report); return new ReportsDDown(); }
	 * 
	 * public ReportsDDown clickTerritoryReportOpt() throws Exception {
	 * waitAndClickElement(opt_Territory_Report); return new ReportsDDown(); }
	 * 
	 * public ReportsDDown clickStreamsStatusReportOpt() throws Exception {
	 * waitAndClickElement(opt_Streams_Status_Report); return new ReportsDDown(); }
	 * 
	 * public ReportsDDown clickSSMBGStatusReportOpt() throws Exception {
	 * waitAndClickElement(opt_SSMBG_Status_Report); return new ReportsDDown(); }
	 */
	
}
