package com.subhash.jukebox.skills;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.amazon.speech.json.SpeechletRequestEnvelope;
import com.amazon.speech.slu.Intent;
import com.amazon.speech.speechlet.IntentRequest;
import com.amazon.speech.speechlet.LaunchRequest;
import com.amazon.speech.speechlet.SessionEndedRequest;
import com.amazon.speech.speechlet.SessionStartedRequest;
import com.amazon.speech.speechlet.SpeechletResponse;
import com.amazon.speech.speechlet.SpeechletV2;
import com.subhash.jukebox.skills.constants.Constants;
import com.subhash.jukebox.skills.intents.handlers.IntentHandler;
import com.subhash.jukebox.skills.intents.handlers.IntentHandlerFactory;
import com.subhash.jukebox.skills.utils.SpeechGenerationUtils;

public class HomeJukeBoxSkillsSpeechlet implements SpeechletV2 {

	private static final Logger log = LoggerFactory.getLogger(HomeJukeBoxSkillsSpeechlet.class);

	@Override
	public void onSessionStarted(SpeechletRequestEnvelope<SessionStartedRequest> requestEnvelope) {
		log.info("onSessionStarted requestId={}, sessionId={}", requestEnvelope.getRequest().getRequestId(),
				requestEnvelope.getSession().getSessionId());
		
		System.out.println("HOME JUKEBOX RATEQUOTING SESSION STARTED - onSessionStarted method");
	}

	@Override
	public SpeechletResponse onLaunch(SpeechletRequestEnvelope<LaunchRequest> requestEnvelope) {
		log.info("onLaunch requestId={}, sessionId={}", requestEnvelope.getRequest().getRequestId(),
				requestEnvelope.getSession().getSessionId());
		System.out.println("HOME JUKEBOX RATEQUOTING SESSION LAUNCHED - onLaunch method");
		System.out.println("USER ID is " + requestEnvelope.getSession().getUser().getUserId());
		String speechText = Constants.HOME_JUKEBOX_WELCOME_TEXT;
		SpeechletResponse response = SpeechGenerationUtils.getAskResponse(Constants.CARD_TITLE_HOME_JUKEBOX, speechText);
		return response;
	}

	@Override
	public SpeechletResponse onIntent(SpeechletRequestEnvelope<IntentRequest> requestEnvelope) {
		
		System.out.println("HOME JUKEBOX INTENT HANDLING - onIntent method");
		IntentRequest request = requestEnvelope.getRequest();
		log.info("onIntent requestId={}, sessionId={}", request.getRequestId(),
				requestEnvelope.getSession().getSessionId());

		Intent intent = request.getIntent();
		String intentName = (intent != null) ? intent.getName() : null;
		System.out.println("INTENT DETECTED IS - " +intentName);
		IntentHandler intentHandler = new IntentHandlerFactory().createIntentHandlerBasedOnIntent(intentName);
		return intentHandler.handle(requestEnvelope);
	}

	@Override
	public void onSessionEnded(SpeechletRequestEnvelope<SessionEndedRequest> requestEnvelope) {
		log.info("onSessionEnded requestId={}, sessionId={}", requestEnvelope.getRequest().getRequestId(),
				requestEnvelope.getSession().getSessionId());

		System.out.println("HOME JUKEBOX RATEQUOTING SESSION ENDED");
	}

}
