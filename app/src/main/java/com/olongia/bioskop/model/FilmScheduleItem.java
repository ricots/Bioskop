package com.olongia.bioskop.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.text.TextUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by wirasto on 7/9/16.
 */
public class FilmScheduleItem implements Parcelable {

    private String bioskop;
    private List<String> jam;
    private String harga;

    public String getBioskop() {
        return bioskop;
    }

    public void setBioskop(String bioskop) {
        this.bioskop = bioskop;
    }

    public List<String> getJam() {
        return jam;
    }

    public String getJamData() {
        StringBuilder sb = new StringBuilder();

        int i = 0;
        for (String s : jam) {
            //jam yang kosong dilewati saja
            if (TextUtils.isEmpty(s.trim())) {
                continue;
            }
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(s);
            i++;
        }

        return sb.toString();
    }

    public void setJam(List<String> jam) {
        this.jam = jam;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    //----------
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeStringArray(new String[] {
                this.bioskop,
                this.harga,
        });

        dest.writeStringList(this.jam);
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public FilmScheduleItem createFromParcel(Parcel in) {
            return new FilmScheduleItem(in);
        }

        public FilmScheduleItem[] newArray(int size) {
            return new FilmScheduleItem[size];
        }
    };

    public FilmScheduleItem() {}

    public FilmScheduleItem(Parcel in) {
        String[] data = new String[2];
        in.readStringArray(data);
        this.bioskop = data[0];
        this.harga = data[1];

        List<String> jam = new ArrayList<>();
        in.readStringList(jam);
        this.jam = jam;
    }
}
