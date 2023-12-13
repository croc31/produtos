package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.Repository.FornecedorRepository;
import com.example.demo.model.FornecedorEntity;

import jakarta.transaction.Transactional;

public class FornecedorService {
    @Autowired
    FornecedorRepository fornecedorRepository;

     public List<FornecedorEntity> listarFornecedor(){
        return fornecedorRepository.findAllByAtivoTrue();
    }

    public FornecedorEntity listarFornecedorPorId(Long id){
        return fornecedorRepository.getReferenceById(id);
    }

    
    @Transactional
    public void cadastrarFornecedor(FornecedorEntity dados){
        fornecedorRepository.save(new FornecedorEntity(dados));
    }

    @Transactional
    public void deletarFornecedor(Long id){
        fornecedorRepository.deleteById(id);
    }

    @Transactional
    public void atualizarFornecedor(FornecedorEntity dados){
        FornecedorEntity entity = fornecedorRepository.getReferenceById(dados.getFornecedor_id());
        entity.atualizarDados(dados);
    }
}
