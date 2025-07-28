package com.spark.alphabet;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TracingView tracingView;
    Button btnNext, btnPrev, btnClear;

    String[] swarLetters = { "अ", "आ", "इ", "ई", "उ", "ऊ", "ए", "ऐ", "ओ", "औ", "अं", "अः" };
    int currentIndex = 0;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tracingView = findViewById(R.id.tracingView);
        btnNext = findViewById(R.id.Next);
        btnPrev = findViewById(R.id.btnPrev);
        btnClear = findViewById(R.id.Clear);

        // Show first letter
        tracingView.setLetterToTrace(swarLetters[currentIndex]);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentIndex < swarLetters.length - 1) {
                    currentIndex++;
                    tracingView.setLetterToTrace(swarLetters[currentIndex]);
                    tracingView.clearPath();
                }
            }
        });

        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentIndex > 0) {
                    currentIndex--;
                    tracingView.setLetterToTrace(swarLetters[currentIndex]);
                    tracingView.clearPath();
                }
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tracingView.clearPath();
            }
        });
    }
}
