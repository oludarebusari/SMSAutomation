package pageObjects.thrive.modal;

import java.io.IOException;
import pageObjects.BasePage;

public class MessageTemplatesPageHelpModal extends BasePage {

	public MessageTemplatesPageHelpModal() throws IOException {
		super();
	}

	

	private final String MESSAGE_TEMPLATES_MANAGEMENT = "Easily manage all of your email and SMS templates from a single location.";
	private final String SEARCH_MESSAGE_TEMPLATES ="Quickly find Templates by typing in a title, subject, or other identifiable data into the search box.";
	private final String TITLE ="The Title provides a brief explanation of the Template's use.";
	private final String SUBJECT="The Subject displays the subject line used when a message is sent as an Email.";
	private final String DESCRIPTION ="The Description provides a detailed explanation of the intent of the message template.";
	private final String UPDATED ="Updated indicates the date when the message was most recently modified.";
	private final String ACTION ="Actions provides quick access to edit and customize the selected template.";
	
	
}
