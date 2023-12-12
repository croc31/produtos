package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.FornecedorEntity;
import com.example.demo.model.ProdutosEntity;
import com.example.demo.services.FornecedorService;
import com.example.demo.services.ProdutoService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/fornecedor")
public class FornecedorController {
    @Autowired
    FornecedorService fornecedorService;

    //Um get que retorna todos os elementos presentes na
    //tabela “fornecedor”
    @GetMapping
    public  List<FornecedorEntity> getAll (){
        return fornecedorService.listarFornecedor();
    }
    @GetMapping("/{id}")
    //Retorna um único fornecedor baseado em seu ID
    public  FornecedorEntity getById (@PathVariable Long id){
        return fornecedorService.listarFornecedorPorId(id);
    }

    //Insere um novo fornecedor na tabela “fornecedor” a partir
    //de JSON enviado na requisição
     @PostMapping
     @Transactional
    public String postProduct (@RequestBody @Valid FornecedorEntity json){
        fornecedorService.cadastrarFornecedor(json);
        return "Fornecedor cadastrado!";
    }
}
