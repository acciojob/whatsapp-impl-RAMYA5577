package com.driver;

import java.util.Date;

public class Message {
    private final Date currentDate;
    private int id;
    private String content;
    private Date timestamp;

    public Message() {
        this.currentDate=getCurrentDate();
        this.id=getId();
        this.content=getContent();
        this.timestamp=getTimestamp();
    }

    public Message(int id, String content, Date currentDate){
        this.id=id;
        this.content=content;
        this.currentDate=timestamp;
    }

    public Date getCurrentDate() {
        return currentDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
