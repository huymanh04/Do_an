package com.example.do_an_.fragment.Home;

public class ItemModel {
    private int imageResId;
    private String title;
    private String count;

    public ItemModel(int imageResId, String title, String count) {
        this.imageResId = imageResId;
        this.title = title;
        this.count = count;
    }

    public int getImageResId() {
        return imageResId;
    }

    public String getTitle() {
        return title;
    }

    public String getCount() {
        return count;
    }
}