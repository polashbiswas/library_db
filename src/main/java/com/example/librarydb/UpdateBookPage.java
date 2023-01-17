package com.example.librarydb;

public class UpdateBookPage {
    private int id;
    private int page;

    public UpdateBookPage(int id, int page) {
        this.id = id;
        this.page = page;
    }

    public UpdateBookPage() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}
