package com.test.onetoone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.onetoone.entities.Laptop;
import com.test.onetoone.service.LaptopService;

@RestController
@RequestMapping("/laptop")
public class LaptopController {
	
	@Autowired
	LaptopService lapser;
	
	@PostMapping("/add")
	public String addLaptop(@RequestBody Laptop laptop)
	{
		lapser.addLaptop(laptop);
		return "Laptop added successfully";
	}
	
	@GetMapping("/get")
	public List<Laptop> getLaptop()
	{
		return lapser.getLaptop();
	}
	
	@PutMapping("/update/{id}")
	public Laptop updateLaptop(@RequestBody Laptop laptop,@PathVariable int id)
	{
		return lapser.updateLaptop(laptop, id);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteLaptop(@PathVariable int id)
	{
		lapser.deleteLaptop(id);
		return "laptop deleted successfully..";
	}

}
