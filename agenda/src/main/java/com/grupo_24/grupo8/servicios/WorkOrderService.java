package com.grupo_24.grupo8.servicios;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.grupo_24.grupo8.modelo.WorkOrder;

public class WorkOrderService {
    // ATRIBUTOS
    SessionFactory factory;

    public WorkOrderService(){
        // Crear objeto fabricante de sesiones
        factory = new Configuration()
        .configure("cfg.xml")
        .addAnnotatedClass(WorkOrder.class)
        .buildSessionFactory();
    }

    public Session createSession(){
        Session session = factory.openSession();
        session.beginTransaction();
        return session;
        }

    public void createWorkOrder(WorkOrder workOrder) throws Exception{
        Session session = createSession();
        session.persist(workOrder);
        session.getTransaction().commit();
        session.close();
    }

    public void updateWorkOrder(WorkOrder workOrder) throws Exception{
        Session session = createSession();
        session.merge(workOrder);
        session.getTransaction().commit();
        session.close();
    }

    public List<WorkOrder> getWorkOrdersList() throws Exception{
        Session session = createSession();
        List<WorkOrder> workOrder = session.createQuery("from WorkOrder", WorkOrder.class).list();
        session.close();
        return workOrder;
    }

    public List<WorkOrder> getWorkOrderbyNumber(int order) throws Exception {
        Session session = createSession();
        List<WorkOrder> objWorkOrdersList = session.createQuery("from WorkOrder where id =:i", WorkOrder.class)
            .setParameter("i", order).list();
        session.close();
        return objWorkOrdersList;
        //return WorkOrder;
    }
    
    public List<WorkOrder> getWorkOrderbyUserName(String userName) throws Exception {
        Session session = createSession();
        List<WorkOrder> objWorkOrdersList = session.createQuery("from WorkOrder where userName=:uN and activityFinished=0", WorkOrder.class)
            .setParameter("uN", userName).list();
        session.close();
        return objWorkOrdersList;
    }

    public void deleteWorkOrderbyId(int order) throws Exception{
        Session session = createSession();
        WorkOrder WorkOrder = session.find(WorkOrder.class,order);
        session.remove(WorkOrder);
        session.getTransaction().commit();
        session.close();
    }

        
}
