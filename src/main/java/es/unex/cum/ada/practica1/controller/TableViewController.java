package main.java.es.unex.cum.ada.practica1.controller;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class TableViewController {

    @FXML
    private TableColumn<?, ?> arraySizeColumn;

    @FXML
    private TableColumn<?, ?> bubbleSortTimeCol;

    @FXML
    private TableColumn<?, ?> cocktailSortTimeCol;

    @FXML
    private TableView<?> performanceTableView;

    @FXML
    private TableColumn<?, ?> quickSortTimeCol;

    @FXML
    private TableColumn<?, ?> selectionSortTimeCol;

    @FXML
    private TableColumn<?, ?> sortingTimeColumns;

    @FXML
    private Button viewGraphic;

}