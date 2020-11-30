package ch.bbw.tjs.shop.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQuery;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * @date 20.11.2020
 * @author Tyler Jordan Storz
 *
 */
@Entity
@Table(name = "Product")
@NamedQuery(name = "Product.findAll", query = "SELECT e FROM Product e")
public class Product {
	@Id
	@Column(name = "product_id", unique = true)
	private Integer productid;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	@Column(name = "price")
	private double price;

	@Column(name = "amount")
	private Integer amount;

	@JsonIgnoreProperties({ "customerProducts", "hibernateLazyInitializer", "handler" })
	@ManyToMany(mappedBy = "customerProducts")
	Set<Customer> productCustomers;

	@JsonIgnoreProperties({ "products", "hibernateLazyInitializer", "handler" })
	@ManyToOne
	@JoinColumn(name = "shop_id")
	private Shop shop;

	public Product() {

	}

	public Product(Integer productid, String name, String description, double price, Integer amount) {
		super();
		this.productid = productid;
		this.name = name;
		this.description = description;
		this.price = price;
		this.amount = amount;
	}

	public Integer getProductid() {
		return productid;
	}

	public void setProductid(Integer productid) {
		this.productid = productid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Set<Customer> getProductCustomers() {
		return productCustomers;
	}

	public void setProductCustomers(Set<Customer> productCustomers) {
		this.productCustomers = productCustomers;
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	@Override
	public String toString() {
		return "Product [productid=" + productid + ", name=" + name + ", description=" + description + ", price="
				+ price + ", amount=" + amount + "]";
	}

}