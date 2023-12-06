package com.example.demo.model;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Repository
public interface ProdutoRepository extends JpaRepository<ProdutosEntity, Long>{
    List<ProdutosEntity> findAllByAtivoTrue();
}
