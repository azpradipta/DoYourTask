package com.example.doyourtask;

import com.example.doyourtask.model.MataKuliahData;
import com.example.doyourtask.model.RiwayatTugasData;
import com.example.doyourtask.model.TugasData;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(@SuppressWarnings("exports") Stage stage) throws IOException {
        // Load data
        TugasData.getInstance().loadTugasData();
        RiwayatTugasData.getInstance().loadRiwayatTugasData();
        MataKuliahData.getInstance().loadMataKuliahData();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("mainmenu.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setResizable(false);
        stage.setTitle("Do Your Task");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void stop() {
        // Save data
        TugasData.getInstance().saveTugasData();
        RiwayatTugasData.getInstance().saveRiwayatTugasData();
        MataKuliahData.getInstance().saveMataKuliahData();
    }

    public static void main(String[] args) {
        launch();
    }
}
