package com.tnsif.Shoppingmall.shop;

import jakarta.persistence.*;


@Entity
@Table(name = "shops")
public class Shops {


@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;


private String shopName;
private String category;
private int floorNumber;
@Override
public String toString() {
	return "Shops [id=" + id + ", shopName=" + shopName + ", category=" + category + ", floorNumber=" + floorNumber
			+ ", ownerName=" + ownerName + ", status=" + status + "]";
}
public Shops() {
	super();
}
private String ownerName;
private String status;


public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getShopName() {
	return shopName;
}
public void setShopName(String shopName) {
	this.shopName = shopName;
}
public String getCategory() {
	return category;
}
public void setCategory(String category) {
	this.category = category;
}
public int getFloorNumber() {
	return floorNumber;
}
public void setFloorNumber(int floorNumber) {
	this.floorNumber = floorNumber;
}
public String getOwnerName() {
	return ownerName;
}
public void setOwnerName(String ownerName) {
	this.ownerName = ownerName;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}


}