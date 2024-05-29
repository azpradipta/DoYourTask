package com.example.doyourtask.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Tugas implements Serializable {
    private transient StringProperty namaTugas;
    private transient StringProperty mataKuliah;
    private transient StringProperty tengat;
    private transient StringProperty urgensi;

    public Tugas(String namaTugas, String mataKuliah, String tengat, String urgensi) {
        this.namaTugas = new SimpleStringProperty(namaTugas);
        this.mataKuliah = new SimpleStringProperty(mataKuliah);
        this.tengat = new SimpleStringProperty(tengat);
        this.urgensi = new SimpleStringProperty(urgensi);
    }

    public String getNamaTugas() {
        return namaTugas.get();
    }

    @SuppressWarnings("exports")
    public StringProperty namaTugasProperty() {
        return namaTugas;
    }

    public String getMataKuliah() {
        return mataKuliah.get();
    }

    @SuppressWarnings("exports")
    public StringProperty mataKuliahProperty() {
        return mataKuliah;
    }

    public String getTengat() {
        return tengat.get();
    }

    @SuppressWarnings("exports")
    public StringProperty tengatProperty() {
        return tengat;
    }

    public String getUrgensi() {
        return urgensi.get();
    }

    @SuppressWarnings("exports")
    public StringProperty urgensiProperty() {
        return urgensi;
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.writeUTF(namaTugas.get());
        out.writeUTF(mataKuliah.get());
        out.writeUTF(tengat.get());
        out.writeUTF(urgensi.get());
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        String namaTugasStr = in.readUTF();
        String mataKuliahStr = in.readUTF();
        String tengatStr = in.readUTF();
        String urgensiStr = in.readUTF();

        namaTugas = new SimpleStringProperty(namaTugasStr);
        mataKuliah = new SimpleStringProperty(mataKuliahStr);
        tengat = new SimpleStringProperty(tengatStr);
        urgensi = new SimpleStringProperty(urgensiStr);
    }
}
