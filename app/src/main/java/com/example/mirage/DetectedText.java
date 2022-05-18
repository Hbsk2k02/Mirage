package com.example.mirage;

//import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
//import android.speech.tts.TextToSpeech;
import android.widget.TextView;

public class DetectedText extends AppCompatActivity {

    TextView idDetectedText;
    String detectedText;

    //private TextToSpeech textToSpeech;

    //@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detected_text);

//        textToSpeech = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
//            @Override
//            public void onInit(int status) {
//
//            }
//        });

        idDetectedText = findViewById(R.id.idDetectedText);
        Bundle bn = getIntent().getExtras();
        detectedText = bn.getString("Dtext");
        idDetectedText.setText(String.valueOf(detectedText));
        //textToSpeech.speak(bn.getString("Dtext"), TextToSpeech.QUEUE_FLUSH,null,null);
    }
}