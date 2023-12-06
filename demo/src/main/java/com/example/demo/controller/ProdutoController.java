package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

import com.example.demo.model.ProdutosAtualizar;
import com.example.demo.model.ProdutosEntity;
import com.example.demo.services.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
     @Autowired
    ProdutoService produtoService;

    //Um get que retorna todos os elementos presentes na
    //tabela “produto”
    @GetMapping
    public  List<ProdutosEntity> getAll (){
        return produtoService.listarProdutos();
    }
    @GetMapping("/{id}")
    //Retorna um único produto baseado em seu ID
    public  ProdutosEntity getById (@PathVariable Long id){
        return produtoService.listarProdutoPorId(id);
    }

    //Insere um novo produto na tabela “produto” a partir
    //de JSON enviado na requisição
     @PostMapping
     @Transactional
    public String postProduct (@RequestBody @Valid ProdutosEntity json){
        produtoService.cadastrarProduto(json);
        return "Produto cadastrado!";
    }

    //Alterar qualquer das características passadas a partir
    //de um JSON enviado na requisição. Apenas o ID será um
    //elemento obrigatório a ser enviado
    @PutMapping
    @Transactional 
    public String putProduct (@RequestBody @Valid ProdutosAtualizar json){
        produtoService.atualizarProduto(json);
        return "Produto modificado";
    }

    //Deleta fisicamente um produto da tabela “produto”
    @DeleteMapping("/{id}")
    @Transactional 
    public String DeleteProduct (@PathVariable Long id){
        produtoService.deletarProduto(id);
        return "Produto Deletado";
    }

    //Mantém um elemento na tabela, mas altera o valor
    //do atributo ativo para false, fazendo que aquele produto não seja
    //mostrado nos métodos get, nem atualizado no método put
    @DeleteMapping("logic/{id}")
    @Transactional 
    public String DeleteLogic (@PathVariable Long id){
        produtoService.inativar(id);
        return "Produto Deletado";
    }
    
}
