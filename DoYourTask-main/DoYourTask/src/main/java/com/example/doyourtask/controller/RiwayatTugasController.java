package com.example.doyourtask.controller;

import com.example.doyourtask.model.RiwayatTugas;
import com.example.doyourtask.model.RiwayatTugasData;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class RiwayatTugasController {

    @FXML
    private TableView<RiwayatTugas> riwayatTugasTableView;

    @FXML
    private TableColumn<RiwayatTugas, String> namaTugasColumn;

    @FXML
    private TableColumn<RiwayatTugas, String> mataKuliahColumn;

    @FXML
    private TableColumn<RiwayatTugas, String> statusColumn;

    @FXML
    public void initialize() {
        namaTugasColumn.setCellValueFactory(new PropertyValueFactory<>("namaTugas"));
        mataKuliahColumn.setCellValueFactory(new PropertyValueFactory<>("mataKuliah"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));

        riwayatTugasTableView.setItems(RiwayatTugasData.getInstance().getRiwayatTugasList());
    }

    @SuppressWarnings("unchecked")
    @FXML
    private <Tugas> void handleDeleteAction() {
        Tugas selectedTask = (Tugas) riwayatTugasTableView.getSelectionModel().getSelectedItem();
        if (selectedTask != null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Anda yakin ingin menghapus tugas ini?", ButtonType.YES, ButtonType.NO);
            alert.showAndWait();

            if (alert.getResult() == ButtonType.YES) {
                ObservableList<Tugas> allTasks = (ObservableList<Tugas>) riwayatTugasTableView.getItems();
                allTasks.remove(selectedTask);
                riwayatTugasTableView.setItems((ObservableList<RiwayatTugas>) allTasks);

            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Pilih tugas yang ingin dihapus terlebih dahulu.", ButtonType.OK);
            alert.showAndWait();
        }
    }

}
