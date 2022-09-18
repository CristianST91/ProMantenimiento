package com.grupo_24.grupo8.vista;

import java.util.List;

import javax.swing.JOptionPane;

import com.grupo_24.grupo8.controlador.User_data_cont;

public class User_data_view {
    
    private User_data_cont controller;

    public User_data_view(){
        controller = new User_data_cont();
    }

    public void showMessage(String message){
        JOptionPane.showMessageDialog(null,message);
    }

    public String showInputDialog(String message){
       return JOptionPane.showInputDialog(null, message);
    }

    public void create_user_data(){
        
        String team = showInputDialog("Enter a team name");
        String _name = showInputDialog("Enter a name");
        String last_name = showInputDialog("Enter a last name");
        String user_name = showInputDialog("Enter a user name");
        String pass_word = showInputDialog("Enter a password");
        boolean team_admin = Boolean.parseBoolean(showInputDialog("Enter (true) if the user is an administrator"));    
        
        // Enviar datos al controlador
        
        try {
            controller.create(team, _name, last_name, user_name, pass_word, team_admin);
            showMessage("Successful registration");
        } catch (Exception e) {
            showMessage("Please try later");
        }
    }

    public String listToString(List<String> list) {
        String info = "------------Users_data------------";
            for(int i = 0; i < list.size(); i++) {
                info += list.get(i);
            }
        return info;
    }

    public void get_user_data_byId(){
        int id = Integer.parseInt(showInputDialog("Enter the user ID"));
        try {
            String info = controller.getbyId(id);
            showMessage(info);
        } catch (Exception e) {
            showMessage("The id does not exist");
        }
        
    }

    public void get_users_data_byLastname(){
        String last_name = showInputDialog("Enter the last name");
        try {
            List<String> users_data = controller.getbyLastname(last_name);
            String info = listToString(users_data);
            showMessage(info);
        } catch (Exception e) {
            showMessage("The last name does not exist");
        }
    }

    public void users_data_list(){
        try {
            List<String> users_data = controller.getList();
            String info = listToString(users_data);
            showMessage(info);
        } catch (Exception e) {
            e.printStackTrace();
            showMessage("Please try later");
        }
    }

        public void menu(){
            String info = "1) Register user\n";
            info += "2) Query user by last name\n";
            info += "3) Users list\n";
            info += "-1) Exit";

            int opc = 0;
            while (opc != -1){
                opc = Integer.parseInt(showInputDialog(info));
                switch (opc){
                    case 1:
                    create_user_data();
                    break;
                    case 2:
                    get_users_data_byLastname();
                    break;
                    case 3:
                    users_data_list();
                    break;
                    case -1:
                    break;
                    default:
                    showMessage("please enter a valid option");
                    break;
                }
            }
        }

    
}

