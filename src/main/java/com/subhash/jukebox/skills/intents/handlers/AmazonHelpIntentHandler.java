package com.subhash.jukebox.skills.intents.handlers;

import com.amazon.speech.json.SpeechletRequestEnvelope;
import com.amazon.speech.speechlet.IntentRequest;
import com.amazon.speech.speechlet.SpeechletResponse;
import com.subhash.jukebox.skills.constants.Constants;
import com.subhash.jukebox.skills.utils.SpeechGenerationUtils;

public class AmazonHelpIntentHandler extends IntentHandler {

	@Override
	public SpeechletResponse handle(SpeechletRequestEnvelope<IntentRequest> request) {
		String speechText = Constants.HOME_JUKEBOX_HELP_TEXT;
		return SpeechGenerationUtils.getAskResponse(Constants.CARD_TITLE_HOME_JUKEBOX, speechText);
	}

}
