package com.grupo_24.grupo8.controlador;

import com.grupo_24.grupo8.modelo.UserData;
import com.grupo_24.grupo8.servicios.UserDataService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userdata")
public class UserDataController {
    private UserDataService service;

    public UserDataController() {
        this.service = new UserDataService();
    }

    @PostMapping
    @CrossOrigin("*")
    public String createUser(@RequestBody UserData userData){
        String message = "";
        try {
            service.createUser(userData);
            message = "User created successfully";
        } catch (Exception e) {
            message = e.getMessage();
            message += "\n\nMaybe the username is already in use";
        }
        return message;
    }

    @PutMapping
    @CrossOrigin("*")
    public String updateUser(@RequestBody UserData userData){
        String message = "";
        try {
            service.updateUser(userData);
            message = "Updated successfully";
        } catch (Exception e) {
            message = e.getMessage();
        }
        return message;
    }

    @GetMapping
    @CrossOrigin("*")
    public List<UserData> getUsersList(){
        List<UserData> userData = new ArrayList<>();
        try {
            userData = service.getUsersList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userData;
    }

    @GetMapping("/login/{username}")
    @CrossOrigin("*")
    public UserData getUserbyUserName(@PathVariable(name = "username") String  userName){
        
        UserData userData = new UserData();
        try {
            System.out.println("Entedi la llamada");
            userData = service.getUserbyUserName(userName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userData;
    }

    @GetMapping("/team/adm/{team}")
    @CrossOrigin("*")
    public List<UserData> getUserbyTeamAdmin(@PathVariable(name = "team") String  team){
        
        List<UserData> userData = new ArrayList<>();
        try {
            System.out.println("Entedi la llamada");
            userData = service.getUserbyTeamAdmin(team);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userData;
    }

    @GetMapping("/login/agend/{team}")
    @CrossOrigin("*")
    public List<UserData> getUserbyTeam(@PathVariable(name = "team") String  team){
        
        List<UserData> userData = new ArrayList<>();
        try {
            System.out.println("Entedi la llamada");
            userData = service.getUserbyTeam(team);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userData;
    }

    @GetMapping("/{id}")
    @CrossOrigin("*")
    public UserData getUserbyId(@PathVariable(name="id") int id){
       UserData userData = new UserData();
        try {
        userData = service.getUserbyId(id);
       } catch (Exception e) {
            e.printStackTrace();
       }
       return userData;
    }

    @DeleteMapping("/{id}")
    @CrossOrigin("*")
    public String deleteUserbyId(@PathVariable(name="id") int id){
        String message = "";
        try {
            service.deleteUserbyId(id);
            message = "Deleted successfully";
        } catch (Exception e) {
            message = e.getMessage();
        }
        return message;
    } 

}