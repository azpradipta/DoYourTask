package com.example.doyourtask.controller;
import com.example.doyourtask.model.MataKuliah;
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
    private ChoiceBox<MataKuliah> pilihMataKuliahChoiceBox;

    @FXML
    private ChoiceBox<String> urgensiTugasChoiceBox;

    @FXML
    private TextField namaTugasTextField;

    @FXML
    private DatePicker tengatDatePicker;

    private static ObservableList<MataKuliah> mataKuliahList;

    @FXML
    public void initialize() {
        pilihMataKuliahChoiceBox.setItems(mataKuliahList);
        urgensiTugasChoiceBox.getItems().addAll("Sangat Mendesak", "Mendesak", "Tidak Mendesak");
    }

    public static void setMataKuliahList(ObservableList<MataKuliah> list) {
        mataKuliahList = list;
    }

    @FXML
    private void tambahkanTugasOnAction() {
        String namaTugas = namaTugasTextField.getText();
        MataKuliah mataKuliah = pilihMataKuliahChoiceBox.getValue();
        String tengat = tengatDatePicker.getValue() != null ? tengatDatePicker.getValue().toString() : "";
        String urgensi = urgensiTugasChoiceBox.getValue();

        if (mataKuliah != null) {
            Tugas tugasBaru = new Tugas(namaTugas, mataKuliah.getNamaMataKuliah(), tengat, urgensi);
            TugasData.getInstance().addTugas(tugasBaru);

            Stage stage = (Stage) namaTugasTextField.getScene().getWindow();
            stage.close();
        } else {
            // Handle case where no mata kuliah is selected
            // You can show an error message or handle it as per your application's logic
        }
    }
}
