package tickets.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import tickets.controller.model.CustomerDto;
import tickets.controller.model.JobDto;
import tickets.controller.model.TicketDto;
import tickets.service.TicketsService;

@RestController
@RequestMapping("/tickets")
@Slf4j
public class TicketsController {
	
	@Autowired
	private TicketsService ticketService;
	
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public List<TicketDto> showAllTickets() {
		
		log.info("Requesting a summary list of all tickets");
		
		return ticketService.retrieveAllTickets();
		
	}
	
	@GetMapping("/{ticketId}")
	@ResponseStatus(code = HttpStatus.OK)
	public TicketDto showSpecificTicket(@PathVariable Long ticketId) {
		
		log.info("Requesting ticket with ID={}", ticketId);
		
		return ticketService.retrieveTicket(ticketId);
		
	}
	
	@PutMapping("/{ticketId}")
	@ResponseStatus(code = HttpStatus.OK)
	public TicketDto modifyTicket(@RequestBody TicketDto ticketDto, @PathVariable Long ticketId) {
		
		log.info("Updating ticket with ID={}", ticketId);
		
		return ticketService.updateTicket(ticketDto);
		
	}
	
	@DeleteMapping("/{ticketId}")
	@ResponseStatus(code = HttpStatus.OK)
	public Map<String, String> removeTicket(@PathVariable Long ticketId) {
		
		log.info("Attempting deletion of ticket with ID={}", ticketId);
		
		return ticketService.deleteTicket(ticketId);
		
	}
	
	@GetMapping("/customers")
	@ResponseStatus(code = HttpStatus.OK)
	public List<CustomerDto> showAllCustomers() {
		
		log.info("Requesting a list of all customers.");
		
		return ticketService.retrieveAllCustomers();
	}

	@GetMapping("/customers/{customerId}")
	@ResponseStatus(code = HttpStatus.OK)
	public CustomerDto showSpecificCustomer(@PathVariable Long customerId) {
		
		log.info("Requesting customer with ID={}", customerId);
		
		return ticketService.retrieveCustomer(customerId);
		
	}
	
	@GetMapping("/jobs")
	@ResponseStatus(code = HttpStatus.OK)
	public List<JobDto> showAllJobs() {
		
		log.info("Requesting a list of all job types.");
		
		return ticketService.retrieveAllJobs();
		
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public TicketDto addTicket(@RequestBody TicketDto ticketDto) {
		
//		if (Objects.isNull(ticketDto.getCustomerDto().getCustomerId())) {
//			ticketDto.getCustomerDto().setCustomerId(3L); // default customerId for in-store tickets
//		}
		
		return ticketService.insertNewTicket(ticketDto);
		
	}

}
