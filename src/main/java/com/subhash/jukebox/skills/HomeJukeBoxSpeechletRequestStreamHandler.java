package com.subhash.jukebox.skills;

import java.util.HashSet;
import java.util.Set;

import com.amazon.speech.speechlet.lambda.SpeechletRequestStreamHandler;

public final class HomeJukeBoxSpeechletRequestStreamHandler extends SpeechletRequestStreamHandler {
    private static final Set<String> supportedApplicationIds;

    static {
        supportedApplicationIds = new HashSet<String>();
        supportedApplicationIds.add("amzn1.ask.skill.4b9b37c4-beea-4c9d-abed-47f83bde5e7e"); // Arch Skills-v2(Arch Account) App ID
        
    }

    public HomeJukeBoxSpeechletRequestStreamHandler() {
        super(new HomeJukeBoxSkillsSpeechlet(), supportedApplicationIds);
    }
}
