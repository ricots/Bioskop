package com.olongia.bioskop.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.olongia.bioskop.R;

import java.util.List;

/**
 * Created by wirasto on 7/9/16.
 */
public class FilmListAdapter extends BaseAdapter {

    private Context mContext;
    private List<FilmListItem> mData;

    public FilmListAdapter(Context context, List<FilmListItem> data) {
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
    public FilmListItem getItem(int position) {
        return mData.get(position);
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        if (convertView==null) {
            LayoutInflater inflater=(LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.list_item_daerah_list, null);
        }

        ((TextView) convertView.findViewById(R.id.row_title)).setText( getItem(position).getMovie() );

        return convertView;
    }
}
