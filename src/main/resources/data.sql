INSERT INTO customer (customer_name) VALUES ('Internal use only');
INSERT INTO customer (customer_name) VALUES ('Jane Doe');

INSERT INTO ticket (customer_id, ticket_note) VALUES ('1', 'acer Chromebook: powerwash required');

INSERT INTO job (job_desc) VALUES ('Reset / Reformat');

INSERT INTO ticket_job (ticket_id, job_id) VALUES ('1', '1');