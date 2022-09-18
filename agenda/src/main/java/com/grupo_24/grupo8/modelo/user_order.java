package com.grupo_24.grupo8.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_order")
public class User_order {
    //ATRIBUTOS
    @Id
    private int id;
    private String team;
    private String real_time;
    private boolean activity_finished;
    private String notes;

    //CONSTRUCTORES
    private User_order() {}

    private User_order(String team, String real_time, boolean activity_finished, String notes) { 
        this.team=team; 
        this.real_time=real_time; 
        this.activity_finished=activity_finished; 
        this.notes=notes; 
    }

    @Override
    public String toString(){
        String info = "------------------------------\n";
        info += "Id: "+id;
        info += "\nTeam: "+team;
        info += "\nReal time: "+real_time;
        info += "\nActivity finished: "+activity_finished;
        info += "\nNotes: "+notes;
        info += "\n------------------------------\n";
        return info;
    }

     //CONSULTORES
    public int getId() {
        return id;
    }

    public String getTeam() {
        return team;
    }

    public String getReal_time() {
        return real_time;
    }

    public boolean isActivity_finished() {
        return activity_finished;
    }

    public String getNotes() {
        return notes;
    }

    //MODEFICADORES
    public void setTeam(String team) {
        this.team = team;
    }

    public void setReal_time(String real_time) {
        this.real_time = real_time;
    }

    public void setActivity_finished(boolean activity_finished) {
        this.activity_finished = activity_finished;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }    

}
