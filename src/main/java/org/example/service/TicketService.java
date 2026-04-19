package org.example.service;

import org.example.dao.TicketDao;
import org.example.entity.Client;
import org.example.entity.Planet;
import org.example.entity.Ticket;

import java.time.LocalDateTime;
import java.util.List;

public class TicketService {

    private final TicketDao ticketDao = new TicketDao();

    public Ticket createTicket(Client client, Planet from, Planet to) {

        Ticket ticket = new Ticket();
        ticket.setClient(client);
        ticket.setFromPlanet(from);
        ticket.setToPlanet(to);
        ticket.setCreatedAt(LocalDateTime.now());

        ticketDao.save(ticket);

        return ticket;
    }

    public Ticket getById(Long id) {
        return ticketDao.getById(id);
    }

    public List<Ticket> getAll() {
        return ticketDao.getAll();
    }
}
