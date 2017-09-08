package com.example.levua.storyhw;

/**
 * Created by levua on 9/7/2017.
 */

public class Story_model {
    private int id;
    private String image;
    private String title;
    private String description;
    private String content;
    private String author;
    private boolean bookmark;

    public Story_model(int id, String image, String title, String description, String content, String author, boolean bookmark) {
        this.id = id;
        this.image = image;
        this.title = title;
        this.description = description;
        this.content = content;
        this.author = author;
        this.bookmark = bookmark;
    }

    public int getId() {
        return id;
    }

    public String getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getContent() {
        return content;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isBookmark() {
        return bookmark;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setBookmark(boolean bookmark) {
        this.bookmark = bookmark;
    }
}
