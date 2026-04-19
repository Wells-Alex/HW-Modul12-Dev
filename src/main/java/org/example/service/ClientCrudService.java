package org.example.service;

import org.example.dao.ClientDao;
import org.example.entity.Client;

public class ClientCrudService {

    private final ClientDao dao = new ClientDao();

    public Client create(String name) {
        Client client = new Client();
        client.setName(name);

        dao.save(client);
        return client;
    }

    public Client getById(Long id) {
        return dao.getById(id);
    }

    public void update(Long id, String name) {
        Client client = dao.getById(id);
        client.setName(name);

        dao.update(client);
    }

    public void delete(Long id) {
        Client client = dao.getById(id);
        dao.delete(client);
    }
}