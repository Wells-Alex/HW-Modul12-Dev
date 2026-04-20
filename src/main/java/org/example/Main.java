package org.example;

import org.example.entity.Client;
import org.example.entity.Planet;
import org.example.service.ClientCrudService;
import org.example.service.ClientCrudServiceImpl;
import org.example.service.PlanetService;
import org.example.service.PlanetServiceImpl;
import org.example.util.FlywayMigration;
import org.example.util.HibernateUtil;

public class Main {

    public static void main(String[] args) {

        FlywayMigration.migrate();

        System.out.println("\n=== CRUD TEST ===");

        ClientCrudService clientService = new ClientCrudServiceImpl();
        PlanetService planetService = new PlanetServiceImpl();

        // =========================
        // CREATE
        // =========================
        Client client = clientService.create("TestUser");

        Planet planet = planetService.getById("PLUTO");
        if (planet == null) {
            planet = planetService.create("PLUTO", "Pluto");
        }

        System.out.println("\nCreated:");
        System.out.println(client.getId() + " | " + client.getName());
        System.out.println(planet.getId() + " | " + planet.getName());

        // =========================
        // READ
        // =========================
        System.out.println("\nRead:");
        System.out.println(clientService.getById(client.getId()));
        System.out.println(planetService.getById("PLUTO"));

        // =========================
        // UPDATE
        // =========================
        clientService.update(client.getId(), "UpdatedUser");
        planetService.update("PLUTO", "New Pluto");

        System.out.println("\nUpdated:");
        System.out.println(clientService.getById(client.getId()));
        System.out.println(planetService.getById("PLUTO"));

        // =========================
        // DELETE
        // =========================
        clientService.delete(client.getId());
        planetService.delete("PLUTO");

        System.out.println("\nDeleted test entities");

        HibernateUtil.shutdown();
    }
}