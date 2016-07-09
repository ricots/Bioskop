package com.olongia.bioskop.model;

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

    public void setJam(List<String> jam) {
        this.jam = jam;
    }
}
