package main.java.es.unex.cum.ada.practica1.controller;

import java.io.IOException;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import main.java.es.unex.cum.ada.practica1.App;
import main.java.es.unex.cum.ada.practica1.model.SortingTest;

public class MenuController {
    @FXML
    private ProgressBar progressBar;

    @FXML
    void simulate(ActionEvent event) {
        Task<Void> task = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                SortingTest sortingTest = new SortingTest();
                sortingTest.test();
                return null;
            }
        };

        task.setOnRunning((e) -> {
            progressBar.setProgress(0);
        });

        task.setOnSucceeded((e) -> {
            progressBar.setProgress(1);
            Platform.runLater(() -> {
                try {
                    App.setRoot("/main/resources/es/unex/cum/ada/practica1/view/table");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            });
        });

        progressBar.progressProperty().bind(task.progressProperty());

        new Thread(task).start();
    }

}
