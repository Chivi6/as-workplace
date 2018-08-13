package com.example.administrator.newsapp;



public class news {

    private String title;
    private String content;
    public news(String title,String content){
        this.content=content;
        this.title=title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public String getTitle() {
        return title;
    }
}
