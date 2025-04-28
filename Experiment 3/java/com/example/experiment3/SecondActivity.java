package com.example.experiment3;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    private TextView textViewReceived;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Now it's safe to findViewById
        textViewReceived = findViewById(R.id.textViewReceived);

        // Get the data from Intent
        String receivedData = getIntent().getStringExtra("key_data");

        // Set the received data to TextView
        textViewReceived.setText(receivedData);
    }
}
