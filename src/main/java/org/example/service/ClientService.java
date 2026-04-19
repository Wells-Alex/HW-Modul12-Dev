package org.example.service;

import org.example.dao.ClientDao;
import org.example.entity.Client;

import java.util.List;

public class ClientService {

    private final ClientDao dao = new ClientDao();

    // CREATE
    public Client create(String name) {
        Client client = new Client();
        client.setName(name);

        dao.save(client);
        return client;
    }

    // READ
    public Client getById(Long id) {
        return dao.getById(id);
    }

    public List<Client> getAll() {
        return dao.getAll();
    }

    // UPDATE
    public void update(Long id, String name) {
        Client client = dao.getById(id);
        client.setName(name);

        dao.update(client);
    }

    // DELETE
    public void delete(Long id) {
        Client client = dao.getById(id);
        dao.delete(client);
    }
}