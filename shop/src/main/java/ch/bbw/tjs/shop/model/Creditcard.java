package ch.bbw.tjs.shop.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "Creditcard")
@NamedQuery(name = "Creditcard.findAll", query = "SELECT e FROM Creditcard e")
public class Creditcard {
	@Id
	@Column(name = "creditcard_id", unique = true)
	private Integer creditcardid;

	@Column(name = "number")
	private Integer number;

	@Column(name = "date")
	private Integer date;

	@Column(name = "pin")
	private Integer pin;

	@JsonIgnoreProperties({ "creditcard", "hibernateLazyInitializer", "handler" })
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_idfs", referencedColumnName = "customer_id")
	private Customer customer;

	public Creditcard() {

	}

	public Creditcard(Integer creditcardid, Integer number, Integer date, Integer pin, Customer customer) {
		super();
		this.creditcardid = creditcardid;
		this.number = number;
		this.date = date;
		this.pin = pin;
		this.customer = customer;
	}

	public Creditcard(Integer creditcardid, Integer number, Integer date, Integer pin) {
		super();
		this.creditcardid = creditcardid;
		this.number = number;
		this.date = date;
		this.pin = pin;
	}

	public int getCreditcardid() {
		return creditcardid;
	}

	public void setCreditcardid(Integer creditcardid) {
		this.creditcardid = creditcardid;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Integer getDate() {
		return date;
	}

	public void setDate(Integer date) {
		this.date = date;
	}

	public Integer getPin() {
		return pin;
	}

	public void setPin(Integer pin) {
		this.pin = pin;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Creditcard [creditcardid=" + creditcardid + ", number=" + number + ", date=" + date + ", pin=" + pin
				+ "]";
	}

}
