package com.example.demo.Repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.FuncionarioEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Repository
public interface FuncionarioRepository extends JpaRepository<FuncionarioEntity, Long>{
    List<FuncionarioEntity> findAllByAtivoTrue();
}
