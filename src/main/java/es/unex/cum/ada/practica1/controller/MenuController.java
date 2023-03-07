package main.java.es.unex.cum.ada.practica1.controller;

import java.io.IOException;
import java.net.URL;
import java.util.Map.Entry;
import java.util.ResourceBundle;

import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.stage.Stage;
import main.java.es.unex.cum.ada.practica1.model.SortingResult;
import main.java.es.unex.cum.ada.practica1.model.SortingTest;

public class MenuController implements Initializable {
    @FXML
    private ProgressBar progressBar;

    private SortingTest sortingTest;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        sortingTest = new SortingTest();
    }

    @FXML
    void test(ActionEvent event) throws IOException {
        Parent root;

        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/main/resources/es/unex/cum/ada/practica1/view/table.fxml"));
        root = loader.load();

        TableViewController tableViewController = loader.getController();

        Task<Void> sortingTask = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                switch (((Button) event.getSource()).getText()) {
                    case "Probar caso mejor":
                        sortingTest.selectTest("Best");
                        break;
                    case "Probar caso medio":
                        sortingTest.selectTest("Average");
                        break;
                    case "Probar caso peor":
                        sortingTest.selectTest("Worst");
                        break;
                    default:
                        break;
                }
                tableViewController.setSortingTest(sortingTest);
                return null;
            }
        };

        sortingTask.setOnSucceeded(e -> {
            Stage stage;
            Scene scene;



            for (Entry<Integer, SortingResult> set : sortingTest.getResultsMap().entrySet()) {
                tableViewController.getSortingResultOvlist().add(set.getValue());
            }

            tableViewController.getPerformanceTableView().setItems(tableViewController.getSortingResultOvlist());

            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        });

        progressBar.progressProperty().bind(sortingTask.progressProperty());

        new Thread(sortingTask).start();
    }

}
