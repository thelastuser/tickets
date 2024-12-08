DROP TABLE IF EXISTS ticket_job;
DROP TABLE IF EXISTS job;
DROP TABLE IF EXISTS ticket;
DROP TABLE IF EXISTS customer;

CREATE TABLE customer (
	customer_id INT NOT NULL AUTO_INCREMENT,
	customer_name VARCHAR(128) NOT NULL,
	phone VARCHAR(32),
	email VARCHAR(128),
	customer_note TEXT,
	PRIMARY KEY(customer_id)
);
CREATE TABLE ticket (
	ticket_id INT NOT NULL AUTO_INCREMENT,
	ticket_note VARCHAR(128) NOT NULL,
	date_created TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	date_updated TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	is_completed BOOLEAN NOT NULL,
	customer_id INT,
	PRIMARY KEY(ticket_id), 
	FOREIGN KEY(customer_id) REFERENCES customer(customer_id)
);
CREATE TABLE job (
	job_id INT NOT NULL AUTO_INCREMENT,
	job_desc VARCHAR(128) NOT NULL,
	PRIMARY KEY(job_id)
);
CREATE TABLE ticket_job (
	ticket_id INT NOT NULL,
	job_id INT NOT NULL,
	FOREIGN KEY(ticket_id) REFERENCES ticket(ticket_id) ON DELETE CASCADE,
	FOREIGN KEY(job_id) REFERENCES job(job_id) ON DELETE CASCADE
);