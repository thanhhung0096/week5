package com.tran.huunghia.exerciseweek5;

import io.realm.RealmObject;

/**
 * Created by user on 06/04/2018.
 */

public class Task{
    private String name;
    private String date;
    private String priority;

    public Task(String name, String priority,String dateandTime) {
        this.name = name;
        this.date = dateandTime;
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }
}
