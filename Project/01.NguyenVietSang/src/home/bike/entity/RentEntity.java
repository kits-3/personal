package home.bike.entity;

import java.sql.Date;

public class RentEntity {
	private int rent_id;
	private int product_id;
	private int customer_id;
	private Date checkin_date;
	private Date checkout_date;

	public RentEntity() {
	}

	public RentEntity(int rent_id, int product_id, int customer_id, Date checkin_date, Date checkout_date) {
		super();
		this.rent_id = rent_id;
		this.product_id = product_id;
		this.customer_id = customer_id;
		this.checkin_date = checkin_date;
		this.checkout_date = checkout_date;
	}

	public int getRent_id() {
		return rent_id;
	}

	public void setRent_id(int rent_id) {
		this.rent_id = rent_id;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public Date getCheckin_date() {
		return checkin_date;
	}

	public void setCheckin_date(Date checkin_date) {
		this.checkin_date = checkin_date;
	}

	public Date getCheckout_date() {
		return checkout_date;
	}

	public void setCheckout_date(Date checkout_date) {
		this.checkout_date = checkout_date;
	}

}
