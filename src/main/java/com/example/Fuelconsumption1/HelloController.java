package com.example.Fuelconsumption1;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class HelloController {
    @FXML
    private Label distanceLabel;
    @FXML
    private Label fuelUsedLabel;
    @FXML
    private Label resultLabel;
    @FXML
    private TextField distanceField;

    @FXML
    private TextField fuelUsedField;

    @FXML
    private Button calculateButton;

    @FXML
    private Button enButton;

    @FXML
    private Button frButton;

    @FXML
    private Button jpButton;

    @FXML
    private Button irButton;

    private ResourceBundle bundle;



    @FXML
    public void initialize() {
        setLanguage(Locale.ENGLISH);
    }

    private void setLanguage(Locale locale) {
        bundle = ResourceBundle.getBundle("bundle", locale);
        updateUIText();
    }
    private void updateUIText() {
        distanceLabel.setText(bundle.getString("distance.text"));
        fuelUsedLabel.setText(bundle.getString("fuel.text"));
        calculateButton.setText(bundle.getString("calculate.text"));
        resultLabel.setText("");
    }

    @FXML
    private void switchToEnglish() {
        setLanguage(Locale.ENGLISH);
    }

    @FXML
    private void switchToFrench() {
        setLanguage(Locale.FRENCH);
    }

    @FXML
    private void switchToJapanese() {
        setLanguage(new Locale("jp"));
    }

    @FXML
    private void switchToPersian() {
        setLanguage(new Locale("ir"));
    }

    @FXML
    void calculateFuelConsumption(){
        try {
            double distance = Double.parseDouble(distanceField.getText());
            double fuelUsed = Double.parseDouble(fuelUsedField.getText());
            double consumption = (fuelUsed / distance) * 100;
            String resultText = MessageFormat.format(bundle.getString("result.text"), String.format("%.2f", consumption));
            resultLabel.setText(resultText);
        } catch (NumberFormatException e) {
            resultLabel.setText("Please enter valid numbers.");
        }
    }

}