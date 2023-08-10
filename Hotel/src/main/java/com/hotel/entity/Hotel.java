package com.hotel.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table
public class Hotel {
@Id
@GeneratedValue(strategy= GenerationType.IDENTITY)
private Integer Id;
private String hotelName;
private String HotelDesc;
private String location;
@Lob
private String hotelImg;
public String getHotelImg() {
	return hotelImg;
}
public void setHotelImg(String hotelImg) {
	this.hotelImg = hotelImg;
}
public Integer getId() {
	return Id;
}
public void setId(Integer id) {
	Id = id;
}
public String getHotelName() {
	return hotelName;
}
public void setHotelName(String hotelName) {
	this.hotelName = hotelName;
}
public String getHotelDesc() {
	return HotelDesc;
}
public void setHotelDesc(String hotelDesc) {
	HotelDesc = hotelDesc;
}
public String getLocation() {
	return location;
}
public void setLocation(String location) {
	this.location = location;
}

@Override
public String toString() {
	return "Hotel [Id=" + Id + ", hotelName=" + hotelName + ", HotelDesc=" + HotelDesc + ", location=" + location
			+ ", hotelImg=" + hotelImg + "]";
}
public Hotel() {
	super();
	// TODO Auto-generated constructor stub
}


}
