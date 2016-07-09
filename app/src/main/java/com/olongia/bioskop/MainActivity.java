package com.olongia.bioskop;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.olongia.bioskop.model.DaerahListAdapter;
import com.olongia.bioskop.model.DaerahListItem;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {

    private AsyncHttpClient mClient;
    private DaerahListAdapter mAdapter;
    private List<DaerahListItem> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mClient = new AsyncHttpClient();

        mData = new ArrayList<>();
        mAdapter = new DaerahListAdapter(this, mData);

        ListView listView = (ListView) findViewById(R.id.listDaerah);
        listView.setAdapter(mAdapter);

        //ambil depe data
        onGetData();
    }


    private void onGetData() {
        final ProgressDialog pd = ProgressDialog.show(this, "", "Tunggi sadiki...", true, false);

        mClient.get("http://ibacor.com/api/jadwal-bioskop", new JsonHttpResponseHandler() {
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
                        mData.add(new DaerahListItem(o.getInt("id"), o.getString("kota")));
                    }
                    mAdapter.notifyDataSetChanged();

                } catch (Exception ex) {
                    Toast.makeText(MainActivity.this, "Data gagal ditampilkan", Toast.LENGTH_SHORT).show();
                }

                pd.dismiss();
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                pd.dismiss();
                Toast.makeText(MainActivity.this, "Permintaan ke server gagal", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
