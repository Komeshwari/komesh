package com.hotel.service;

import java.io.IOException;
import java.util.Base64;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import com.hotel.entity.Hotel;
import com.hotel.repository.HotelRepository;
@Service
public class HotelServiceImp implements HotelService {
	@Autowired
	private HotelRepository repo;

	@Override
	public Hotel register(String hotelName, String hotelDesc, String location, MultipartFile hotelImg) {
		// TODO Auto-generated method stub
		Hotel ie = new  Hotel();
        String fileName = StringUtils.cleanPath(hotelImg.getOriginalFilename());
        if(fileName.contains("..")) {
            System.out.println("Invalid path");

        }
        try{
//            ie.setEventImg(Base64.getEncoder().encodeToString(eventImg.getBytes()));
            ie.setHotelImg(Base64.getEncoder().encodeToString(hotelImg.getBytes()));
        }
        catch( Exception e) {
            e.printStackTrace();
        }

        ie.setHotelName(hotelName);
        ie.setHotelDesc(hotelDesc);
        ie.setLocation(location);
        repo.save(ie);
        return ie;
		//return null;
	}

	@Override//retrieve
	public Optional<Hotel> retrieveData(Integer Id) {
		// TODO Auto-generated method stub
		return repo.findById(Id);
	}

	@Override//update
	public Hotel updateData(Integer Id, String hotelName, String hotelDesc, String location, MultipartFile hotelImg) {
		// TODO Auto-generated method stub
		Optional<Hotel> optionalHotel=repo.findById(Id);
		if(!optionalHotel.isPresent())
		{
			return null;
		}
		Hotel hotel=optionalHotel.get();
		hotel.setHotelName(hotelName);
		hotel.setHotelDesc(hotelDesc);
		hotel.setLocation(location);
		if(hotelImg!=null&&!hotelImg.isEmpty())
		{
			String fileName = StringUtils.cleanPath(hotelImg.getOriginalFilename());
			if(fileName.contains(".."))
			{
				System.out.println("Not a valid file");
			}
			else
			{
				try {
					hotel.setHotelImg(Base64.getEncoder().encodeToString(hotelImg.getBytes()));
					
				}
				catch(IOException e)
				{
					e.printStackTrace();
				}
			}
		}
		repo.save(hotel);
		return hotel;
		//return null;
	}

	@Override
	public String deleteData(Integer Id) {
		// TODO Auto-generated method stub
		Optional<Hotel> delete=repo.findById(Id);
		if(delete.isPresent())
		{
			repo.deleteById(Id);
		}
		return "Data Deleted sucessfully!";
		//return null;
	}
	

}
