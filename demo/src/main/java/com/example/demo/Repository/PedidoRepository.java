package com.example.demo.Repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.PedidoEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Repository
public interface PedidoRepository extends JpaRepository<PedidoEntity, Long>{
    List<PedidoEntity> findAllByAtivoTrue();
}
