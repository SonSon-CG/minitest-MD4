package com.example.com_sboot.service.impl;



import com.example.com_sboot.model.Computer;
import com.example.com_sboot.repository.IComputerRepository;
import com.example.com_sboot.service.IComputerService;
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
    public Computer save(Computer computer) {
        return iComputerRepository.save(computer);

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
