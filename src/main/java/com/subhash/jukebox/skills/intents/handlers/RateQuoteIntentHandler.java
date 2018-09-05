//package com.subhash.jukebox.skills.intents.handlers;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import com.amazon.speech.json.SpeechletRequestEnvelope;
//import com.amazon.speech.slu.Intent;
//import com.amazon.speech.speechlet.Directive;
//import com.amazon.speech.speechlet.IntentRequest;
//import com.amazon.speech.speechlet.IntentRequest.DialogState;
//import com.amazon.speech.speechlet.SpeechletResponse;
//import com.amazon.speech.speechlet.dialog.directives.ElicitSlotDirective;
//import com.amazon.speech.ui.PlainTextOutputSpeech;
//import com.amazonaws.util.StringUtils;
//import com.subhash.archmi.skills.ratequote.RateQuoteRequestBuilder;
//import com.subhash.archmi.skills.ratequote.RateQuoteServiceClient;
//import com.subhash.archmi.skills.ratequote.RateQuoteSpeechTextGenerator;
//import com.subhash.jukebox.skills.constants.Constants;
//
//public class RateQuoteIntentHandler extends IntentHandler {
//
//	@Override
//	public SpeechletResponse handle(SpeechletRequestEnvelope<IntentRequest> requestEnv) {
//		
//		IntentRequest request = requestEnv.getRequest();
//		Intent intent = request.getIntent();
//		DialogState dialogueState = request.getDialogState();
//		
//		boolean validationStatus = validateSlotValues(request);
//		System.out.println("RATEQUOTE INTENT HANDLER- DialogState/ValidationStatus - " + dialogueState + "/" +validationStatus) ;
//		
//
//		if (validationStatus && (dialogueState == IntentRequest.DialogState.STARTED
//				|| dialogueState == IntentRequest.DialogState.IN_PROGRESS)) {
//			return delegateBackToAlexa(intent);
//		} else if(validationStatus == false){
//			return promptForCorrectInput(intent);
//		} else {
//			System.out.println("dialogueState is niether STARTED NOR IN_PROGRESS");
//			return generateRatequoteSpeechResponse(request);
//		}
//	}
//
//	private SpeechletResponse promptForCorrectInput(Intent intent) {
//		System.out.println("prompting for Correct Input ");
//		
//		ElicitSlotDirective elicitSlotDirective = new ElicitSlotDirective();
//		elicitSlotDirective.setSlotToElicit("CreditScore");
//		
//		List<Directive> directiveList = new ArrayList<Directive>();
//		directiveList.add(elicitSlotDirective);
//
//		SpeechletResponse speechletResp = new SpeechletResponse();
//		speechletResp.setDirectives(directiveList);
//		speechletResp.setNullableShouldEndSession(false);
//		PlainTextOutputSpeech prompt = new PlainTextOutputSpeech();
//		prompt.setText("Your input is invalid. Please try again ");
//		
//		speechletResp.setOutputSpeech(prompt);
//		return speechletResp;
//	}
//
//	private SpeechletResponse generateRatequoteSpeechResponse(IntentRequest intentRequest) {
//		
//		PlainTextOutputSpeech outputSpeech = new PlainTextOutputSpeech();
//		try {
//			
////			RateQuoteRequest ratequoteReq = RateQuoteRequestBuilder.buildUsingIntentRequest(intentRequest);
////			RateQuoteResponse response = new RateQuoteServiceClient().callRateQuoteService(ratequoteReq);
////			System.out.println("RateQuote Response is - "+ response);
////			String speechText = new RateQuoteSpeechTextGenerator().generate(response);
////			outputSpeech.setText(speechText);
//			
//		} catch (Exception e) {
//			outputSpeech.setText(Constants.ARCH_SKILL_ERROR_TEXT);
//			e.printStackTrace();
//			
//		}
//		return SpeechletResponse.newTellResponse(outputSpeech);
//	}
//	
//	
//	private boolean validateSlotValues(IntentRequest request){
//		
//		String creditScore= (String)request.getIntent().getSlots().get("CreditScore").getValue();
//		System.out.println("VALIDATING the CreditScore " + creditScore);
//		if(StringUtils.isNullOrEmpty(creditScore)){
//			return true;
//		}
//		try{
//			int creditScoreInt = Integer.parseInt(creditScore);
//			if(creditScoreInt < 620 || creditScoreInt > 850){
//				return false;
//			}
//		}catch(Exception e){
//			e.printStackTrace();
//			return false;
//		}
//		return true;
//	}
//}
