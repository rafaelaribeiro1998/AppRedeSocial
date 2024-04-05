package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void teladois (View view) {
        Intent in = new Intent(MainActivity.this, TelaDois.class);

        startActivity(in);
    }

    public void ListaUsuario(View view) {
        Intent in = new Intent(MainActivity.this,ListaUsuario.class);
        startActivity(in);
    }
}