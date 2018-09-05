package com.subhash.jukebox.skills.intents.handlers;

import com.amazon.speech.json.SpeechletRequestEnvelope;
import com.amazon.speech.speechlet.IntentRequest;
import com.amazon.speech.speechlet.SpeechletResponse;
import com.amazon.speech.ui.PlainTextOutputSpeech;

public class PlayMusicIntentHandler extends IntentHandler {

	@Override
	public SpeechletResponse handle(SpeechletRequestEnvelope<IntentRequest> request) {
		PlainTextOutputSpeech outputSpeech = new PlainTextOutputSpeech();
		outputSpeech.setText("I am playing music");
		return SpeechletResponse.newTellResponse(outputSpeech);
	}

}
