package com.grupo_24.grupo8.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "admin_order")
public class admin_order {
    //ATRIBUTOS
    @Id
    private int id;
    private String team;
    private long _date;
    //private java.sql.Date _date = new java.sql.Date(date);
    private String work_order_number;
    private int estimated_time;
    private String responsible;
    private String activity;
    private String suggestions;

    //CONSTRUCTORES
    private admin_order() {}

    private admin_order(String team, long _date, String work_order_number, int estimated_time, String responsible, String activity, String suggestions) {    
        this.team= team;
        this._date= _date;
        this.work_order_number= work_order_number;
        this.estimated_time= estimated_time;
        this.responsible=responsible;
        this.activity= activity;
        this.suggestions= suggestions;
    }

     //CONSULTORES
    public int getId() {
        return id;
    }

    public String getTeam() {
        return team;
    }

    public long get_date() {
        return _date;
    }

    public String getWork_order_number() {
        return work_order_number;
    }

    public int getEstimated_time() {
        return estimated_time;
    }

    public String getResponsible() {
        return responsible;
    }

    public String getActivity() {
        return activity;
    }

    public String getSuggestions() {
        return suggestions;
    }

    //MODEFICADORES
    public void setTeam(String team) {
        this.team = team;
    }

    public void set_date(long _date) {
        this._date = _date;
    }

    public void setWork_order_number(String work_order_number) {
        this.work_order_number = work_order_number;
    }

    public void setEstimated_time(int estimated_time) {
        this.estimated_time = estimated_time;
    }

    public void setResponsible(String responsible) {
        this.responsible = responsible;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public void setSuggestions(String suggestions) {
        this.suggestions = suggestions;
    }

}
