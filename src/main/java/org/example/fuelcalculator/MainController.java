package org.example.fuelcalculator;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.util.Locale;
import java.util.ResourceBundle;

public class MainController {

    @FXML
    private TextField distanceField;
    @FXML
    private TextField fuelField;
    @FXML
    private Label resultLabel;
    @FXML
    private Button calculateButton;
    @FXML
    private Label distanceLabel;
    @FXML
    private Label fuelLabel;

    private ResourceBundle bundle;

    @FXML
    public void initialize() {
        switchLanguage(new Locale("en")); // Default to English
    }

    @FXML
    private void calculateConsumption() {
        try {
            double distance = Double.parseDouble(distanceField.getText());
            double fuel = Double.parseDouble(fuelField.getText());
            double consumption = (fuel / distance) * 100;

            // Save the result to the database
            DatabaseHelper.saveConsumption(distance, fuel, consumption);

            resultLabel.setText(String.format(bundle.getString("result.label"), consumption));
        } catch (NumberFormatException e) {
            resultLabel.setText(bundle.getString("invalid.input"));
        }
    }

    @FXML
    private void switchToEnglish() {
        switchLanguage(new Locale("en"));
    }

    @FXML
    private void switchToFrench() {
        switchLanguage(new Locale("fr"));
    }

    @FXML
    private void switchToJapanese() {
        switchLanguage(new Locale("jp"));
    }

    @FXML
    private void switchToPersian() {
        switchLanguage(new Locale("ir"));
    }

    private void switchLanguage(Locale locale) {
        bundle = ResourceBundle.getBundle("messages", locale);
        updateUIText();
    }

    private void updateUIText() {
        distanceLabel.setText(bundle.getString("distance.label"));
        fuelLabel.setText(bundle.getString("fuel.label"));
        distanceField.setPromptText(bundle.getString("distance.label"));
        fuelField.setPromptText(bundle.getString("fuel.label"));
        calculateButton.setText(bundle.getString("calculate.button"));
        resultLabel.setText(""); // Clear result when changing language
    }
}