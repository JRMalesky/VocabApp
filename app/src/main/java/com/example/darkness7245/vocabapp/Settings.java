package com.example.darkness7245.vocabapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Button saveset = (Button) findViewById(R.id.btnsaveset);
        saveset.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Settings.this, MainActivity.class);
                intent.putExtra("settingsExtra", GetSettings());
                startActivity(intent);
            }
        });
    }
    private int GetSettings() {

        RadioButton easy, med, hard, rand, streak;
        easy = (RadioButton) findViewById(R.id.radioeasy);
        med = (RadioButton) findViewById(R.id.radiomed);
        hard = (RadioButton) findViewById(R.id.radiohard);
        streak = (RadioButton) findViewById(R.id.radiostreak);
        rand = (RadioButton) findViewById(R.id.radiorand);
        if (easy.isChecked())
            return  0;
        else if (med.isChecked())
            return 1;
        else if (hard.isChecked())
            return 2;
        else if (streak.isChecked())
            return 3;
        else if (rand.isChecked())
            return 4;
        return -1;
    }
}

