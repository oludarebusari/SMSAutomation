package pageObjects.thrive.modal;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class StreamSettingsModal extends BasePage {

	
	public StreamSettingsModal() throws IOException {
		super();
	}

	
	private final String REVIEWS_SYETEM_TOOLTIP_TEXT = "Reviews System\nWhen enabled it will be possible to capture reviews on Merchant sites.";
	private final String SEND_REVIEWS_REQUEST_AFTER_X_CHECKINS = "Send Review Request after X check-ins\nWe will send a request for a review after this number of check-ins. This counter starts from the day the feature is enabled and not from the day the subscriber was added.";
	private final String CHECKIN_REVIEW_REQUEST = "Check-in Review Request\nChoose when the request for a review should be sent after a check-in. If the Next Day option is chosen, the review will be sent out at 9:00 A.M. the following morning.";
	private final String REVIEW_SUBMISSIONS_AUTOMATIC_RESPONSE_METHOD = "Review Submissions Automatic Response Method\nControl which method we use to reach out to a user after a review is written. If set to Email or SMS Response, the system will send and SMS to Engage Members and Emails to everyone else.";
	private final String SOCIAL_SHARE_AUTOMATIC_RESPONSE = "Social Share Automatic Response\nIf Enabled, a message will be sent to a review author requesting that they share the review on social media.";
	
	
	public String getREVIEWS_SYETEM_TOOLTIP_TEXT() {
		return REVIEWS_SYETEM_TOOLTIP_TEXT;
	}

	public String getSendReviewsRequestAfterXCheckins() {
		return SEND_REVIEWS_REQUEST_AFTER_X_CHECKINS;
	}

	public String getCHECKIN_REVIEW_REQUEST() {
		return CHECKIN_REVIEW_REQUEST;
	}

	public String getREVIEW_SUBMISSIONS_AUTOMATIC_RESPONSE_METHOD() {
		return REVIEW_SUBMISSIONS_AUTOMATIC_RESPONSE_METHOD;
	}
	
	public String getSOCIAL_SHARE_AUTOMATIC_RESPONSE() {
		return SOCIAL_SHARE_AUTOMATIC_RESPONSE;
	}



	public @FindBy(xpath = "(//h4[@class=\"modal-title\" and text()[normalize-space()=\"Settings\"]])[1]") WebElement mod_Title;
	public @FindBy(xpath = "//div[@class=\"modal-dialog modal-lg\"]//button[@class=\"close\"]") WebElement btn_Close;
	public @FindBy(xpath = "//div[@role=\"tooltip\"]") WebElement title_ReviewSSYSTooltip;
	
	//Tabs
	public @FindBy(xpath = "//a[text()=\"Stream Settings\"]") WebElement tab_StreamSettings;
	public @FindBy(xpath = "//a[text()=\"Review Settings\"]") WebElement tab_ReviewSettings;
	public @FindBy(xpath = "//a[text()=\"Review Templates\"]") WebElement tab_ReviewTemplates;
	
	//Stream Settings Elements
	public @FindBy(xpath = "//input[@id=\"streams_snippet_settings_streams-post-quantity\"]") WebElement txtF_StreamPostQuantity;
	public @FindBy(xpath = "//select[@id=\"streams_snippet_settings_streams-default-sort\"]") WebElement txtF_StreamDefaultSortDDown;
	public @FindBy(xpath = "//select[@id=\"streams_snippet_settings_streams-ha_fetch-frequnecy\"]") WebElement txtF_StreamsFetchFrequencyDDown;
	public @FindBy(xpath = "//input[@id=\"streams_snippet_settings_streams-snippet-allowed-domain-selectized\"]") WebElement txtF_AllowDomains;
	public @FindBy(xpath = "//select[@id=\"streams_snippet_settings_streams-posts-theme\"]") WebElement txtF_ThemeDDown;
	public @FindBy(xpath = "//input[@id=\"streams_snippet_settings_streams-truncate-words\"]") WebElement txtF_TruncateStreams;
	
	//Review Settings Elements
	public @FindBy(xpath = "//label[@data-original-title=\"Reviews System\"]") WebElement title_ReviewsSystem;
	public @FindBy(xpath = "//label[normalize-space()=\"Reviews Enabled\"]") WebElement btn_ReviewsEnabled;
	public @FindBy(xpath = "//label[normalize-space()=\"Reviews Disabled\"]") WebElement btn_ReviewsDisabled;
	public @FindBy(xpath = "//label[@data-original-title=\"Send Review Request after X check-ins\"]") WebElement title_SendReviewRequestAfterXCheckIns;
	public @FindBy(xpath = "//input[@id=\"review_settings_type_reviews-request-checkin-count_value\"]") WebElement txtF_SendReviewRequestAfterXCheckIns;
	public @FindBy(xpath = "//label[@data-original-title=\"Check-in Review Request\"]") WebElement title_CheckInReviewRequest;
	public @FindBy(xpath = "//select[@id=\"review_settings_type_reviews-request-checkin-request_delay_value\"]") WebElement txtF_CheckInReviewRequestDDown;
	public @FindBy(xpath = "//label[@data-original-title=\"Review Submissions Automatic Response Method\"]") WebElement title_ReviewSubmissionsAutoResponseMethod;
	public @FindBy(xpath = "//select[@id=\"review_settings_type_reviews-response-method_value\"]") WebElement txtF_ReviewSubmissionsAutoResponseMethodDDown;
	public @FindBy(xpath = "//label[@data-original-title=\"Social Share Automatic Response\"]") WebElement title_SocialShareAutoRespons;
	public @FindBy(xpath = "//label[normalize-space()=\"Enabled\"]") WebElement btn_SocialShareAutoResponseEnabled;
	public @FindBy(xpath = "//label[normalize-space()=\"Disabled\"]") WebElement btn_SocialShareAutoResponseDisabled;
	public @FindBy(xpath = "//select[@id=\"review_settings_type_social_share-response-delay_value\"]") WebElement txtF_SocialShareAutoResponseDelayDDown;
	public WebElement CheckInReviewRequestOptions (String option) {
		return txtF_CheckInReviewRequestDDown.findElement(By.xpath("//option[text()=\'" + option + "']"));
	}
	public WebElement ReviewSubmissionsAutoResponseMethod (String option) {
		return txtF_ReviewSubmissionsAutoResponseMethodDDown.findElement(By.xpath("//option[text()=\'" + option + "']"));
	}
	public WebElement SocialShareAutoResponseDelay (String option) {
		return txtF_SocialShareAutoResponseDelayDDown.findElement(By.xpath("//option[text()=\'" + option + "']"));
	}	

	//Review Templates Elements
	public @FindBy(xpath = "//h3[text()=\"Templates\"]") WebElement title_ReviewTemplate;
	public @FindBy(xpath = "//textArea[@id=\"review_settings_type_review-request\"]") WebElement txtArea_ReviewRequestSMS;
	public @FindBy(xpath = "//textArea[@id=\"review_settings_type_review-request-emailBody\"]") WebElement txtArea_ReviewRequestEmail;
	public @FindBy(xpath = "//textArea[@id=\"review_settings_type_review-positive-submission\"]") WebElement txtArea_ReviewPositiveFormSubmissionSMS;
	public @FindBy(xpath = "//textArea[@id=\"review_settings_type_review-positive-submission-emailBody\"]") WebElement txtArea_ReviewPositiveFormSubmissionEmail;
	public @FindBy(xpath = "//textArea[@id=\"review_settings_type_review-negative-submission\"]") WebElement txtArea_ReviewNegativeFormSubmissionSMS;
	public @FindBy(xpath = "//textArea[@id=\"review_settings_type_review-negative-submission-emailBody\"]") WebElement txtArea_ReviewNegativeFormSubmissionEmail;
	public @FindBy(xpath = "//textArea[@id=\"review_settings_type_review-share-request\"]") WebElement txtArea_ReviewRequestToShareTemplateSMS;
	public @FindBy(xpath = "//textArea[@id=\"review_settings_type_review-share-request-emailBody\"]") WebElement txtArea_ReviewRequestToShareTemplateEmail;
	public @FindBy(xpath = "//input[@id=\"review_settings_type_reviews-positive-message\"]") WebElement txtF_ReviewPositiveMessage;
	public @FindBy(xpath = "//input[@id=\"review_settings_type_reviews-negative_response\"]") WebElement txtF_ReviewNegativeMessage;


	
	public @FindBy(xpath = "//button[@id=\"stream-settings-save\"]") WebElement btn_SaveSetting;
	
	
}
