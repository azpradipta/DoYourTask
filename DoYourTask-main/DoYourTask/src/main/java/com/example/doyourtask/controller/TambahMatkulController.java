package com.example.doyourtask.controller;

import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class TambahMatkulController {

    @FXML
    private TextField namaMataKuliahTextField;

    @FXML
    private TableView<String> tabelMatkul;

    @FXML
    private TableColumn<String, String> TabelMatkul;

    private final ObservableList<String> mataKuliahList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        TabelMatkul.setCellValueFactory(data -> new ReadOnlyStringWrapper(data.getValue()));
        tabelMatkul.setItems(mataKuliahList);
        TambahTugasController.setMataKuliahList(mataKuliahList);
    }

    @FXML
    private void tambahkanMatkulOnAction() {
        String mataKuliah = namaMataKuliahTextField.getText();
        if (!mataKuliah.isEmpty() && !mataKuliahList.contains(mataKuliah)) {
            mataKuliahList.add(mataKuliah);
            namaMataKuliahTextField.clear();
        }
    }

    @FXML
    private void hapusMatkulOnAction() {
        String selectedMataKuliah = tabelMatkul.getSelectionModel().getSelectedItem();
        if (selectedMataKuliah != null) {
            mataKuliahList.remove(selectedMataKuliah);
        }
    }
}
