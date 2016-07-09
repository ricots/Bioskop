package com.olongia.bioskop.model;

import android.text.TextUtils;

import java.util.List;

/**
 * Created by wirasto on 7/9/16.
 */
public class FilmScheduleItem {

    private String bioskop;
    private List<String> jam;

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
}
