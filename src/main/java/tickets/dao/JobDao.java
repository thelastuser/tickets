package tickets.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import tickets.entity.Job;

public interface JobDao extends JpaRepository<Job, Long> {

}
