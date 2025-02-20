package com.example.calculatorong;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.util.Objects;

public class HelloController {
    public GridPane gpCalcu;
    public TextField tfInput;
    public Button btnnine, btneight, btnseven, btnsix, btnfive, btnfour,
            btnthree, btntwo, btnone, btnzero, btnplus, btnminus,
            btntimes, btndivide, btnequals, btndelete;
    public Button btndeci;
    public Button btnclear;
    public Button btnsquare;
    public Button btnmodulu;

    private double firstOperand = 0;
    private String operator = "";
    private boolean isNewInput = false;

    public void onButtonNineClicked() {
        appendToInput("9");
    }

    public void onButtonEightClicked() {
        appendToInput("8");
    }

    public void onButtonSevenClicked() {
        appendToInput("7");
    }

    public void onButtonSixClicked() {
        appendToInput("6");
    }

    public void onButtonFiveClicked() {
        appendToInput("5");
    }

    public void onButtonFourClicked() {
        appendToInput("4");
    }

    public void onButtonThreeClicked() {
        appendToInput("3");
    }

    public void onButtonTwoClicked() {
        appendToInput("2");
    }

    public void onButtonOneClicked() {
        appendToInput("1");
    }

    public void onButtonZeroClicked() {
        appendToInput("0");
    }

    public void onButtonPlusClicked() {
        setOperator("+");
    }

    public void onButtonMinusClicked() {
        setOperator("-");
    }

    public void onButtonMultiplyClicked() {
        setOperator("*");
    }

    public void onButtonDivideClicked() {
        setOperator("/");
    }

    public void onButtonEqualsClicked() {
        calculateResult();
    }

    public void onButtonDeleteClicked() {
        deleteLastCharacter();
    }

    private void appendToInput(String value) {
        if (isNewInput) {
            tfInput.clear();
            isNewInput = false;
        }
        tfInput.appendText(value);
    }

    private void setOperator(String op) {
        if (!tfInput.getText().isEmpty()) {
            firstOperand = Double.parseDouble(tfInput.getText());
            operator = op;
            isNewInput = true;
        }
    }

    private void calculateResult() {
        if (!tfInput.getText().isEmpty() && !operator.isEmpty()) {
            double secondOperand = Double.parseDouble(tfInput.getText());
            double result = 0;

            switch (operator) {
                case "+":
                    result = firstOperand + secondOperand;
                    break;
                case "-":
                    result = firstOperand - secondOperand;
                    break;
                case "*":
                    result = firstOperand * secondOperand;
                    break;
                case "/":
                    if (secondOperand != 0) {
                        result = firstOperand / secondOperand;
                    } else {
                        tfInput.setText("Error");
                        return;
                    }
                    break;
                case "%":
                    if (secondOperand != 0) {
                        result = firstOperand % secondOperand;
                    } else {
                        tfInput.setText("Error");
                        return;
                    }
                    break;
            }

            if (result % 1 == 0) {
                tfInput.setText(String.valueOf((int) result));
            } else {
                tfInput.setText(String.valueOf(result));
            }

            operator = "";
            isNewInput = true;
        }
    }

    public void onButtonClearAllClicked() {
        tfInput.clear();
        firstOperand = 0;
        operator = "";
        isNewInput = false;
    }

    public void onButtonDecimalClicked() {
        if (!tfInput.getText().contains(".")) {
            appendToInput(".");
        }
    }

    public void onButtonSquareClicked() {
        if (!tfInput.getText().isEmpty()) {
            double number = Double.parseDouble(tfInput.getText());
            double result = number * number;

            if (result % 1 == 0) {
                tfInput.setText(String.valueOf((int) result));
            } else {
                tfInput.setText(String.valueOf(result));
            }
            isNewInput = true;
        }
    }

    public void onButtonModulusClicked() {
        setOperator("%");
    }

    private void deleteLastCharacter() {
        String currentText = tfInput.getText();
        if (!currentText.isEmpty()) {
            tfInput.setText(currentText.substring(0, currentText.length() - 1));
        }
    }
}