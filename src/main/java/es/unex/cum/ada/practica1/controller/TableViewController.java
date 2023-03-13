package main.java.es.unex.cum.ada.practica1.controller;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import main.java.es.unex.cum.ada.practica1.model.SortingResult;
import main.java.es.unex.cum.ada.practica1.model.SortingTest;

public class TableViewController implements Initializable {

    @FXML
    private TableView<SortingResult> performanceTableView;

    @FXML
    private TableColumn<SortingResult, Long> arraySizeColumn;

    @FXML
    private TableColumn<SortingResult, Long> bubbleSortTimeCol;

    @FXML
    private TableColumn<SortingResult, Long> cocktailSortTimeCol;

    @FXML
    private TableColumn<SortingResult, Long> quickSortTimeCol;

    @FXML
    private TableColumn<SortingResult, Long> selectionSortTimeCol;

    @FXML
    private TableColumn<SortingResult, Long> sortingTimeColumns;

    @FXML
    private Button viewGraphic;

    private SortingTest sortingTest;

    private ObservableList <SortingResult>  sortingResultOvlist;

    public void setSortingTest(SortingTest sortingTest) {
        this.sortingTest = sortingTest;
    }

    public ObservableList<SortingResult> getSortingResultOvlist() {
        return sortingResultOvlist;
    }

    public void setSortingResultOvlist(ObservableList<SortingResult> sortingResultOvlist) {
        this.sortingResultOvlist = sortingResultOvlist;
    }

    public TableView<SortingResult> getPerformanceTableView() {
        return performanceTableView;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //Creo los observablelist
        sortingResultOvlist = FXCollections.observableArrayList();
        
        //COLUMNAS
        arraySizeColumn.setCellValueFactory(new PropertyValueFactory<>("arraySize"));
        bubbleSortTimeCol.setCellValueFactory(new PropertyValueFactory<>("bubbleSortAvgTime"));
        cocktailSortTimeCol.setCellValueFactory(new PropertyValueFactory<>("cocktailSortAvgTime"));
        quickSortTimeCol.setCellValueFactory(new PropertyValueFactory<>("quickSortAvgTime"));
        selectionSortTimeCol.setCellValueFactory(new PropertyValueFactory<>("selectionSortAvgTime"));
        
    }

    @FXML
    void createLineChart(ActionEvent event) {
        // Crear un gráfico de líneas con el tamaño del arreglo en el eje X y el tiempo
        // en el eje Y
        NumberAxis xAxis = new NumberAxis("Tamaño", 2000, 20000, 2000);
        NumberAxis yAxis = new NumberAxis("Tiempo", 0, 600, 50);
        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);

        // Crear una serie de datos para cada algoritmo de ordenamiento
        XYChart.Series<Number, Number> bubbleSortSeries = new XYChart.Series<>();
        bubbleSortSeries.setName("Bubble Sort");

        XYChart.Series<Number, Number> cocktailSortSeries = new XYChart.Series<>();
        cocktailSortSeries.setName("Cocktail Sort");

        XYChart.Series<Number, Number> quickSortSeries = new XYChart.Series<>();
        quickSortSeries.setName("Quick Sort");

        XYChart.Series<Number, Number> selectionSortSeries = new XYChart.Series<>();
        selectionSortSeries.setName("Selection Sort");

        // Agregar puntos de datos a cada serie de datos
        for (int size : sortingTest.getResultsMap().keySet()) {
            SortingResult result = sortingTest.getResultsMap().get(size);

            bubbleSortSeries.getData().add(new XYChart.Data<>(size, result.getBubbleSortAvgTime()));
            cocktailSortSeries.getData().add(new XYChart.Data<>(size, result.getCocktailSortAvgTime()));
            quickSortSeries.getData().add(new XYChart.Data<>(size, result.getQuickSortAvgTime()));
            selectionSortSeries.getData().add(new XYChart.Data<>(size, result.getSelectionSortAvgTime()));
        }

        // Agregar las series de datos al gráfico de líneas
        List<XYChart.Series<Number, Number>> seriesList = new ArrayList<>();
        seriesList.add(bubbleSortSeries);
        seriesList.add(cocktailSortSeries);
        seriesList.add(quickSortSeries);
        seriesList.add(selectionSortSeries);
        lineChart.getData().addAll(seriesList);

        // Crear una nueva ventana para el gráfico de líneas
        Stage stage = new Stage();
        Scene scene = new Scene(lineChart);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void repeatTest(ActionEvent event) throws IOException {
        Stage stage;
        Scene scene;
        Parent root;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/main/resources/es/unex/cum/ada/practica1/view/menu.fxml"));
        root = loader.load();
        sortingTest.getResultsMap().clear();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

}