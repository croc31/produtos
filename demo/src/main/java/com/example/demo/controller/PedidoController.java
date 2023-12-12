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

import com.example.demo.model.PedidoEntity;
import com.example.demo.model.ProdutosAtualizar;
import com.example.demo.model.ProdutosEntity;
import com.example.demo.services.PedidoService;
import com.example.demo.services.ProdutoService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/pedido")
public class PedidoController {
     @Autowired
    PedidoService pedidoService;

    //Um get que retorna todos os elementos presentes na
    //tabela “pedido”
    @GetMapping
    public  List<PedidoEntity> getAll (){
        return pedidoService.listarPedido();
    }
    @GetMapping("/{id}")
    //Retorna um único pedido baseado em seu ID
    public  PedidoEntity getById (@PathVariable Long id){
        return pedidoService.listarPedidoPorId(id);
    }

    //Insere um novo pedido na tabela “pedido” a partir
    //de JSON enviado na requisição
     @PostMapping
     @Transactional
    public String postProduct (@RequestBody @Valid PedidoEntity json){
        pedidoService.cadastrarPedido(json);
        return "Pedido cadastrado!";
    }

    //Deleta fisicamente um pedido da tabela “pedido”
    @DeleteMapping("/{id}")
    @Transactional 
    public String DeleteProduct (@PathVariable Long id){
        pedidoService.deletarPedido(id);
        return "Pedido Deletado";
    }
}
