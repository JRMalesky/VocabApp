package com.example.darkness7245.vocabapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Enumeration;
import java.util.Map;
import java.util.Random;



public class MainActivity extends AppCompatActivity {

    int numberofhints = 0;
    String word = "dog";
    EditText hintone, hinttwo, hintthree, wordtxt, userinput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //creating the variables
        hintone = (EditText) findViewById(R.id.txthintone);
        hinttwo = (EditText) findViewById(R.id.txthinetwo);
        hintthree = (EditText) findViewById(R.id.txthintthree);
        wordtxt = (EditText) findViewById(R.id.txtword);
        userinput = (EditText) findViewById(R.id.txtinput);
        Button hintbtn = (Button) findViewById(R.id.btnHInt);
        Button nextbtn = (Button) findViewById(R.id.btnnext);
        //setting the word text box to the given word
        word = word.toLowerCase();
        word = ScrambleWord(word);
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
                    //first hint first letter of the given word
                    String firstLetter = String.valueOf(word.charAt(0));
                    hintone.setText(firstLetter);
                }
                if (numberofhints == 2)
                {
                    //second hint sentence
                    String sentence = "A dog is a man's best friend.";
                    hinttwo.setText(sentence);
                }
                if(numberofhints == 3)
                {
                    //third hint syn and ant
                    String synandant = "pup, doggo, doggy, puppo, puppy";
                    hintthree.setText(synandant);
                }
            }
        });
        nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //clearing the hints
                //and setting the word text box to the new word
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
            //switching the letter around with a random index each time
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
            //easy
            return 0;
        }
        else if (a.length() > 4 && a.length() < 7)
        {
            //medium
            return  1;
        }
        else
        {
            //hard
            return  3;
        }
    }

    public boolean CheckWord(String a, String b)
    {
        a = a.toLowerCase();
        b = b.toLowerCase();
        int letter_check = 0;
        char c[] = a.toCharArray();
        char d[] = b.toCharArray();
        for (int i = 0; i < a.length(); i++)
        {
            if (c[i] == d[i])
            {
                //checking each letter in the string and keeping track of how many are correct
                letter_check++;
            }
        }
        //return true if all the letter match
        if (letter_check == a.length())
            return  true;
        else
            return  false;
    }


}
