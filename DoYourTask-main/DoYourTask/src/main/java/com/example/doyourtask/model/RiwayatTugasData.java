package com.example.doyourtask.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RiwayatTugasData {
    private static RiwayatTugasData instance = null;
    private final ObservableList<RiwayatTugas> riwayatTugasList;

    private RiwayatTugasData() {
        riwayatTugasList = FXCollections.observableArrayList();
    }

    public static RiwayatTugasData getInstance() {
        if (instance == null) {
            instance = new RiwayatTugasData();
        }
        return instance;
    }

    public ObservableList<RiwayatTugas> getRiwayatTugasList() {
        return riwayatTugasList;
    }

    public void addRiwayatTugas(RiwayatTugas riwayatTugas) {
        riwayatTugasList.add(riwayatTugas);
    }

    public void saveRiwayatTugasData() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("riwayatTugasData.ser"))) {
            out.writeObject(new ArrayList<>(riwayatTugasList));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public void loadRiwayatTugasData() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("riwayatTugasData.ser"))) {
            List<RiwayatTugas> loadedList = (List<RiwayatTugas>) in.readObject();
            riwayatTugasList.setAll(loadedList);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void saveMataKuliahData() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("mataKuliahData.ser"))) {
            out.writeObject(new ArrayList<>(MataKuliahData.getInstance().getMataKuliahList()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public void loadMataKuliahData() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("mataKuliahData.ser"))) {
            List<MataKuliah> loadedList = (List<MataKuliah>) in.readObject();
            MataKuliahData.getInstance().getMataKuliahList().setAll(loadedList);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
