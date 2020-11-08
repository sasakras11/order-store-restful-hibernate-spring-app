package com.space.rest_service.dao;

import com.space.rest_service.entity.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClientDaoImpl implements ClientCrudDao{


    private final SessionFactory sessionFactory;


    public ClientDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void create(Client value) {
        Session session = getSessionWithOpenedTransaction();
        session.persist(value);
        session.getTransaction().commit();
    }

    @Override
    public boolean update(Client value,Integer id) {
        Session session = getSessionWithOpenedTransaction();

        if (session.get(Client.class, id) != null) {
            value.setId(id);
            session.update(value);
            session.getTransaction().commit();
            return true;
        }

        return false;
    }

    @Override
    public boolean delete(Integer id) {
        Session session = getSessionWithOpenedTransaction();
        Client client = session.find(Client.class, id);
        if (client != null) {
            session.delete(client);
            session.getTransaction().commit();
            return true;
        }
        session.getTransaction().commit();
        return false;    }

    @Override
    public Client read(Integer id) {
        Session session = getSessionWithOpenedTransaction();
        Client client = session.get(Client.class, id);
        session.getTransaction().commit();
        return client;
    }

    @Override
    public List<Client> readAll() {
        Session session = getSessionWithOpenedTransaction();
        List<Client> clients = session.createQuery("SELECT a FROM Client a", Client.class).getResultList();
        session.getTransaction().commit();
        return clients;
    }

    private Session getSessionWithOpenedTransaction(){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        return session;
    }
}
