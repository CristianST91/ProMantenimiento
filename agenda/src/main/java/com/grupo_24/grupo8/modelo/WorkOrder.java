package com.grupo_24.grupo8.modelo;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "workOrder")
public class WorkOrder {
     //ATRIBUTOS
     @Id
     private int id;
     private String team;
     private LocalDate dat;
     //private java.sql.Date _date = new java.sql.Date(date);
     private int estimatedTime;
     private String activity;
     private String userName;
     private String suggestions;
     private String realTime;
     private Boolean activityFinished;
     private String notes;  

    //CONSTRUCTORES
    public WorkOrder() {}

    public WorkOrder(String team, LocalDate dat, int estimatedTime, String userName, String activity, String suggestions, String realTime, Boolean activityFinished, String notes) {
        this.team= team;
        this.dat= dat;
        this.estimatedTime= estimatedTime;
        this.activity= activity;
        this.userName = userName;
        this.suggestions= suggestions;
        this.realTime=realTime;
        this.activityFinished=activityFinished;
        this.notes=notes;
    }    

    @Override
    public String toString(){
        String info = "------------------------------\n";
        info += "\nOrder: "+id;
        info += "\nTeam: "+team;
        info += "\nDate: "+dat;
        info += "\nEstimatedTime: "+estimatedTime;
        info += "\nActivity: "+activity;
        info += "\nSuggestions: "+suggestions;
        info += "\nReal time: "+realTime;
        info += "\nActivity finished: "+activityFinished;
        info += "\nNotes: "+notes;
        info += "\n------------------------------\n";
        return info;
    }

    public int getId() {
        return id;
    }

    public String getTeam() {
        return team;
    }

    public LocalDate getdat() {
        return dat;
    }

    public int getEstimatedTime() {
        return estimatedTime;
    }

    public String getActivity() {
        return activity;
    }

    public String getUserName() {
        return userName;
    }

    public String getSuggestions() {
        return suggestions;
    }

    public String getRealTime() {
        return realTime;
    }

    public Boolean getActivityFinished() {
        return activityFinished;
    }

    public String getNotes() {
        return notes;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public void setdat(LocalDate dat) {
        this.dat = dat;
    }

    public void setEstimatedTime(int estimatedTime) {
        this.estimatedTime = estimatedTime;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setSuggestions(String suggestions) {
        this.suggestions = suggestions;
    }

    public void setRealTime(String realTime) {
        this.realTime = realTime;
    }

    public void setActivityFinished(Boolean activityFinished) {
        this.activityFinished = activityFinished;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }    

}
