package com.sld.projetofatooufake;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

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
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.EmailAuthCredential;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ExcluirUsuarioActivity extends AppCompatActivity {

    private Button buttonExcluirUsuario;
    private EditText editTextSenha;
    private TextView emailLogado;


    private FirebaseAuth mAuth;
    private FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_excluir_usuario);

        buttonExcluirUsuario = findViewById(R.id.idbuttonExcluirUsuario);
        editTextSenha = findViewById(R.id.ideditTextSenha);
        emailLogado = findViewById(R.id.idemailLogado2);

        mAuth = FirebaseAuth.getInstance();
        user = mAuth.getCurrentUser();


        buttonExcluirUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pass = editTextSenha.getText().toString();
                if (pass.isEmpty()) {
                    Toast.makeText(ExcluirUsuarioActivity.this, "Digite a senha.", Toast.LENGTH_SHORT).show();
                  //  return;
                }else{
                    AuthCredential credential = EmailAuthProvider.getCredential(user.getEmail(), pass);
                    user.reauthenticate(credential)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    user.delete().addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            if(task.isSuccessful()){
                                                mAuth.signOut();
                                                Intent i3 = new Intent(ExcluirUsuarioActivity.this,LoginActivity.class);
                                                startActivity(i3);
                                                finish();
                                                Toast.makeText(ExcluirUsuarioActivity.this, "Usuário Deletado.", Toast.LENGTH_SHORT).show();
                                            }else{
                                                Toast.makeText(ExcluirUsuarioActivity.this, "Senha inválida, ela deve ter 6 digitos.", Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                    });
                                }
                            });

                }



            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        CheckUserStatus();
    }

    private void CheckUserStatus() {
        FirebaseUser user = mAuth.getCurrentUser();
        if (user != null){
            emailLogado.setText(user.getEmail());

        }else{
            startActivity(new Intent(ExcluirUsuarioActivity.this,LoginActivity.class));
        }
    }


}