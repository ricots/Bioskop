package com.olongia.bioskop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;

import com.olongia.bioskop.model.FilmScheduleAdapter;
import com.olongia.bioskop.model.FilmScheduleItem;

import java.util.ArrayList;
import java.util.List;

public class FilmScheduleActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film_schedule);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        List<FilmScheduleItem> jadwal = intent.getParcelableArrayListExtra("jadwal");

        getSupportActionBar().setTitle("Jadwal Tayang");
        getSupportActionBar().setSubtitle(intent.getStringExtra("judul"));

        ListView listView = (ListView) findViewById(R.id.listSchedule);
        listView.setAdapter(new FilmScheduleAdapter(this, jadwal));
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return true;
    }
}
