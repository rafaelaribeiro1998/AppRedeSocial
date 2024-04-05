package com.example.myapplication;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.database.sqlite.SQLiteDatabase;
import android.app.AlertDialog.Builder;
import android.content.ContentValues;
import android.widget.EditText;

public class Telaquatro extends AppCompatActivity {
    EditText editTextNomeUsuario, editTextNomeC, editTextUsuario, editTextPasswordSenha;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_quatro);

        // Inicialize os EditTexts corretamente
        editTextNomeUsuario = findViewById(R.id.editTextNomeUsuario);
        editTextNomeC = findViewById(R.id.editTextNomeC);
        editTextUsuario = findViewById(R.id.editTextUsuario);
        editTextPasswordSenha = findViewById(R.id.editTextPasswordSenha);

        // Abra ou crie o banco de dados
        db = openOrCreateDatabase("Login", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS usuario (email VARCHAR, nome VARCHAR NOT NULL, usuario VARCHAR, senha VARCHAR);");
    }

    // Método para o botão "Inscrever-se"
    public void telacinco(View view) {
        // Obtenha os valores dos EditTexts
        String email = editTextNomeUsuario.getText().toString().trim();
        String nome = editTextNomeC.getText().toString().trim();
        String usuario = editTextUsuario.getText().toString().trim();
        String senha = editTextPasswordSenha.getText().toString().trim();

        // Verifique se os campos de e-mail e senha estão preenchidos
        if (email.isEmpty() || nome.isEmpty() || usuario.isEmpty() || senha.isEmpty()) {
            showMessage("Erro", "Preencha corretamente os valores");
            return;
        }

        // Inserir os dados de login no banco de dados utilizando ContentValues para consultas parametrizadas
        ContentValues values = new ContentValues();
        values.put("email", email);
        values.put("nome", nome);
        values.put("usuario", usuario);
        values.put("senha", senha);
        db.insert("usuario", null, values);

        // Exibir perfil automaticamente após o cadastro bem-sucedido
        exibirPerfilAutomatico(email, nome);

        // Limpar os campos e mostrar mensagem após iniciar a próxima atividade
        showMessage("Ok", "Conta criada com sucesso");
        clearText();
    }

    // Método para exibir uma caixa de diálogo com mensagem
    public void showMessage(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

    // Método para limpar os campos EditText
    public void clearText() {
        editTextNomeUsuario.setText("");
        editTextNomeC.setText("");
        editTextUsuario.setText("");
        editTextPasswordSenha.setText("");
    }

    // Método para abrir a tela de recuperação de senha
    public void esqueceuSenhaClicked(View view) {
        Intent intent = new Intent(this, TelaTres.class);
        startActivity(intent);
    }

    // Método para exibir o perfil automaticamente após o cadastro bem-sucedido
    private void exibirPerfilAutomatico(String email, String nome) {
        Intent intent = new Intent(this, MyPerfil.class);
        intent.putExtra("email", email);
        intent.putExtra("nome", nome);
        startActivity(intent);
    }
}
