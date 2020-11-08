package com.space.rest_service.service;

import com.space.rest_service.dao.ClientCrudDao;
import com.space.rest_service.entity.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientCrudDao clientDao;

    @Autowired
    public ClientServiceImpl(ClientCrudDao clientDao) {
        this.clientDao = clientDao;
    }

    @Override
    public void create(Client client) {
         clientDao.create(client);
    }

    @Override
    public List<Client> readAll() {
        return clientDao.readAll();
    }

    @Override
    public Client read(Integer id) {
        return clientDao.read(id);
    }

    @Override
    public boolean update(Client client, Integer id) {
        return clientDao.update(client,id);
    }

    @Override
    public boolean delete(Integer id) {
        return clientDao.delete(id);
    }
}

