package com.grupo_24.grupo8;

import com.grupo_24.grupo8.vista.User_data_view;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
   
        User_data_view view = new User_data_view();
       // view.create_user_data();
       // view.get_user_data_byId();
        //view.get_users_data_byLastname();
        view.menu();
    }
       /*  //Crear objeto fabricante de sesiones
        SessionFactory factory = new Configuration()
        .configure("cfg.xml")
        .addAnnotatedClass(User_data.class)
        .buildSessionFactory();

        //Abrir sesion

        Session session = factory.openSession();

        //Preparar la sesion para realizar transacciones
        session.beginTransaction();

        //Generar transacciones
        try {
            //CRUD

            // Create
            /* User_data user_data = new User_data("diurno", "luisa", "arango", "lu_ar", "345", false);
            session.persist(user_data);
            session.getTransaction().commit(); */

            // Read
            /* User_data user_data = session.find(User_data.class, 2);
            System.out.println(user_data); */

            /* User_data user_data = session.byId(User_data.class).load(1);
            System.out.println(user_data); */

            /* List<User_data> user_data = session.createQuery("from User_data", User_data.class).list();
            for(int i=0; i<user_data.size(); i++) {
                System.out.println(user_data.get(i));
            } */

            // Update
            /* User_data user_data = session.find(User_data.class,1);
            user_data.setTeam("Nocturno");
            user_data.set_name("Alejandro");
            // Guardar cambios
            session.merge(user_data);
            session.getTransaction().commit(); */

           /*  // Delete
            User_data user_data = session.find(User_data.class,1);
            session.remove(user_data);
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }

        //Cerrar sesion
        session.close(); */
        


    
}
