package damon.gui;

import damon.Damon;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;

import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

import javafx.stage.Stage;

/**
 * A GUI for Damon using FXML.
 */
public class Main extends Application {

    private Damon damon = new Damon("..\\Damon.txt");

    @Override
    public void start(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/view/MainWindow.fxml"));
            AnchorPane ap = fxmlLoader.load();
            Scene scene = new Scene(ap);
            stage.setTitle("Damon");
            stage.setScene(scene);
            fxmlLoader.<MainWindow>getController().setDamon(damon);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

