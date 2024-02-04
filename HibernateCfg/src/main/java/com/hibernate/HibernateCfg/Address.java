package com.hibernate.HibernateCfg;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;


@Entity
@Table(name = "studentaddress")
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="address_id")
	private int addressId;
	
	@Column(length = 100, name = "Street")
	private String street;
	
	@Column(length = 50, name = "City")
	private String city;
	
	@Column(name = "is_India")
	private boolean isInIndia;
	
	@Transient
	private double x;
	
	@Column(name = "added_date")
	@Temporal(TemporalType.DATE)
	private Date addedDate;
	
	@Lob
	private byte[] image;
	
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	public boolean isInIndia() {
		return isInIndia;
	}
	public void setInIndia(boolean isInIndia) {
		this.isInIndia = isInIndia;
	}
	
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	
	public Date getAddedDate() {
		return addedDate;
	}
	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}
	
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	
	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", street=" + street + ", city=" + city + ", isInIndia=" + isInIndia
				+ ", x=" + x + ", addedDate=" + addedDate + "]";
	}
	
}
