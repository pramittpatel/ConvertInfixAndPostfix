package CSCI3200;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

// GUI application for Infix and Postfix conversion using JavaFX
public class InfixAndPostfixGUI extends Application {
    private TextField inputField;
    private Label resultLabel;
    private RadioButton infixToPostfixRadio;
    private RadioButton postfixToInfixRadio;
    private InfixAndPostfix converter;

    public void start(Stage primaryStage) {
        // Initialize the converter logic object
        converter = new InfixAndPostfix();

        // 1. Radio Buttons for Mode Selection
        infixToPostfixRadio = new RadioButton("Infix to Postfix");
        infixToPostfixRadio.setSelected(true);
        postfixToInfixRadio = new RadioButton("Postfix to Infix");

        ToggleGroup group = new ToggleGroup();
        infixToPostfixRadio.setToggleGroup(group);
        postfixToInfixRadio.setToggleGroup(group);

        HBox radioPanel = new HBox(20, infixToPostfixRadio, postfixToInfixRadio);
        radioPanel.setAlignment(Pos.CENTER);

        // 2. Input Panel (Label + Text Field)
        Label inputLabel = new Label("Expression: ");
        inputField = new TextField();
        inputField.setPrefColumnCount(20);

        HBox inputPanel = new HBox(10, inputLabel, inputField);
        inputPanel.setAlignment(Pos.CENTER);

        // 3. Convert Button
        Button convertButton = new Button("Convert");
        convertButton.setPrefWidth(120);

        // Add event handler to the Convert button using lambda expression
        convertButton.setOnAction(e -> handleConversion());

        // 4. Result Label
        resultLabel = new Label("Result: ");
        resultLabel.setFont(Font.font("Serif", FontWeight.BOLD, 14));

        // Main Layout
        VBox root = new VBox(15, radioPanel, inputPanel, convertButton, resultLabel);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20));
        
        // Window settings
        Scene scene = new Scene(root, 450, 250);
        primaryStage.setTitle("Infix & Postfix Converter - CSCI 3200");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Handles event when Convert button is clicked
    private void handleConversion() {
        String input = inputField.getText().trim();

        if (input.isEmpty()) {
            resultLabel.setText("Result: Please enter an expression.");
            return;
        }

        if (infixToPostfixRadio.isSelected()) {
            String result = converter.convertToPostfix(input);
            resultLabel.setText("Postfix: " + result);
        } else if (postfixToInfixRadio.isSelected()) {
            String result = converter.convertToInfix(input);
            resultLabel.setText("Infix: " + result);
        }
    }
}