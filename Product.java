package com.Project.projectms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="online_shopping")

public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column (name="product_id")
	private long id;
	@Column (name="product_name")
	private String p_name;
	@Column (name="product_category")
	private String p_category;
	@Column (name="product_price")
	private int p_price;
	@Column (name="product_brand")
	private String p_brand;
	@Column (name="product_quantity")
	private int p_quantity;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public String getP_category() {
		return p_category;
	}
	public void setP_category(String p_category) {
		this.p_category = p_category;
	}
	public int getP_price() {
		return p_price;
	}
	public void setP_price(int p_price) {
		this.p_price = p_price;
	}
	public String getP_brand() {
		return p_brand;
	}
	public void setP_brand(String p_brand) {
		this.p_brand = p_brand;
	}
	public int getP_quantity() {
		return p_quantity;
	}
	public void setP_quantity(int p_quantity) {
		this.p_quantity = p_quantity;
	}
	public Product( String p_name, String p_category, int p_price, String p_brand, int p_quantity) {
		super();
		this.p_name = p_name;
		this.p_category = p_category;
		this.p_price = p_price;
		this.p_brand = p_brand;
		this.p_quantity = p_quantity;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", p_name=" + p_name + ", p_category=" + p_category + ", p_price=" + p_price
				+ ", p_brand=" + p_brand + ", p_quantity=" + p_quantity + "]";
	}


}
