package com.example.computer.service.impl;

import com.example.computer.model.DTO.ITypeDTO;
import com.example.computer.model.Type;
import com.example.computer.repository.ITypeRepository;
import com.example.computer.service.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class TypeService implements ITypeService {

    @Autowired
    private ITypeRepository iTypeRepository;

    @Override
    public Iterable<Type> findAll() {
        return iTypeRepository.findAll();
    }

    @Override
    public void save(Type type) {
        iTypeRepository.save(type);
    }

    @Override
    public Optional<Type> findById(Long id) {
        return iTypeRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        iTypeRepository.deleteTypeById(id);
    }

    @Override
    public Iterable<ITypeDTO> getAllTypes() {
        return iTypeRepository.getAllTypes();
    }
}
