package com.sld.projetofatooufake;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginCadastroActivity extends AppCompatActivity {

    private EditText editTextEmail, editTextSenha1, editTextSenha2;
    private Button buttonSalvar;
    private FirebaseAuth mAuth;
    private TextView loginTV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_cadastro);
        editTextEmail = findViewById(R.id.ideditTextEmail);
        editTextSenha1 = findViewById(R.id.ideditTextSenha1);
        editTextSenha2 = findViewById(R.id.ideditTextSenha2);
        loginTV = findViewById(R.id.idloginTV);
        buttonSalvar = findViewById(R.id.idbuttonSalvar);
        mAuth = FirebaseAuth.getInstance();
        loginTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoginCadastroActivity.this,LoginActivity.class);
                startActivity(i);
            }
        });

        buttonSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String editEmail = editTextEmail.getText().toString();
                String editSenha1 = editTextSenha1.getText().toString();
                String editSenha2 = editTextSenha2.getText().toString();
                if(!editSenha1.equals(editSenha2)){
                    Toast.makeText(LoginCadastroActivity.this, "Senhas divergentes!", Toast.LENGTH_SHORT).show();
                }else if(TextUtils.isEmpty(editEmail) && TextUtils.isEmpty(editSenha1) && TextUtils.isEmpty(editSenha2)){
                    Toast.makeText(LoginCadastroActivity.this, "Digite todas as informações!", Toast.LENGTH_SHORT).show();
                }else{
                    mAuth.createUserWithEmailAndPassword(editEmail,editSenha1).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(LoginCadastroActivity.this, "Usuário cadastrado com sucesso!", Toast.LENGTH_SHORT).show();
                                Intent i = new Intent(LoginCadastroActivity.this,LoginActivity.class);
                                startActivity(i);
                                finish();
                            }else{
                                Toast.makeText(LoginCadastroActivity.this, "Falha ao cadastradar o usuário, a senha deve ter 6 dígitos.", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });


        
    }
}