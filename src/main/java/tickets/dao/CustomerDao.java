package tickets.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import tickets.entity.Customer;

public interface CustomerDao extends JpaRepository<Customer, Long> {

}
