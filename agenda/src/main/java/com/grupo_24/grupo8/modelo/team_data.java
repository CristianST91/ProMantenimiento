package com.grupo_24.grupo8.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "team_data")
public class Team_data {
    //ATRIBUTOS
    @Id
    private int id;
    private String team;
    private String user_admin;

    //CONSTRUCTORES
    public Team_data() {}

    public Team_data(String team, String user_admin) {
        this.team= team;
        this.user_admin= user_admin;
    }

    @Override
    public String toString(){
        String info = "------------------------------\n";
        info += "Id: "+id;
        info += "\nTeam: "+team;
        info += "\nUser_admin: "+user_admin;
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

    public String getUser_admin() {
        return user_admin;
    }

    //MODEFICADORES
    public void setTeam(String team) {
        this.team = team;
    }

    public void setUser_admin(String user_admin) {
        this.user_admin = user_admin;
    }


}