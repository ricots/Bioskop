package com.olongia.bioskop.model;

/**
 * Created by wirasto on 7/9/16.
 */
public class DaerahListItem {

    private int id;
    private String nama;

    public DaerahListItem(int id, String nama) {
        this.id = id;
        this.nama = nama;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

}
