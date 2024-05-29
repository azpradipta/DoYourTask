package com.example.doyourtask.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TugasData {
    private static TugasData instance = null;
    private final ObservableList<Tugas> tugasList;

    private TugasData() {
        tugasList = FXCollections.observableArrayList();
    }

    public static TugasData getInstance() {
        if (instance == null) {
            instance = new TugasData();
        }
        return instance;
    }

    public ObservableList<Tugas> getTugasList() {
        return tugasList;
    }

    public void addTugas(Tugas tugas) {
        tugasList.add(tugas);
    }

    public void saveTugasData() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("tugasData.ser"))) {
            out.writeObject(new ArrayList<>(tugasList));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public void loadTugasData() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("tugasData.ser"))) {
            List<Tugas> loadedList = (List<Tugas>) in.readObject();
            tugasList.setAll(loadedList);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
