package com.subhash.jukebox.skills.utils;

import java.util.ArrayList;
import java.util.List;

import com.amazon.speech.speechlet.Directive;
import com.amazon.speech.speechlet.SpeechletResponse;
import com.amazon.speech.speechlet.dialog.directives.ElicitSlotDirective;
import com.amazon.speech.ui.OutputSpeech;
import com.amazon.speech.ui.PlainTextOutputSpeech;
import com.amazon.speech.ui.Reprompt;
import com.amazon.speech.ui.SimpleCard;
import com.subhash.jukebox.skills.constants.Constants;

public class SpeechGenerationUtils {
	
	/**
	 * Helper method for retrieving an Ask response with a simple card and reprompt
	 * included.
	 * 
	 * @param cardTitle
	 *            Title of the card that you want displayed.
	 * @param speechText
	 *            speech text that will be spoken to the user.
	 * @return the resulting card and speech text.
	 */
	public static SpeechletResponse getAskResponse(String cardTitle, String speechText) {
		SimpleCard card = getSimpleCard(cardTitle, speechText);
		PlainTextOutputSpeech speech = getPlainTextOutputSpeech(speechText);
		Reprompt reprompt = getReprompt(speech);
		return SpeechletResponse.newAskResponse(speech, reprompt, card);
	}
	
	/**
	 * Helper method that creates a card object.
	 * 
	 * @param title
	 *            title of the card
	 * @param content
	 *            body of the card
	 * @return SimpleCard the display card to be sent along with the voice response.
	 */
	public static SimpleCard getSimpleCard(String title, String content) {
		SimpleCard card = new SimpleCard();
		card.setTitle(title);
		card.setContent(content);

		return card;
	}
	
	/**
	 * Helper method for retrieving an OutputSpeech object when given a string of
	 * TTS.
	 * 
	 * @param speechText
	 *            the text that should be spoken out to the user.
	 * @return an instance of SpeechOutput.
	 */
	public static PlainTextOutputSpeech getPlainTextOutputSpeech(String speechText) {
		PlainTextOutputSpeech speech = new PlainTextOutputSpeech();
		speech.setText(speechText);
		return speech;
	}
	
	/**
	 * Helper method that returns a reprompt object. This is used in Ask responses
	 * where you want the user to be able to respond to your speech.
	 * 
	 * @param outputSpeech
	 *            The OutputSpeech object that will be said once and repeated if
	 *            necessary.
	 * @return Reprompt instance.
	 */
	public static Reprompt getReprompt(OutputSpeech outputSpeech) {
		Reprompt reprompt = new Reprompt();
		reprompt.setOutputSpeech(outputSpeech);

		return reprompt;
	}
	
	public static SpeechletResponse elicitSlot(String slotName , String promptText , boolean endSessionFlag){
		
		System.out.println("Eliciting the Slot - " + slotName);
		ElicitSlotDirective elicitSlotDirective = new ElicitSlotDirective();
		elicitSlotDirective.setSlotToElicit(slotName);
		
		List<Directive> directiveList = new ArrayList<Directive>();
		directiveList.add(elicitSlotDirective);

		SpeechletResponse speechletResp = new SpeechletResponse();
		speechletResp.setDirectives(directiveList);
		speechletResp.setNullableShouldEndSession(endSessionFlag);
		speechletResp.setOutputSpeech(getPlainTextOutputSpeech(promptText));
		speechletResp.setCard(getSimpleCard(Constants.CARD_TITLE_HOME_JUKEBOX, promptText));
		speechletResp.setReprompt(getReprompt(getPlainTextOutputSpeech(promptText)));

		return speechletResp;
	}

}
