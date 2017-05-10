package com.example.darkness7245.vocabapp;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.Queue;

public class MainActivity extends AppCompatActivity{ //implements TextToSpeech.OnInitListener

    TextView tv_text;
    Button b_scramble;
    Button b_s;

    /*private TextToSpeech tts;
    private Button S;
    private TextView getTextToSpeak;*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

           b_scramble=(Button)findViewById(R.id.b_sramble);
           b_s=(Button)findViewById((R.id.b_s));
           tv_text=(TextView) findViewById(R.id.tv_text);



        b_scramble.setOnClickListener(new View.OnClickListener(){
               @Override

               public void onClick(View view){
                   String text=" ";
                   try {
                       InputStream is = getAssets().open("10EnglishWithDefinition.txt");
                       int size=is.available();
                       byte[]buffer=new byte[size];
                       is.read(buffer);
                       is.close();
                       text=new String(buffer);
                   }
                    catch(IOException ex){

                       ex.printStackTrace();
                   }
                   tv_text.setText(text);
                }

        });




    }

}

        /*tts = new TextToSpeech(this, this);

        getTextToSpeak = (TextView) findViewById(R.id.textView);
        S = (Button) findViewById(R.id.S);
        S.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                speakOutNow();
            }
        });

    }


    public void onInit(int text) {
        if (text == TextToSpeech.SUCCESS){
            int language = tts.setLanguage(Locale.ENGLISH);
        if (language == TextToSpeech.LANG_MISSING_DATA || language == getTextToSpeak.LANG_NOT_SUPPORTED) {
            S.setEnabled(true);
            speakOutNow();
        } else {
        }
    }
    else
    {

    }

}

    public void speakOutNow()
    {
        String text=getTextToSpeak.getText().toString();
        tts.speak(text,TextToSpeech.QUEUE_FLUSH,null);
    }
}
*/

