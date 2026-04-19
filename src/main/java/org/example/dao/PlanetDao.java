package org.example.dao;

import org.example.entity.Planet;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.function.Consumer;

public class PlanetDao {

    public void save(Planet planet) {
        execute(session -> session.persist(planet));
    }

    public Planet getById(String id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.find(Planet.class, id);
        }
    }

    public List<Planet> getAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Planet", Planet.class).list();
        }
    }

    public void update(Planet planet) {
        execute(session -> session.merge(planet));
    }

    public void delete(Planet planet) {
        execute(session -> {
            Planet managed = session.merge(planet);
            session.remove(managed);
        });
    }

    private void execute(Consumer<Session> action) {
        Transaction tx = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();

            action.accept(session);

            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        }
    }
}