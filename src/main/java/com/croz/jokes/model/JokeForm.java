package com.croz.jokes.model;

public class JokeForm {
    private long category;
    private String content;

    public JokeForm() {}

    public long getCategory() {
        return category;
    }

    public String getContent() {
        return content;
    }

    public void setCategory(long category) {
        this.category = category;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "JokeForm{" +
                "category=" + category +
                ", content='" + content + '\'' +
                '}';
    }
}
