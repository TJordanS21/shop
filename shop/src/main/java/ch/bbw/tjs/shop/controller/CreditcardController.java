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

import ch.bbw.tjs.shop.model.Creditcard;
import ch.bbw.tjs.shop.repository.CreditcardRepository;

/**
 * @date 30.11.2020
 * @author Tyler Jordan Storz
 *
 */
@RestController
@RequestMapping("shop/creditcard")
public class CreditcardController {
	@Autowired
	private CreditcardRepository creditcardRepository;

	@CrossOrigin("*")
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Creditcard getCreditcard(@PathVariable("id") Integer id) {
		Optional<Creditcard> optionalCreditcard = creditcardRepository.findById(id);
		if (optionalCreditcard.isPresent()) {
			return optionalCreditcard.get();
		}
		return null;
	}

	@CrossOrigin("*")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public Iterable<Creditcard> getAllCreditcards() {
		Iterable<Creditcard> creditcards = creditcardRepository.findAll();
		return creditcards;
	}

	@CrossOrigin("*")
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Creditcard updateCreditcard(@RequestBody Creditcard creditcard) {
		return creditcardRepository.save(creditcard);
	}

	@CrossOrigin("*")
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Creditcard createCreditcard(@RequestBody Creditcard creditcard) {
		return creditcardRepository.save(creditcard);
	}

	@CrossOrigin("*")
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public void deleteCreditcard(@PathVariable("id") Integer id) {
		creditcardRepository.deleteById(id);
	}
}
