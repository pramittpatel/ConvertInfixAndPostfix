package CSCI3200;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// GUI application for Infix and Postfix conversion
public class InfixAndPostfixGUI extends JFrame {
    private JTextField inputField;
    private JLabel resultLabel;
    private JRadioButton infixToPostfixRadio;
    private JRadioButton postfixToInfixRadio;
    private InfixAndPostfix converter;

    public InfixAndPostfixGUI() {
        // initialize the converter logic object
        converter = new InfixAndPostfix();

        // window settings
        setTitle("Infix & Postfix Converter - CSCI 3200");
        setSize(450, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // center on screen
        setLayout(new GridLayout(5, 1, 10, 10));

        // 1. Radio Buttons for Mode Selection
        infixToPostfixRadio = new JRadioButton("Infix to Postfix", true);
        postfixToInfixRadio = new JRadioButton("Postfix to Infix");

        ButtonGroup group = new ButtonGroup();
        group.add(infixToPostfixRadio);
        group.add(postfixToInfixRadio);

        JPanel radioPanel = new JPanel();
        radioPanel.add(infixToPostfixRadio);
        radioPanel.add(postfixToInfixRadio);

        // 2. Input Panel (Label + Text Field)
        JPanel inputPanel = new JPanel(new FlowLayout());
        JLabel inputLabel = new JLabel("Expression: ");
        inputField = new JTextField(20);
        inputPanel.add(inputLabel);
        inputPanel.add(inputField);

        // 3. Convert Button
        JButton convertButton = new JButton("Convert");

        // 4. Result Label
        resultLabel = new JLabel("Result: ", SwingConstants.CENTER);
        resultLabel.setFont(new Font("Serif", Font.BOLD, 14));

        // Add action listener to the Convert button
        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleConversion();
            }
        });

        // Add components to the frame
        add(radioPanel);
        add(inputPanel);
        add(convertButton);
        add(resultLabel);
    }

    // handles event when Convert button is clicked
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

    // main method to run the GUI
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new InfixAndPostfixGUI().setVisible(true);
            }
        });
    }
}