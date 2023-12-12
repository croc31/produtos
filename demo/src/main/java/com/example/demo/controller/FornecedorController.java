package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.ProdutosEntity;
import com.example.demo.services.ProdutoService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/fornecedor")
public class FornecedorController {
    @Autowired
    ProdutoService fornecedorService;

    //Um get que retorna todos os elementos presentes na
    //tabela “fornecedor”
    @GetMapping
    public  List<ProdutosEntity> getAll (){
        return fornecedorService.listarProdutos();
    }
    @GetMapping("/{id}")
    //Retorna um único fornecedor baseado em seu ID
    public  ProdutosEntity getById (@PathVariable Long id){
        return fornecedorService.listarProdutoPorId(id);
    }

    //Insere um novo fornecedor na tabela “fornecedor” a partir
    //de JSON enviado na requisição
     @PostMapping
     @Transactional
    public String postProduct (@RequestBody @Valid ProdutosEntity json){
        fornecedorService.cadastrarProduto(json);
        return "Produto cadastrado!";
    }
}
