package com.example.laba3;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView resultTextView = findViewById(R.id.resultTextView);

        // Получаем данные из Intent
        double num1 = getIntent().getDoubleExtra("NUM1", 0);
        double num2 = getIntent().getDoubleExtra("NUM2", 0);

        // Вычисляем сумму
        double sum = num1 + num2;

        // Форматируем вывод
        String resultText = String.format("%.2f + %.2f = %.2f", num1, num2, sum);
        resultTextView.setText(resultText);
    }
}