package tickets.controller.model;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import lombok.Data;
import lombok.NoArgsConstructor;
import tickets.entity.Job;
import tickets.entity.Ticket;

// Ticket data only: Data Transfer Object to prevent recursive references to related objects
@Data
@NoArgsConstructor
public class TicketDto {
	
	private Long ticketId;
	private String ticketNote;
	private Timestamp dateCreated;
	private Timestamp dateUpdated;
	private Boolean isCompleted;
	private CustomerDto customerDto;
	private Set<JobDto> jobsDto = new HashSet<>();
	
	public TicketDto (Ticket ticket) {
		
		this.ticketId = ticket.getTicketId();
		this.ticketNote = ticket.getTicketNote();
		this.dateCreated = ticket.getDateCreated();
		this.dateUpdated = ticket.getDateUpdated();
		this.isCompleted = ticket.getIsCompleted();
		this.customerDto = new CustomerDto(ticket.getCustomer());
		for (Job job : ticket.getJobs()) {
			this.jobsDto.add(new JobDto(job));
		}

	}
	
	public Ticket toEntity() {
		
		Ticket ticket = new Ticket();
		
		ticket.setTicketId(this.ticketId);
		ticket.setTicketNote(this.ticketNote);
		ticket.setDateCreated(this.dateCreated);
		ticket.setDateUpdated(this.dateUpdated);
		ticket.setIsCompleted(this.isCompleted);
		ticket.setCustomer(customerDto.toEntity(customerDto));
		
		ticket.getJobs().clear();
		for (JobDto jobDto : jobsDto ) {
			ticket.getJobs().add(jobDto.toEntity());
		}
		
		return ticket;
	
	}

}
