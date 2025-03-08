package com.example.com_sboot.controller;


import com.example.com_sboot.model.Computer;
import com.example.com_sboot.service.IComputerService;
import com.example.com_sboot.service.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/computers")
public class ComputerController {

    @Autowired
    private IComputerService computerService;

    @Autowired
    private ITypeService typeService;

    @GetMapping
    public ResponseEntity<Iterable<Computer>> findAllComputer() {
        List<Computer> customers = (List<Computer>) computerService.findAll();
        if (customers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Computer> saveComputer(@RequestBody Computer computer) {
        return new ResponseEntity<>(computerService.save(computer), HttpStatus.CREATED);
    }
}