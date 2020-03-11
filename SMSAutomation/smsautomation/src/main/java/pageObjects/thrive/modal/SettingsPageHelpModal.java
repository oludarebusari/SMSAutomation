package pageObjects.thrive.modal;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

public class SettingsPageHelpModal extends BasePage {

	public SettingsPageHelpModal() throws IOException {
		super();
	}
	
	
	private final String SETTINGS_MANAGEMENT_CONTENT = "Easily manage all of your site settings from a single location.";
	private final String SEARCH_SETTINGS ="Quickly find the setting(s) you need by typing in a setting name, group, value, or other identifiable data and clicking search to pull up relevant settings.";
	private final String TITLE ="The Title indicates the setting currently being displayed.";
	private final String GROUP ="Groups provides a way to access Settings based on their relevance to specific systems or processes.";
	private final String VALUE ="The Value shows the currently defined value for the setting.";
	private final String DESCRIPTION ="The Description highlights what each setting controls and how it works.";
	private final String UPDATED ="Updated indicates when Settings were most recently updated, providing a reference point as to when the setting was last modified.";
	private final String ACTION ="The Edit button provides quick access to customize the selected setting.";
		
	
	public String getSettingsManagementContent() {
		return SETTINGS_MANAGEMENT_CONTENT;
	}
	
	public String getSearchSettings() {
		return SEARCH_SETTINGS;
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
