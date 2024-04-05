package com.example.myapplication;

public class Book {
    private String title;
    private int pagesRead;
    private int totalPages;
    private int totalTime;
    private int bookImageResource;  // Adicionado para referenciar a imagem do livro

    public Book(String title, int pagesRead, int totalPages, int totalTime, int bookImageResource) {
        this.title = title;
        this.pagesRead = pagesRead;
        this.totalPages = totalPages;
        this.totalTime = totalTime;
        this.bookImageResource = bookImageResource;
    }

    public String getTitle() {
        return title;
    }

    public int getPagesRead() {
        return pagesRead;
    }

    public int getTotalTime() {
        return totalTime;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public int getBookImageResource() {
        return bookImageResource;
    }
}
