package com.ibm.actions;

import java.io.InputStream;

import com.ibm.watson.developer_cloud.text_to_speech.v1.TextToSpeech;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.AudioFormat;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.Voice;
import com.ibm.watson.developer_cloud.text_to_speech.v1.util.WaveUtils;

public class TextAction {
	private String text;
	private String TEXTUSERNAME;
	private String TEXTPASSWORD;
	private InputStream audiostream;
	
	public TextAction(){
		TEXTUSERNAME= System.getenv("TEXTUSERNAME");
		TEXTPASSWORD= System.getenv("TEXTPASSWORD");
		
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	public String execute(){
		TextToSpeech service = new TextToSpeech();
//		service.setUsernameAndPassword("7759c1e2-4ca9-4e1b-9fad-7544188fc645", "8b5qJv6ubIAf");
		System.out.println("text");
		System.out.println(text);
		service.setUsernameAndPassword(TEXTUSERNAME,TEXTPASSWORD);
		try {
			InputStream stream = service.synthesize(text, Voice.EN_ALLISON, AudioFormat.WAV).execute();
			audiostream = WaveUtils.reWriteWaveHeader(stream);
			System.out.println("done");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "success";
	}

	public InputStream getAudiostream() {
		return audiostream;
	}


}
