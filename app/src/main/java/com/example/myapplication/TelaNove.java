package com.example.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.*;

public class TelaNove extends AppCompatActivity {

    private RadioGroup radioGroupOptions;
    private Spinner spinnerBooks;
    private Button buttonVote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_nove);

        radioGroupOptions = findViewById(R.id.radioGroupOptions);
        spinnerBooks = findViewById(R.id.spinnerBooks);
        buttonVote = findViewById(R.id.buttonVote);

        // Popular spinner com opções de livros do mês
        String[] bookOptions = {"Amor, teoricamente", " Tress: a garota do mar esmeralda", "O segredo da empregada", "O Herdeiro Roubado"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, bookOptions);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerBooks.setAdapter(adapter);

        buttonVote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedOptionId = radioGroupOptions.getCheckedRadioButtonId();

                if (selectedOptionId == -1) {
                    // Nenhuma opção selecionada
                    Toast.makeText(TelaNove.this, "Por favor, selecione uma opção", Toast.LENGTH_SHORT).show();
                } else {
                    // Opção selecionada
                    RadioButton radioButtonSelected = findViewById(selectedOptionId);
                    String selectedOption = radioButtonSelected.getText().toString();

                    // Livro do mês selecionado
                    String bookOfMonth = spinnerBooks.getSelectedItem().toString();

                    // Simulação de votação
                    Toast.makeText(TelaNove.this, "Você votou em: " + selectedOption + "\nLeitura do mês: " + bookOfMonth, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
