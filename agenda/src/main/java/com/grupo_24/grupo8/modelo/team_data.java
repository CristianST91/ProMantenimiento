package com.grupo_24.grupo8.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "team_data")
public class team_data {
    //ATRIBUTOS
    @Id
    private int id;
    private String team;
    private String user_admin;

    //CONSTRUCTORES
    public team_data() {}

    public team_data(String team, String user_admin) {
        this.team= team;
        this.user_admin= user_admin;
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