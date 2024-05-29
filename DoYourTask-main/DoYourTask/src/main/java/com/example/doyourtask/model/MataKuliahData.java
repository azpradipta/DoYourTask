package com.example.doyourtask.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MataKuliahData {
    private static MataKuliahData instance = null;
    private final ObservableList<MataKuliah> mataKuliahList;

    private MataKuliahData() {
        mataKuliahList = FXCollections.observableArrayList();
    }

    public static MataKuliahData getInstance() {
        if (instance == null) {
            instance = new MataKuliahData();
        }
        return instance;
    }

    public ObservableList<MataKuliah> getMataKuliahList() {
        return mataKuliahList;
    }

    public void addMataKuliah(MataKuliah mataKuliah) {
        mataKuliahList.add(mataKuliah);
    }

    public void saveMataKuliahData() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("mataKuliahData.ser"))) {
            out.writeObject(new ArrayList<>(mataKuliahList));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public void loadMataKuliahData() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("mataKuliahData.ser"))) {
            List<MataKuliah> loadedList = (List<MataKuliah>) in.readObject();
            mataKuliahList.setAll(loadedList);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
