package com.example.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.ListView;

import java.util.*;

public class Telasete extends AppCompatActivity {

    private Map<String, List<String>> agenda; // Mapa para armazenar os compromissos por data selecionada
    private ListView listView;
    private EditText editTextMeeting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_sete);

        // Inicializa a agenda
        agenda = new HashMap<>();

        CalendarView calendarView = findViewById(R.id.calendarView);
        listView = findViewById(R.id.listView);
        editTextMeeting = findViewById(R.id.editTextMeeting);
        Button buttonAddMeeting = findViewById(R.id.buttonAddMeeting);

        // Adiciona um ouvinte para o CalendarView
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView calendarView, int year, int month, int day) {
                // Converte a data selecionada para o formato desejado (dd/MM)
                String selectedDate = String.format("%02d/%02d", day, month + 1);

                // Obtém os compromissos para a data selecionada, se houver
                List<String> meetings = agenda.get(selectedDate);

                // Verifica se há compromissos para essa data
                if (meetings != null && !meetings.isEmpty()) {
                    // Se houver, exibe na lista
                    ArrayAdapter<String> adapter = new ArrayAdapter<>(Telasete.this,
                            android.R.layout.simple_list_item_1, android.R.id.text1, meetings);
                    listView.setAdapter(adapter);
                } else {
                    // Se não houver, limpa a lista
                    listView.setAdapter(null);
                }
            }
        });

        // Adiciona um ouvinte para o botão "Adicionar"
        buttonAddMeeting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String selectedDate = getSelectedDate();
                String meeting = editTextMeeting.getText().toString();

                if (!meeting.isEmpty()) {
                    addMeeting(selectedDate, meeting);
                    editTextMeeting.setText(""); // Limpa o campo de texto
                }
            }
        });
    }

    // Método para adicionar compromissos à agenda
    private void addMeeting(String date, String meeting) {
        List<String> meetings = agenda.get(date);
        if (meetings == null) {
            meetings = new ArrayList<>();
            agenda.put(date, meetings);
        }
        meetings.add(meeting);

        // Atualiza a lista após adicionar o compromisso
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, meetings);
        listView.setAdapter(adapter);
    }

    // Método para obter a data selecionada no formato "dd/MM"
    private String getSelectedDate() {
        CalendarView calendarView = findViewById(R.id.calendarView);
        long selectedDateMillis = calendarView.getDate();
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(selectedDateMillis);
        return String.format("%02d/%02d", calendar.get(Calendar.DAY_OF_MONTH), calendar.get(Calendar.MONTH) + 1);
    }
}
