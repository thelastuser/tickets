package tickets.controller.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import tickets.entity.Customer;

//Customer data only: Data Transfer Object to prevent recursive references to related objects
@Data
@NoArgsConstructor
public class CustomerDto {
	
	private Long customerId;
	private String customerName;
	private String phone;
	private String email;
	private String customerNote;
	
	public Customer toEntity (CustomerDto customerDto) {
		
		Customer customer = new Customer();
		customer.setCustomerId(customerId);
		customer.setCustomerName(customerName);
		customer.setPhone(phone);
		customer.setEmail(email);
		customer.setCustomerNote(customerNote);
		
		return customer;
		
	}
	
	public CustomerDto (Customer customer) {
		
		this.customerId = customer.getCustomerId();
		this.customerName = customer.getCustomerName();
		this.phone = customer.getPhone();
		this.email = customer.getEmail();
		this.customerNote = customer.getCustomerNote();
		
	}

}
