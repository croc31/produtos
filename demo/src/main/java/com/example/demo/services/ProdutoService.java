package com.example.demo.services;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.ProdutoRepository;
import com.example.demo.model.ProdutosAtualizar;
import com.example.demo.model.ProdutosEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Service
public class ProdutoService {
    @Autowired
    ProdutoRepository produtoRepository;

    public List<ProdutosEntity> listarProdutos(){
        return produtoRepository.findAllByAtivoTrue();
    }

    public ProdutosEntity listarProdutoPorId(Long id){
        return produtoRepository.getReferenceById(id);
    }

    
    @Transactional
    public void cadastrarProduto(ProdutosEntity dados){
        produtoRepository.save(new ProdutosEntity(dados));
    }

    @Transactional
    public void atualizarProduto(ProdutosAtualizar dados){
        ProdutosEntity entity = produtoRepository.getReferenceById(dados.id());
        entity.atualizarDados(dados);
    }

    @Transactional
    public void deletarProduto(Long id){
        produtoRepository.deleteById(id);
    }

    @Transactional
    public void inativar(Long id){
        ProdutosEntity aluno = produtoRepository.getReferenceById(id);
        aluno.inativar();
    }

}
