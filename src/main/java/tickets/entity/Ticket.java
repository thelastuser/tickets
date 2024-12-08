package tickets.entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
public class Ticket {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long ticketId;
	
	private String ticketNote;
	
	@CreationTimestamp
	@Column (name = "date_created")
	private Timestamp dateCreated;
	
	@UpdateTimestamp
	@Column (name = "date_updated")
	private Timestamp dateUpdated;
	
	@Column (name = "is_completed")
	private Boolean isCompleted;
	
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@ManyToOne (cascade = CascadeType.MERGE)
	@JoinColumn (name = "customer_id")
	private Customer customer;
	
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@ManyToMany (cascade = CascadeType.MERGE)
	@JoinTable(
			name = "ticket_job",
			joinColumns = @JoinColumn (name = "ticket_id"),
			inverseJoinColumns = @JoinColumn (name = "job_id")
			)
	private Set<Job> jobs = new HashSet<>();

}
