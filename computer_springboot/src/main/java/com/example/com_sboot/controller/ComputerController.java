package com.example.com_sboot.controller;


import com.example.com_sboot.model.Computer;
import com.example.com_sboot.service.IComputerService;
import com.example.com_sboot.service.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/computers")
@CrossOrigin("*")
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



    @GetMapping("/{id}")
    public ResponseEntity<Computer> findComputerById(@PathVariable Long id) {
        Optional<Computer> customerOptional = computerService.findById(id);
        if (!customerOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customerOptional.get(), HttpStatus.OK);
    }

//    @PostMapping
//    public ResponseEntity<Computer> saveComputer(@RequestBody Computer computer) {
//        Computer savedComputer = computerService.save(computer);
//        return savedComputer != null
//                ? ResponseEntity.status(HttpStatus.CREATED).body(savedComputer)
//                : ResponseEntity.badRequest().build();
//    }

    @PutMapping("/{id}")
    public ResponseEntity<Computer> updateComputer(@PathVariable Long id, @RequestBody Computer computer) {
        Optional<Computer> computerOptional = computerService.findById(id);
        if (!computerOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        computer.setId(computerOptional.get().getId());
        return new ResponseEntity<>(computerService.save(computer), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Computer> deleteCustomer(@PathVariable Long id) {
        Optional<Computer> computerOptional = computerService.findById(id);
        if (!computerOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        computerService.remove(id);
        return new ResponseEntity<>(computerOptional.get(), HttpStatus.OK);
    }

//    @GetMapping("/search")
//    public ResponseEntity<Page<Computer>> searchComputers(
//            @RequestParam("search") Optional<String> search,
//            Pageable pageable) {
//
//        Page<Computer> computers = search
//                .map(s -> computerService.findAllByNameContaining(pageable, s))
//                .orElseGet(() -> computerService.findAll(pageable));
//
//        return computers.isEmpty()
//                ? ResponseEntity.noContent().build()
//                : ResponseEntity.ok(computers);
//    }



}