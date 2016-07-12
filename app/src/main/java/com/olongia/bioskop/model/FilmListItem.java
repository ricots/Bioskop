package com.olongia.bioskop.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wirasto on 7/9/16.
 */
public class FilmListItem {

    private String movie;
    private String poster;
    private ArrayList<FilmScheduleItem> jadwal;
    private String genre;
    private String duration;

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

    public ArrayList<FilmScheduleItem> getJadwal() {
        return jadwal;
    }

    public void setJadwal(ArrayList<FilmScheduleItem> jadwal) {
        this.jadwal = jadwal;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}
