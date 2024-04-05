package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Telacinco extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telacinco);

        ImageView imageViewAgenda = findViewById(R.id.imageAgenda);
        imageViewAgenda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Criar um Intent para iniciar a próxima atividade
                Intent intent = new Intent(Telacinco.this, Telasete.class);
                startActivity(intent);
            }
        });

        ImageView imageViewClassificacao = findViewById(R.id.imageClassificaçao);
        imageViewClassificacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Criar um Intent para iniciar a próxima atividade
                Intent intent = new Intent(Telacinco.this, TelaOito.class);
                startActivity(intent);
            }
        });
    }

    public void telaquatro(View view) {
        Intent in = new Intent(Telacinco.this, Telaquatro.class);
        startActivity(in);
    }

    public void telasete(View view) {
        Intent in = new Intent(Telacinco.this, Telasete.class);
        startActivity(in);
    }

    public void MyPerfil(View view) {
        Intent in = new Intent(Telacinco.this, MyPerfil.class);
        startActivity(in);
    }

    // Método para abrir a tela nove
    public void abrirTelaNove(View view) {
        Intent intent = new Intent(Telacinco.this, TelaNove.class);
        startActivity(intent);
    }

    public void abrirTelaSeis(View view) {
        Intent intent = new Intent(Telacinco.this, TelaSeis.class);
        startActivity(intent);
    }
}
