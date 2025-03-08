package com.example.com_sboot.repository;


import com.example.com_sboot.model.Computer;
import org.springframework.data.repository.CrudRepository;



public interface IComputerRepository extends CrudRepository<Computer, Long > {
}
