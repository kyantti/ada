package main.java.es.unex.cum.ada.practica1.controller;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import main.java.es.unex.cum.ada.practica1.model.SortingTest;

public class TableViewController {

    @FXML
    private TableView<SortingTest> performanceTableView;

    @FXML
    private TableColumn<SortingTest, Long> arraySizeColumn;

    @FXML
    private TableColumn<SortingTest, Long> bubbleSortTimeCol;

    @FXML
    private TableColumn<SortingTest, Long> cocktailSortTimeCol;

    @FXML
    private TableColumn<SortingTest, Long> quickSortTimeCol;

    @FXML
    private TableColumn<SortingTest, Long> selectionSortTimeCol;

    @FXML
    private TableColumn<SortingTest, Long> sortingTimeColumns;

    @FXML
    private Button viewGraphic;

}