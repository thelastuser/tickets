package tickets.service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import tickets.controller.model.CustomerDto;
import tickets.controller.model.JobDto;
import tickets.controller.model.TicketDto;
import tickets.dao.CustomerDao;
import tickets.dao.JobDao;
import tickets.dao.TicketDao;
import tickets.entity.Customer;
import tickets.entity.Job;
import tickets.entity.Ticket;

@Service
public class TicketsService {
	
	@Autowired
	private TicketDao ticketDao;
	
	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	private JobDao jobDao;

	public List<TicketDto> retrieveAllTickets() {

		List<Ticket> tickets = ticketDao.findAll();
		List<TicketDto> ticketsDto = new LinkedList<>();

		for (Ticket ticket : tickets) {
			ticketsDto.add(new TicketDto(ticket));
		}
		
		return ticketsDto;
		
	}

	public TicketDto retrieveTicket(Long ticketId) {

		return new TicketDto(ticketDao.getReferenceById(ticketId));

	}

	public List<CustomerDto> retrieveAllCustomers() {

		List<Customer> customers = customerDao.findAll();
		List<tickets.controller.model.CustomerDto> customersDto = new LinkedList<>();
		
		for (Customer customer : customers) {
			customersDto.add(new CustomerDto(customer));
		}
		
		return customersDto;
		
	}

	public TicketDto insertNewTicket(TicketDto ticketDto) {
		
		ticketDao.save(ticketDto.toEntity());
		
		return ticketDto;
		
	}

	public CustomerDto retrieveCustomer(Long customerId) {

		return new CustomerDto(customerDao.getReferenceById(customerId));
		
	}

	public List<JobDto> retrieveAllJobs() {

		List<Job> jobs = jobDao.findAll();
		List<JobDto> jobsDto = new LinkedList<>();
		
		for (Job job : jobs) {
			jobsDto.add(new JobDto(job));
		}
		
		return jobsDto;
		
	}

	@Transactional
	public Map<String, String> deleteTicket(Long ticketId) {

		Ticket ticketForDeletion = ticketDao.findById(ticketId).orElseThrow(() -> new NoSuchElementException("No ticket with ID=" + ticketId + " was found."));
		ticketDao.delete(ticketForDeletion);
		Map<String, String> operationComplete = new HashMap<>();
		operationComplete.put("message", "Your request to delete ticket with ID=" + ticketId + " was successful.");
		return operationComplete;
	}

	@Transactional(readOnly = false)
	public TicketDto updateTicket(TicketDto ticketDto) {

		Ticket ticket = ticketDto.toEntity();
		
		
		
		return new TicketDto(ticketDao.save(ticket));
		
	}

}
