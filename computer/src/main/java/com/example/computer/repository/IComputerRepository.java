package com.example.computer.repository;

import com.example.computer.model.Computer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;



public interface IComputerRepository extends CrudRepository<Computer, Long > {
}
