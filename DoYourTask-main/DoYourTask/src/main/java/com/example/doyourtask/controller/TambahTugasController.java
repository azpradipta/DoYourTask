package com.example.doyourtask.controller;

import com.example.doyourtask.model.Tugas;
import com.example.doyourtask.model.TugasData;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class TambahTugasController {

    @FXML
    private ChoiceBox<String> pilihMataKuliahChoiceBox;

    @FXML
    private ChoiceBox<String> urgensiTugasChoiceBox;

    @FXML
    private TextField namaTugasTextField;

    @FXML
    private DatePicker tengatDatePicker;

    private static ObservableList<String> mataKuliahList;

    @FXML
    public void initialize() {
        if (mataKuliahList != null) {
            pilihMataKuliahChoiceBox.setItems(mataKuliahList);
        }

        urgensiTugasChoiceBox.getItems().addAll("Sangat Mendesak", "Mendesak", "Tidak Mendesak");
    }


    public static void setMataKuliahList(ObservableList<String> list) {
        mataKuliahList = list;
    }


    @FXML
    private void tambahkanTugasOnAction() {
        String namaTugas = namaTugasTextField.getText();
        String mataKuliah = pilihMataKuliahChoiceBox.getValue();
        String tengat = tengatDatePicker.getValue() != null ? tengatDatePicker.getValue().toString() : "";
        String urgensi = urgensiTugasChoiceBox.getValue();

        Tugas tugasBaru = new Tugas(namaTugas, mataKuliah, tengat, urgensi);
        TugasData.getInstance().addTugas(tugasBaru);

        Stage stage = (Stage) namaTugasTextField.getScene().getWindow();
        stage.close();
    }

}