package com.example.placar_agoravai;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import kotlin.jvm.JvmStatic;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Button botao_placar = (Button)findViewById(R.id.botao_placar);
        Button botao_historico = (Button)findViewById(R.id.botao_historico);

        botao_placar.setOnClickListener(view -> {

            Intent i = new Intent(MainActivity.this, CriarJogo.class);
            startActivity(i);

        });

    }
}