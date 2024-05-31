package com.example.doyourtask.controller;

import com.example.doyourtask.model.MataKuliah;
import com.example.doyourtask.model.MataKuliahData;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class TambahMatkulController {

    @FXML
    private TextField namaMataKuliahTextField;

    @FXML
    private TableView<MataKuliah> tabelMatkul;

    @FXML
    private TableColumn<MataKuliah, String> TabelMatkul;

    private ObservableList<MataKuliah> mataKuliahList;

    @FXML
    public void initialize() {
        mataKuliahList = MataKuliahData.getInstance().getMataKuliahList();

        TabelMatkul.setCellValueFactory(data -> new ReadOnlyStringWrapper(data.getValue().getNamaMataKuliah()));
        tabelMatkul.setItems(mataKuliahList);

        // Set listener to save data whenever mataKuliahList changes
        mataKuliahList.addListener((ListChangeListener<MataKuliah>) change -> {
            while (change.next()) {
                MataKuliahData.getInstance().saveMataKuliahData();
            }
        });

        // Update this line to pass mataKuliahList directly
        TambahTugasController.setMataKuliahList(mataKuliahList);
    }

    @FXML
    private void tambahkanMatkulOnAction() {
        String namaMataKuliah = namaMataKuliahTextField.getText().trim();
        if (!namaMataKuliah.isEmpty() && !isMataKuliahExist(namaMataKuliah)) {
            MataKuliah mataKuliah = new MataKuliah(namaMataKuliah);
            mataKuliahList.add(mataKuliah);
            namaMataKuliahTextField.clear();
        }
    }

    private boolean isMataKuliahExist(String namaMataKuliah) {
        for (MataKuliah mataKuliah : mataKuliahList) {
            if (mataKuliah.getNamaMataKuliah().equals(namaMataKuliah)) {
                return true;
            }
        }
        return false;
    }

    @FXML
    private void hapusMatkulOnAction() {
        MataKuliah selectedMataKuliah = tabelMatkul.getSelectionModel().getSelectedItem();
        if (selectedMataKuliah != null) {
            mataKuliahList.remove(selectedMataKuliah);
        }
    }
}
