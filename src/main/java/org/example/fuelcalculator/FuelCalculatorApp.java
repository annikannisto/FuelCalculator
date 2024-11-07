package org.example.fuelcalculator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.Locale;
import java.util.ResourceBundle;

public class FuelCalculatorApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Locale locale = new Locale("en");
        ResourceBundle bundle = ResourceBundle.getBundle("messages", locale);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FuelCalculatorView.fxml"), bundle);

        Scene scene = new Scene(loader.load());
        stage.setTitle("Anni!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
