package main.java.es.unex.cum.ada.practica1.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import main.java.es.unex.cum.ada.practica1.App;

public class MenuController {

    @FXML
    private ProgressBar progressBar;

    @FXML
    void simulate(ActionEvent event) throws IOException {
        App.setRoot("/main/resources/es/unex/cum/ada/practica1/view/table");
    }

}
