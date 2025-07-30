package com.spark.alphabet;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TracingView tracingView;
    Button btnClear, btnNext, btnPrev;
    Button colorRed, colorBlue, colorGreen, colorBlack;

    String[] letters = {"अ", "आ", "इ", "ई", "उ", "ऊ", "ए", "ऐ", "ओ", "औ"};
    int currentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tracingView = findViewById(R.id.tracingView);
        btnClear = findViewById(R.id.Clear);
        btnNext = findViewById(R.id.Next);
        btnPrev = findViewById(R.id.btnPrev);

        colorRed = findViewById(R.id.colorRed);
        colorBlue = findViewById(R.id.colorBlue);
        colorGreen = findViewById(R.id.colorGreen);
        colorBlack = findViewById(R.id.colorBlack);

        tracingView.setLetter(letters[currentIndex]); // Show first letter

        btnClear.setOnClickListener(v -> tracingView.clearCanvas());

        btnNext.setOnClickListener(v -> {
            if (currentIndex < letters.length - 1) {
                currentIndex++;
                tracingView.setLetter(letters[currentIndex]);
            }
        });

        btnPrev.setOnClickListener(v -> {
            if (currentIndex > 0) {
                currentIndex--;
                tracingView.setLetter(letters[currentIndex]);
            }
        });

        // Color Change Actions
        colorRed.setOnClickListener(v -> tracingView.setPaintColor(Color.RED));
        colorBlue.setOnClickListener(v -> tracingView.setPaintColor(Color.BLUE));
        colorGreen.setOnClickListener(v -> tracingView.setPaintColor(Color.GREEN));
        colorBlack.setOnClickListener(v -> tracingView.setPaintColor(Color.BLACK));
    }
}
