package com.example.myapplication;

import android.app.AlertDialog.Builder;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class TelaTres extends AppCompatActivity {
    EditText editTextTextEmailAddress, editTextSenha;

    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_tres);

        editTextTextEmailAddress = findViewById(R.id.editTextTextEmailAddress);
        editTextSenha = findViewById(R.id.editTextSenha);

        db = openOrCreateDatabase("Conta", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS LOGIN (email VARCHAR, senha VARCHAR);");
    }

    public void telacinco(View view) {
        String email = editTextTextEmailAddress.getText().toString().trim();
        String senha = editTextSenha.getText().toString().trim();

// Verificar se os campos de e-mail e senha estão preenchidos
        if (email.isEmpty() || senha.isEmpty()) {
            showMessage("Erro", "Preencha corretamente os valores");
            return;
        }

// Inserir os dados de login no banco de dados utilizando ContentValues para consultas parametrizadas
        ContentValues values = new ContentValues();
        values.put("email", email);
        values.put("senha", senha);
        db.insert("login", null, values);

        showMessage("Ok", "Login feito com sucesso!!");
        clearText();

// Se os campos estiverem preenchidos, crie um Intent para iniciar a próxima atividade (TelaQuatro)
        Intent intent = new Intent(TelaTres.this, Telacinco.class);

// Adicione quaisquer dados extras que você deseja passar para a próxima atividade, se necessário
        intent.putExtra("email", email); // Exemplo de passagem de dados extras

// Inicie a próxima atividade
        startActivity(intent);
    }

    public void showMessage(String title, String message) {
        Builder builder = new Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

    public void clearText() {
        editTextTextEmailAddress.setText("");
        editTextSenha.setText("");
    }

    public void esqueceuSenhaClicked (View view){
        // Crie um Intent para abrir a nova atividade
        Intent intent = new Intent(this, Telaquatro.class);
        startActivity(intent);
    }

}