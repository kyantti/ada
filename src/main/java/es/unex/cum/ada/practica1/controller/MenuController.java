package main.java.es.unex.cum.ada.practica1.controller;

import java.io.IOException;
import java.net.URL;
import java.util.Map.Entry;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
        Stage stage;
        Scene scene;
        Parent root;

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/main/resources/es/unex/cum/ada/practica1/view/table.fxml"));
        root = loader.load();

        TableViewController tableViewController = loader.getController();
        sortingTest.test();
        tableViewController.setSortingTest(sortingTest);

        for (Entry<Integer, SortingResult> set : sortingTest.getResultsMap().entrySet()) {
            System.out.println("Size:" + set.getKey() + " -> " + "BubbleSort:" + set.getValue().getBubbleSortTime()
                    + " - " + "CocktailSort:" + set.getValue().getCocktailSortTime() + " - " + "QuickSort:"
                    + set.getValue().getQuickSortTime() + " - " + "SelectionSort:"
                    + set.getValue().getSelectionSortTime());
            tableViewController.getSortingResultOvlist().add(set.getValue());
        }

        tableViewController.getPerformanceTableView().setItems(tableViewController.getSortingResultOvlist());

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

    }

}
