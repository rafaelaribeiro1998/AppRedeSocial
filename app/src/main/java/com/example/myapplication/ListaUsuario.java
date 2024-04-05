package com.example.myapplication;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.*;

import java.util.ArrayList;

public class ListaUsuario extends AppCompatActivity {

    ListView usersListView;
    ArrayList<String> userList;
    ArrayAdapter adapter;
    SQLiteDatabase myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_usuario);

        usersListView = findViewById(R.id.usersListView);
        userList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, userList);
        usersListView.setAdapter(adapter);

        myDB = openOrCreateDatabase("Login", MODE_PRIVATE, null);

        loadUsers();

        usersListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                final String selectedItem = (String) parent.getItemAtPosition(position);
                // Supondo que o nome do usuário é único e usamos ele para excluir
                final String userName = selectedItem.split(" - ")[0];

                new AlertDialog.Builder(ListaUsuario.this)
                        .setTitle("Excluir Usuário")
                        .setMessage("Você tem certeza que deseja excluir este usuário?")
                        .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                deleteUser(userName);
                            }
                        })
                        .setNegativeButton("Não", null)
                        .show();

                return true;
            }
        });
    }


    private void loadUsers() {
        Cursor cursor = myDB.rawQuery("SELECT * FROM usuario", null);
        userList.clear();
        if (cursor.moveToFirst()) {
            do {
                String user = cursor.getString(0) + " - " + cursor.getString(1);
                userList.add(user);
            } while (cursor.moveToNext());
        }
        cursor.close();
        adapter.notifyDataSetChanged();
    }

    private void deleteUser(String userName) {
        int result = myDB.delete("usuario", "Username=?", new String[]{userName});
        if (result > 0) {
            Toast.makeText(ListaUsuario.this, "Usuário excluído com sucesso", Toast.LENGTH_SHORT).show();
            loadUsers(); // Recarrega a lista após a exclusão
        } else {
            Toast.makeText(ListaUsuario.this, "Erro ao excluir usuário", Toast.LENGTH_SHORT).show();
        }

        Button Excluir = findViewById(R.id.viewUsersButton);

    }

}



