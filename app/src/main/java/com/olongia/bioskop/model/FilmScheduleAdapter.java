package com.olongia.bioskop.model;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.olongia.bioskop.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wirasto on 7/11/16.
 */
public class FilmScheduleAdapter extends BaseAdapter {

    private Context mContext;
    private List<FilmScheduleItem> mData;

    public FilmScheduleAdapter(Context context, List<FilmScheduleItem> data) {
        this.mContext = context;
        this.mData = data;
    }

    @Override
    public  int getCount() {
        return mData.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public FilmScheduleItem getItem(int position) {
        return mData.get(position);
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        if (convertView==null) {
            LayoutInflater inflater=(LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.list_item_film_schedule_list, null);
        }

        FilmScheduleItem item = getItem(position);

        ((TextView) convertView.findViewById(R.id.row_schedule_bioskop)).setText(item.getBioskop());
        ((TextView) convertView.findViewById(R.id.row_schedule_harga)).setText(item.getHarga());
        ((TextView) convertView.findViewById(R.id.row_schedule_jam)).setText(item.getJamData());

        return convertView;
    }
}
