package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class BooksAdapter extends ArrayAdapter<Book> {

    public BooksAdapter(Context context, Book[] books) {
        super(context, 0, books);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.book_item, parent, false);
        }

        Book currentBook = getItem(position);

        // Encontre as ImageView e TextViews no layout do item do livro
        ImageView bookIconImageView = convertView.findViewById(R.id.bookIcon);
        TextView bookTitleTextView = convertView.findViewById(R.id.bookTitle);
        TextView pagesReadTextView = convertView.findViewById(R.id.pagesRead);
        TextView totalPagesTextView = convertView.findViewById(R.id.totalPages);
        TextView totalTimeTextView = convertView.findViewById(R.id.totalTime);

        // Defina os recursos de imagem e textos com base nas informações do livro
        bookIconImageView.setImageResource(currentBook.getBookImageResource());
        bookTitleTextView.setText(currentBook.getTitle());
        pagesReadTextView.setText("Páginas Lidas Por Dia: " + currentBook.getPagesRead());
        totalPagesTextView.setText("Total de Páginas: " + currentBook.getTotalPages());
        totalTimeTextView.setText("Tempo de Leitura: " + currentBook.getTotalTime() + " minutos");

        return convertView;
    }
}
