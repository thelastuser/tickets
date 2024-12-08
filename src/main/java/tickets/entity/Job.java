package tickets.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Job {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long jobId;
	
	private String jobDesc;
		
}
