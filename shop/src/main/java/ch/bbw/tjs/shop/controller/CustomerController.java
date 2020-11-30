package ch.bbw.tjs.shop.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.bbw.tjs.shop.model.Customer;
import ch.bbw.tjs.shop.repository.CustomerRepository;

/**
 * @date 30.11.2020
 * @author Tyler Jordan Storz
 *
 */
@RestController
@RequestMapping("shop/customer")
public class CustomerController {

	@Autowired
	private CustomerRepository customerRepository;

	@CrossOrigin("*")
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Customer getCustomer(@PathVariable("id") Integer id) {
		Optional<Customer> optionalCustomer = customerRepository.findById(id);
		if (optionalCustomer.isPresent()) {
			return optionalCustomer.get();
		}
		return null;
	}

	@CrossOrigin("*")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public Iterable<Customer> getAllCustomers() {
		Iterable<Customer> customers = customerRepository.findAll();
		return customers;
	}

	@CrossOrigin("*")
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Customer updateCustomer(@RequestBody Customer customer) {
		return customerRepository.save(customer);
	}

	@CrossOrigin("*")
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Customer createCustomer(@RequestBody Customer customer) {
		return customerRepository.save(customer);
	}

	@CrossOrigin("*")
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public void deleteCustomer(@PathVariable("id") Integer id) {
		customerRepository.deleteById(id);
	}
}
