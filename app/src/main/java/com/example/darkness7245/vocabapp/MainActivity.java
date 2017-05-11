package com.example.darkness7245.vocabapp;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Queue;
import java.util.Random;

public class MainActivity extends AppCompatActivity { //implements TextToSpeech.OnInitListener

    TextView tv_text;
    Button b_scramble;
    Button b_s;
    EditText hintone, hinttwo, hintthree, wordtxt, userinput;

    /*private TextToSpeech tts;
    private Button S;
    private TextView getTextToSpeak;*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hintone = (EditText) findViewById(R.id.txthintone);
        hinttwo = (EditText) findViewById(R.id.txthinetwo);
        hintthree = (EditText) findViewById(R.id.txthintthree);
        //wordtxt = (EditText) findViewById(R.id.txtword);
        userinput = (EditText) findViewById(R.id.txtinput);
        Button hintbtn = (Button) findViewById(R.id.btnHInt);
        Button nextbtn = (Button) findViewById(R.id.btnnext);
        b_scramble = (Button) findViewById(R.id.btnnext);
        //b_s = (Button) findViewById((R.id.b_s));
        tv_text = (TextView) findViewById(R.id.txtviewword);


        b_scramble.setOnClickListener(new View.OnClickListener(){
            @Override

            public void onClick(View view){
                List<String> lines=new ArrayList<String>();
                String text=" ";
                try {


                    InputStream is = getAssets().open("10EnglishWithDefinition.txt");
                    BufferedReader reader=new BufferedReader((new InputStreamReader(is)));
                    String line=reader.readLine();
                    while(line!=null)
                    {
                        lines.add(line);
                        line=reader.readLine();

                    }
                    Random r=new Random();
                    text=lines.get(r.nextInt(lines.size()));


                }


                catch(IOException ex){

                    ex.printStackTrace();
                }
                tv_text.setText(text);
            }

        });

    }

    public int Random_Difficulty() {
        Random rand = new Random();
        return rand.nextInt(3);
    }

    public String ScrambleWord(String _string) {
        Random rand = new Random();
        char a[] = _string.toCharArray();

        for (int i = 0; i < a.length; i++) {
            //switching the letter around with a random index each time
            int j = rand.nextInt(a.length);
            char temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }

        return new String(a);
    }

    public int CheckDifficulty(String a) {
        if (a.length() < 4) {
            //easy
            return 0;
        } else if (a.length() > 4 && a.length() < 7) {
            //medium
            return 1;
        } else {
            //hard
            return 3;
        }
    }

    public boolean CheckWord(String a, String b) {

        a = a.toLowerCase();
        b = b.toLowerCase();
        if (a.equals(b))
            return true;
        else
            return false;
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

}