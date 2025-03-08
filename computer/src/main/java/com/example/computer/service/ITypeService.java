package com.example.computer.service;

import com.example.computer.model.DTO.ITypeDTO;
import com.example.computer.model.Type;

public interface ITypeService extends IGenerateService<Type>{
Iterable<ITypeDTO> getAllTypes();
}
