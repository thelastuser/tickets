package tickets.controller.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import tickets.entity.Job;

//Job data only: Data Transfer Object to prevent recursive references to related objects
@Data
@NoArgsConstructor
public class JobDto {
	
	Long jobId;
	
	String jobDesc;
	
	public JobDto (Job job) {
		
		this.jobId = job.getJobId();
		this.jobDesc = job.getJobDesc();
		
	}
	
	public Job toEntity() {

		Job job = new Job();
		job.setJobId(this.jobId);
		job.setJobDesc(this.jobDesc);
		
		return job;
		
	}

}
