package com.grupo_24.grupo8.servicios;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import com.grupo_24.grupo8.modelo.UserData;


public class UserDataService {
    // ATRIBUTOS
    SessionFactory factory;
    public static String USER_LOG;

    public UserDataService(){
        // Crear objeto fabricante de sesiones
        factory = new Configuration()
        .configure("cfg.xml")
        .addAnnotatedClass(UserData.class)
        .buildSessionFactory();

    }

    public Session createSession(){
        Session session = factory.openSession();
        session.beginTransaction();
        return session;
        }

    public void createUser(UserData userData) throws Exception{
        Session session = createSession();
        session.persist(userData);
        session.getTransaction().commit();
        session.close();
    }

    public void updateUser(UserData userData) throws Exception {
        Session session = createSession();
        session.merge(userData);
        session.getTransaction().commit();
        session.close(); 
    }

    public List<UserData> getUsersList() throws Exception {
        Session session = createSession();
        List<UserData> userData = session.createQuery("from UserData", UserData.class).list();
        session.close();
        return userData;
    }

    public UserData getUserbyUserName(String userName) throws Exception {
        Session session = createSession();
        UserData userData = session.createQuery("from UserData where userName = :uN", UserData.class)
        .setParameter("uN", userName).getSingleResult();                              
        session.close();
        return userData;
    }

    public List<UserData> getUserbyTeam(String team) throws Exception {
        Session session = createSession();
        List<UserData> userData = session.createQuery("from UserData where team = :tm and teamAdmin = false", UserData.class)
        .setParameter("tm", team).list();                              
        session.close();
        return userData;
    }

    public List<UserData> getUserbyTeamAdmin(String team) throws Exception {
        Session session = createSession();
        List<UserData> userData = session.createQuery("from UserData where team = :tm and teamAdmin = true", UserData.class)
        .setParameter("tm", team).list();                              
        session.close();
        return userData;
    }

    public UserData getUserbyId(int id) throws Exception {
        Session session = createSession();
        UserData userData = session.find(UserData.class, id);
        session.close();
        return userData;
    }

    public void deleteUserbyId(int id) throws Exception{
        Session session = createSession();
        UserData userData = session.find(UserData.class,id);
        session.remove(userData);
        session.getTransaction().commit();
        session.close();
    } 

    
}
