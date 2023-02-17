package com.unifunec.imc_2023;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        EditText peso = findViewById(R.id.edt_Peso);
        EditText altura = findViewById(R.id.edt_Altura);

        TextView imc = findViewById(R.id.txt_Imc);
        TextView result = findViewById(R.id.txt_Result);

        Button calcular = findViewById(R.id.btn_Calcular);
        Button limpar = findViewById(R.id.btn_Limpar);


        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double pes = Double.parseDouble(peso.getText().toString());
                double alt = Double.parseDouble(altura.getText().toString());

                double op = pes/(alt*alt);
                String rf = String.format("%.1f", op);

                if(op < 18.5){
                    imc.setText("Ops, seu cálculo do IMC foi de: "+rf+" Kg/m²");
                    result.setText("Precisa ganhar peso, você esta na fase de: Magreza");

                } else if (op > 18.4 && op < 25) {
                    imc.setText("Parabéns, seu cálculo do IMC foi de: "+rf+" Kg/m²");
                    result.setText("Você se encontra no seu peso ideal, continue assim!!");
                    
                } else if (op > 24.5 && op < 30) {
                    imc.setText("Ops, seu cálculo do IMC foi de: "+rf+" Kg/m²");
                    result.setText("Precisa perder um pouco de peso, você esta na fase de: Sobrepeso");

                } else if (op > 29.9 && op < 35) {
                    imc.setText("Ops, seu cálculo do IMC foi de: "+rf+" Kg/m²");
                    result.setText("Precisa perder peso, você esta na fase de: Obesidade I");

                } else if (op > 34.9 && op < 40) {
                    imc.setText("Ops, seu cálculo do IMC foi de: "+rf+" Kg/m²");
                    result.setText("Precisa perder peso rápido, você esta na fase de: Obesidade II");

                }else {
                    imc.setText("Ops, seu cálculo do IMC foi de: "+rf+" Kg/m²");
                    result.setText("Precisa perder peso urgente, você esta na fase de: Obesidade III");

                }
                calcular.setEnabled(false);
                limpar.setEnabled(true);
            }
        });

        limpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                peso.setText("");
                altura.setText("");

                imc.setText("");
                result.setText("");

                limpar.setEnabled(false);
                calcular.setEnabled(true);
            }
        });
    }
}