package com.example.darkness7245.vocabapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

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
                startActivity(new Intent(GameActivity.this,MainActivity.class));

            }
        });

    }
}


