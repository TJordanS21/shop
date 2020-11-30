package ch.bbw.tjs.shop.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
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
@Table(name = "Customer")
@NamedQuery(name = "Customer.findAll", query = "SELECT e FROM Customer e")
public class Customer {
	@Id
	@Column(name = "customer_id", unique = true)
	private Integer customerid;

	@Column(name = "firstname")
	private String firstName;

	@Column(name = "lastname")
	private String lastName;

	@Column(name = "email")
	private String email;

	@JsonIgnoreProperties({ "productCustomers", "hibernateLazyInitializer", "handler" })
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "customer_product", joinColumns = @JoinColumn(name = "customer_id"), inverseJoinColumns = @JoinColumn(name = "product_id"))
	Set<Product> customerProducts;

	@JsonIgnoreProperties({ "customer", "hibernateLazyInitializer", "handler" })
	@OneToOne(mappedBy = "customer", fetch = FetchType.LAZY)
	private Creditcard creditcard;

	public Customer() {

	}

	public Customer(Integer customerid, String firstName, String lastName, String email) {
		super();
		this.customerid = customerid;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public Integer getCustomerid() {
		return customerid;
	}

	public void setCustomerid(Integer customerid) {
		this.customerid = customerid;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Product> getCustomerProducts() {
		return customerProducts;
	}

	public void setCustomerProducts(Set<Product> customerProducts) {
		this.customerProducts = customerProducts;
	}

	public Creditcard getCreditcard() {
		return creditcard;
	}

	public void setCreditcard(Creditcard creditcard) {
		this.creditcard = creditcard;
	}

	@Override
	public String toString() {
		return "Customer [customerid=" + customerid + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", customerProducts=" + customerProducts + ", creditcard=" + creditcard + "]";
	}

}
