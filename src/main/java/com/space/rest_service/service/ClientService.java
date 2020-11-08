package com.space.rest_service.service;

import com.space.rest_service.entity.Client;

import java.util.List;

public interface ClientService {

    void create(Client client);

    List<Client> readAll();


    Client read(Integer id);

    boolean update(Client client, Integer id);

    boolean delete(Integer id);
}
