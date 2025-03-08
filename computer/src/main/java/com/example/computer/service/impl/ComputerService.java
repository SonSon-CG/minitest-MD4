package com.example.computer.service.impl;

import com.example.computer.model.Computer;
import com.example.computer.repository.IComputerRepository;
import com.example.computer.service.IComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ComputerService implements IComputerService {
    @Autowired
    private IComputerRepository iComputerRepository;

    @Override
    public Iterable<Computer> findAll() {
        return iComputerRepository.findAll();
    }

    @Override
    public void save(Computer computer) {
        iComputerRepository.save(computer);
    }

    @Override
    public Optional<Computer> findById(Long id) {
        return iComputerRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        iComputerRepository.deleteById(id);
    }
}
