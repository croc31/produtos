package com.example.demo.model;

import jakarta.validation.constraints.NotNull;

public record ProdutosAtualizar(
        @NotNull(message = "O produto precisa de um id!")
        Long id,
      String nome_produto, String descricao_produto,
      double preco_produto, String data_validade, 
      int estoque, String fornecedor, int ativo){
}