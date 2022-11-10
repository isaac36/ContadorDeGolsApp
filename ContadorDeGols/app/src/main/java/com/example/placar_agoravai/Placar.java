package com.example.placar_agoravai;

import static java.lang.String.valueOf;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;

import java.util.concurrent.atomic.AtomicInteger;

public class Placar extends AppCompatActivity {

    int score1 = 0;
    int score2 = 0;
    String TVstring = "";
    boolean parado = true;
    long pausa = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_placar);

        TextView TV = (TextView)findViewById(R.id.textView);


        //PEGAR VALORES DA TELA ANTERIOR
        String tempo = getIntent().getStringExtra("tempo");
        int tempoNumero = Integer.parseInt(tempo);
        String time1 = getIntent().getStringExtra("time1");
        String time2 = getIntent().getStringExtra("time2");

        //MOSTRAR SCORES
        TextView TVscore1 = (TextView)findViewById(R.id.score1);
        TextView TVscore2 = (TextView)findViewById(R.id.score2);
        TextView TV_time1 = (TextView)findViewById(R.id.TV_time1);
        TextView TV_time2 = (TextView)findViewById(R.id.TV_time2);

        TV_time1.setText(time1);
        TV_time2.setText(time2);

        //COMEÇAR/PARAR/REINICIAR
        Button btn_start = (Button)findViewById(R.id.btn_start);
        Button btn_resetar = (Button)findViewById(R.id.btn_resetar);


        //CRONOMETRO
        Chronometer crono = (Chronometer)findViewById(R.id.cronos);
        crono.stop(); pausa = SystemClock.elapsedRealtime();
        crono.setCountDown(true);
        crono.setBase(SystemClock.elapsedRealtime() + (((tempoNumero*60) * 1000)));
        crono.stop(); pausa = SystemClock.elapsedRealtime();


        //DIMINUIR SCORE
        Button score1Menos = (Button)findViewById(R.id.score1Menos);
        Button score2Menos = (Button)findViewById(R.id.score2Menos);




        TVscore1.setOnClickListener(view -> {

            if(score1<99)score1++;
            TVscore1.setText(valueOf(score1));

        });


        TVscore2.setOnClickListener(view -> {

            if(score2<99)score2++;
            TVscore2.setText(valueOf(score2));

        });

        btn_start.setOnClickListener(view -> {

            if(parado==true)//Ta parado
            {
                crono.setBase(crono.getBase() + SystemClock.elapsedRealtime() - pausa);
                crono.start();
                parado = false;
                btn_start.setText("Pausar");

            }
            else//Ta rodando
            {
                crono.stop();
                parado = true;
                btn_start.setText("Jogar!");
                pausa = SystemClock.elapsedRealtime();
            }




        });


        score1Menos.setOnClickListener(view -> {

            if(score1>0){score1--;};
            TVscore1.setText(valueOf(score1));

        });

        score2Menos.setOnClickListener(view -> {

            if(score2>0){score2--;};
            TVscore2.setText(valueOf(score2));

        });

        btn_resetar.setOnClickListener(view -> {

            //crono.setBase(SystemClock.elapsedRealtime());


            crono.setBase(SystemClock.elapsedRealtime() + (((tempoNumero*60) * 1000)));
            crono.stop(); pausa = SystemClock.elapsedRealtime();
            parado=true;
            btn_start.setText("Jogar!");




        });





















        crono.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {

            @Override
            public void onChronometerTick(Chronometer crono) {

                String currentTime= crono.getText().toString();
                if(currentTime.equals("00:00")) //put time according to you
                {
                    crono.stop();
                }
            }
        });


    }






    //CRONOMETRO CHECANDO SE CHEGOU A 0


}