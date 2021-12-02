package com.sld.projetofatooufake;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bootomNav = findViewById(R.id.botton_navigation);
        bootomNav.setOnNavigationItemSelectedListener(navListiner);


    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListiner =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selecFragment = null;
                    switch (item.getItemId()) {
                        case R.id.nav_home:
                            selecFragment = new HomeFragment();
                            break;
                        case R.id.nav_novidades:
                            selecFragment = new NovidadesFragment();
                            break;
                        case R.id.nav_quiz:
                            selecFragment = new QuizFragment();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,selecFragment).commit();
                    return true;
                }
            };






    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
      //  MenuInflater inflater = getMenuInflater();
      //  getMenuInflater().inflate(R.menu.menu_main_principal ,menu);
      //  MenuItem m1 = menu.add(0,1,1, "Item 1");
      //  m1.setIcon(R.drawable.ic_baseline_share_24);
      //  m1.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
      //  inflater.inflate(R.menu.game_menu, menu);
     //   return true;
     //   return (true);

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main_principal, menu);
        return true;
    }


   // onCreateOptionsMenu
  //onOptionsItemSelected
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.idlogOut:
                Toast.makeText(this, "Usuário Desconectado.", Toast.LENGTH_SHORT).show();
                FirebaseAuth.getInstance().signOut();
                Intent i = new Intent(MainActivity.this,LoginActivity.class);
                startActivity(i);
                finish();
                return true;
            case R.id.idCompartilhar:
                Toast.makeText(this, "Compartilhando...", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.idAlterarSenha:
                Toast.makeText(this, "Alterando Senha.", Toast.LENGTH_SHORT).show();
                FirebaseAuth.getInstance().signOut();
                Intent i3 = new Intent(MainActivity.this,RecuperarSenhaActivity.class);
                startActivity(i3);
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}