package com.sld.projetofatooufake;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class QuizTotalActivity extends AppCompatActivity {

    private Button buttonVoltarQuiz;
    private TextView textViewPontuacaoQuiz;
    private TextView textViewPontuacaoQuizTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_total);

        textViewPontuacaoQuiz = findViewById(R.id.idtextViewPontuacaoQuiz);
        textViewPontuacaoQuizTotal = findViewById(R.id.idtextViewPontuacaoQuizTotal);
        buttonVoltarQuiz = findViewById(R.id.idbuttonExcluirUsuario);

        Intent i = getIntent();
        int Score = i.getIntExtra("Score",0);
        textViewPontuacaoQuiz.setText("Respostas corretas: "+Score);

        SharedPreferences mypref = getPreferences(MODE_PRIVATE);
        int pontuacaoTotal = mypref.getInt("Pontuação Total",0);
        if(pontuacaoTotal>=Score){
            textViewPontuacaoQuizTotal.setText("Maior Pontuação: "+pontuacaoTotal);
        }else{
            textViewPontuacaoQuizTotal.setText("Nova Pontuação: "+Score);
            SharedPreferences.Editor editor = mypref.edit();
            editor.putInt("Pontuação Total",Score);
            editor.commit();
        }



        buttonVoltarQuiz.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent i = new Intent(QuizTotalActivity.this, MainActivity.class);
                startActivity(i);
            }
        });

    }

}