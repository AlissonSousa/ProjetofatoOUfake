package com.sld.projetofatooufake;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class RecuperarSenhaActivity extends AppCompatActivity {

    private TextView loginTV;
    private EditText editTextRecuperarSenhaEmail;
    private Button buttonEnviarEmail;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recuperar_senha);

        loginTV = findViewById(R.id.idloginTV);
        buttonEnviarEmail = findViewById(R.id.idbuttonExcluirUsuario);
        editTextRecuperarSenhaEmail = findViewById(R.id.ideditTextSenha);
        mAuth = FirebaseAuth.getInstance();

        loginTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(RecuperarSenhaActivity.this,LoginActivity.class);
                startActivity(i);
            }
        });

        buttonEnviarEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetSenha();
            }
        });
    }

    private void resetSenha(){
        String email = editTextRecuperarSenhaEmail.getText().toString().trim();

        if(email.isEmpty()){
            editTextRecuperarSenhaEmail.setError("Campo e-mail obrigatório!");
            editTextRecuperarSenhaEmail.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            editTextRecuperarSenhaEmail.setError("Digite um e-mail válido!");
            editTextRecuperarSenhaEmail.requestFocus();
            return;
        }
        mAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    Toast.makeText(RecuperarSenhaActivity.this, "Verifique seu e-mail!", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(RecuperarSenhaActivity.this,LoginActivity.class);
                    startActivity(i);
                    finish();
                }else{
                    Toast.makeText(RecuperarSenhaActivity.this, "Tente novamente, algo errado!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}