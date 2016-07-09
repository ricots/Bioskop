package com.olongia.bioskop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class FilmListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film_list);

        Intent intent = getIntent();
        Log.d("BIOSKOP", Long.toString(intent.getLongExtra("id", 85)));
        setTitle(intent.getStringExtra("nama"));
    }
}
