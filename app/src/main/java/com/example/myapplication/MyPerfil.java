package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MyPerfil extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_perfil);

        ImageView profileImage = findViewById(R.id.profileImage);
        TextView usernameTextView = findViewById(R.id.username);
        TextView contactInfoTextView = findViewById(R.id.contactInfo);
        Button editMenuButton = findViewById(R.id.editMenuButton);
        ListView booksReadListView = findViewById(R.id.booksReadList);
        Button logoutButton = findViewById(R.id.logoutButton);

        // Recupere as informações do usuário do intent extras
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String nomeUsuario = extras.getString("nome");
            String emailUsuario = extras.getString("email");

            // Configurar as informações do perfil do usuário
            usernameTextView.setText(nomeUsuario);
            contactInfoTextView.setText("Contato: " + emailUsuario);
        }

        // Configurar a lista de livros lidos (exemplo)
        Book[] booksArray = {
                new Book("Quem é você, Alasca?", 50, 277, 200, R.drawable.alasca),
                new Book("A Cinco Passos de Você", 30, 352, 150, R.drawable.cinco),
                new Book("É assim que começa(vol.2)", 40, 336, 180, R.drawable.assim)
        };

        BooksAdapter booksAdapter = new BooksAdapter(this, booksArray);
        booksReadListView.setAdapter(booksAdapter);

        // Botão de edição do Menu Principal
        editMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(MyPerfil.this, Telacinco.class);
                startActivity(in);
                // Adicione lógica para abrir o Menu Principal aqui
            }
        });

        // Botão de logout
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(MyPerfil.this, TelaTres.class);
                startActivity(in);
                // Adicione lógica de logout aqui
                finish();  // Fechar a atividade ou redirecionar para a tela de login
            }
        });
    }
}