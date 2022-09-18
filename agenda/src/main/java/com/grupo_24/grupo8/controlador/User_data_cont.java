package com.grupo_24.grupo8.controlador;

import com.grupo_24.grupo8.modelo.User_data;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class User_data_cont {

    // ATRIBUTOS
    SessionFactory factory;

    public User_data_cont() {
        // Crear objeto fabricante de sesiones
        factory = new Configuration()
        .configure("cfg.xml")
        .addAnnotatedClass(User_data.class)
        .buildSessionFactory();
    }

    public void create(String team, String _name, String last_name, String user_name, String pass_word, boolean team_admin) throws Exception {
        
        Session session = factory.openSession();
        session.beginTransaction();
        User_data user_data = new User_data(team, _name, last_name, user_name, pass_word, team_admin);
        session.persist(user_data);
        session.getTransaction().commit();
        session.close();
    }

    public String getbyId(int id) throws Exception {
        Session session = factory.openSession();
        session.beginTransaction();
        User_data user_data = session.find(User_data.class, id);
        session.close();
        return user_data.toString();
    }

    public List<String> objToString(List<User_data> objUser_list){
        List<String> user_data = new ArrayList<>();
        for(int i = 0; i < objUser_list.size(); i++){
            user_data.add(objUser_list.get(i).toString());
        }
        return user_data;
    }

    public List<String> getbyLastname(String last_name) throws Exception {
        //List<String> user_data = new ArrayList<>();
        Session session = factory.openSession();
        session.beginTransaction();
        List<User_data> objUser_list = session.createQuery("from User_data where last_name =:ln", User_data.class)
            .setParameter("ln", last_name).list();
        session.close();
        return objToString(objUser_list);
        //return user_data;
    }

    public List<String> getList() throws Exception {
        Session session = factory.openSession();
        session.beginTransaction();
        List<User_data> user_data = session.createQuery("from User_data", User_data.class).list();
        session.close();
        return objToString(user_data);

    }

}