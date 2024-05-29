package com.example.doyourtask.controller;

import com.example.doyourtask.model.RiwayatTugas;
import com.example.doyourtask.model.RiwayatTugasData;
import com.example.doyourtask.model.Tugas;
import com.example.doyourtask.model.TugasData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;
import java.time.LocalDate;


public class MainMenuController {

    @FXML

    private void toTambahTugas(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/doyourtask/tambahtugas.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setTitle("Tambah Tugas");
        stage.setResizable(false);
        stage.initModality(Modality.APPLICATION_MODAL); // This line makes the pop-up modal
        stage.initOwner(((Node) event.getSource()).getScene().getWindow());
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML

    private void toTambahMatkul(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/doyourtask/tambahmatkul.fxml"));
        Parent root = loader.load();

        Stage stage = new Stage();
        stage.setTitle("Tambah Mata Kuliah");
        stage.setResizable(false);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initOwner(((Node) event.getSource()).getScene().getWindow());
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML

    private void toRiwayatTugas(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/doyourtask/riwayattugas.fxml"));
        Parent root = loader.load();

        Stage stage = new Stage();
        stage.setTitle("Riwayat Tugas");
        stage.setResizable(false);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initOwner(((Node) event.getSource()).getScene().getWindow());
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private TableView<Tugas> tugasTableView;

    @FXML
    private TableColumn<Tugas, String> namaTugasColumn;

    @FXML
    private TableColumn<Tugas, String> mataKuliahColumn;

    @FXML
    private TableColumn<Tugas, String> tengatColumn;

    @FXML
    private TableColumn<Tugas, String> urgensiColumn;



    @FXML
    public void initialize() {
        namaTugasColumn.setCellValueFactory(new PropertyValueFactory<>("namaTugas"));
        mataKuliahColumn.setCellValueFactory(new PropertyValueFactory<>("mataKuliah"));
        tengatColumn.setCellValueFactory(new PropertyValueFactory<>("tengat"));
        urgensiColumn.setCellValueFactory(new PropertyValueFactory<>("urgensi"));

        tugasTableView.setItems(TugasData.getInstance().getTugasList());
    }

    @FXML
    private void toTambahTugas() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/doyourtask/view/tambahtugas.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void tugasSelesaiOnAction() {
        Tugas selectedTugas = tugasTableView.getSelectionModel().getSelectedItem();
        if (selectedTugas != null) {
            String status = LocalDate.parse(selectedTugas.getTengat()).isBefore(LocalDate.now()) ? "Tidak Selesai" : "Selesai";
            RiwayatTugas riwayatTugas = new RiwayatTugas(selectedTugas.getNamaTugas(), selectedTugas.getMataKuliah(), status);
            RiwayatTugasData.getInstance().addRiwayatTugas(riwayatTugas);
            TugasData.getInstance().getTugasList().remove(selectedTugas);
        }
    }

    @FXML
    private void toRiwayatTugas() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/doyourtask/view/riwayattugas.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
