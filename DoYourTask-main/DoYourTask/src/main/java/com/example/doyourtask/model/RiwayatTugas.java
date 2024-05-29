package com.example.doyourtask.model;

import java.io.Serializable;

public class RiwayatTugas implements Serializable {
    private String namaTugas;
    private String mataKuliah;
    private String status;

    public RiwayatTugas(String namaTugas, String mataKuliah, String status) {
        this.namaTugas = namaTugas;
        this.mataKuliah = mataKuliah;
        this.status = status;
    }

    public String getNamaTugas() {
        return namaTugas;
    }

    public void setNamaTugas(String namaTugas) {
        this.namaTugas = namaTugas;
    }

    public String getMataKuliah() {
        return mataKuliah;
    }

    public void setMataKuliah(String mataKuliah) {
        this.mataKuliah = mataKuliah;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
