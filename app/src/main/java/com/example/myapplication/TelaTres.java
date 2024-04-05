package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.content.ContentValues;

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

        // Consultar o banco de dados para verificar se as credenciais estão corretas
        Cursor cursor = db.rawQuery("SELECT * FROM LOGIN WHERE email = ? AND senha = ?", new String[]{email, senha});

        if (cursor.getCount() > 0) {
            // As credenciais estão corretas, login bem-sucedido
            showMessage("Sucesso", "Login feito com sucesso!!");
            clearText();

            // Se os campos estiverem preenchidos, crie um Intent para iniciar a próxima atividade (TelaQuatro)
            Intent intent = new Intent(TelaTres.this, Telacinco.class);

            // Adicione quaisquer dados extras que você deseja passar para a próxima atividade, se necessário
            intent.putExtra("email", email); // Exemplo de passagem de dados extras

            // Inicie a próxima atividade
            startActivity(intent);
        } else {
            // Credenciais inválidas
            showMessage("Erro", "Credenciais inválidas");
        }

        cursor.close();
    }

    public void showMessage(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
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
