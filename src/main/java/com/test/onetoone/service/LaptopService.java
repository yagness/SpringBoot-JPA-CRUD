package com.test.onetoone.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.test.onetoone.entities.Laptop;
import com.test.onetoone.repo.LaptopRepo;

@Service
public class LaptopService {
	
	@Autowired
	LaptopRepo laprep;
	
	public Laptop addLaptop(@RequestBody Laptop laptop)
	{
		return laprep.save(laptop);
	}
	
	public List<Laptop> getLaptop()
	{
		return laprep.findAll();
	}
	
	public Laptop updateLaptop(@RequestBody Laptop laptop,@PathVariable int id)
	{
		Laptop olap = laprep.findById(id).get();
		if(olap!=null)
		{
			olap.setBrand(laptop.getBrand());
			olap.setOs(laptop.getOs());
			laprep.save(olap);
		}
		return olap;
	}
	
	public void deleteLaptop(@PathVariable int id)
	{
		Laptop lap =laprep.findById(id).get();
		if(lap!=null)
		{
			laprep.delete(lap);
		}
		System.out.println("data deleted");
	}
}
