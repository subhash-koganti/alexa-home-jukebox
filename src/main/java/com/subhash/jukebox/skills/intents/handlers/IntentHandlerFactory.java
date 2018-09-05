package com.subhash.jukebox.skills.intents.handlers;

import com.subhash.jukebox.skills.constants.HomeJukeBoxIntents;

public class IntentHandlerFactory {
	
	public IntentHandler createIntentHandlerBasedOnIntent(String intentName){
		
		if (HomeJukeBoxIntents.AMAZON_HelpIntent.equals(intentName)) {
			return new AmazonHelpIntentHandler();
		} else if (HomeJukeBoxIntents.AMAZON_StopIntent.equals(intentName)) {
			return new AmazonStopIntentHandler();
		} else if (HomeJukeBoxIntents.AMAZON_CancelIntent.equals(intentName)) {
			return new AmazonCancelIntentHandler();
		} else if (HomeJukeBoxIntents.AMAZON_NavigateHomeIntent.equals(intentName)) {
			return new AmazonNavigateHomeIntentHandler();
		} else if (HomeJukeBoxIntents.AMAZON_PauseIntent.equals(intentName)) {
			return new AmazonPauseIntentHandler();
		} else if (HomeJukeBoxIntents.AMAZON_ResumeIntent.equals(intentName)) {
			return new AmazonResumeIntentHandler();
		} else if (HomeJukeBoxIntents.PlayMusicIntent.equals(intentName)) {
			return new PlayMusicIntentHandler();
		} else {
			return new CatchAllIntentHandler();
		}
	}

}
