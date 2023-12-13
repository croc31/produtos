package com.example.demo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.FuncionarioEntity;
import com.example.demo.services.FuncionarioService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {
     @Autowired
    FuncionarioService funcionarioService;

    //Um get que retorna todos os elementos presentes na
    //tabela “fornecedor”
    @GetMapping
    public  List<FuncionarioEntity> getAll (){
        return funcionarioService.listarFuncionario();
    }
    @GetMapping("/{id}")
    //Retorna um único fornecedor baseado em seu ID
    public  FuncionarioEntity getById (@PathVariable Long id){
        return funcionarioService.listarFuncionarioPorId(id);
    }

    //Insere um novo fornecedor na tabela “fornecedor” a partir
    //de JSON enviado na requisição
     @PostMapping
     @Transactional
    public String postProduct (@RequestBody @Valid FuncionarioEntity json){
        funcionarioService.cadastrarFuncionario(json);
        return "Funcionario cadastrado!";
    }

    @PutMapping
    @Transactional 
    public String putFuncionario (@RequestBody @Valid FuncionarioEntity json){
        funcionarioService.atualizarFuncionario(json);
        return "Funcionario modificado";
    }
}
