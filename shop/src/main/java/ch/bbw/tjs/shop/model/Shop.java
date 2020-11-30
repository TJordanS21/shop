package ch.bbw.tjs.shop.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
@Table(name = "Shop")
@NamedQuery(name = "Shop.findAll", query = "SELECT e FROM Shop e")
public class Shop {
	@Id
	@Column(name = "shop_id", unique = true)
	private Integer shopid;

	@Column(name = "name")
	private String name;

	@Column(name = "city")
	private String city;

	@Column(name = "address")
	private String address;

	@JsonIgnoreProperties({ "shop", "hibernateLazyInitializer", "handler" })
	@OneToMany(mappedBy = "shop")
	private Set<Product> products;

	public Shop() {

	}

	public Shop(Integer shopid, String name, String city, String address) {
		super();
		this.shopid = shopid;
		this.name = name;
		this.city = city;
		this.address = address;
	}

	public Integer getShopid() {
		return shopid;
	}

	public void setShopid(Integer shopid) {
		this.shopid = shopid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Shop [shopid=" + shopid + ", name=" + name + ", city=" + city + ", address=" + address + ", products="
				+ products + "]";
	}

}
