package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.Repository.PedidoRepository;
import com.example.demo.model.FuncionarioEntity;
import com.example.demo.model.PedidoEntity;

import jakarta.transaction.Transactional;

public class PedidoService {
    @Autowired
    PedidoRepository pedidoRepository;

     public List<PedidoEntity> listarPedido(){
        return pedidoRepository.findAllByAtivoTrue();
    }

    public PedidoEntity listarPedidoPorId(Long id){
        return pedidoRepository.getReferenceById(id);
    }

    
    @Transactional
    public void cadastrarPedido(PedidoEntity dados){
        pedidoRepository.save(new PedidoEntity(dados));
    }

    @Transactional
    public void deletarPedido(Long id){
        pedidoRepository.deleteById(id);
    }

     @Transactional
    public void atualizarPedido(PedidoEntity dados){
        PedidoEntity entity = pedidoRepository.getReferenceById(dados.getPedido_id());
        entity.atualizarDados(dados);
    }
}
