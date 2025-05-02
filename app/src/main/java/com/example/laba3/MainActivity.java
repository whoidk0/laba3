package com.example.laba3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.TextView;

import com.example.laba3.R;

public class MainActivity extends AppCompatActivity {
    private EditText num1EditText, num2EditText;
    private Button calculateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1EditText = findViewById(R.id.num1EditText);
        num2EditText = findViewById(R.id.num2EditText);
        calculateButton = findViewById(R.id.calculateButton);

        calculateButton.setOnClickListener(v -> {
            // Получаем значения из полей ввода
            String num1Str = num1EditText.getText().toString();
            String num2Str = num2EditText.getText().toString();

            // Проверяем, что поля не пустые
            if (!num1Str.isEmpty() && !num2Str.isEmpty()) {
                try {
                    double num1 = Double.parseDouble(num1Str);
                    double num2 = Double.parseDouble(num2Str);

                    // Создаем Intent для перехода на ResultActivity
                    Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                    intent.putExtra("NUM1", num1);
                    intent.putExtra("NUM2", num2);
                    startActivity(intent);

                } catch (NumberFormatException e) {
                    // Обработка ошибки неверного формата числа
                    num1EditText.setError("Некорректное число");
                    num2EditText.setError("Некорректное число");
                }
            } else {
                // Показываем ошибки если поля пустые
                if (num1Str.isEmpty()) num1EditText.setError("Введите число");
                if (num2Str.isEmpty()) num2EditText.setError("Введите число");
            }
        });
    }
}
