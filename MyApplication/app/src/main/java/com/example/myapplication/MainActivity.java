package com.example.testesapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Método chamado ao criar a Activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Método chamado ao clicar no botão (android:onClick="calcularIMC" no XML)
    public void calcularIMC(View view) {
        EditText inputPeso = findViewById(R.id.inputPeso);
        EditText inputAltura = findViewById(R.id.inputAltura);
        TextView message = findViewById(R.id.lbResultado);

        // Verifica se os campos não estão vazios
        if (!inputPeso.getText().toString().isEmpty() &&
                !inputAltura.getText().toString().isEmpty()) {

            float peso = Float.parseFloat(inputPeso.getText().toString());
            float altura = Float.parseFloat(inputAltura.getText().toString());

            float imc = peso / (altura * altura);
            String resultado;

            if (imc <= 18.5) {
                resultado = "Baixo peso!";
            } else if (imc <= 24.9) {
                resultado = "Normal!";
            } else if (imc <= 29.9) {
                resultado = "Sobrepeso!";
            } else {
                resultado = "Obeso!";
            }

            message.setText(String.format("IMC: %.2f\n%s", imc, resultado));
        } else {
            message.setText("Preencha peso e altura corretamente.");
        }
    }
}






