package com.example.com_sboot.service;


import com.example.com_sboot.DTO.ITypeDTO;
import com.example.com_sboot.model.Type;

public interface ITypeService extends IGenerateService<Type>{
Iterable<ITypeDTO> getAllTypes();
}
