package com.example.com_sboot.service.impl;



import com.example.com_sboot.DTO.ITypeDTO;
import com.example.com_sboot.model.Type;
import com.example.com_sboot.repository.ITypeRepository;
import com.example.com_sboot.service.ITypeService;
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
    public Type save(Type type) {
        return iTypeRepository.save(type);
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
