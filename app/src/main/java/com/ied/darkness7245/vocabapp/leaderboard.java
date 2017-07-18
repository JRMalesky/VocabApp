package com.ied.darkness7245.vocabapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class leaderboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard);
        final TextView leader;
        leader = (TextView) findViewById(R.id.leaderboard);

        FirebaseDatabase leaderboards = FirebaseDatabase.getInstance();
        final Query leaderref = leaderboards.getReference("leaderboard");
        leaderref.addChildEventListener(new ChildEventListener() {
            List<Integer> leaderboards = new ArrayList<Integer>();

            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Integer message = dataSnapshot.getValue(Integer.class);
                leaderboards.add(message);
                Collections.sort(leaderboards);
                Collections.reverse(leaderboards);
                StringBuilder str = new StringBuilder(6);
                for (int i = 0; i < leaderboards.size() && i < 20; i++)
                {
                    str.append(leaderboards.get(i).toString() + "\n");
                }
                leader.setText(str);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                Integer message = dataSnapshot.getValue(Integer.class);
                leaderboards.remove(message);
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
