package com.example.darkness7245.vocabapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    public int randomdificulty()
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

}
