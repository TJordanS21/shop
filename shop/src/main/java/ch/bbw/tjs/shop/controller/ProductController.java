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

import ch.bbw.tjs.shop.model.Product;
import ch.bbw.tjs.shop.repository.ProductRepository;

/**
 * @date 30.11.2020
 * @author Tyler Jordan Storz
 *
 */
@RestController
@RequestMapping("shop/product")
public class ProductController {
	@Autowired
	private ProductRepository PpoductRepository;

	@CrossOrigin("*")
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Product getProduct(@PathVariable("id") Integer id) {
		Optional<Product> optionalProduct = PpoductRepository.findById(id);
		if (optionalProduct.isPresent()) {
			return optionalProduct.get();
		}
		return null;
	}

	@CrossOrigin("*")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public Iterable<Product> getAllProducts() {
		Iterable<Product> product = PpoductRepository.findAll();
		return product;
	}

	@CrossOrigin("*")
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Product updateProduct(@RequestBody Product Ppoduct) {
		return PpoductRepository.save(Ppoduct);
	}

	@CrossOrigin("*")
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Product createProduct(@RequestBody Product product) {
		return PpoductRepository.save(product);
	}

	@CrossOrigin("*")
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public void deleteProduct(@PathVariable("id") Integer id) {
		PpoductRepository.deleteById(id);
	}
}
