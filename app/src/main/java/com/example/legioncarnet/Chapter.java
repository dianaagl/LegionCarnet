package com.example.legioncarnet;

public class Chapter{
    private int page;
    private String name;

    public Chapter(int page, String name) {
        this.page = page;
        this.name = name;
    }



    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
