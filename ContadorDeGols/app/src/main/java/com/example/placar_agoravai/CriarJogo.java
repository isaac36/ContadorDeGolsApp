package com.example.placar_agoravai;

import static java.lang.String.valueOf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CriarJogo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_jogo);

        EditText caixa_time1 = (EditText)findViewById(R.id.caixa_time1);
        EditText caixa_time2 = (EditText)findViewById(R.id.caixa_time2);
        EditText caixa_tempo = (EditText)findViewById(R.id.caixa_tempo);

        Button botao_criar = (Button)findViewById(R.id.botao_criar);

        botao_criar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CriarJogo.this,Placar.class);

                if(caixa_tempo.getText().length()>0) {
                    intent.putExtra("tempo", caixa_tempo.getText().toString());
                }else{intent.putExtra("tempo", "10");}

                if(caixa_time1.getText().length()>0) {
                    intent.putExtra("time1",caixa_time1.getText().toString());
                }else{intent.putExtra("time1", "Time 1");}

                if(caixa_time2.getText().length()>0) {
                    intent.putExtra("time2",caixa_time2.getText().toString());
                }else{intent.putExtra("time2", "Time 2");}



                startActivity(intent);
                finish();
            }
        });




    }
}