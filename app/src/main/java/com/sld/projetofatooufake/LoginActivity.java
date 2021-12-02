package com.sld.projetofatooufake;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;



public class LoginActivity extends AppCompatActivity {

    private EditText editTextAcessarEmail,editTextAcessarSenha;
    private Button buttonAcessar;
    private TextView textCadastrar;
    private TextView textRecuperarSenha;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextAcessarEmail = findViewById(R.id.ideditTextAcessarEmail);
        editTextAcessarSenha = findViewById(R.id.ideditTextAcessarSenha);
        textCadastrar = findViewById(R.id.idtextCadastrar);
        textRecuperarSenha = findViewById(R.id.idtextRecuperarSenha);
        buttonAcessar = findViewById(R.id.idbuttonCovid19);
        mAuth = FirebaseAuth.getInstance();

        textCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoginActivity.this,LoginCadastroActivity.class);
                startActivity(i);
            }
        });

        textRecuperarSenha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoginActivity.this,RecuperarSenhaActivity.class);
                startActivity(i);
            }
        });

        buttonAcessar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userEmail = editTextAcessarEmail.getText().toString();
                String userSenha = editTextAcessarSenha.getText().toString();
                if (TextUtils.isEmpty(userEmail) && TextUtils.isEmpty(userSenha)) {
                    Toast.makeText(LoginActivity.this, "Informe suas credenciais..", Toast.LENGTH_SHORT).show();
                    return;
                } else{
                    mAuth.signInWithEmailAndPassword(userEmail, userSenha).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(LoginActivity.this, "Usuário logado com sucesso!", Toast.LENGTH_SHORT).show();
                                Intent i = new Intent(LoginActivity.this,MainActivity.class);
                                startActivity(i);
                                finish();
                            }else{
                                Toast.makeText(LoginActivity.this, "Falha no acesso, informações inválidas.", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });



    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser user = mAuth.getCurrentUser();
        if(user!=null){
            Intent i = new Intent(LoginActivity.this,MainActivity.class);
            startActivity(i);
            this.finish();
        }
    }

}
