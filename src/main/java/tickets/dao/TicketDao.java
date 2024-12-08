package tickets.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import tickets.entity.Ticket;

public interface TicketDao extends JpaRepository<Ticket, Long> {

}
