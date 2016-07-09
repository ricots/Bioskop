package com.olongia.bioskop.model;

import java.util.List;

/**
 * Created by wirasto on 7/9/16.
 */
public class FilmListItem {

    private String movie;
    private String poster;
    private List<FilmScheduleItem> jadwal;

    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public List<FilmScheduleItem> getJadwal() {
        return jadwal;
    }

    public void setJadwal(List<FilmScheduleItem> jadwal) {
        this.jadwal = jadwal;
    }
}
