package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textViewInput;
    String input = "";
    String operator = "";
    Double firstValue = null;
    boolean isNewOperation = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewInput = findViewById(R.id.textViewInput);
    }

    // Number buttons 0-9
    public void numberClick(View view) {
        if (isNewOperation) {
            input = "";
            isNewOperation = false;
        }
        Button button = (Button) view;
        input += button.getText().toString();
        textViewInput.setText(input);
    }

    // Operator buttons (+ − × ÷)
    public void operatorClick(View view) {
        Button button = (Button) view;
        operator = button.getText().toString();
        try {
            firstValue = Double.parseDouble(input);
        } catch (NumberFormatException e) {
            firstValue = 0.0;
        }
        input = "";
    }

    // Equals (=) button
    public void equalsClick(View view) {
        try {
            Double secondValue = Double.parseDouble(input);
            Double result = 0.0;

            switch (operator) {
                case "+":
                    result = firstValue + secondValue;
                    break;
                case "−":
                case "-":
                    result = firstValue - secondValue;
                    break;
                case "×":
                case "*":
                    result = firstValue * secondValue;
                    break;
                case "÷":
                case "/":
                    if (secondValue == 0) {
                        textViewInput.setText("Cannot divide by 0");
                        return;
                    }
                    result = firstValue / secondValue;
                    break;
            }

            textViewInput.setText(result.toString());
            input = result.toString();
            isNewOperation = true;

        } catch (Exception e) {
            textViewInput.setText("Error");
        }
    }

    // Clear button
    public void clearClick(View view) {
        input = "";
        operator = "";
        firstValue = null;
        textViewInput.setText("");
        isNewOperation = true;
    }

    // Backspace button
    public void backspaceClick(View view) {
        if (input.length() > 0) {
            input = input.substring(0, input.length() - 1);
            textViewInput.setText(input);
        }
    }

    // Dot button
    public void dotClick(View view) {
        if (!input.contains(".")) {
            input += ".";
            textViewInput.setText(input);
        }
    }
}
