package org.example.service;

import org.example.dao.PlanetDao;
import org.example.entity.Planet;

import java.util.List;

public class PlanetService {

    private final PlanetDao dao = new PlanetDao();

    // CREATE
    public Planet create(String id, String name) {
        Planet planet = new Planet();
        planet.setId(id);
        planet.setName(name);

        dao.save(planet);
        return planet;
    }

    // READ
    public Planet getById(String id) {
        return dao.getById(id);
    }

    public List<Planet> getAll() {
        return dao.getAll();
    }

    // UPDATE
    public void update(String id, String name) {
        Planet planet = dao.getById(id);
        planet.setName(name);

        dao.update(planet);
    }

    // DELETE
    public void delete(String id) {
        Planet planet = dao.getById(id);
        dao.delete(planet);
    }
}