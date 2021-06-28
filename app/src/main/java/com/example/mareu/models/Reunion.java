package com.example.mareu.models;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Reunion implements Serializable {

    public String getRoom;
    private int id;
    private String subject;
    private Date date;
    private String room;
    private String start_time;
    private String end_time;
    private String mails;
    private String avatarUrl;



    public Reunion(int id, String subject, Date date, String room, String start_time, String end_time, String mails, String avatarUrl) {
        this.id = id;
        this.subject = subject;
        this.date = date;
        this.room = room;
        this.start_time = start_time;
        this.end_time = end_time;
        this.mails = mails;
        this.avatarUrl = avatarUrl;
    }



    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public String getMails() {
        return mails;
    }

    public void setMails(String mails) {
        this.mails = mails;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reunion reunion = (Reunion) o;
        return Objects.equals(id, reunion.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }



}