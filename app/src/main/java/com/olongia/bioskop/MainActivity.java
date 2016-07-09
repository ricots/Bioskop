package com.olongia.bioskop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.olongia.bioskop.model.DaerahListAdapter;
import com.olongia.bioskop.model.DaerahListItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private DaerahListAdapter mAdapter;
    private List<DaerahListItem> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mData = new ArrayList<>();
        mAdapter = new DaerahListAdapter(this, mData);

        ListView listView = (ListView) findViewById(R.id.listDaerah);
        listView.setAdapter(mAdapter);
    }
}
