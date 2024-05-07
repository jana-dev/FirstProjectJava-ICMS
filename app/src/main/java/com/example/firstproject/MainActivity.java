package com.example.firstproject;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.EditText;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText editTextEstado;
    private EditText editTextValor;
    private TextView textViewICMS;
    private TextView textViewValorTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        editTextEstado = findViewById(R.id.editTextEstado);
        editTextValor = findViewById(R.id.editTextValor);
        textViewICMS = findViewById(R.id.textViewICMS);
        textViewValorTotal = findViewById(R.id.textViewValorTotal);
    }

    public void calcular(View view){
        String estado = editTextEstado.getText().toString();
        double valor = Double.parseDouble(editTextValor.getText().toString());
        double icms = 0;
        double valorTotal = 0;
        switch (estado){
            case "SP":
                icms = 18;
                break;

            case "PR":
                icms = 15.5;
                break;

            case "MG":
                icms = 13;
                break;
        }
        valorTotal = valor + (valor * icms / 100);
        textViewICMS.setText(String.format("%.2f", icms) + " %");
        textViewValorTotal.setText(String.format("R$ %.2f", valorTotal));
    }
}