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

import ch.bbw.tjs.shop.model.Shop;
import ch.bbw.tjs.shop.repository.ShopRepository;

/**
 * @date 30.11.2020
 * @author Tyler Jordan Storz
 *
 */
@RestController
@RequestMapping("shop/shop")
public class ShopController {

	@Autowired
	private ShopRepository shopRepository;

	@CrossOrigin("*")
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Shop getShop(@PathVariable("id") Integer id) {
		Optional<Shop> optionalShop = shopRepository.findById(id);
		if (optionalShop.isPresent()) {
			return optionalShop.get();
		}
		return null;
	}

	@CrossOrigin("*")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public Iterable<Shop> getAllShops() {
		Iterable<Shop> shops = shopRepository.findAll();
		return shops;
	}

	@CrossOrigin("*")
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Shop updateShop(@RequestBody Shop shop) {
		return shopRepository.save(shop);
	}

	@CrossOrigin("*")
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Shop createShop(@RequestBody Shop shop) {
		return shopRepository.save(shop);
	}

	@CrossOrigin("*")
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public void deleteShop(@PathVariable("id") Integer id) {
		shopRepository.deleteById(id);
	}
}
