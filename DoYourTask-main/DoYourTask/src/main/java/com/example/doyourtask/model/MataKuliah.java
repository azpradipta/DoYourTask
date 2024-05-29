package com.example.doyourtask.model;

import java.io.Serializable;

public class MataKuliah implements Serializable {
    private String namaMataKuliah;

    public MataKuliah(String namaMataKuliah) {
        this.namaMataKuliah = namaMataKuliah;
    }

    public String getNamaMataKuliah() {
        return namaMataKuliah;
    }

    public void setNamaMataKuliah(String namaMataKuliah) {
        this.namaMataKuliah = namaMataKuliah;
    }

    @Override
    public String toString() {
        return namaMataKuliah;
    }
}
