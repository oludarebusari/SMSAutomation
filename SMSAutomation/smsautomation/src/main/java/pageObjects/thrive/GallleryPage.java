package pageObjects.thrive;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class GallleryPage extends BasePage {

	public GallleryPage() throws IOException {
		super();
	}

	
	private final String ALLIMAGESLOCATOR = "//img[contains(@class, \"responsive\")]";
	
	public String getALLIMAGESLOCATOR() {
		return ALLIMAGESLOCATOR;
	}
	
	public @FindBy(xpath = "//a[text()=\"Gallery\"]") WebElement lnk_Gallery;
	public @FindBy(xpath = "//a[normalize-space()=\"Update\"]") WebElement btn_Update;
	public @FindBy(xpath = "//a[normalize-space()=\"Delete\"]") WebElement btn_Delete;
	public @FindBy(xpath = "//img[@class=\"img-responsive\"]") WebElement allImages;
	public @FindBy(xpath = "//img[contains(@src, \"/thumb_17604_image_gallery_small.png\")]") WebElement image;
	public @FindBy(xpath = "//div[contains(@class, \"alert-danger\")]") WebElement noImage;
	public @FindBy(xpath = "//form[@name=\"gallery_upload_type\"]") WebElement form_UploadImages;
	public @FindBy(xpath = "//input[@id=\"gallery_upload_type_images\"]") WebElement txtF_InputFile;
	public @FindBy(xpath = "//form[@name=\"gallery_upload_type\"]//div[@class=\"form-group\" and ./label[normalize-space()=\"Vertical\"]]//div[contains(@class, \"selectize-input\")]'") WebElement txtF_FormVerticalDDown;
	public @FindBy(xpath = "//form[@name=\\\"gallery_upload_type\\\"]//div[@class=\"form-group\" and ./label[normalize-space()=\"Tagged with\"]]//div[contains(@class, \"selectize-input\")]") WebElement txtF_FormInputFileDDown;
	public @FindBy(xpath = "//button[@id=\"gallery_upload_type_Upload\"]") WebElement btn_Upload;
	public @FindBy(xpath = "//p[normalize-space()=\"The image has been successfully uploaded\"]") WebElement uploadNotificationAlert;
	
	
	
	
}


