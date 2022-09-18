package com.grupo_24.grupo8.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_data")
public class User_data {
    //ATRIBUTOS
    @Id
    private int id;
    private String team;
    private String _name;
    private String last_name;
    private String user_name;
    private String pass_word;
    private boolean team_admin;    

    //CONSTRUCTORES
    public User_data(){}

    public User_data(String team, String _name, String last_name, String user_name, String pass_word, boolean team_admin) {  
        this.team = team; 
        this._name = _name; 
        this.last_name = last_name;
        this.user_name = user_name; 
        this.pass_word = pass_word; 
        this.team_admin = team_admin;         
    }

    @Override
    public String toString(){
        String info = "------------------------------\n";
        info += "Id: "+id;
        info += "\nTeam: "+team;
        info += "\nName: "+_name;
        info += "\nLast name: "+last_name;
        info += "\nUser name: "+user_name;
        info += "\nPass word: "+pass_word;
        info += "\nTeam admin: "+team_admin;
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

    public String get_name() {
        return _name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getPass_word() {
        return pass_word;
    }

    public boolean getTeam_admin() {
        return team_admin;
    }

      //MODEFICADORES
    public void setTeam(String team) {
        this.team = team;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setPass_word(String pass_word) {
        this.pass_word = pass_word;
    }

    public void setTeam_admin(boolean team_admin) {
        this.team_admin = team_admin;
    }
     

}