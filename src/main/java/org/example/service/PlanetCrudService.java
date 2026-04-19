package org.example.service;

import org.example.dao.PlanetDao;
import org.example.entity.Planet;

public class PlanetCrudService {

    private final PlanetDao dao = new PlanetDao();

    public Planet create(String id, String name) {
        Planet planet = new Planet();
        planet.setId(id);
        planet.setName(name);

        dao.save(planet);
        return planet;
    }

    public Planet getById(String id) {
        return dao.getById(id);
    }

    public void update(String id, String name) {
        Planet planet = dao.getById(id);
        planet.setName(name);

        dao.update(planet);
    }

    public void delete(String id) {
        Planet planet = dao.getById(id);
        dao.delete(planet);
    }
}