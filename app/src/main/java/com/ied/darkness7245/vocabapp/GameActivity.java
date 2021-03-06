package com.ied.darkness7245.vocabapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

/**
 * Created by Student on 5/19/2017.
 */

public class GameActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

            Button enter_game=(Button)findViewById(R.id.enter_game);
        enter_game.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                //setContentView(R.layout.activity_main);
                Intent intent = new Intent(GameActivity.this,MainActivity.class);
                intent.putExtra("example", Getdifficulty().ordinal());
                intent.putExtra("lang", GetLanguage());
                startActivity(intent);

            }
        });

    }
    private final Difficulty Getdifficulty()
    {
        RadioButton easy, med, hard, streak, random;
        easy = (RadioButton) findViewById(R.id.radeasy);
        med = (RadioButton) findViewById(R.id.radmed);
        hard = (RadioButton) findViewById(R.id.radhard);
        streak = (RadioButton) findViewById(R.id.radstreak);
        random = (RadioButton) findViewById(R.id.radrand);

        if(easy.isChecked())
        {
            return Difficulty.EASY;
        }
        else if(med.isChecked())
        {
            return Difficulty.MEDIUM;
        }
        else if(hard.isChecked())
        {
            return Difficulty.HARD;
        }
        else if(streak.isChecked())
        {
            return Difficulty.STREAK;
        }
        else if(random.isChecked())
        {
            return Difficulty.RANDOM;
        }
        else
            return Difficulty.RANDOM;

    }
    private final int GetLanguage()
    {
        RadioButton english, french, spanish;
        english = (RadioButton) findViewById(R.id.radEnglish);
        french = (RadioButton) findViewById(R.id.radFrench);
        spanish = (RadioButton) findViewById(R.id.radspanishmain);
        if (english.isChecked())
        {
            return 0;
        }
        else if (french.isChecked())
        {
            return  1;
        }
        else if (spanish.isChecked())
        {
            return 2;
        }
        else
        {
            return 0;
        }
    }


}


