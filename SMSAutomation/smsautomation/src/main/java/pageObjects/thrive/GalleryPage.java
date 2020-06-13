package pageObjects.thrive;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class GalleryPage extends BasePage {

	public GalleryPage() throws IOException {
		super();
	}

	
	private final String ALLIMAGESLOCATOR = "//img[contains(@class, \"responsive\")]";
	private final String TestIMAGE2LOCATOR = "//img[contains(@class, \"responsive\")]";
	private final String TESTVIDEOLOCATOR = "//img[@data-full-duration=\"5\"]";
	
	public String getALLIMAGESLOCATOR() {
		return ALLIMAGESLOCATOR;
	}
	
	public String getTestIMAGE2LOCATOR() {
		return TestIMAGE2LOCATOR;
	}
	
	public @FindBy(xpath = "//a[text()=\"Gallery\"]") WebElement lnk_Gallery;
	public @FindBy(xpath = "//a[normalize-space()=\"Update\"]") WebElement btn_Update;
	public @FindBy(xpath = "//a[normalize-space()=\"Delete\"]") WebElement btn_Delete;
	public @FindBy(xpath = "//img[@class=\"img-responsive\"]") WebElement allImages;
	public @FindBy(xpath = "//img[contains(@src, \"/thumb_17604_image_gallery_small.png\")]") WebElement TestImage1;
	public @FindBy(xpath = "//img[@data-full-width=\"500\"]") WebElement TestImage2;
	public @FindBy(xpath = "//div[contains(@class, \"alert-danger\")]") WebElement noImage;
	public @FindBy(xpath = "//form[@name=\"gallery_upload_type\"]") WebElement form_UploadImages;
	public @FindBy(xpath = "//input[@id=\"gallery_upload_type_images\"]") WebElement txtF_InputFile;
	public @FindBy(xpath = "//form[@name=\"gallery_upload_type\"]//div[@class=\"form-group\" and ./label[normalize-space()=\"Vertical\"]]//div[contains(@class, \"selectize-input\")]'") WebElement txtF_FormVerticalDDown;
	public @FindBy(xpath = "//form[@name=\\\"gallery_upload_type\\\"]//div[@class=\"form-group\" and ./label[normalize-space()=\"Tagged with\"]]//div[contains(@class, \"selectize-input\")]") WebElement txtF_FormInputFileDDown;
	public @FindBy(xpath = "//button[@id=\"gallery_upload_type_Upload\"]") WebElement btn_Upload;
	public @FindBy(xpath = "//div[@role=\"alert\"]//p") WebElement uploadNotificationAlert;
	public @FindBy(xpath = "//div[@class=\"image-option\" and ./img[@data-full-width=\"500\"]]//a[normalize-space()=\"Update\"]") WebElement btn_UpdateTestImage;
	public @FindBy(xpath = "//div[@class=\"image-option\" and ./img[@data-full-width=\"500\"]]//a[normalize-space()=\"Delete\"]") WebElement btn_DeleteTestImage;
	public @FindBy(xpath = "//input[@placeholder=\"Filter by Vertical\"]") WebElement txtF_VerticalDDown;
	public @FindBy(xpath = "(//div[@class=\"form-group\" and ./label[normalize-space()=\"Vertical\"]]//div[@class=\"selectize-dropdown-content\"])[2]") WebElement verticalOptions;
	public @FindBy(xpath = "(//div[@class=\"form-group\" and ./label[normalize-space()=\"Tagged with\"]]//div[@class=\"selectize-dropdown-content\"])[2]") WebElement taggedWithOptions;
	public @FindBy(xpath = "//input[@placeholder=\"Filter by Tag\"]") WebElement txtF_TaggedWithDDown;
	public @FindBy(xpath = "//div[@class=\"selectize-dropdown-content\"]") WebElement parentElement;
	public WebElement selectVerticalOrTaggedWith(String option) {
		return parentElement.findElement(By.xpath("//div[text()=\'" + option + "']"));
	}
	
	// Videos
	
	public String getTESTVIDEOLOCATOR() {
		return TESTVIDEOLOCATOR;
	}


	public @FindBy(xpath = "//img[contains(@src, \"/thumb_164858_video_gallery_small.png\")]") WebElement TestVideo1;
	public @FindBy(xpath = "//img[@data-full-width=\"500\"]") WebElement TestVideo2;
    
}


