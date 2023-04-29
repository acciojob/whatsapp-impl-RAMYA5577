package com.driver;

import java.util.Date;

public class Message {


    private  Date timeStamp;
    private int id;
    private String content;


    public Message(int id) {
        this.id = id;
        this.timeStamp = new Date();
    }

    public Message() {
        this.timeStamp =new Date();
        this.id=getId();
        this.content=getContent();

    }

    public Message(int id, String content) {
        this.id = id;
        this.content = content;
        this.timeStamp = new Date();
    }

    public Message(int id, String content, Date currentDate){
        this.id=id;
        this.content=content;
        this.timeStamp =currentDate;
    }

    public Date getTimeStamp() {
        return timeStamp;
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
    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public void setContent(String content) {
        this.content = content;
    }


}
