package com.sld.projetofatooufake;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class HomeFragment extends Fragment {

    private Button buttonCovid19;
    private Button buttonTransmissao;
    private Button buttonProtecao;
    private Button buttonSintomas;
    private Button buttonPrevencao;
    private Button buttonFakeNews;
    private FirebaseAuth mAuth;
    private String email;

    View myFragment;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        myFragment =  inflater.inflate(R.layout.fragment_home, container, false);
        mAuth = FirebaseAuth.getInstance();
        email = mAuth.getCurrentUser().toString();

        buttonCovid19 = (Button) myFragment.findViewById( R.id.idbuttonCovid19);
        buttonTransmissao = (Button) myFragment.findViewById( R.id.idbuttonTransmissao);
        buttonProtecao = (Button) myFragment.findViewById( R.id.idbuttonProtecao);
        buttonSintomas = (Button) myFragment.findViewById( R.id.idbuttonSintomas);
        buttonPrevencao = (Button) myFragment.findViewById( R.id.idbuttonPrevencao);
        buttonFakeNews = (Button) myFragment.findViewById( R.id.idbuttonFakeNews);


        buttonCovid19.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getActivity(),Covid19Activity.class);
                startActivity(intent);
            }
        });

        buttonTransmissao.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent i = new Intent(getActivity(),TransmissaoActivity.class);
                startActivity(i);

            }
        });

        buttonProtecao.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent i = new Intent(getActivity(),ProtecaoActivity.class);
                startActivity(i);

            }
        });

        buttonSintomas.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent i = new Intent(getActivity(),SintomaActivity.class);
                startActivity(i);

            }
        });

        buttonPrevencao.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent i = new Intent(getActivity(),PrevencaoActivity.class);
                startActivity(i);

            }
        });

        buttonFakeNews.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent i = new Intent(getActivity(),FakeNewsActivity.class);
                startActivity(i);

            }
        });


        return myFragment;
    }


}
