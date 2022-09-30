package com.grupo_24.grupo8.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "userData")
public class UserData {
    //ATRIBUTOS
    @Id
    private int id;
    private String team;
    private String name_;
    private String lastName;
    private String userName;
    private String password_;
    private Boolean teamAdmin;
   

    //CONSTRUCTORES
    public UserData(){}

    public UserData(String team, String name_, String lastName, String userName, String password_, Boolean teamAdmin) {  
        this.team = team;
        this.name_ = name_;
        this.lastName = lastName;
        this.userName = userName;
        this.password_ = password_;
        this.teamAdmin = teamAdmin;
    }

    @Override
    public String toString(){
        String info = "------------------------------\n";
        info += "Id: "+id;
        info += "\nTeam: "+team;
        info += "\nName: "+name_;
        info += "\nLast name: "+lastName;
        info += "\nUser name: "+userName;
        info += "\nPass word: "+password_;
        info += "\nTeam admin: "+teamAdmin;
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

    public String getName() {
        return name_;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password_;
    }

    public Boolean getTeamAdmin() {
        return teamAdmin;
    }

      //MODEFICADORES
    public void setTeam(String team) {
        this.team = team;
    }

    public void setName(String name_) {
        this.name_ = name_;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password_) {
        this.password_ = password_;
    }

    public void setTeamAdmin(Boolean teamAdmin) {
        this.teamAdmin = teamAdmin;
    }
     

}
