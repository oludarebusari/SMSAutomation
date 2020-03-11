package pageObjects.thrive.modal;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class LanguagePageHelpModal extends BasePage {

	public LanguagePageHelpModal() throws IOException {
		super();
	}

	
	private final String LANGUAGE_STRINGS_MANAGEMENT = "Easily manage all of your language strings from a single location.";
	private final String SEARCH_LANGUAGE_STRING ="Quickly find the language string(s) you need by typing in a title, group, value, or other identifiable data and clicking search to pull up relevant Language Strings.";
	private final String TITLE ="The Title indicates the languge string currently being displayed.";
	private final String GROUP ="Groups provides a way to access Language Strings based on their relevance to specific systems or processes.";
	private final String ACCESS_LEVEL = "";
	private final String VALUE ="The Value shows the currently defined value for the languge string.";
	private final String DESCRIPTION ="The Description highlights what each languge string controls and how it works.";
	private final String UPDATED ="Updated indicates when Settings were most recently updated, providing a reference point as to when the languge string was last modified.";
	private final String ACTION ="The Edit button provides quick access to customize the selected languge string.";
	
	
	public String getLANGUAGE_STRINGS_MANAGEMENT() {
		return LANGUAGE_STRINGS_MANAGEMENT;
	}
	public String getSEARCH_LANGUAGE_STRING() {
		return SEARCH_LANGUAGE_STRING;
	}
	public String getTITLE() {
		return TITLE;
	}
	public String getGROUP() {
		return GROUP;
	}
	public String getVALUE() {
		return VALUE;
	}
	public String getDESCRIPTION() {
		return DESCRIPTION;
	}
	public String getUPDATED() {
		return UPDATED;
	}
	public String getACTION() {
		return ACTION;
	}
	
}
