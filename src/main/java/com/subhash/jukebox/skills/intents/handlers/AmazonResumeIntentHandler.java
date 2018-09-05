package com.subhash.jukebox.skills.intents.handlers;

import com.amazon.speech.json.SpeechletRequestEnvelope;
import com.amazon.speech.speechlet.IntentRequest;
import com.amazon.speech.speechlet.SpeechletResponse;
import com.subhash.jukebox.skills.utils.SpeechGenerationUtils;

public class AmazonResumeIntentHandler extends IntentHandler {

	@Override
	public SpeechletResponse handle(SpeechletRequestEnvelope<IntentRequest> request) {
		String speechText = "Resume . Good Bye";
		return SpeechletResponse.newTellResponse(SpeechGenerationUtils.getPlainTextOutputSpeech(speechText));
	}

}
