package com.example.darkness7245.vocabapp;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.Queue;
import java.util.Random;

public class MainActivity extends AppCompatActivity { //implements TextToSpeech.OnInitListener

    TextView tv_text;
    Button b_scramble;
    Button b_s;
    EditText hintone, hinttwo, hintthree, wordtxt, userinput;
    int numberofhints = 0;
    /*private TextToSpeech tts;
    private Button S;
    private TextView getTextToSpeak;*/
    String text = " ";
    String word = "";
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
        //Button nextbtn = (Button) findViewById(R.id.btnnext);
        b_scramble = (Button) findViewById(R.id.btnnext);
        //b_s = (Button) findViewById((R.id.b_s));
        tv_text = (TextView) findViewById(R.id.txtviewword);


        //word = word.toLowerCase();
        //String scrambledword = ScrambleWord(word);
        //wordtxt.setText(scrambledword);

        b_scramble.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {

                try {
                    InputStream is = getAssets().open("10EnglishWithDefinition.txt");
                    int size = is.available();
                    byte[] buffer = new byte[size];
                    is.read(buffer);
                    is.close();
                    text = new String(buffer);
                } catch (IOException ex) {

                    ex.printStackTrace();
                }
                tv_text.setText(text);










                String[] parts = text.split(":");
                word = parts[0];
                String empty = "";
                hintone.setText(empty);
                hinttwo.setText(empty);
                hintthree.setText(empty);
                numberofhints = 0;
            }

        });
        hintbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if (numberofhints < 4)
                {
                    numberofhints++;
                }
                if (numberofhints == 1)
                {
                    //first hint first letter of the given word
                    String firstLetter = String.valueOf(text.charAt(0));
                    hintone.setText(firstLetter);
                }
                else if (numberofhints == 2)
                {
                    //second hint sentence
                    String sentence = "A dog is a man's best friend.";
                    hinttwo.setText(sentence);
                }
                else if(numberofhints == 3)
                {
                    //third hint syn and ant
                    String synandant = "pup, doggo, doggy, puppo, puppy";
                    hintthree.setText(synandant);
                }
            }
        });
        userinput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String userword = userinput.getText().toString();
                if (CheckWord(word, userword))
                {
                    Toast toast = Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT);
                    toast.show();
                }
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