package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class TelaOito extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_oito);

    }
    public void telacinco(View view) {
        Intent in = new Intent(TelaOito.this, Telacinco.class);
        startActivity(in);
    }


}

