package com.hotel.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.hotel.entity.Hotel;
import com.hotel.service.HotelService;

@RestController
public class HotelController {
	
	
@Autowired
private HotelService service;

@PostMapping("/saveHotel")//save data
public String saveHotel(@RequestParam String hotelName,
		@RequestParam String hotelDesc,
		@RequestParam String location,
		@RequestParam MultipartFile hotelImg)
{
	Hotel hotel=service.register(hotelName,hotelDesc,location,hotelImg);
	String message=null;
	if(hotel!=null)
	{
		message="Data Saved Sucessfully!";
	}
	else
	{
		message="Failed to Register!";
	}
	
        return message;
}	
@GetMapping("/retrieveHotel")//Retrieve Data
public Optional<Hotel> retrieveData(@RequestParam Integer Id)
{
	return service.retrieveData(Id);
}
@PutMapping("/updateHotel")
 public Hotel updateHotel(@RequestParam  Integer Id,
		      @RequestParam String hotelName,
		      @RequestParam String hotelDesc,
		      @RequestParam String location,
		      @RequestParam MultipartFile hotelImg)
 {
	       Hotel update=service.updateData(Id,hotelName,hotelDesc,location,hotelImg);
	      return update;
 }
@DeleteMapping("/deleteHotel")
public String deleteHotel(Integer Id)
{
	return service.deleteData(Id);
}

}
