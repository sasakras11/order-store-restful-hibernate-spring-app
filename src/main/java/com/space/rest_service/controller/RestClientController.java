package com.space.rest_service.controller;

import com.space.rest_service.entity.Client;
import com.space.rest_service.service.ClientService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestClientController {

    private final ClientService clientService;

    @Autowired
    public RestClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping(value = "clients")
    public ResponseEntity<List<Client>> read() {
        final List<Client> clients = clientService.readAll();
        return clients != null && !clients.isEmpty()
                ? new ResponseEntity<>(clients, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/clients")
    public ResponseEntity<?> create(@RequestBody Client client) {
        clientService.create(client);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/clients/{id}")
    public ResponseEntity<Client> read(@PathVariable(name = "id") int id){
        final Client client = clientService.read(id);

        return client!=null
                ? new ResponseEntity<>(client,HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/clients/{id}")
     public ResponseEntity<?> update(@PathVariable(name = "id") int id,@RequestBody Client client){
        final boolean updated = clientService.update(client,id);

        return updated ? new ResponseEntity<>(HttpStatus.OK):new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
    @DeleteMapping(value = "clients/{id}")
     public ResponseEntity<?> delete(@PathVariable(name = "id") int id){
        final boolean deleted = clientService.delete(id);

        return deleted ? new ResponseEntity<>(HttpStatus.OK):new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }




}
