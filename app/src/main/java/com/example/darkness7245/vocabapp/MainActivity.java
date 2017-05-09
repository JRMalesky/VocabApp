package com.example.darkness7245.vocabapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Dictionary;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Random;



public class MainActivity extends AppCompatActivity {

    int numberofhints = 0;
    String word = "dog";
    EditText hintone, hinttwo, hintthree, wordtxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hintone = (EditText) findViewById(R.id.txthintone);
        hinttwo = (EditText) findViewById(R.id.txthinetwo);
        hintthree = (EditText) findViewById(R.id.txthintthree);
        wordtxt = (EditText) findViewById(R.id.txtword);
        Button hintbtn = (Button) findViewById(R.id.btnHInt);
        Button nextbtn = (Button) findViewById(R.id.btnnext);
        wordtxt.setText(word);
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

                    String firstLetter = String.valueOf(word.charAt(0));
                    hintone.setText(firstLetter);
                }
                if (numberofhints == 2)
                {
                    String sentence = "A dog is a man best friend.";
                    hinttwo.setText(sentence);
                }
                if(numberofhints == 3)
                {
                    String synandant = "pup, doggo, doggy, puppo, puppy";
                    hintthree.setText(synandant);
                }
            }
        });
        nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String empty = "";
                hintone.setText(empty);
                hinttwo.setText(empty);
                hintthree.setText(empty);
                wordtxt.setText(word);
                numberofhints = 0;
            }
        });
    }



    public int Random_Difficulty()
    {
        Random rand = new Random();
        return rand.nextInt(3);
    }
    public String ScrambleWord(String _string)
    {
        Random rand = new Random();
        char a[] = _string.toCharArray();

        for( int i=0 ; i< a.length ; i++ )
        {
            int j = rand.nextInt(a.length);
            char temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }

        return new String( a );
    }

    public int CheckDifficulty(String a)
    {
        if(a.length() < 4)
        {
            return 0;
        }
        else if (a.length() > 4 && a.length() < 7)
        {
            return  1;
        }
        else
        {
            return  3;
        }
    }

    public boolean CheckWord(String a, String b)
    {
        int letter_check = 0;
        char c[] = a.toCharArray();
        char d[] = b.toCharArray();
        for (int i = 0; i < a.length(); i++)
        {
            if (c[i] == d[i])
            {
                letter_check++;
            }
        }
        if (letter_check == a.length())
            return  true;
        else
            return  false;
    }


}
