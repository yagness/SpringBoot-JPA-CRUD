package com.test.onetoone.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.onetoone.entities.Laptop;

@Repository
public interface LaptopRepo extends JpaRepository<Laptop,Integer >{

}
