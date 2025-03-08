package com.example.com_sboot.repository;



import com.example.com_sboot.DTO.ITypeDTO;
import com.example.com_sboot.model.Type;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface ITypeRepository extends CrudRepository<Type, Long> {


@Query(nativeQuery = true,
value="select type.id as id , type.name, count(c.name) as count\n" +
        "from type\n" +
        "         left join computer\n" +
        "    c on type.id = c.type_id\n" +
        "group by type.id;")
    Iterable<ITypeDTO> getAllTypes();


    @Query(nativeQuery = true,
            value = "call deleteTypeById(:id);")
    @Transactional
    @Modifying
    void deleteTypeById(@Param("id") Long id);



}
