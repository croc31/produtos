package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.Repository.FuncionarioRepository;
import com.example.demo.model.FuncionarioEntity;

import jakarta.transaction.Transactional;

public class FuncionarioService {
    @Autowired
    FuncionarioRepository funcionarioRepository;

     public List<FuncionarioEntity> listarFuncionario(){
        return funcionarioRepository.findAllByAtivoTrue();
    }

    public FuncionarioEntity listarFuncionarioPorId(Long id){
        return funcionarioRepository.getReferenceById(id);
    }

    
    @Transactional
    public void cadastrarFuncionario(FuncionarioEntity dados){
        funcionarioRepository.save(new FuncionarioEntity(dados));
    }

    @Transactional
    public void deletarFuncionario(Long id){
        funcionarioRepository.deleteById(id);
    }

     @Transactional
    public void atualizarFuncionario(FuncionarioEntity dados){
        FuncionarioEntity entity = funcionarioRepository.getReferenceById(dados.getFuncionario_id());
        entity.atualizarDados(dados);
    }
}
