package com.olongia.bioskop;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.olongia.bioskop.model.FilmListAdapter;
import com.olongia.bioskop.model.FilmListItem;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;

public class FilmListActivity extends AppCompatActivity {

    private AsyncHttpClient mClient;
    private FilmListAdapter mAdapter;
    private List<FilmListItem> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film_list);

        Intent intent = getIntent();
        setTitle(intent.getStringExtra("nama"));

        mClient = new AsyncHttpClient();
        mClient.setTimeout(60*1000); // 1 menit (default 10 detik)

        mData = new ArrayList<>();
        mAdapter = new FilmListAdapter(this, mData);

        ListView listView = (ListView) findViewById(R.id.listFilm);
        listView.setAdapter(mAdapter);

        //ambil depe data (default: Gorontalo)
        onGetData(intent.getLongExtra("id", 85));
    }


    private void onGetData(final long id) {
        final ProgressDialog pd = ProgressDialog.show(this, "", "Tunggi sadiki...", true, false);

        mClient.get("http://ibacor.com/api/jadwal-bioskop?id=" + id, new JsonHttpResponseHandler() {
            @Override
            public void onStart() {
                Log.d("BIOSKOP", "Menghubungi API");
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                Log.d("BIOSKOP", Integer.toString(statusCode));

                try {
                    JSONArray data = new JSONArray(response.getString("data"));
                    for (int i = 0; i < data.length(); i++) {
                        JSONObject o = data.getJSONObject(i);

                        FilmListItem item = new FilmListItem();
                        item.setMovie(o.getString("movie"));
                        item.setPoster(o.getString("poster"));

                        mData.add(item);
                    }

                    mAdapter.notifyDataSetChanged();

                } catch (Exception ex) {
                    Toast.makeText(FilmListActivity.this, "Data gagal ditampilkan", Toast.LENGTH_SHORT).show();
                }

                pd.dismiss();
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                pd.dismiss();
                Toast.makeText(FilmListActivity.this, "Permintaan ke server gagal", Toast.LENGTH_SHORT).show();
            }
        });

    }
}