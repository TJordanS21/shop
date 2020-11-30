package ch.bbw.tjs.shop.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ch.bbw.tjs.shop.model.Product;

/**
 * 
 * @date 20.11.2020
 * @author Tyler Jordan Storz
 *
 */
@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
}
