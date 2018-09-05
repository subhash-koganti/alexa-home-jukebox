package com.subhash.jukebox.skills.intents.handlers;

import com.amazon.speech.json.SpeechletRequestEnvelope;
import com.amazon.speech.speechlet.IntentRequest;
import com.amazon.speech.speechlet.SpeechletResponse;
import com.amazon.speech.ui.PlainTextOutputSpeech;

public class CatchAllIntentHandler extends IntentHandler {

	@Override
	public SpeechletResponse handle(SpeechletRequestEnvelope<IntentRequest> request) {
		PlainTextOutputSpeech outputSpeech = new PlainTextOutputSpeech();
		outputSpeech.setText("This is not supported. Please try something else.");
		return SpeechletResponse.newTellResponse(outputSpeech);	}

}
