package com.example.mirage;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DetectedText extends AppCompatActivity {

    TextView idDetectedText;
    ImageView idBackButton,idTextToAudio;
    String detectedText;

    private TextToSpeech textToSpeech;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detected_text);

        textToSpeech = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {

            }
        });

        idDetectedText = findViewById(R.id.idDetectedText);
        idBackButton = findViewById(R.id.idBackButton);
        idTextToAudio = findViewById(R.id.idTextToAudio);

        Bundle bn = getIntent().getExtras();
        detectedText = bn.getString("Dtext");
        idDetectedText.setText(String.valueOf(detectedText));

        idBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetectedText.this,SnapActivity.class);
                startActivity(intent);
            }
        });

        idTextToAudio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textToSpeech.speak(detectedText, TextToSpeech.QUEUE_FLUSH,null,null);
            }
        });
    }
}